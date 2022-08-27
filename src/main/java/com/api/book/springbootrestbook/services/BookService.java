package com.api.book.springbootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.springbootrestbook.dao.BookRepository;
import com.api.book.springbootrestbook.entity.Book;

@Component
public class BookService {

    @Autowired
private BookRepository bookRepository;

    //private static List<Book> list = new ArrayList<>();
    // static {
    //     list.add(new Book(1, "java complete reference", "raje"));
    //     list.add(new Book(2, "c++ complete reference", "sonu"));
    //     list.add(new Book(3, "Phython complete reference", "rahul"));
    // }

    // get all books
    public List<Book> getAlBooks() {
        List<Book> list=(List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book by id

    public Book getBookById(int id) {
        Book book = null;
        try{

        
     //   book = list.stream().filter(e -> e.getId() == id).findFirst().get();

     book=this.bookRepository.findById(id);
       
    }catch(Exception e){
        e.printStackTrace();
    }
     return book;
    }

    // adding the book

    public Book addBook(Book b) {
      Book result =bookRepository.save(b);
        return result;
    }

    // deleting the book
    public void deleteBook(int bid) {

        //list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());

        bookRepository.deleteById(bid);
    }

    // update the book

    public void updateBook(Book book, int bookId) {

        // list = list.stream().map(b -> {
        //     if (b.getId() == bookId) {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());


        book.setId(bookId);
        bookRepository.save(book);
    }

}
