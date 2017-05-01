package com.asifsid88.myexpense.configuration;

import com.asifsid88.configuration.SystemPropertyConfiguration;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by mhussaa on 3/18/17.
 */
@Log4j2
public class MyExpenseWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() {
        log.info("Loading SpringWebConfig");
        return new Class<?>[] { SpringWebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        log.info("Loading SystemPropertyConfiguration");
        return new Class<?>[] { SystemPropertyConfiguration.class };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
    }
}
