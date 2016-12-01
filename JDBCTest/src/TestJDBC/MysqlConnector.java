package TestJDBC;
import java.sql.*;
/**
 * Created by Anakinliu.
 * On 2016/11/26.
 */
public class MysqlConnector {
    private static Connection connect ;
    private static Statement st;
    public static Connection getConnection() {
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "old46new47");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }
    public static void insert() {

        connect = getConnection(); // 首先要获取连接，即连接到数据库

        try {
            String sql = "insert into user(ID,NAME,PASSWORD) values (1,'tom','123456')";  // 插入数据的sql语句

            st = (Statement) connect.createStatement();    // 创建用于执行静态sql语句的Statement对象

            int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数

            System.out.println("向staff表中插入 " + count + " 条数据"); //输出插入操作的处理结果

            connect.close();   //关闭数据库连接

        } catch (SQLException e) {
            System.out.println("插入数据失败" + e.getMessage());
        }
    }
    public static void insert(String sql) {

        connect = getConnection(); // 首先要获取连接，即连接到数据库

        try {

            st = (Statement) connect.createStatement();    // 创建用于执行静态sql语句的Statement对象

            int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数

            System.out.println("向staff表中插入 " + count + " 条数据"); //输出插入操作的处理结果

            connect.close();   //关闭数据库连接

        } catch (SQLException e) {
            System.out.println("插入数据失败" + e.getMessage());
        }
    }
    /* 更新符合要求的记录，并返回更新的记录数目*/
    public static void update() {
        connect = getConnection(); //同样先要获取连接，即连接到数据库
        try {
            String sql = "update user set PASSWORD='abcd1234' where NAME = 'tom'";// 更新数据的sql语句

            st = (Statement) connect.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量

            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数

            System.out.println("user表中更新 " + count + " 条数据");      //输出更新操作的处理结果

            connect.close();   //关闭数据库连接

        } catch (SQLException e) {
            System.out.println("更新数据失败");
        }
    }
    public static void update(String sql) {
        connect = getConnection(); //同样先要获取连接，即连接到数据库
        try {


            st = (Statement) connect.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量

            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数

            System.out.println("user表中更新 " + count + " 条数据");      //输出更新操作的处理结果

            connect.close();   //关闭数据库连接

        } catch (SQLException e) {
            System.out.println("更新数据失败");
        }
    }
    /* 删除符合要求的记录，输出情况*/
    public static void delete() {

        connect = getConnection(); //同样先要获取连接，即连接到数据库
        try {
            String sql = "delete from user  where NAME = 'tom'";// 删除数据的sql语句
            st = (Statement) connect.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量

            int count = st.executeUpdate(sql);// 执行sql删除语句，返回删除数据的数量

            System.out.println("user表中删除 " + count + " 条数据\n");    //输出删除操作的处理结果

            connect.close();   //关闭数据库连接

        } catch (SQLException e) {
            System.out.println("删除数据失败");
        }

    }
    public static void delete(String sql) {

        connect = getConnection(); //同样先要获取连接，即连接到数据库
        try {
            st = (Statement) connect.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量

            int count = st.executeUpdate(sql);// 执行sql删除语句，返回删除数据的数量

            System.out.println("user表中删除 " + count + " 条数据\n");    //输出删除操作的处理结果

            connect.close();   //关闭数据库连接

        } catch (SQLException e) {
            System.out.println("删除数据失败");
        }

    }
    /* 查询数据库，输出符合要求的记录的情况*/
    public static void query() {

        connect = getConnection(); //同样先要获取连接，即连接到数据库
        try {
            String sql = "select * from user";     // 查询数据的sql语句
            st = (Statement) connect.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量

            ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集
            System.out.println("查询结果为：");
            System.out.println("ID" + " " + "NAME" + " " + "PASSWORD" );
            while (rs.next()) { // 判断是否还有下一个数据

                // 根据字段名获取相应的值
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String password = rs.getString("PASSWORD");

                //输出查到的记录的各个字段的值
                System.out.println(id + " " + name + " " + password );

            }
            connect.close();   //关闭数据库连接

        } catch (SQLException e) {
            System.out.println("查询数据失败");
        }
    }
    public static void main(String[] args) {
        insert();
        insert("insert into user (ID,NAME,PASSWORD) values (2,'tiny','987654')");
        query();
        //update();
        //update user set PASSWORD='abcd1234' where NAME = 'tom'";// 更新数据的sql语句
        update("update user set PASSWORD = 'abcd1234' where ID = 2");
        //"delete from user  where NAME = 'tom'"
        //delete();
        delete("delete from user where ID = 1");
        query();
    }
}
