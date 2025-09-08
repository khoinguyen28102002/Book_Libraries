package com.example.web_app.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.web_app.dto.BookRequestDTO;
import com.example.web_app.dto.BookResponseDTO;
import com.example.web_app.exceptions.ApiException;
import com.example.web_app.mapper.MapperBook;
import com.example.web_app.models.Book;
import com.example.web_app.respositories.BookRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepo;

    public List<BookResponseDTO> getAllBooks(){

        return bookRepo.findAll().stream()
                .map(MapperBook::modelToResponseDto)
                .toList();
    }

    public List<BookResponseDTO> getBookByName(String title){
        if(title == ""){
            throw new ApiException("No name field!", HttpStatus.BAD_REQUEST);
        }
        
        return bookRepo.findBookByTitle(title).stream()
                .map(MapperBook::modelToResponseDto)
                .toList();
    }
    
    public BookResponseDTO addNewBook(BookRequestDTO book){
        Book modelBook = MapperBook.dtoRequestToModel(book);
        return MapperBook.modelToResponseDto(bookRepo.addNewBook(modelBook));
    }

    public BookResponseDTO updateBook(int id, BookRequestDTO book){
        Book repositoryBook = bookRepo.findById(id);
        if(repositoryBook == null){
            throw new ApiException("Not found book by id: " + id, HttpStatus.NOT_FOUND);
        }

        repositoryBook.setTitle(book.getTitle());
        repositoryBook.setAuthor(book.getAuthor());
        repositoryBook.setPrice(book.getPrice());
        repositoryBook.setQuantity(book.getQuantity());
        repositoryBook.setImage_url(book.getImage_url());

        Book savedBook = bookRepo.updateBook(repositoryBook);

        return MapperBook.modelToResponseDto(savedBook);
    }

    public void deleteBook(int id){
        bookRepo.deleteById(id);
    }
}
