package com.arobs.sbw.services;

import com.arobs.sbw.dtos.BookDto;
import com.arobs.sbw.mapper.BookMapper;
import com.arobs.sbw.model.Book;
import com.arobs.sbw.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public Optional<List<BookDto>> findAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        if (CollectionUtils.isEmpty(allBooks)) {
            return Optional.empty();
        }

        return Optional.of(bookMapper.booksToBookDtos(allBooks));
    }

    public Optional<BookDto> findBookForId(Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.map(bookMapper::bookToBookDto);
    }

    public Optional<BookDto> findBookForTitle(String title) {
        Optional<Book> bookOptional = bookRepository.findByTitle(title);
        return bookOptional.map(bookMapper::bookToBookDto);
    }

    public Optional<Integer> createBook(BookDto bookDto) {
        if (bookDto == null) {
            return Optional.empty();
        }

        Book book = bookMapper.bookDtoToBook(bookDto);
        return Optional.of(bookRepository.saveAndFlush(book).getId());
    }

    public Optional<BookDto> updateBook(int id, BookDto updatedBookDto) {
        Optional<Book> existingBookOptional = bookRepository.findById(id);

        if (existingBookOptional.isEmpty()) {
            return Optional.empty();
        }

        Book existingBook = existingBookOptional.get();
        existingBook.setTitle(updatedBookDto.getTitle());
        existingBook.setAuthor(updatedBookDto.getAuthor());
        existingBook.setDescription(updatedBookDto.getDescription());

        Book updatedBook = bookRepository.save(existingBook);

        return Optional.of(bookMapper.bookToBookDto(updatedBook));
    }

    public Optional<Integer> deleteBook(int id) {
        Optional<Book> existingBookOptional = bookRepository.findById(id);
        if (existingBookOptional.isEmpty()) {
            return Optional.empty();
        }

        bookRepository.delete(existingBookOptional.get());

        return Optional.of(id);
    }
}
