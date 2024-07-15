package com.example.sbmvcbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sbmvcbookapp.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
    
}
