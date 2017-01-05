package com.ThingInJava;

import java.sql.Connection;

/**
 * Created by liu_y.
 * On 2016/10/22.
 */




public class ConnectionManager {
    static int howManyLeft = 3;
    static Connection2[] ca = new Connection2[3];
    {
        for(Connection2 x : ca)
            x = Connection2.makeConnection();
    }
    public static Connection2 getConnection() {
        if(howManyLeft > 0)
            return ca[--howManyLeft];
        else {
            System.out.println("No more connections");
            return null;
        }
    }
    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager();
        System.out.println(cm.howManyLeft);
        cm.getConnection();
        System.out.println(howManyLeft);
        cm.getConnection();
        System.out.println(howManyLeft);
        cm.getConnection();
        System.out.println(cm.getConnection());
        System.out.println(howManyLeft);
    }
}