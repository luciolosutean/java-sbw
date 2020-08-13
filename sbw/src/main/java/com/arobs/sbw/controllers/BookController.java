package com.arobs.sbw.controllers;

import com.arobs.sbw.dtos.BookDto;
import com.arobs.sbw.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    @RequestMapping(value = "/byTitle", method = RequestMethod.GET)
    public ResponseEntity<BookDto> getBookByTitle(@RequestParam("title") String title) {
        return ResponseEntity.of(bookService.findBookForTitle(title));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Integer> createBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.of(bookService.createBook(bookDto));
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BookDto> updateBook(@PathVariable(value = "id") Integer id, @RequestBody BookDto updatedBookDto) {
        return ResponseEntity.of(bookService.updateBook(id, updatedBookDto));
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteBook(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.of(bookService.deleteBook(id));
    }
}
