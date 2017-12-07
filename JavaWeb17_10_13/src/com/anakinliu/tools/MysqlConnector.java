package com.anakinliu.tools;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnector {
//    // 驱动包全名
//    private  String JDBC_DRIVER_PATH = null;
//
//
//    // 数据库URL
//    private  String DB_URL = null;
//
//    // 数据库用户名， 密码
//    private  String DB_USER = null;
//    private  String DB_USER_PASSWD = null;

    private static Connection con = null;

    public static Connection getConnection() {
        return con;
    }

    /*
     * 实例化类时就打开数据库连接
     */
    private MysqlConnector(String path, String url, String user, String pw) {
        try {
            // 注册JDBC驱动器，黑人问号？？？
            Class.forName(path);
            // 打开数据库的连接
            con = DriverManager.getConnection(url, user, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MysqlConnector initMySqlConnector(String path, String url, String user, String pw) {
        return new MysqlConnector(path, url, user, pw);
    }

    /*
	 * 连接数据库并检查用户名与密码
	 */
    public boolean check(String wUserName, String wPasswd, String wUserType) {

        boolean flag = false;
        try {
//			// 注册JDBC驱动器，黑人问号？？？
//			Class.forName(JDBC_DRIVER_PATH);

            // 预处理的sql语句
            String sql = "SELECT username, password FROM " + wUserType;

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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    /*
    如果用户名已存在, 返回false
     */
    public boolean insert(String wUserName, String wPasswd) {
        // 预处理的sql语句
        String checkUsername = "SELECT username FROM user;";
        String insertUser = "INSERT INTO user (username, password) VALUES(\"" +
                wUserName + "\", \"" + wPasswd + "\")";
        boolean flag = true;
        try {
            System.out.println(insertUser);
            PreparedStatement preparedStatement = con.prepareStatement(checkUsername);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                if (username.equals(wUserName)) {
                    flag = false;
                    break;
                }
            }
            // 新用户可以插入
            if (flag) {
                preparedStatement = con.prepareStatement(insertUser);
                preparedStatement.execute();
            }

            // 顺利完成就关闭连接, 倒序
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    /*
     * 如果关闭连接, 会导致刷新页面时, 控制台显示: 数据库已关闭, 无法操作
     * TODO: 使用线程池创建连接
     */
    public void closeCon() {
        try {
            con.close();
        } catch(SQLException sqlE) {
            sqlE.printStackTrace();
        }

    }
}
