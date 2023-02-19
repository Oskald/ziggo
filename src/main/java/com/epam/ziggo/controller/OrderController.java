package com.epam.ziggo.controller;

import java.util.List;

import javax.validation.Valid;

import com.epam.ziggo.mapping.CreateOrderMapper;
import com.epam.ziggo.mapping.OrderIdMapper;
import com.epam.ziggo.mapping.OrderMapper;
import com.epam.ziggo.service.OrderService;
import com.epam.ziggo.vo.CreateOrderVO;
import com.epam.ziggo.vo.OrderIdVO;
import com.epam.ziggo.vo.OrderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/order")
@Tag(name = "Order service", description = "Order API. Order a product for a given user")
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final OrderIdMapper orderIdMapper;
    private final CreateOrderMapper createOrderMapper;

    @PostMapping
    public OrderIdVO createOrder(@Valid @RequestBody CreateOrderVO orderVO){
        try{
            return orderIdMapper.map(orderService.createOrder(createOrderMapper.map(orderVO)));
        } catch (DataIntegrityViolationException throwable){
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, "Product is already assigned to the user", throwable);
        } catch (Throwable throwable){
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "System error", throwable);
        }

    }

    @GetMapping()
    public @ResponseBody List<OrderVO> getAll(){
        return orderMapper.map(orderService.findAll());
    }

}
