package com.good.jzhouse.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Pages<T> implements Serializable {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer count;
    private Integer totleCount;
    private List<T> list;

    public Pages(){

    }

    public Pages(Integer pageIndex,Integer pageSize,Integer count,List<T> list){
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.count = count;
        this.totleCount = count==0?0:(pageSize-1)/count;
        this.list = list;
    }
}
