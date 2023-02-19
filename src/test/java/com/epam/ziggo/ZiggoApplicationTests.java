package com.epam.ziggo;

import com.epam.ziggo.vo.CreateOrderVO;
import com.epam.ziggo.vo.OrderIdVO;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ZiggoApplicationTests {

    @Value(value="${local.server.port}")
    private int port;


    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void contextLoads() {
    }

    private String getUrl(){
        return "http://localhost:"+port+"/order";
    }

    @DisplayName("Single order creation all is OK")
    @Test
    void createOrder_AllIsCorrect_SuccessTest(){
//        ARRANGE
        CreateOrderVO createOrderVO = new CreateOrderVO(6L, "george.bluth@reqres.in");
//        ACT
        ResponseEntity<OrderIdVO> responseEntity = restTemplate.postForEntity(getUrl(), createOrderVO, OrderIdVO.class);
//        ASSERT
        Assertions.assertEquals(200, responseEntity.getStatusCode().value());
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertNotNull(responseEntity.getBody().getId());
    }

    @DisplayName("All is ok test response 200")
    @Test
    void createOrder_WrongEmail_FailTest(){
//        ARRANGE
        CreateOrderVO createOrderVO = new CreateOrderVO(2L, "aaa.bbb@ccc.ddd");
//        ACT
        ResponseEntity<OrderIdVO> responseEntity = restTemplate.postForEntity(getUrl(), createOrderVO, OrderIdVO.class);
//        ASSERT
        Assertions.assertEquals(400, responseEntity.getStatusCode().value());
    }

    @DisplayName("Duplicate pair product-email test response 409")
    @Test
    void createOrder_DuplicateProduct_FailTest(){
//        ARRANGE
        CreateOrderVO createOrderVO = new CreateOrderVO(3L, "george.bluth@reqres.in");
//        ACT
        ResponseEntity<OrderIdVO> responseEntity = restTemplate.postForEntity(getUrl(), createOrderVO, OrderIdVO.class);
        if(responseEntity.getStatusCode().value() != 200){
            throw new RuntimeException("Test data doesnt prepared correctly");
        }
        responseEntity = restTemplate.postForEntity(getUrl(), createOrderVO, OrderIdVO.class);
//        ASSERT
        Assertions.assertEquals(409, responseEntity.getStatusCode().value());
    }

    @DisplayName("Missed email test response is 400")
    @Test
    void createOrder_MissedEmail_FailedTest(){
//        ARRANGE
        CreateOrderVO createOrderVO = new CreateOrderVO(4L, null);
//        ACT
        ResponseEntity<OrderIdVO> responseEntity = restTemplate.postForEntity(getUrl(), createOrderVO, OrderIdVO.class);
//        ASSERT
        Assertions.assertEquals(400, responseEntity.getStatusCode().value());
    }

    @DisplayName("Missed product test response is 400")
    @Test
    void createOrder_MissedProduct_FailedTest(){
//        ARRANGE
        CreateOrderVO createOrderVO = new CreateOrderVO(null, "george.bluth@reqres.in");
//        ACT
        ResponseEntity<OrderIdVO> responseEntity = restTemplate.postForEntity(getUrl(), createOrderVO, OrderIdVO.class);
//        ASSERT
        Assertions.assertEquals(400, responseEntity.getStatusCode().value());
    }

}
