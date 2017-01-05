package four;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login {
	String inputName;
	String inputPasswd;
	public boolean check(String name,String passwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?&useSSL=false","root","nopasswd");
			
			PreparedStatement pst = con.prepareStatement("select number from user");
			
			ResultSet rs = pst.executeQuery();
			
			
			while (rs.next()) {
			inputName = rs.getString(1);
			}
			
			pst = con.prepareStatement("select passwd from user");
			
			rs = pst.executeQuery();
			while (rs.next()) {
			 inputPasswd = rs.getString(1);
			}
			if (name.equals(inputName) && passwd.equals(inputPasswd)) {
				return true;
			}
			
			rs.close();
			
			pst.close();
			
			con.close();
		} catch (Exception e) { //!!!!!!!!!!
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public login() {
		System.out.println("login...");
		
	}
}
