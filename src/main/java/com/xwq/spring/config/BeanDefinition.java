package com.xwq.spring.config;

public class BeanDefinition {
    private String beanId;
    private String className;

    public BeanDefinition() {
    }

    public BeanDefinition(String beanId, String className) {
        this.beanId = beanId;
        this.className = className;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
