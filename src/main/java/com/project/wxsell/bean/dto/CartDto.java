package com.project.wxsell.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by yachao on 2018/9/16.
 */
@Data
@AllArgsConstructor
public class CartDto {

    private String productId;

    private Integer productQuantity;
}
