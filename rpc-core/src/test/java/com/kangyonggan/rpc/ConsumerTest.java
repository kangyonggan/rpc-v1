package com.kangyonggan.rpc;

import com.kangyonggan.rpc.service.MathService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


/**
 * @author kangyonggan
 * @since 2019-02-13
 */
public class ConsumerTest {

    private Logger logger = Logger.getLogger(ConsumerTest.class);

    private ClassPathXmlApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("test-consumer.xml");
    }

    /**
     * 引用服务
     *
     * @throws IOException
     */
    @Test
    public void testPublishService() throws IOException {
        MathService mathService = (MathService) context.getBean("mathService");
        logger.info("调用远程服务，1 + 2 = " + mathService.add(1, 2));
        System.in.read();
    }

}
