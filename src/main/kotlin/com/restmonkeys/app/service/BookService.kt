package com.restmonkeys.app.service

import org.springframework.stereotype.Service

@Service
class BookService {

    fun getAllBooks(): List<Book> {
        return listOf(Book(1, "hello"), Book(2, "world"))
    }
}