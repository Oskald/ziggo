package com.epam.ziggo.service;

import java.util.List;
import java.util.Optional;

import com.epam.ziggo.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserClient userClient;


    public List<UserVO> findAll(){
        return userClient.findAll().getData();
    }

    public Optional<UserVO> findByEmail(String email){
        return findAll().stream().filter(it -> it.getEmail().equals(email)).findFirst();
    }

}
