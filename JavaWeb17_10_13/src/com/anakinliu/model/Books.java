package com.anakinliu.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Anakinliu on 17.12.2.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Books implements Serializable {
    private ArrayList<Book> bookArrayList;


    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }


}
