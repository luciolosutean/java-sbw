package com.arobs.sbw.mapper;

import com.arobs.sbw.dtos.BookDto;
import com.arobs.sbw.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);

    List<BookDto> booksToBookDtos(List<Book> books);
}
