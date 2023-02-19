package com.epam.ziggo.service;

import java.awt.print.Book;
import java.util.List;

import com.epam.ziggo.vo.UsersHolderVO;
import feign.Param;
import feign.RequestLine;

public interface UserClient {
    @RequestLine("GET")
    UsersHolderVO findAll();


}
