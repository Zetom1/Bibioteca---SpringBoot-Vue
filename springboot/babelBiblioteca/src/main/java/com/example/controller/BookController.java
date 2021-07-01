package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.repository.BookRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookController {


	@Autowired
	BookRepository repository;

	@GetMapping("/books")
	public List<Book> getAllBooks() {

		List<Book> books = new ArrayList<>();
		repository.findAll().forEach(books::add);
		return books; 
	}
	
	@PostMapping("/book")
	public Book postBook(@RequestBody Book book) {
		
		if(!(book.getEstante()==""||book.getLibrero()==""||book.getPosicion()==""||
				book.getTitulo()==""||book.getSala()=="")){
			Book _book = repository.save(
					new Book(
							book.getTitulo(),
							book.getVolumen(),
							book.getEstante(),
							book.getSala(),
							book.getLibrero(),
							book.getPosicion()
							) 
					);
			return _book;
		}
		return null;
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") long id) {
		repository.deleteById(id);

		return new ResponseEntity<>("Libro eliminado", HttpStatus.OK);
	}

	@GetMapping("books/titulo/{titulo}")
	public List<Book> findByTitulo(@PathVariable String titulo) {

		List<Book> book = repository.findByTitulo(titulo);
		return book;
	}
	
	@GetMapping("sala/{sala}")
	public List<Book> findBySala(@PathVariable String sala) {

		List<Book> book = repository.findBySala(sala);
		return book;
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book) {

		Optional<Book> bookData = repository.findById(id);

		if (bookData.isPresent()) {
			Book _book = bookData.get();
			_book.setTitulo(book.getTitulo());
			_book.setVolumen(book.getVolumen());
			_book.setEstante(book.getEstante());
			_book.setSala(book.getSala());
			_book.setLibrero(book.getLibrero());
			_book.setPosicion(book.getPosicion());
			return new ResponseEntity<>(repository.save(_book), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
