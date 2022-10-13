package com.digitalbooks.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbooks.entity.BookEntity;

@Repository
public interface BookDao extends JpaRepository<BookEntity, Long>{
	

}
