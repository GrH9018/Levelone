package com.sparta.levelone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDto {
    private String title;
    private String author;
    private String password;
    private String contents;


    @Getter
    public static class PasswordDto{
        private String password;
    }
}