package com.anakinliu.tools;

import com.anakinliu.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Anakinliu on 17.12.2.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class BookSQL {
    private static Connection con = MysqlConnector.getConnection();

    private static void toBook(ArrayList<Book> bookArrayList, String sql) {
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getFloat("price"));
                book.setCount(resultSet.getInt("count"));
                book.setIntro(resultSet.getString("intro"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setPublisherID(resultSet.getInt("pubID"));

                bookArrayList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 只根据图书名搜索
    public static ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        String sql = "SELECT * FROM books where title=" + "\"" +
                title + "\";";
        toBook(bookArrayList, sql);
        return bookArrayList;
    }

    // 只根据出版社 ID 搜索
    public static ArrayList<Book> searchBypubID(int pubID) {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        String sql = "SELECT * FROM books where pubID="  +
                pubID + ";";
        toBook(bookArrayList, sql);
        return bookArrayList;
    }


    // 所有图书
    public static ArrayList<Book> search() {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        String sql = "SELECT * FROM books";
        toBook(bookArrayList, sql);
        return bookArrayList;
    }

    public static void add(String title, String isbn, float price,
                           int publisherID, int count,
                           String intro) {
        String insertBook =
                "INSERT INTO books (title, isbn, price, pubID, count, intro) VALUES(\"" +
                title + "\", \"" + isbn +
                        "\", " + price +
                        ", " + publisherID +
                        ", " + count +
                        ", \"" + intro +
                "\")";

        try {
            PreparedStatement  pre = con.prepareStatement(insertBook);
            pre.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
