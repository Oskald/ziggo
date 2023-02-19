package com.epam.ziggo.mapping;

import com.epam.ziggo.entity.Order;
import com.epam.ziggo.vo.OrderIdVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface OrderIdMapper {
    OrderIdVO map(Order order);
}
