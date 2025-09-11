package com.example.web_app.respositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.web_app.exceptions.ApiException;
import com.example.web_app.models.Book;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.UUID;


@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String TABLE_NAME = "postgresql.public.book";

    private final RowMapper<Book> bookRowMapper = (rs, rowNum) -> {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPrice(rs.getString("price"));
        book.setQuantity(rs.getInt("quantity"));
        book.setImage_url(rs.getString("image_url"));
        return book;
    };

    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM " + TABLE_NAME, bookRowMapper);
    }

    public List<Book> findBookByTitle(String title){
        return jdbcTemplate.query(
            "SELECT * FROM " + TABLE_NAME + " WHERE title = ?", 
            bookRowMapper, 
            title
        );
    }
    public Book findById(int id){
        try{
            return jdbcTemplate.queryForObject(
                "SELECT * FROM " + TABLE_NAME + " WHERE id = ?", 
                bookRowMapper, 
                id
            );
        }catch(EmptyResultDataAccessException e) {
            return null;
        }

    }
    private boolean isValidId(int id, String title, String author) {
        String sql = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE id = ? AND (title <> ? OR author <> ?)";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id, title, author);
        int value = (count != null) ? count.intValue() : 0;
        return value == 0;
    }

    public Book addNewBook(Book book){
        int id;
        do {
            id = 10000000 + new Random().nextInt(90000000);
        } while (!isValidId(id, book.getTitle(), book.getAuthor()));

        String sql = "INSERT INTO " + TABLE_NAME + " (id, title, author, price, quantity, image_url) VALUES (?, ?, ?, ?, ?, ?)";

        int rowsAffected = jdbcTemplate.update(
            sql,
            id,
            book.getTitle(),
            book.getAuthor(),
            book.getPrice(),
            book.getQuantity(),
            book.getImage_url()
        );

        if (rowsAffected == 0) {
            throw new ApiException("Failed to insert book", HttpStatus.BAD_REQUEST);
        }
        book.setId(id);
        return book;
    }
    public Book updateBook(Book book) {
        String sql = "UPDATE " + TABLE_NAME + " SET title = ?, author = ?, price = ?, quantity = ?, image_url = ? WHERE id = ?";
        
        int rowsAffected = jdbcTemplate.update(sql, 
            book.getTitle(), 
            book.getAuthor(), 
            book.getPrice(), 
            book.getQuantity(),
            book.getImage_url(),
            book.getId()
        );

        if (rowsAffected == 0) {
            throw new RuntimeException("Book with id " + book.getId() + " not found");
        }

        return findById(book.getId());
    }

    public void deleteById(int id){
        jdbcTemplate.update(
            "DELETE FROM " + TABLE_NAME + " WHERE id = ?", id
        );
    }

    
}
