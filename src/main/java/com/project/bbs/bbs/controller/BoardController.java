package com.project.bbs.bbs.controller;

import com.project.bbs.bbs.dto.BoardDto;
import com.project.bbs.bbs.dto.ResponseDto;
import com.project.bbs.bbs.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boards")
    public ResponseDto<List<BoardDto>> get(Integer page, Integer size) {
        return ResponseDto.<List<BoardDto>>builder()
                .data(boardService.get(page, size))
                .build();
    }

    @GetMapping("/board/{id}")
    public ResponseDto<BoardDto> get(@PathVariable("id") Long id) {
        return ResponseDto.<BoardDto>builder()
                .data(boardService.get(id))
                .build();
    }

    @PostMapping("/board")
    public ResponseDto<Object> post(@RequestBody BoardDto boardDto) {
        boardService.save(boardDto);
        return ResponseDto.builder().build();
    }
}

