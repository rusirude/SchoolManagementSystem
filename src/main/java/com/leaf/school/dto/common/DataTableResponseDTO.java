package com.leaf.school.dto.common;

import java.io.Serializable;
import java.util.List;

/**
 * @Author : Rusiru De Silva
 */
public class DataTableResponseDTO implements Serializable{
    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private List<?> data;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
