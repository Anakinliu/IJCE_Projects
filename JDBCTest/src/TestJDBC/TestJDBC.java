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
            //ע��Driver
            Class.forName("com.mysql.jdbc.Driver");
            //��������
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/base1", "root", "old46new47");
            //����statement����
            Statement smt = connect.createStatement();
            String s = "select * from biao1";
            //ִ������õ����
            ResultSet res = smt.executeQuery(s);
            //��������ִ�еĽ��
            while(res.next()) {//����������Ȼ�޷�getString
                System.out.println(res.getString(1) + " " + res.getString(2));//��һ�о���1
            }
            res.close();
            smt.close();
            connect.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            //������쳣
            e.printStackTrace();
        }
    }

}
