package org.opensource.pethelper.controller;

import java.util.List;

import org.opensource.pethelper.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping("/")
    public List<Book> getAllBooks() {
        Book book = new Book();
        book.setId(1L);
        book.setAuthor("Tyler");
        book.setTitle("ass");
        book.setTest("test");

        return List.of(book);
    }

    

}
