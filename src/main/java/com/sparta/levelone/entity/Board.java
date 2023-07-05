package com.sparta.levelone.entity;

import com.sparta.levelone.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "board")
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "contents", nullable = false,  length = 500)
    private String contents;

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }

    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();;
        this.contents = requestDto.getContents();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
    }
}