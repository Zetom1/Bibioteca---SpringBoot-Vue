package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByTitulo(String titulo);
	List<Book> findBySala(String sala);
}
