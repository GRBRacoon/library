package com.example.library.Service;

import com.example.library.Repository.BookRepository;
import com.example.library.Repository.MemberRepository;
import com.example.library.domain.Book;
import com.example.library.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MemberService {

    private final MemberRepository repository;

    private final BookRepository bookRepository;


    public MemberService(@Autowired MemberRepository repository,@Autowired BookRepository bookRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
    }

    public void memberSave(String id , String password, String name){
        Member member=new Member();
        member.setId(id);
        member.setName(name);
        member.setPassword(password);
        repository.save(member);
    }

    public Object findById(String id){
        return repository.findById(id);
    }
    public String memberLogin(String id, String password){
        if(findById(id)==null){
            return "no such member";
        }
        else{
            Member member= (Member) findById(id);
            if(member.getPassword().equals(password)){
                return  "log in success";
            }
            else return "wrong password";
        }
    }




}