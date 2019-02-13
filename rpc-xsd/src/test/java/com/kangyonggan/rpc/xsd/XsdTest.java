package com.kangyonggan.rpc.xsd;

import com.kangyonggan.rpc.xsd.pojo.Application;
import com.kangyonggan.rpc.xsd.pojo.Server;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author kangyonggan
 * @since 2019-02-13
 */
public class XsdTest {

    Logger logger = Logger.getLogger(XsdTest.class);

    @Test
    public void testParse() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-xsd.xml");

        Application application = (Application) context.getBean("application");
        logger.info(application);

        Server server = (Server) context.getBean("server");
        logger.info(server);
    }

}
