package com.example.library.Controller;


import com.example.library.Service.BookRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRequestController {
    @Autowired
    private final BookRequestService service;

    public BookRequestController(BookRequestService service) {
        this.service = service;
    }
    @PostMapping("/request")
    public void addRequest(@RequestParam("date")int date, @RequestParam("name")String name,
                           @RequestParam("writer")String writer,@RequestParam("explain") String explain){

        service.addBookRequest(name, date, writer, explain);
    }

}
