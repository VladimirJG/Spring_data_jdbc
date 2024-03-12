package ru.danilov.Spring_data_jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.danilov.Spring_data_jdbc.controller.BookController;
import ru.danilov.Spring_data_jdbc.model.Book;
import ru.danilov.Spring_data_jdbc.service.BookService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringDataJdbcApplicationTests {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Test
    public void testGetAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(10, "Book1", "Author1", "2000"));
        books.add(new Book(20, "Book2", "Author2", "2001"));
        Mockito.when(bookService.getAllBooks()).thenReturn(books);
        Iterable<Book> result = bookController.getAllBooks();
        Assertions.assertEquals(2, ((List<Book>) result).size());
    }

    @Test
    public void testGetBookById() {
        int id = 10;
        Book book = new Book(id, "Book1", "Author1", "2000");
        Mockito.when(bookService.getBookById(id)).thenReturn(book);
        Book result = bookController.getBookById(id);
        Assertions.assertEquals(id, result.getId());
    }

    @Test
    public void testSaveBook() {
        Book book = new Book(10, "Book1", "Author1", "2000");
        Mockito.when(bookService.saveBook(Mockito.any(Book.class))).thenReturn(book);
        Book result = bookController.saveBook(book);
        Assertions.assertEquals(book, result);
    }

    @Test
    public void testDeleteBook() {
        int id = 10;
        bookController.deleteBook(id);
        Mockito.verify(bookService, Mockito.times(1)).deleteBook(id);
    }
}