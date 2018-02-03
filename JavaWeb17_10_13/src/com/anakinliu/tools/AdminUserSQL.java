package com.anakinliu.tools;

import com.anakinliu.model.AdminUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Anakinliu on 17.12.10.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class AdminUserSQL extends MysqlConnector {
    private static Connection con = MysqlConnector.getConnection();

    public AdminUserSQL(String path, String url, String user, String pw) {
        super(path, url, user, pw);
    }

    public static int insertAdminUser(AdminUser user) throws SQLException{
        String sql = "INSERT INTO admin(username, password, permission) VALUES(?,?,?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getPermissions());
        System.out.println(user.getPermissions());
        return ps.executeUpdate();
    }

}
