package com.example.web_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDTO {
    private String name;
    private String author;
    private String price;
}
