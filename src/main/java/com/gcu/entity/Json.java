package com.gcu.entity;

import lombok.Data;

import java.util.List;

@Data
public class Json {
    private int code;
    private String msg;
    private long count;
    private List<?> data;
}
