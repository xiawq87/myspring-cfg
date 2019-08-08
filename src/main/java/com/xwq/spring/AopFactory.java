package com.xwq.spring;

import com.xwq.spring.config.AopDefinition;
import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class AopFactory {
    public static void init(List<AopDefinition> aopDefinitionList) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if(CollectionUtils.isNotEmpty(aopDefinitionList)) {
            for(AopDefinition definition : aopDefinitionList) {
                String aspectClassName = definition.getAspect();
                String pointcutClassName = definition.getPointcut();

                Object target = BeanFactory.getBeanByClassName(pointcutClassName);

                Class<?> clz = Class.forName(aspectClassName);
                Object aspectObj = clz.newInstance();
                Method method = clz.getMethod("setTarget", Object.class);
                method.invoke(aspectObj, target);

                Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (InvocationHandler) aspectObj);
                BeanFactory.setProxyByClassName(pointcutClassName, proxy);
            }
        }
    }
}
