package com.springmvc;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ClientLogic {
	public static void main(String args[])
	{
		Resource res=new ClassPathResource("spconfig.xml");
		BeanFactory factory=new XmlBeanFactory(res);
		WelcomeBean wb=(WelcomeBean) factory.getBean("wb");
		wb.show();
		
		//Since BeanFactory IOC container is depricated now we use ApplicationContext as follows
		ApplicationContext context=new ClassPathXmlApplicationContext("spconfig.xml");
		WelcomeBean wb1=context.getBean("wb",WelcomeBean.class);
		wb1.show();
	}
}
