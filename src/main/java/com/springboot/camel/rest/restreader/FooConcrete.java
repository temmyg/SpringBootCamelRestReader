package com.springboot.camel.rest.restreader;

import com.springboot.camel.rest.restreader.FooFilledArg;
import com.springboot.camel.rest.restreader.model.ClubMember;

public class FooConcrete /*implements FooFilledArg*/ {

    public String getValue(ClubMember mem){
        return mem.getFirstName();
    }
}
