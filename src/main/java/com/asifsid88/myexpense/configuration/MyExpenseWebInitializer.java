package com.asifsid88.myexpense.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by mhussaa on 3/18/17.
 */
public class MyExpenseWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { SpringWebConfig.class };
    }

    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
}
