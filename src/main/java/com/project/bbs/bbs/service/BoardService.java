package com.project.bbs.bbs.service;

import com.project.bbs.bbs.domain.Board;
import com.project.bbs.bbs.dto.BoardDto;
import com.project.bbs.bbs.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    public List<BoardDto> get(Integer page, Integer size) {
        final Pageable pageable = PageRequest.of(page, size);
        final Page<Board> boardPage = boardRepository.findAll(pageable);

        return  boardPage.getContent().stream()
                .map((board) -> modelMapper.map(board, BoardDto.class))
                .collect(Collectors.toList());
    }

    public BoardDto get(Long id) {
        final Board board = boardRepository.findById(id).orElse(new Board());
        return modelMapper.map(board, BoardDto.class); // board -> BoardDto;
    }
}
