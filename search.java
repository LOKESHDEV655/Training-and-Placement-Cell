import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;

public class search extends JFrame implements ActionListener{
	JLabel jl1,header;
	JComboBox jc;
	String str[]={null};
	
	JTable jt;
	JScrollPane js;
	DefaultTableModel dt;
	JButton jb,jb1;
	
	public search(String s){
		super(s);
        setLayout(null);
		jl1 = new JLabel("Company");  
		header = new JLabel(new ImageIcon("search.jpg"));
        jc  = new JComboBox(str);        		
		jb = new JButton(new ImageIcon("search_img.png"));
		jb1 = new JButton("Home");
		
				
		jt = new JTable();
		js = new JScrollPane(jt);
		dt = new DefaultTableModel(0,0);                       //DefaultTableModel(0,0) with 0 rows and 0 columns
		String col[] = {"student_id","fname","lname","Email","Branch","Gender","Btech%","backlog"};
		dt.setColumnIdentifiers(col);
		jt.setModel(dt);
		
		header.setBounds(0,0,500,500);
		jl1.setBounds(30,50,80,40);jc.setBounds(110,50,100,40);		
		jb.setBounds(250,50,40,40);jb1.setBounds(300,50,100,40);
		
		js.setBounds(50,160,400,200);
		
		add(jl1);add(jc);        		
		add(jb);add(jb1);
		add(js);
		add(header);
		jb.addActionListener(this);
		jb1.addActionListener(this);
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/btu","root","");
			Statement st = cn.createStatement();
			
			ResultSet rs = st.executeQuery("select * from company");
			while(rs.next()){
				jc.addItem(rs.getString(1));		
			}
		}
		catch(ClassNotFoundException er){
			System.out.print(er.getMessage());
		}
		catch(SQLException er){
			System.out.print(er.getMessage());
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jb1){
			this.setVisible(false);
			management i = new management("Login");
			i.setSize(1920,1080);
			i.setVisible(true);
		}
		else{
			dt.setRowCount(0);
			String cname = (String)jc.getSelectedItem();
			String branch = "";
			try{
				int nob = 0;
				int aggregate = 0;
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/btu","root","");		
				
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery("select * from company where name='"+cname+"'");
				while(rs.next()){				
					nob = rs.getInt(3);
					aggregate = rs.getInt(4);
					
				}				
				
				ResultSet rs2 = st.executeQuery("select * from branch where company='"+cname+"'");
				while(rs2.next()){				
					branch = rs2.getString(2);
					
					Statement st1 = cn.createStatement();
					ResultSet rs1 = st1.executeQuery("select * from student where nob<="+nob+" AND tenth>="+aggregate+" AND twe>="+aggregate+" AND btech>="+aggregate+" AND branch='"+branch+"'");
				
					while(rs1.next()){
						dt.addRow(new Object[]{rs1.getString("student_id"),rs1.getString("fname"),rs1.getString("lname"),rs1.getString("email"),rs1.getString("branch"),rs1.getString("gender"),rs1.getInt("btech"),rs1.getInt("nob")}); 
					}
				}
				
				
			}
			catch(ClassNotFoundException er){
				System.out.print(er.getMessage());
			}
			catch(SQLException er){
				System.out.print(er.getMessage());
			}
		}
		
	}
	
	public static void main(String[] arr){
		search i = new search("search");
		i.setSize(500,500);
		i.setVisible(true);
	}
}