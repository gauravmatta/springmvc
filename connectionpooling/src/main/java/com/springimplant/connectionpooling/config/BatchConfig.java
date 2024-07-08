package com.springimplant.connectionpooling.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.springimplant.connectionpooling.component.CustomerProcessor;
import com.springimplant.connectionpooling.component.CustomerWriter;
import com.springimplant.connectionpooling.entity.Customers;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	@Qualifier("hickariDataSource")
	DataSource dataSource;
	

    @Bean
    FlatFileItemReader<Customers> reader(){
		FlatFileItemReader<Customers> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
		itemReader.setName("customerReader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(linemapper());
		return itemReader;
	}
	
	private LineMapper<Customers> linemapper(){
		DefaultLineMapper<Customers> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id","customer_name","created_at");
		BeanWrapperFieldSetMapper<Customers> fieldSetMapper = new BeanWrapperFieldSetMapper<>();		
		fieldSetMapper.setConversionService(testConversionService());
		fieldSetMapper.setTargetType(Customers.class);
//		DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT);
//		final Map<Class, PropertyEditor> customEditors = Stream
//		            .of(new AbstractMap.SimpleEntry<>(Date.class, new CustomDateEditor(df, false)))
//		            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//		fieldSetMapper.setCustomEditors(customEditors);
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}
	
    @Bean
    ConversionService testConversionService() {
        DefaultConversionService testConversionService = new DefaultConversionService();
        DefaultConversionService.addDefaultConverters(testConversionService);
        testConversionService.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String text) {
                return LocalDateTime.parse(text, DateTimeFormatter.ISO_DATE_TIME);
            }
        });

        return testConversionService;
    }
    
//    @Bean
//    CustomDateEditor dateEditor() {
//    	Locale loc = new Locale("en", "US");
//    	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
//    	CustomDateEditor editor = new CustomDateEditor(dateFormat,false);
//    	return editor;
//    }
	
	@Bean
	CustomerProcessor processor() {
		return new CustomerProcessor();
	}
	
	@Bean
	CustomerWriter writer() {
		return new CustomerWriter();
	}
	
	@Bean
	TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor("spring_batch");
		simpleAsyncTaskExecutor.setConcurrencyLimit(10);
		return simpleAsyncTaskExecutor;
	}
	
	@Bean
	Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("sampleStep", jobRepository)
					.<Customers,Customers>chunk(100000, transactionManager)
					.reader(reader())
					.processor(processor())
					.writer(writer())
					.taskExecutor(taskExecutor())
					.build();
	}
	
	@Bean(name = "batchjob")
	Job job(JobRepository jobRepository,PlatformTransactionManager transactionManager) {
		return new JobBuilder("importCustomnersCsvToDb",jobRepository)
				.preventRestart()
				.start(step1(jobRepository, transactionManager))
				.build();
	}
	
	@Bean(name = "transactionManager")
	PlatformTransactionManager getTransactionManager() {
		return new JpaTransactionManager();
	}
	
	
	@Bean(name="jobrepository")
	JobRepository getJobRepository() {
	JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
	factory.setDataSource(this.dataSource);
	factory.setTransactionManager(getTransactionManager());
	factory.setDatabaseType("mysql");
	try {
		factory.afterPropertiesSet();
		return factory.getObject();
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	}
	
}
