package com.springboot.camel.rest.restreader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springboot.camel.rest.restreader.daolayer.ClubMemberRepository;
import com.springboot.camel.rest.restreader.daolayer.DAManager;
import com.springboot.camel.rest.restreader.model.ClubMember;
import org.apache.camel.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;



@Service("persistenceBean")
public class PersistenceBean {

    @Autowired
    private DAManager dam;

    public void persistIncomingData(@Body String messageBody) {
        int i = 0;

        Type listType = new TypeToken<List<ClubMember>>(){}.getType();
        List<ClubMember> allMember = new Gson().fromJson(messageBody, listType);

        int affecteRows = 0;
        try {
            affecteRows = dam.saveMembers(allMember);
        }
        catch (Exception e){
            System.out.println();
            System.out.println(String.format("****** Some Error Happened: %1$s", e));
            e.printStackTrace();
            System.out.println();
        }

        System.out.println(String.format("Total %1$d rows added.", affecteRows));
    }
}
