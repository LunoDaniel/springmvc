package com.mvc.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvc.model.GEntity;

@Repository
public interface DateRepository extends JpaRepository<GEntity, Long> {

	@Query(value = "select CURDATE()", nativeQuery = true)
	public Date current();

}
