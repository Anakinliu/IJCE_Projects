

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login {
	String dbName;
	String dbPasswd;
	int row;
	boolean ok;
	public void check(String name,String passwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","123456");
			
			PreparedStatement pst = con.prepareStatement("select * from user");
			
			ResultSet rs = pst.executeQuery();
			
			//System.out.println(inputName);
			row = 0;
			ok = false;
			while (rs.next()) {
				
				if (rs.getString(1).equals(name)) {
					row = rs.getRow();
					dbName = rs.getString(1);
					//�û����ڵ�һ��
					//System.out.println(rs.getString(1));
				}
				
				//System.out.println(".......");
			}
			
			if (row<1) {
				//û�д��û�
				ok =  false;
			}
			
			System.out.println("row" + row);
			
			//����ƶ���row��
			rs.absolute(row);
			
			System.out.println("������û�������Ӧ��������" + name + passwd);
			
		
			
			dbPasswd = rs.getString(2);//�����ڵڶ���
			
			System.out.println("���ݿ�����" + rs.getString(2));
			System.out.println("���������" + passwd);
			if (dbPasswd.equals(passwd)) { //equals!!no ==
				System.out.println("������ȷ");
				ok = true;
			}
			else {
				ok = false;
			}
			
			rs.close();
			
			pst.close();
			
			con.close();
		} catch (Exception e) { //!!!!!!!!!!
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public login() {
		System.out.println("login...");
		
	}
}
