package com.kangyonggan.rpc;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


/**
 * @author kangyonggan
 * @since 2019-02-13
 */
public class PublishServiceTest {

    private Logger logger = Logger.getLogger(PublishServiceTest.class);

    private ClassPathXmlApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("test-publish-service.xml");
    }

    /**
     * 发布服务
     *
     * @throws IOException
     */
    @Test
    public void testPublishService() throws IOException {
        System.in.read();
    }

}
