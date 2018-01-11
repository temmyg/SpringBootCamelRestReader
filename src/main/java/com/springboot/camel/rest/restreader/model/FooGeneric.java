package com.springboot.camel.rest.restreader.model;

public interface FooGeneric<T> {

    public String getValue(T value);
}
