package com.sparta.levelone.service;

import com.sparta.levelone.dto.BoardRequestDto;
import com.sparta.levelone.dto.BoardResponseDto;
import com.sparta.levelone.entity.Board;
import com.sparta.levelone.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    public BoardResponseDto createBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        Board saveBoard = boardRepository.save(board);
        return new BoardResponseDto(board);
    }

    public List<BoardResponseDto> getBoards() {
        return boardRepository.findAllByOrderByCreatedAtDesc().stream().map(BoardResponseDto::new).toList();
    }

    public BoardResponseDto getBoard(Long id) {
        Board board = findBoard(id);
        return new BoardResponseDto(board);
    }

    public BoardResponseDto updateBoard(Long id, BoardRequestDto requestDto) {
        Board board = findBoard(id);
        if (board.getPassword().equals(requestDto.getPassword())) {
            board.update(requestDto);
            return new BoardResponseDto(board);
        } else {
            throw new IllegalArgumentException("비밀번호 틀림");
        }
    }



    public Long deleteBoard(Long id) {
        Board board = findBoard(id);
        boardRepository.delete(board);
        return id;
    }


    public Board findBoard(Long id) {
        Optional<Board> optionalBoard = boardRepository.findById(id);
        return optionalBoard.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "게시글이 존재하지 않습니다.")
        );
    }
}