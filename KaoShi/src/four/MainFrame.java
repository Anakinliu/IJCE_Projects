package four;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class MainFrame extends JFrame{
	 JLabel user;
	JLabel passwd;
	 JTextField userName;
	 JPasswordField passwdText;
	 JButton ok,canel;
	JPanel base;
	JMenuBar menuBar;
	JMenu jMenu[];

	public MainFrame() {
		 user = new JLabel("yonghu");
			passwd = new JLabel("mima");
			userName = new JTextField(20);
			passwdText = new JPasswordField(20);
			base = new JPanel();
			ok = new JButton("login");
			canel = new JButton("exit");
			
			user.setBounds(50, 50, 60, 20);
			passwd.setBounds(50, 80, 60, 20);
			userName.setBounds(110, 50, 100, 20);
			passwdText.setBounds(110,80,100,20);
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
		menuBar = new JMenuBar();
		jMenu = new JMenu[4];
		for (int i=0;i<4;i++) {
			jMenu[i] = new JMenu("menu" + i);
			menuBar.add(jMenu[i]);
		}
		if (test.check(userName.getText(),passwdText.getText())) {
			this.dispose();

			JFrame n = new JFrame();

			//base.removeAll();
			//base.add(menuBar);
			n.add(menuBar, BorderLayout.NORTH);
			n.setSize(600,600);
			n.setVisible(true);
		}
		else {
			System.out.println("Login Failed");
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
