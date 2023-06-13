package com.product.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Response {
    private Object data;
    private int status;
    private String mess;
}
