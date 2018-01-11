package com.springboot.camel.rest.restreader.model;

public class FooConcrete /*implements FooFilledArg*/ {

    private int value;

    public  FooConcrete(int val){
        value = val;
    }

    public String getValue(ClubMember mem){
        return mem.getFirstName();
    }
}
