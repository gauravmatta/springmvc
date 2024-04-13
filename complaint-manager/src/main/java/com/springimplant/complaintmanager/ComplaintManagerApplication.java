package com.springimplant.complaintmanager;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import io.micrometer.context.ContextRegistry;

@SpringBootApplication(scanBasePackages = "com.springimplant.complaintmanager")
@EnableEncryptableProperties
public class ComplaintManagerApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringApplicationBuilder.class);
    }

	public static void main(String[] args) {
		ContextRegistry.getInstance().registerThreadLocalAccessor("cid",
				() -> MDC.get("cid"),
				cid->MDC.put("cid",cid),
				()->MDC.remove("cid"));
		SpringApplication.run(ComplaintManagerApplication.class, args);
	}

}
