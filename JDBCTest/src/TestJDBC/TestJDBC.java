package TestJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class TestJDBC {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            //注册Driver
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/base1", "root", "old46new47");
            //创建statement对象
            Statement smt = connect.createStatement();
            String s = "select * from biao1";
            //执行命令并得到结果
            ResultSet res = smt.executeQuery(s);
            //处理命令执行的结果
            while(res.next()) {//迭代器，不然无法getString
                System.out.println(res.getString(1) + " " + res.getString(2));//第一列就是1
            }
            res.close();
            smt.close();
            connect.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            //检查型异常
            e.printStackTrace();
        }
    }

}
