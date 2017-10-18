package com.anakinliu.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnector {
    // 驱动包全名
    static final String JDBC_DRIVER_PATH = "com.mysql.jdbc.Driver";

    // 数据库URL
    static final String DB_URL = "jdbc:mysql://localhost:3306/nopdata";

    // 数据库用户名， 密码
    static final String DB_USER = "root";
    static final String DB_USER_PASSWD = "qwer5678";


    private Connection con = null;
    /*
     * 实例化类时就打开数据库连接
     */
    public MysqlConnector() {
        try {
            // 注册JDBC驱动器，黑人问号？？？
            Class.forName(JDBC_DRIVER_PATH);

            // 打开数据库的连接
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PASSWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
	 * 连接数据库并检查用户名与密码
	 */
    public boolean check(String wUserName, String wPasswd) {



        boolean flag = false;
        try {
//			// 注册JDBC驱动器，黑人问号？？？
//			Class.forName(JDBC_DRIVER_PATH);

            // 预处理的sql语句
            String sql = "SELECT username, password FROM user;";

//			// 打开数据库的连接
//			con = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PASSWD);

            // 开始查询
            PreparedStatement pre = null;
            pre = con.prepareStatement(sql);
            // 得到结果集合
            ResultSet res = pre.executeQuery();


            while (res.next()) {
                //通过表列名检索
                String userName = res.getString("username");
                String userPasswd = res.getString("password");


                // 比较检查密码与用户名
                if (userName.equals(wUserName) &&
                        userPasswd.equals(wPasswd)) {
                    flag = true;
                    break;
                }
            }

            // 顺利完成就关闭连接, 倒序
            res.close();
            pre.close();
            //closeCon(); 如果关闭连接, 会导致刷新页面时, 控制台显示: 数据库已关闭, 无法操作

        } catch(SQLException sqlE) {
            sqlE.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    /*
     * 如果关闭连接, 会导致刷新页面时, 控制台显示: 数据库已关闭, 无法操作
     */
    private void closeCon() {
        try {
            con.close();
        } catch(SQLException sqlE) {
            sqlE.printStackTrace();
        }

    }
}
