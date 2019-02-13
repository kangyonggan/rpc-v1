package com.kangyonggan.rpc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试服务提供者
 *
 * @author kangyonggan
 * @since 2019-02-13
 */
public class ProviderTest {

    /**
     * 向注册中心注册服务
     *
     * @throws Exception
     */
    @Test
    public void register() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("rpc-provider.xml");
        context.start();
        System.in.read();
    }

}
