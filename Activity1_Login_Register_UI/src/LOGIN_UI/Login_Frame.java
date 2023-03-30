package LOGIN_UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import javax.swing.*;
public final class Login_Frame extends JFrame implements ActionListener {
	
	New_Account_Frame NewA= new New_Account_Frame();
	ImageIcon icon = new ImageIcon("images_-.png");
	Toolkit toolkit = getToolkit();
	Dimension size = toolkit.getScreenSize();
	JLabel username=new JLabel("Username ");
	JLabel password=new JLabel("Password ");
	
	JTextField usertxt =new JTextField();
	JPasswordField PassField =new JPasswordField();
	
	JButton newAccount =new JButton("<html><u>Don't have an accout? Sign Up</u></html>");
	JButton Login =new JButton("Sign in");
	JButton Cancel =new JButton("Cancel");
	
	ImageIcon img = new ImageIcon(new ImageIcon("bg.jpg").getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
	JLabel bg = new JLabel("", img, JLabel.CENTER);
	
	ImageIcon img3 = new ImageIcon(new ImageIcon("username-.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
	JLabel icon1 = new JLabel("", img3, JLabel.RIGHT);
	
	JLabel signin =new JLabel ("Sign In To Your Account");
	
	JCheckBox showpass =new JCheckBox();
	JLabel sp=new JLabel("Show Password");
	
	String user="empty";
	String pass;
	
	String Firstname;
	String Middlename;
	String Lastname;
	void Login_Frame(){
		setSize(410,440);
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		setTitle("LOGIN/REGISTER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(icon.getImage());
		getContentPane().setBackground(Color.decode("#205072"));
		setResizable(false);
		bg.setBounds(0, 0, 400, 400);
		
		signin.setBounds(90, 40, 250,40);
		signin.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 21));
		signin.setForeground(Color.WHITE);
		icon1.setBounds(155, 70, 80, 80);

		username.setBounds(165, 140, 150, 30);
		username.setForeground(Color.white);
		usertxt.setBounds(65, 160, 260, 30);
		usertxt.setForeground(Color.WHITE);
		usertxt.setHorizontalAlignment(JTextField.CENTER);
		usertxt.setBorder(BorderFactory.createMatteBorder(0,0,3,0,Color.white ));
		usertxt.setOpaque(false);
		
		password.setBounds(165, 190, 150, 30);
		password.setForeground(Color.white);
		PassField.setBounds(65, 210, 260, 30);
		PassField.setEchoChar('*');
		PassField.setHorizontalAlignment(JTextField.CENTER);
		PassField.setForeground(Color.WHITE);
		PassField.setBorder(BorderFactory.createMatteBorder(0,0,3,0,Color.white ));
		PassField.setOpaque(false);
		
		
		showpass.setBounds(110, 250, 20, 20);
		showpass.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
		showpass.setOpaque(false);
		showpass.addActionListener(this);
		sp.setBounds(130, 250, 100, 20);
		sp.setForeground(Color.WHITE);
		add(showpass);
		
		Login.setBounds(110, 280, 80, 25);
		Login.setForeground(Color.white);
		Login.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		Login.setFocusable(false);
		Login.setBackground(Color.decode("#0000FF"));
		Login.addActionListener(this);
		
		Cancel.setBounds(200, 280, 80, 25);
		Cancel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		Cancel.setForeground(Color.white);
		Cancel.setBackground(Color.decode("#AA4A44"));
		Cancel.setFocusable(false);
		Cancel.addActionListener(this);
		
		newAccount.setBounds(95, 310, 200, 25);
		newAccount.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
		newAccount.setOpaque(false);
		newAccount.setBackground(Color.decode("#329D9C"));
		newAccount.setForeground(Color.white);
		newAccount.setFocusable(false);
		newAccount.addActionListener(this);
		
		
		add(sp);
		add(signin);
		add(icon1);
		add(username);
		add(usertxt);
		add(password);
		add(PassField);
		add(newAccount);
		add(Login);
		add(Cancel);
		add(bg);
		setLayout(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String username =usertxt.getText();
		String password =(new String(PassField.getPassword()));

		if(e.getSource()==showpass) {
			if(showpass.isSelected()==true) {
				PassField.setEchoChar((char)0);
			}else {
				PassField.setEchoChar('*');
			}
			
		}
		
		if(e.getSource().equals(Login)) {
			
			if(user.equals(usertxt.getText()) && pass.equals(new String(PassField.getPassword()))) {
				JOptionPane.showMessageDialog(this, "Login", "Successfully Login", JOptionPane.INFORMATION_MESSAGE);
				DashBoard_Frame dash=new DashBoard_Frame();
				dash.DashBoard_Frame();
				dash.welcome.setText("Welcome !!  " + Firstname +" " +Middlename +" "+ Lastname);
				
				
				this.setVisible(false);		
			}else if (!username.equals(user) || !password.equals(user)) {
				JOptionPane.showMessageDialog(this,"<html>No account detected. <br>You must create your account first.<br> Tap Sign Up to create account.</html>" ,"Create An Account" , JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this,"<html>The Username/Password <br>you entered is incorrect.<br>Try Again!</html>" ,"Incorrect Username/Passsword" , JOptionPane.ERROR_MESSAGE);
			}
			
		}
		if (e.getSource().equals(Cancel)) {
			int ext = JOptionPane.showConfirmDialog(this, "Exit", "Are you want to exit?", JOptionPane.YES_NO_OPTION);
			if (ext == JOptionPane.YES_OPTION) {
				this.dispose();
			}
		}
		
		if (e.getSource().equals(newAccount)) {
			
			int ca = JOptionPane.showConfirmDialog(this, "Create an new Account", "CONFIRM", JOptionPane.YES_NO_OPTION);
			if (ca == JOptionPane.YES_OPTION) {
				this.setVisible(false);
				New_Account_Frame New= new New_Account_Frame();
				New.New_Account_Frame();
			}	
		}
		

				
				
		
			
		
		
		
		
	
	
	}


}
