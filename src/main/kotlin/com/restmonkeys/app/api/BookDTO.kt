package com.restmonkeys.app.api

import com.restmonkeys.app.service.Book

data class BookDTO(val name: String)

fun fromService(book: Book): BookDTO {
    return BookDTO(book.name)
}

fun toService(book: BookDTO, id: Long? = null): Book {
    return Book(id, book.name)
}