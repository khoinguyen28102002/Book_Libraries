package com.example.web_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDTO {

    private int id;

    private String title;

    private String author;
    
    private String price;

    private int quantity;

    private String image_url;
}
