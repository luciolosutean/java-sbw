package com.arobs.sbw.controllers;

import com.arobs.sbw.dtos.BookDto;
import com.arobs.sbw.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    @RequestMapping(name = "/book", method = RequestMethod.GET)
    public ResponseEntity<BookDto> getBookByTitle(@RequestParam("title") String title) {
        return ResponseEntity.of(bookService.findBookForTitle(title));
    }

    @RequestMapping(name = "/book", method = RequestMethod.POST)
    public ResponseEntity<Integer> createBook(BookDto bookDto) {
        return ResponseEntity.of(bookService.createBook(bookDto));
    }
}
