import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	JLabel jl,jl1,jl2,header;
	JTextField jt1;
	JPasswordField jt2;

	JButton jb;
	
	public Login(String s){
		super(s);
        setLayout(null);
		jl = new JLabel(new ImageIcon("user2.png")); 
		jl1 = new JLabel(new ImageIcon("user1.png"));        
        jl2 = new JLabel(new ImageIcon("passlogo.png"));
		header = new JLabel(new ImageIcon("bglogin(1).jpg"));
		
		jt1 = new JTextField(20);
		jt2 = new JPasswordField(20);
		
		jb = new JButton("Log In");
		
		header.setBounds(0,0,1920,1080);
		jl.setBounds(930,370,140,120);
		jl1.setBounds(830,500,40,40);jt1.setBounds(880,500,250,40);
		jl2.setBounds(830,550,40,40);jt2.setBounds(880,550,250,40);
		jb.setBounds(880,600,250,40);	
		jb.setBackground(Color.BLUE);
		jb.setForeground(Color.white);
		
		add(jl);
		add(jl1);add(jt1);
        	add(jl2);add(jt2);
		add(jb);
		add(header);
		
		jb.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/btu","root","");
			
			String email = jt1.getText();
			String password = jt2.getText();
			
			Statement st = cn.createStatement();		
			ResultSet rs = st.executeQuery("select * from login where email='"+email+"'");
			this.setVisible(false);
						management i = new management("Management");
						i.setSize(1920,1080);
						i.setVisible(true);
			/*if(rs.next()){
				if(rs.getString("email").equals(email)){
					if(rs.getString("pass").equals(password)){
						this.setVisible(false);
						management i = new management("Management");
						i.setSize(1920,1080);
						i.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null,"Incorrect Password");
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Incorrect email");
				}				
			}
			else{
				JOptionPane.showMessageDialog(null,"Record not found");
			}*/
		}
		catch(ClassNotFoundException er){
			System.out.print(er.getMessage());
		}
		catch(SQLException er){
			System.out.print(er.getMessage());
		}
				
	}
	
	public static void main(String[] arr){
		Login i = new Login("Login");
		i.setSize(1920,1080);
		i.setVisible(true);
	}
}	
		
		
		
		
		
		