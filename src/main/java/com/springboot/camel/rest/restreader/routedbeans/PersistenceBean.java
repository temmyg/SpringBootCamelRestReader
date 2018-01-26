package com.springboot.camel.rest.restreader.routedbeans;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springboot.camel.rest.restreader.daolayer.ClubMemberRepository;
import com.springboot.camel.rest.restreader.daolayer.DAManager;
import com.springboot.camel.rest.restreader.model.ClubMember;
import org.apache.camel.Body;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.spi.TypeConverterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;



@Service("persistenceBean")
public class PersistenceBean {

    @Autowired
    private DAManager dam;

    @Autowired
    private CamelContext camelContext;

    public void processData(@Body String data, Exchange exchange) {
        int i = 0;
        int affecteRows = 0;
        Type listType = new TypeToken<List<ClubMember>>(){}.getType();
        List<ClubMember> allMember = new Gson().fromJson(data, listType);

        try {
            affecteRows = dam.saveMembers(allMember);
        }
        catch (Exception e){
            System.out.println();
            System.out.println(String.format("****** Some Error Happened: %1$s", e));
            e.printStackTrace();
            System.out.println();
        }
    }

    public void persistIncomingData(@Body ClubMember member, Message message) {
        int i = 0;
        int affecteRows = 0;

       // Object body = message.getBody(ClubMember.class);

       // TypeConverterRegistry tcr = camelContext.getTypeConverterRegistry();

       // camelContext.getTypeConverterRegistry().addTypeConverter(ClubMember.class, String.class, new ClubMemberTypeConverter());

        // ClubMember mem = (ClubMember)message.getExchange().getContext().getTypeConverter().convertTo(ClubMember.class, "asfas");


        System.out.println(String.format("Total %1$d rows added.", affecteRows));
    }
}
