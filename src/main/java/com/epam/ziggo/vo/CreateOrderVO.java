package com.epam.ziggo.vo;

import javax.validation.constraints.NotNull;

import com.epam.ziggo.validation.UserValidationConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateOrderVO {
    @NotNull
    private Long productId;
    @UserValidationConstraint
    @NotNull
    private String email;
}
