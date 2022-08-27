package com.api.book.springbootrestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.springbootrestbook.entity.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{

public Book findById(int id);    

}
