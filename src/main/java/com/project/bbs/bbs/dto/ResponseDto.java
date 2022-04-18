package com.project.bbs.bbs.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto<T> {
    @Builder.Default
    private String status = "success";
    private T data;
}
