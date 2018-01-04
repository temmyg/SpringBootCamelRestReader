package com.springboot.camel.rest.restreader;

import daolayer.ClubMemberRepository;
import org.apache.camel.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("persistenceBean")
public class PersistenceBean {

    public void persistIncomingData(@Body String messageBody){
        int i = 0;
        System.out.println("message: " + messageBody);
    }
}
