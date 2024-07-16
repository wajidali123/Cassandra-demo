package com.sboot.cassandra.demo.repo;

import com.sboot.cassandra.demo.model.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CassandraRepository<Book, String> {

}