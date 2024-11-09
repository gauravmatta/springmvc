package com.springimplant.gatewayservice.filter;

import javax.servlet.http.HttpServletRequest;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.CharEncoding;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
@Configuration
public class PostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("PostFilter: "+String.format("%s request to %s",request.getMethod(),request.getRequestURL().toString()));
		try(InputStream is = ctx.getResponseDataStream()){
			String respData = CharStreams.toString(new InputStreamReader(is, CharEncoding.UTF_8));
			log.info("respData: "+respData);
			ctx.setResponseBody(respData);
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
