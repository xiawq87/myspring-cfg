package com.xwq.spring.config;

import java.util.ArrayList;
import java.util.List;

public class DefinitionHolder {
    private List<BeanDefinition> beanDefinitionList = new ArrayList<BeanDefinition>();
    private List<AopDefinition> aopDefinitionList = new ArrayList<AopDefinition>();

    public List<BeanDefinition> getBeanDefinitionList() {
        return beanDefinitionList;
    }

    public void setBeanDefinitionList(List<BeanDefinition> beanDefinitionList) {
        this.beanDefinitionList = beanDefinitionList;
    }

    public List<AopDefinition> getAopDefinitionList() {
        return aopDefinitionList;
    }

    public void setAopDefinitionList(List<AopDefinition> aopDefinitionList) {
        this.aopDefinitionList = aopDefinitionList;
    }
}
