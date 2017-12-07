package com.anakinliu.model;

/**
 * Created by Anakinliu on 17.12.2.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Book implements java.io.Serializable{
    private String title = "";
    private String isbn = "";
    private float price;
    private int publisherID;
    private int count;
    private String intro = "";

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
