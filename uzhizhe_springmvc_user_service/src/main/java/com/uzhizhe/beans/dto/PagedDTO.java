package com.uzhizhe.beans.dto;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class PagedDTO<T> {
    private int page = 1;
    private int pageSize = 10;
    private int totalSize;
    private List<T> list;

    public static <TEMP> PagedDTO<TEMP> emptyPagedDTO(Class<TEMP> clazz) {
        PagedDTO<TEMP> pageDTO = new PagedDTO<>();
        pageDTO.setList(Collections.emptyList());
        pageDTO.setTotalSize(0);
        return pageDTO;
    }
}
