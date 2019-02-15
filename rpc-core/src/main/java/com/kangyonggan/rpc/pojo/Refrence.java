package com.kangyonggan.rpc.pojo;

import com.kangyonggan.rpc.constants.RpcPojo;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author kangyonggan
 * @since 2019-02-15
 */
@Data
public class Refrence implements InitializingBean, ApplicationContextAware {

    private Logger logger = Logger.getLogger(Refrence.class);

    private ApplicationContext applicationContext;

    private String id;

    private String name;

    /**
     * 获取spring上下文对象
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 在spring实例化全部的bean之后执行
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        if (!applicationContext.containsBean(RpcPojo.application.name())) {
            logger.info("没有配置application，无法获取引用");
            return;
        }
        if (!applicationContext.containsBean(RpcPojo.client.name())) {
            logger.info("没有配置client，无法获取引用");
            return;
        }
        if (!applicationContext.containsBean(RpcPojo.register.name())) {
            logger.info("没有配置register，无法获取引用");
            return;
        }

        // TODO 获取引用

    }

}
