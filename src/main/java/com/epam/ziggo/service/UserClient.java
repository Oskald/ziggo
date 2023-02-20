package com.epam.ziggo.service;

import com.epam.ziggo.vo.UsersHolderVO;
import feign.RequestLine;

public interface UserClient {
    @RequestLine("GET")
    UsersHolderVO findAll();


}
