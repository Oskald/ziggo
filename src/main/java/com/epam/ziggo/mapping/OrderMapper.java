package com.epam.ziggo.mapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.epam.ziggo.entity.Order;
import com.epam.ziggo.service.UserService;
import com.epam.ziggo.vo.OrderVO;
import com.epam.ziggo.vo.UserVO;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public abstract class OrderMapper {

    @Autowired
    private UserService userService;

    public abstract Order map(OrderVO orderVO);

    public List<OrderVO> map(List<Order> orders){
        List<OrderVO> result = orders.stream().map(this::map).collect(Collectors.toList());
        Map<String, UserVO> users = userService.findAll().stream().collect(Collectors.toMap(UserVO::getEmail, userVO -> userVO));
        result.forEach(orderVO -> setupUser(orderVO, users.get(orderVO.getEmail())));
        return result;
    }
    public abstract OrderVO map(Order order);




    private void setupUser(OrderVO orderVO, UserVO userVO) {
        if(userVO == null) return;
        orderVO.setFirstName(userVO.getFirstName());
        orderVO.setLastName(userVO.getLastName());
    }
}
