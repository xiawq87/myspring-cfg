package com.xwq.spring.config;

public class AopDefinition {
    private String aspect;
    private String pointcut;

    public AopDefinition() {
    }

    public AopDefinition(String aspect, String pointcut) {
        this.aspect = aspect;
        this.pointcut = pointcut;
    }

    public String getAspect() {
        return aspect;
    }

    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    public String getPointcut() {
        return pointcut;
    }

    public void setPointcut(String pointcut) {
        this.pointcut = pointcut;
    }
}
