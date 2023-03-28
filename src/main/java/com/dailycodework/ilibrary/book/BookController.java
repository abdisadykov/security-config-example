package com.dailycodework.ilibrary.book;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author Samson Effes
 */

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/{id}")
    public Optional<Book> getById(@PathVariable("id") Long bookId){
        return bookService.findById(bookId);
    }
    @PostMapping
    public ResponseEntity<Book> add(@RequestBody Book book){
        return new ResponseEntity<>(bookService.add(book), CREATED);
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book theBook){
        return new ResponseEntity<>(bookService.update(theBook), OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long bookId){
        bookService.delete(bookId);
    }

}
