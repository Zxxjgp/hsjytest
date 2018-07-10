package com.springmvc.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable{

    private static final long serialVersionUID = 7338793109182937318L;

    private int pageNum;
    private int pageSize;
    private int size;
    private int startRow;
    private int endRow;
    private List<T> list = new ArrayList<T>();

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public Page(int pageNum, int pageSize, int size, int startRow, int endRow) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.size = size;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    public Page(List <T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.size = size;
        this.startRow = startRow;
        this.endRow = endRow;
        this.list = list;
    }

    public List <T> getList() {
        return list;
    }

    public void setList(List <T> list) {
        this.list = list;
    }
}
