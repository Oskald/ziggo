package com.epam.ziggo.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersHolderVO {
    private Long page;
    private Long perPage;
    private Long total;
    private Long totalPages;
    private List<UserVO> data;
}
