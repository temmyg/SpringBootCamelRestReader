package com.springboot.camel.rest.restreader.daolayer;

import com.springboot.camel.rest.restreader.model.ClubMember;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class DAManager {

//    @Autowired(required = false)
//    private ClubMemberRepository repo;

    public int saveMember(ClubMember member){
        Logger logger = LoggerFactory.getLogger(DAManager.class);

        int affectdRowNum = -1;
        try {
            //ClubMember saved = (ClubMember) repo.save(member);
        }
        catch (Exception e){
            logger.error(e.getMessage(), e.getStackTrace());
            throw e;
        }
        return affectdRowNum;
    }
}
