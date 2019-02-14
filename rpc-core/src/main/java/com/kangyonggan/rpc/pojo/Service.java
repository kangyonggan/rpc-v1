package com.kangyonggan.rpc.pojo;

import com.kangyonggan.rpc.constants.RpcPojo;
import com.kangyonggan.rpc.util.RegisterUtils;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;
import java.net.InetAddress;

/**
 * @author kangyonggan
 * @since 2019-02-13
 */
@Data
public class Service implements InitializingBean, ApplicationContextAware, Serializable {

    private Logger logger = Logger.getLogger(Service.class);

    private ApplicationContext applicationContext;

    private String id;

    private String name;

    private String impl;

    private String ref;

    private String version;

    private int weight;

    private String applicationName;

    private String ip;

    private int port;

    /**
     * 在spring实例化全部的bean之后执行
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        if (!applicationContext.containsBean(RpcPojo.application.name())) {
            logger.info("没有配置application，不发布到注册中心");
            return;
        }
        if (!applicationContext.containsBean(RpcPojo.server.name())) {
            logger.info("没有配置server，不发布到注册中心");
            return;
        }
        if (!applicationContext.containsBean(RpcPojo.register.name())) {
            logger.info("没有配置register，不发布到注册中心");
            return;
        }

        Application application = (Application) applicationContext.getBean(RpcPojo.application.name());
        Server server = (Server) applicationContext.getBean(RpcPojo.server.name());
        this.setApplicationName(application.getName());
        this.setIp(InetAddress.getLocalHost().getHostAddress());
        this.setPort(server.getPort());

        // 发布服务到注册中心
        RegisterUtils.registerService(this);
    }

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
}
