

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
	 JLabel user;
	JLabel passwd;
	 JTextField userName;
	 JPasswordField passwdText;
	 JButton ok,canel;
	JPanel base;
	public MainFrame() {
		 user = new JLabel("yonghu");
			passwd = new JLabel("mima");
			userName = new JTextField(50);
			passwdText = new JPasswordField(50);
			base = new JPanel();
			ok = new JButton("login");
			canel = new JButton("exit");
			
			user.setBounds(10, 10, 60, 20);
			passwd.setBounds(10, 50, 60, 20);
			userName.setBounds(80, 10, 80, 20);
			passwdText.setBounds(80,50,80,20);
			ok.setBounds(10, 150, 100, 50);
			canel.setBounds(150,150,100,50);
			
			ok.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					next();
				}
				
			});
			
			canel.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					passwdText.setText("");
					userName.setText("");
				}
				
			});
			base.setLayout(null);
			base.add(user);
			base.add(passwd);
			base.add(userName);
			base.add(passwdText);
			base.add(ok);
			base.add(canel);
			
			this.setContentPane(base);
			this.setSize(300,300);
			this.setVisible(true);
			this.setDefaultCloseOperation(3);
			
	}
	public void next() {
		login test = new login();
		test.check(userName.getText(),String.valueOf(passwdText.getPassword()));
		if (test.ok) {
			System.out.println("login successful!");
			this.dispose();
			
			JFrame frame = new JFrame("...");
			JMenuBar menubar = new JMenuBar();
			JMenu menus[] = new JMenu[4]; 
			//JPanel base = new JPanel();
			for (int i=0;i<4;i++) {
				menus[i] = new JMenu("menu" + i);
				menubar.add(menus[i]);
			}
			//base.add(menubar);
			frame.add(menubar,BorderLayout.NORTH);
			frame.setSize(600,600);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(3);
			
		}
		else {
			JOptionPane.showMessageDialog(this, "用户或密码错误", "警告", JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
