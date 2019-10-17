package com.mvc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.model.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long>{

}
