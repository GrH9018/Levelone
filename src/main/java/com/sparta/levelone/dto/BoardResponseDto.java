package com.sparta.levelone.dto;

import com.sparta.levelone.entity.Board;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BoardResponseDto {
    private String title;
    private String author;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public BoardResponseDto(Board board) {
        this.title = board.getTitle();
        this.author = board.getAuthor();
        this.contents = board.getContents();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }
}