package ru.danilov.Spring_data_jdbc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.danilov.Spring_data_jdbc.model.Book;
import ru.danilov.Spring_data_jdbc.util.BookRowMapper;

import java.util.List;

@Repository
public class BookRepository  {
    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> findAll() {
        String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    public Book findById(int id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BookRowMapper());
    }

    public Book save(Book book) {
        String sql = "INSERT INTO books (title, author,publication_year) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(),book.getPublicationYear());
        return book;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}