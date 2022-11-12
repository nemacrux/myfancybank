package com.nemacrux;

import com.nemacrux.context.MyFancyBankAppConfiguration;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;

public class ApplicationLauncher {

    public static void main( String[] args ) throws LifecycleException {

        final int port = Integer.parseInt(System.getProperty("server.port", "8080"));

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.getConnector();

        Context tomcatCtx = tomcat.addContext("", null);

        WebApplicationContext appCtx = createWebApplicationContext(tomcatCtx.getServletContext());
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appCtx);
        Wrapper servlet = Tomcat.addServlet(tomcatCtx, "dispatcherServlet", dispatcherServlet);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();
    }

    private static WebApplicationContext createWebApplicationContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyFancyBankAppConfiguration.class);
        ctx.setServletContext(servletContext);
        ctx.refresh();
        ctx.registerShutdownHook();
        return ctx;
    }
}
