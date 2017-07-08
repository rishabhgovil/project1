package com.example.rishabh.gettinbored.model;

import java.util.ArrayList;

/**
 * Created by RISHABH on 06-07-2017.
 */

public class newsclass {
    String status;
    String source;
    String sortBy;
    ArrayList<articles> articles;

    public newsclass(String status, String source, String sortBy, ArrayList<com.example.rishabh.gettinbored.model.articles> articles) {
        this.status = status;
        this.source = source;
        this.sortBy = sortBy;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public ArrayList<com.example.rishabh.gettinbored.model.articles> getArticles() {
        return articles;
    }
}
