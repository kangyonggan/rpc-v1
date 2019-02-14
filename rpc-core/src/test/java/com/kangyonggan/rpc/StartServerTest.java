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
public class StartServerTest {

    private Logger logger = Logger.getLogger(StartServerTest.class);

    private ClassPathXmlApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("test-start-server.xml");
    }

    /**
     * 启动服务端
     *
     * @throws IOException
     */
    @Test
    public void testStartServer() throws IOException {
        System.in.read();
    }

}
