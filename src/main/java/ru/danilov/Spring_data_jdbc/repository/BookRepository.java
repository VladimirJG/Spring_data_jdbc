package ru.danilov.Spring_data_jdbc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.danilov.Spring_data_jdbc.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}