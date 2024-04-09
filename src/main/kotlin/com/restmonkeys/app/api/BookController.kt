package com.restmonkeys.app.api

import com.restmonkeys.app.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController("books")
@RequestMapping("/books")
class BookController(val bookService: BookService) {

    @GetMapping("/")
    fun list(): List<BookDTO> {
        return bookService.getAllBooks().map(::fromService)
    }

}