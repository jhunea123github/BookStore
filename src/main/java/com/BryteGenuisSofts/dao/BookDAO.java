package com.BryteGenuisSofts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BryteGenuisSofts.pojo.Book;
@Repository
public interface BookDAO extends JpaRepository<Book, Integer> {

}
