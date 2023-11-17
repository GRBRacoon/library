package com.example.library.Controller;

import com.example.library.Service.BookService;
import com.example.library.domain.Book;
import com.example.library.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private final BookService service;


    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public List<Book> search(@RequestParam("name")Object name, @RequestParam("writer")Object writer,
                             @RequestParam("publisher")Object publisher){

        return service.search(name, writer, publisher);
    }

    @GetMapping("/bookBorrow")
    public String bookBorrow(@RequestParam("num")int num,@RequestParam("member") Member member){
       return service.bookBorrow(num, member);
    }

    @GetMapping("/bookReturn")
    public String bookReturn(@RequestParam("num")int num){
        //멤버의 책 배열에서 찾고 있을 경우, 없을 경우
        return "string";
        //return  service.bookReturn(num);
    }

    public List<Book> memberBookBorrowList(@RequestParam("id")String id){
        List<Book> bookList= service.findByMemberId(id);
        return bookList;
    }

}
