package com.springboot.camel.rest.restreader;

import com.springboot.camel.rest.restreader.model.ClubMember;
import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.FallbackConverter;
import org.apache.camel.spi.TypeConverterRegistry;
import org.apache.camel.support.TypeConverterSupport;
import org.apache.cxf.jaxrs.impl.ResponseImpl;

@Converter
public class ClubMemberTypeConverter  extends TypeConverterSupport {

    @Converter
    public static ClubMember convertTo(ResponseImpl val /* , Exchange exchange */){
        ClubMember mem = new ClubMember();
        mem.setAge(24);
        return  mem;
    }

    @FallbackConverter
    public static <T> T convertTo(Class<T> targetType, Exchange exchange, Object value, TypeConverterRegistry tcs){
//
//        ClubMember mem = new ClubMember();
//        mem.setAge(22);
//        return (T) mem;

        if(value instanceof ResponseImpl) {
            ClubMember mem = new ClubMember();
            mem.setAge(22);
            return (T) mem;
        }
        else
            return null;
    }

    public <T> T convertTo(Class<T> targetType, Exchange exchange, Object value){
        ClubMember mem = new ClubMember();
        mem.setAge(25);
        return  (T)mem;
    }
}
