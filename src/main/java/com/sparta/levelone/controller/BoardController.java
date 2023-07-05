package com.sparta.levelone.controller;

import com.sparta.levelone.dto.BoardRequestDto;
import com.sparta.levelone.dto.BoardResponseDto;
import com.sparta.levelone.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    // 게시글 생성
    @PostMapping("/boards")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }

    // 게시글 조회 (전체)
    @GetMapping("/boards")
    public List<BoardResponseDto> getBoards() {
        return boardService.getBoards();
    }

    // 게시글 조회 (선택)
    @GetMapping("/boards/{id}")
    public BoardResponseDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    // 게시글 수정
    @PutMapping("/boards/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.updateBoard(id, requestDto);
    }

    // 게시글 삭제
    @DeleteMapping("/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }
}