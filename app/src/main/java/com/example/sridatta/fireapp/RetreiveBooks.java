package com.example.sridatta.fireapp;

/**
 * Created by sridatta on 27-11-2016.
 */

//under construction
    // class to retrieve the info to set to the cards/ recyclerView

public class RetreiveBooks {


    private String title;
    private String author;
    private String location;
    private String publisher;

    private String BookImage;

    public RetreiveBooks(){

    }

    public RetreiveBooks(String publisher, String location, String author, String title,String BookImage) {
        this.publisher = publisher;
        this.location = location;
        this.BookImage=BookImage;
        this.author = author;
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getBookImage() {return BookImage;}

    public void setBookImage(String BookImage) {this.BookImage = BookImage;    }

}
