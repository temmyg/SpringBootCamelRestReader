package com.springboot.camel.rest.restreader.daolayer;

import com.springboot.camel.rest.restreader.model.ClubMember;
import org.apache.camel.Exchange;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DAManager {

    @Autowired(required = false)
    private ClubMemberRepository repo;

    public int saveMembers(List<ClubMember> members) {

        Logger logger = LoggerFactory.getLogger(DAManager.class);

        int affectedRowNum = 0;
//        try {
            //ClubMember saved = (ClubMember) repo.save(member);
            for(ClubMember member : members){
                repo.save(member);
                affectedRowNum++;
            }
//        }
//        catch (Exception e){
//          //  logger.error(e.getMessage(), e);
//            throw e;
//        }
        return affectedRowNum;
    }
}
