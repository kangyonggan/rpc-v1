package com.kangyonggan.rpc.xsd;

import com.kangyonggan.rpc.xsd.parser.ApplicationDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * RPC命名空间解析
 *
 * @author kangyonggan
 * @since 2019-02-13
 */
public class RpcNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("application", new ApplicationDefinitionParser());
    }
}
