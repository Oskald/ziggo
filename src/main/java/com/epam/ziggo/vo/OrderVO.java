package com.epam.ziggo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderVO {
    private Long id;
    private Long productId;
    private String email;
    private String firstName;
    private String lastName;
}
