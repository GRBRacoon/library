package com.example.library.Controller;

import com.example.library.Service.MemberService;
import com.example.library.domain.Book;
import com.example.library.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private final MemberService service;


    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/memberLogin")
    public String memberLogin(@RequestParam("id") String id, @RequestParam("password") String password) {
        return service.memberLogin(id, password);
    }

    @GetMapping("/memberJoin")
    public String memberJoin() {

        return "/memberJoin";
    }

    @PostMapping("/memberJoin")
    public String memberSave(@RequestParam("id") String id, @RequestParam("password") String password,
                             @RequestParam("name") String name) {
        service.memberSave(id, password, name);
        return "memberSave";
    }

}

