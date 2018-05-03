/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.vicente.light.export;

import java.io.Serializable;
import java.util.List;

/**
 * @author shiweisen
 * @since 2018-04-08
 */
public class ExcelData implements Serializable {

    private static final long serialVersionUID = -5667105045457159092L;
    // 表头
    private List<String> titles;

    // 数据
    private List<List<Object>> rows;

    // 页签名称
    private String name;

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<List<Object>> getRows() {
        return rows;
    }

    public void setRows(List<List<Object>> rows) {
        this.rows = rows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
