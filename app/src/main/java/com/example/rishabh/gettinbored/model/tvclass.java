package com.example.rishabh.gettinbored.model;

import java.util.ArrayList;

/**
 * Created by RISHABH on 07-07-2017.
 */

public class tvclass {
    Integer total;
    Integer page;
    Integer pages;
    tv_shows tv_shows;

    public Integer getTotal() {
        return total;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPages() {
        return pages;
    }

    public com.example.rishabh.gettinbored.model.tv_shows getTv_shows() {
        return tv_shows;
    }

    public tvclass(Integer total, Integer page, Integer pages, com.example.rishabh.gettinbored.model.tv_shows tv_shows) {

        this.total = total;
        this.page = page;
        this.pages = pages;
        this.tv_shows = tv_shows;
    }
}
