package com.rvcode.pdfinvo;

import javax.servlet.ServletContext;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.rvcode.pdfinvo.context.PdfInvoicesApplicationConfiguration;

public class ApplicationLauncher {

	public static void main(String[] args) throws LifecycleException {

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		tomcat.getConnector();
		
		// adding spring web mvc related things
		
		Context ctx = tomcat.addContext("", null);
		
		
		WebApplicationContext appCtx = createApplicationContext(ctx.getServletContext());
		DispatcherServlet dispatcherServlet = new DispatcherServlet(appCtx);
		Wrapper servlet = Tomcat.addServlet(ctx, "dispatcherServlet", dispatcherServlet);
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/*");

		tomcat.start();
	}

	public static WebApplicationContext createApplicationContext(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(PdfInvoicesApplicationConfiguration.class);
		ctx.setServletContext(servletContext);
		ctx.refresh();
		ctx.registerShutdownHook();
		return ctx;
	}
}