package com.kangyonggan.rpc.xsd.parser;

import com.kangyonggan.rpc.xsd.model.Application;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @author kangyonggan
 * @since 2019-02-13
 */
public class ApplicationDefinitionParser extends AbstractSimpleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Application.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String id = element.getAttribute("id");
        String name = element.getAttribute("name");

        bean.addPropertyValue("id", id);
        bean.addPropertyValue("name", name);
    }

}
