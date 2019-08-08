package com.xwq;

import com.xwq.spring.AopFactory;
import com.xwq.spring.config.AopDefinition;
import com.xwq.spring.config.BeanConfigReader;
import com.xwq.spring.config.BeanDefinition;
import com.xwq.spring.BeanFactory;
import com.xwq.spring.config.DefinitionHolder;

import java.util.List;

public class ApplicationContext {
    private String beanDefinitionFilePath;

    public ApplicationContext(String beanDefinitionFilePath) {
        this.beanDefinitionFilePath = beanDefinitionFilePath;
        init();
    }

    private void init() {
        try {
            DefinitionHolder definitionHolder = BeanConfigReader.readBeanDefinitions(beanDefinitionFilePath);
            List<BeanDefinition> beanDefinitionList = definitionHolder.getBeanDefinitionList();
            BeanFactory.initBeans(beanDefinitionList);

            List<AopDefinition> aopDefinitionList = definitionHolder.getAopDefinitionList();
            AopFactory.init(aopDefinitionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public <T> T getBean(String beanId, Class<T> clz) {
        Object bean = BeanFactory.getBean(beanId);
        return (T) bean;
    }

    public <T> T getBean(Class<T> clz) {
        return BeanFactory.getBean(clz);
    }
}
