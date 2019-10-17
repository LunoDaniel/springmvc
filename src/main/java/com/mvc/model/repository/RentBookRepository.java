package com.mvc.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.model.RentBook;
import com.mvc.model.User;

@Repository
public interface RentBookRepository extends JpaRepository<RentBook, Long> {

	List<RentBook> findAllRentByUser(User user);
}
