package com.kangyonggan.rpc.xsd;

import com.kangyonggan.rpc.xsd.model.Application;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kangyonggan
 * @since 2019-02-13
 */
public class XsdTest {

    @Test
    public void testParse() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-xsd.xml");

        Application application = (Application) context.getBean("application");
        System.out.println(application.getId());
        System.out.println(application.getName());
    }

}
