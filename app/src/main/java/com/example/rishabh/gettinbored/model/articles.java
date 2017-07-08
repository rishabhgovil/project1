package com.example.rishabh.gettinbored.model;

/**
 * Created by RISHABH on 06-07-2017.
 */

public class articles {
        String author;
        String title;
        String description;
        String url;
        String urlToImage;
        String publishedAt;

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getUrl() {
            return url;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public articles(String author, String title, String description, String url,String publishedAt, String urlToImage) {
            this.author = author;
            this.title = title;
            this.description = description;
            this.url = url;
            this.publishedAt = publishedAt;
            this.urlToImage = urlToImage;

        }
    }

