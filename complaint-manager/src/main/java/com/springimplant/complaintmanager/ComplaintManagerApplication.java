package com.springimplant.complaintmanager;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import io.micrometer.context.ContextRegistry;
import reactor.core.publisher.Hooks;

@SpringBootApplication(scanBasePackages = "com.springimplant.complaintmanager")
@EnableEncryptableProperties
@EnableJdbcHttpSession
public class ComplaintManagerApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringApplicationBuilder.class);
    }

	public static void main(String[] args) {
		Hooks.enableAutomaticContextPropagation();
		ContextRegistry.getInstance().registerThreadLocalAccessor("cid",
				() -> MDC.get("cid"),
				cid->MDC.put("cid",cid),
				()->MDC.remove("cid"));
		SpringApplication.run(ComplaintManagerApplication.class, args);
	}

}
