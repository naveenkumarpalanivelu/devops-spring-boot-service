package com.avaya.absa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.avaya.absa.model.DNCUserProfile;

public interface DNCUserRepository extends CrudRepository<DNCUserProfile, String>
{
	@Query(value ="SELECT * FROM DNC_USER_PROFILE WHERE USER_NAME COLLATE Latin1_General_CS_AS = ?1",nativeQuery = true)
	public DNCUserProfile findByCollateId(String userName);
}
