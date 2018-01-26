package com.springboot.camel.rest.restreader.daolayer;

import com.springboot.camel.rest.restreader.model.ClubMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClubMemberRepository extends JpaRepository<ClubMember, Long> {
}
