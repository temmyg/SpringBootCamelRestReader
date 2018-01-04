package com.springboot.camel.rest.restreader;

import com.springboot.camel.rest.restreader.model.ClubMember;
import org.apache.camel.Body;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service("persistenceBean")
public class PersistenceBean {

    public void persistIncomingData(@Body InputStream messageBody){
        int i = 0;
        System.out.println("message: " + messageBody);
    }
}
