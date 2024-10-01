package com.springimplant.springredis;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.micrometer.context.ContextRegistry;
import reactor.core.publisher.Hooks;

@SpringBootApplication
public class SpringredisApplication {

	public static void main(String[] args) {
		Hooks.enableAutomaticContextPropagation();
		ContextRegistry.getInstance().registerThreadLocalAccessor("cid",
				() -> MDC.get("cid"),
				cid->MDC.put("cid",cid),
				()->MDC.remove("cid"));
		SpringApplication.run(SpringredisApplication.class, args);
	}

}
