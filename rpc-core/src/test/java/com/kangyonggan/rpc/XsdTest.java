package com.kangyonggan.rpc;

import com.kangyonggan.rpc.constants.RpcPojo;
import com.kangyonggan.rpc.pojo.Application;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


/**
 * @author kangyonggan
 * @since 2019-02-13
 */
public class XsdTest {

    private Logger logger = Logger.getLogger(XsdTest.class);

    private ClassPathXmlApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("test-xsd.xml");
    }

    /**
     * 解析自定义的xml标签
     */
    @Test
    public void testParse() {
        Application application = (Application) context.getBean(RpcPojo.application.name());
        logger.info(application);
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

    /**
     * 发布服务到注册中心
     *
     * @throws IOException
     */
    @Test
    public void testRegister() throws IOException {
        System.in.read();
    }

}
