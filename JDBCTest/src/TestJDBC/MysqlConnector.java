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

        connect = getConnection(); // ����Ҫ��ȡ���ӣ������ӵ����ݿ�

        try {
            String sql = "insert into user(ID,NAME,PASSWORD) values (1,'tom','123456')";  // �������ݵ�sql���

            st = (Statement) connect.createStatement();    // ��������ִ�о�̬sql����Statement����

            int count = st.executeUpdate(sql);  // ִ�в��������sql��䣬�����ز������ݵĸ���

            System.out.println("��staff���в��� " + count + " ������"); //�����������Ĵ�����

            connect.close();   //�ر����ݿ�����

        } catch (SQLException e) {
            System.out.println("��������ʧ��" + e.getMessage());
        }
    }
    public static void insert(String sql) {

        connect = getConnection(); // ����Ҫ��ȡ���ӣ������ӵ����ݿ�

        try {

            st = (Statement) connect.createStatement();    // ��������ִ�о�̬sql����Statement����

            int count = st.executeUpdate(sql);  // ִ�в��������sql��䣬�����ز������ݵĸ���

            System.out.println("��staff���в��� " + count + " ������"); //�����������Ĵ�����

            connect.close();   //�ر����ݿ�����

        } catch (SQLException e) {
            System.out.println("��������ʧ��" + e.getMessage());
        }
    }
    /* ���·���Ҫ��ļ�¼�������ظ��µļ�¼��Ŀ*/
    public static void update() {
        connect = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
        try {
            String sql = "update user set PASSWORD='abcd1234' where NAME = 'tom'";// �������ݵ�sql���

            st = (Statement) connect.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����

            int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���

            System.out.println("user���и��� " + count + " ������");      //������²����Ĵ�����

            connect.close();   //�ر����ݿ�����

        } catch (SQLException e) {
            System.out.println("��������ʧ��");
        }
    }
    public static void update(String sql) {
        connect = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
        try {


            st = (Statement) connect.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����

            int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���

            System.out.println("user���и��� " + count + " ������");      //������²����Ĵ�����

            connect.close();   //�ر����ݿ�����

        } catch (SQLException e) {
            System.out.println("��������ʧ��");
        }
    }
    /* ɾ������Ҫ��ļ�¼��������*/
    public static void delete() {

        connect = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
        try {
            String sql = "delete from user  where NAME = 'tom'";// ɾ�����ݵ�sql���
            st = (Statement) connect.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����

            int count = st.executeUpdate(sql);// ִ��sqlɾ����䣬����ɾ�����ݵ�����

            System.out.println("user����ɾ�� " + count + " ������\n");    //���ɾ�������Ĵ�����

            connect.close();   //�ر����ݿ�����

        } catch (SQLException e) {
            System.out.println("ɾ������ʧ��");
        }

    }
    public static void delete(String sql) {

        connect = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
        try {
            st = (Statement) connect.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����

            int count = st.executeUpdate(sql);// ִ��sqlɾ����䣬����ɾ�����ݵ�����

            System.out.println("user����ɾ�� " + count + " ������\n");    //���ɾ�������Ĵ�����

            connect.close();   //�ر����ݿ�����

        } catch (SQLException e) {
            System.out.println("ɾ������ʧ��");
        }

    }
    /* ��ѯ���ݿ⣬�������Ҫ��ļ�¼�����*/
    public static void query() {

        connect = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
        try {
            String sql = "select * from user";     // ��ѯ���ݵ�sql���
            st = (Statement) connect.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����

            ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����
            System.out.println("��ѯ���Ϊ��");
            System.out.println("ID" + " " + "NAME" + " " + "PASSWORD" );
            while (rs.next()) { // �ж��Ƿ�����һ������

                // �����ֶ�����ȡ��Ӧ��ֵ
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String password = rs.getString("PASSWORD");

                //����鵽�ļ�¼�ĸ����ֶε�ֵ
                System.out.println(id + " " + name + " " + password );

            }
            connect.close();   //�ر����ݿ�����

        } catch (SQLException e) {
            System.out.println("��ѯ����ʧ��");
        }
    }
    public static void main(String[] args) {
        insert();
        insert("insert into user (ID,NAME,PASSWORD) values (2,'tiny','987654')");
        query();
        //update();
        //update user set PASSWORD='abcd1234' where NAME = 'tom'";// �������ݵ�sql���
        update("update user set PASSWORD = 'abcd1234' where ID = 2");
        //"delete from user  where NAME = 'tom'"
        //delete();
        delete("delete from user where ID = 1");
        query();
    }
}
