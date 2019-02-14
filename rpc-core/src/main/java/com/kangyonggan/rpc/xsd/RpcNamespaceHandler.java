package com.kangyonggan.rpc.xsd;

import com.kangyonggan.rpc.pojo.Application;
import com.kangyonggan.rpc.pojo.Register;
import com.kangyonggan.rpc.pojo.Server;
import com.kangyonggan.rpc.pojo.Service;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * RPC命名空间解析
 *
 * @author kangyonggan
 * @since 2019-02-13
 */
public class RpcNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("application", new SimpleBeanDefinitionParser(Application.class));
        registerBeanDefinitionParser("server", new SimpleBeanDefinitionParser(Server.class));
        registerBeanDefinitionParser("register", new SimpleBeanDefinitionParser(Register.class));
        registerBeanDefinitionParser("service", new SimpleBeanDefinitionParser(Service.class));
    }
}
