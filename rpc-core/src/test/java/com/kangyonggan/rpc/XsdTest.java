package com.kangyonggan.rpc;

import com.kangyonggan.rpc.pojo.Application;
import com.kangyonggan.rpc.pojo.Server;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


/**
 * @author kangyonggan
 * @since 2019-02-13
 */
public class XsdTest {

    Logger logger = Logger.getLogger(XsdTest.class);

    /**
     * 测试自定义的xml标签是否能解析
     */
    @Test
    public void testParse() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-xsd.xml");

        Application application = (Application) context.getBean("application");
        logger.info(application);

        Server server = (Server) context.getBean("server");
        logger.info(server);
    }

    /**
     * 测试启动服务端
     *
     * @throws IOException
     */
    @Test
    public void testStartServer() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-xsd.xml");

        System.in.read();
    }

}
