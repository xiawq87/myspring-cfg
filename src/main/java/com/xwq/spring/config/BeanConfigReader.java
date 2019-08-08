package com.xwq.spring.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xwq.exception.MyException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BeanConfigReader {
    public static DefinitionHolder readBeanDefinitions(String configFilePath) throws IOException {
        URL resource = BeanConfigReader.class.getClassLoader().getResource(configFilePath);
        String filepath = resource.getFile();
        File file = new File(filepath);
        if(file == null) throw new MyException("配置文件不存在");
        String configStrs = FileUtils.readFileToString(file, "UTF-8");
        JSONObject configJSON = JSONObject.parseObject(configStrs);

        JSONArray beansArray = configJSON.getJSONArray("beans");

        List<BeanDefinition> beanDefinitionList = new ArrayList<BeanDefinition>();
        if(beansArray.size() > 0) {
            for(int i=0; i<beansArray.size(); i++) {
                JSONObject beanJSON = beansArray.getJSONObject(i);
                BeanDefinition definition = new BeanDefinition(beanJSON.getString("id"), beanJSON.getString("class"));
                beanDefinitionList.add(definition);
            }
        }

        JSONArray aopArray = configJSON.getJSONArray("aop");
        List<AopDefinition> aopDefinitionList = new ArrayList<AopDefinition>();
        if(aopArray.size() > 0) {
            for(int i=0; i<aopArray.size(); i++) {
                JSONObject aopJSON = aopArray.getJSONObject(i);
                AopDefinition aopDefinition = new AopDefinition(aopJSON.getString("aspect"), aopJSON.getString("pointcut"));
                aopDefinitionList.add(aopDefinition);
            }
        }

        DefinitionHolder definitionHolder = new DefinitionHolder();
        definitionHolder.setBeanDefinitionList(beanDefinitionList);
        definitionHolder.setAopDefinitionList(aopDefinitionList);
        return definitionHolder;
    }
}
