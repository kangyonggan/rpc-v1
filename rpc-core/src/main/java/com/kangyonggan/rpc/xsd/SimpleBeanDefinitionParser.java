package com.kangyonggan.rpc.xsd;

import com.kangyonggan.rpc.pojo.Client;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author kangyonggan
 * @since 2019-02-13
 */
public class SimpleBeanDefinitionParser extends AbstractSimpleBeanDefinitionParser {

    private Class<?> pojoClass;

    SimpleBeanDefinitionParser(Class<?> pojoClass) {
        this.pojoClass = pojoClass;
    }

    @Override
    protected Class<?> getBeanClass(Element element) {
        return pojoClass;
    }

    /**
     * 属性名不一致的转换
     *
     * @param element
     * @param parserContext
     * @param builder
     */
    @Override
    protected void doParse(Element element, ParserContext parserContext,
                           BeanDefinitionBuilder builder) {
        if (Client.class.equals(pojoClass)) {
            String loadBalance = element.getAttribute("load_balance");
            builder.addPropertyValue("loadBalance", loadBalance);
        }
    }

}
