package com.shenjies88.practice.impl;

import com.alibaba.fastjson.JSON;
import com.shenjies88.practice.interfaces.Serializer;
import com.shenjies88.practice.interfaces.SerializerAlgorithm;

public class JSONSerializer implements Serializer {
   
    @Override
    public byte getSerializerAlgorithm() {
        
        return SerializerAlgorithm.JSON;
    } 

    @Override
    public byte[] serialize(Object object) {
        
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        
        return JSON.parseObject(bytes, clazz);
    }
}