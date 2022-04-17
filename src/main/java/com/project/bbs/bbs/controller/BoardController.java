package com.project.bbs.bbs.controller;

import com.project.bbs.bbs.dto.BoardDto;
import com.project.bbs.bbs.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boards")
    public List<BoardDto> get(Integer page, Integer size) {
        return boardService.get(page, size);
    }

    @GetMapping("/board/{id}")
    public BoardDto get(@PathVariable("id") Long id) {
        return boardService.get(id);
    }
}

