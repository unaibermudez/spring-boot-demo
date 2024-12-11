package com.example.demo.dto;

import lombok.Data;

@Data
public class PostCreateRequest {
    private String title;
    private String content;
    private String url;
    private Long user_id;


    
}
