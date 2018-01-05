package com.springboot.camel.rest.restreader;

public interface FooGeneric<T> {

    public String getValue(T value);
}
