package ru.danilov.Spring_data_jdbc.util;

import org.springframework.jdbc.core.RowMapper;
import ru.danilov.Spring_data_jdbc.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublicationYear(rs.getString("publication_year"));
        return book;
    }
}
