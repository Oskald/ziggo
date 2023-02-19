package com.epam.ziggo.vo;

import java.lang.annotation.Annotation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.epam.ziggo.validation.UserValidationConstraint;
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
