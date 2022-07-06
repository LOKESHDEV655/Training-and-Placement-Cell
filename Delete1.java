
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Delete1 extends JFrame implements ActionListener{
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12;
    JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8,jt9,jt10;     
    JRadioButton jr1,jr2,jr3,jr4,jr5;
	JButton jb,jb1,jb2;
	
	int flag =0;
       
    public Delete1(String s){
		super(s);
        setLayout(null);
		jl1 = new JLabel("Roll no.");
        jt1 = new JTextField(20);
        jl2 = new JLabel("Student ID");
        jt2 = new JTextField(20);
        jl3 = new JLabel("First Name");
        jt3 = new JTextField(20);
        jl4 = new JLabel("Last Name");
        jt4 = new JTextField(20);
        jl5 = new JLabel("Email");
        jt5 = new JTextField(20);
        jl6 = new JLabel("Phone no");
        jt6 = new JTextField(20);
        
        jl7 = new JLabel("Gender");
        jr1 = new JRadioButton("male");
        jr2 = new JRadioButton("female");
                
        jl8 = new JLabel("Branch");
        jr3 = new JRadioButton("CS");
        jr4 = new JRadioButton("IT");
        jr5 = new JRadioButton("ECE");
		
		jl9 = new JLabel("10th %");
        jt7 = new JTextField(20);
        jl10 = new JLabel("12th %");
        jt8 = new JTextField(20);
        jl11 = new JLabel("B.Tech %");
        jt9 = new JTextField(20);
		jl12 = new JLabel("no. of back");
        jt10 = new JTextField(20);
		
		jb = new JButton("Submit");
		jb1 = new JButton("Edit");
		jb2 = new JButton("Delete");
		
        
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(jr1);
        bg1.add(jr2);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(jr3);
        bg2.add(jr4);
		bg2.add(jr5);
		
		jl1.setBounds(20,20,100,30);jt1.setBounds(120,20,100,30);
		jl2.setBounds(20,60,100,30);jt2.setBounds(120,60,100,30);
		jl3.setBounds(20,100,100,30);jt3.setBounds(120,100,100,30);
		jl4.setBounds(20,140,100,30);jt4.setBounds(120,140,100,30);
		jl5.setBounds(20,180,100,30);jt5.setBounds(120,180,100,30);
		jl6.setBounds(20,220,100,30);jt6.setBounds(120,220,100,30);
		jl7.setBounds(20,260,100,30);jr1.setBounds(120,260,100,30);jr2.setBounds(230,260,100,30);
		jl8.setBounds(20,300,100,30);jr3.setBounds(120,300,100,30);jr4.setBounds(230,300,100,30);jr5.setBounds(340,300,100,30);
		jl9.setBounds(20,340,100,30);jt7.setBounds(120,340,100,30);
		jl10.setBounds(20,380,100,30);jt8.setBounds(120,380,100,30);
		jl11.setBounds(20,420,100,30);jt9.setBounds(120,420,100,30);
		jl12.setBounds(20,460,100,30);jt10.setBounds(120,460,100,30);
		
		jb.setBounds(20,520,100,30);
		jb1.setBounds(230,20,100,30);
		jb2.setBounds(230,60,100,30);
		
        add(jl1);add(jt1);
        add(jl2);add(jt2);
		add(jl3);add(jt3);
		add(jl4);add(jt4);
		add(jl5);add(jt5);
		add(jl6);add(jt6);
		
		add(jl7);add(jr1);add(jr2);
		add(jl8);add(jr3);add(jr4);add(jr5);
        
		add(jl9);add(jt7);
        add(jl10);add(jt8);
		add(jl11);add(jt9);
        add(jl12);add(jt10);
        add(jb);
		add(jb1);
		add(jb2);

        jb.addActionListener(this);  
		jb1.addActionListener(this);
		jb2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/btu","root","");
		    Statement st = cn.createStatement();
		    if(e.getSource()==jb){
				
			   int sn = Integer.parseInt(jt1.getText());
			   String student_id = jt2.getText();
			   String fname = jt3.getText();
			   String lname = jt4.getText();
			   String email = jt5.getText();
			   String phone = jt6.getText();
			   
			   String gender = null;
			   if(jr1.isSelected()){
				   gender = "male";
			   }
			   else if(jr2.isSelected()){
				   gender = "female";
			   }
			   
			   String branch = null;
			   if(jr3.isSelected()){
				   branch = "CS";
			   }
			   else if(jr4.isSelected()){
				   branch = "IT";
			   }
			   else if(jr5.isSelected()){
				   branch = "ECE";
			   }
			   
			   int tenth = Integer.parseInt(jt7.getText());
			   int twe = Integer.parseInt(jt8.getText());
			   int btech = Integer.parseInt(jt9.getText());
			   int nob = Integer.parseInt(jt10.getText());	    	   
			  
			    if(flag==0){				   
			   
				   PreparedStatement ps = cn.prepareStatement("insert into student(student_id,fname,lname,email,phone,gender,branch,tenth,twe,btech,nob) values(?,?,?,?,?,?,?,?,?,?,?)");
				   
					ps.setInt(1,sn);
					ps.setString(2,student_id);
					ps.setString(3,fname);
					ps.setString(4,lname);
					ps.setString(5,email);
					ps.setString(6,phone);
					ps.setString(7,gender);
					ps.setString(8,branch);
					ps.setInt(9,tenth);
					ps.setInt(10,twe);
					ps.setInt(11,btech);
					ps.setInt(12,nob);			
				   
				   if(ps.executeUpdate()>0){
					   JOptionPane.showMessageDialog(null,"Record Inserted");
					   this.setVisible(false);
						Delete1 i = new Delete1("student");
					    i.setSize(600,600);
						i.setVisible(true);
				   }
				   else{
					   JOptionPane.showMessageDialog(null,"All Field Required");
				   }
			    }
			    else if(flag==1){		    	   
						    PreparedStatement ps = cn.prepareStatement("update student set student_id=?,fname=?,lname=?,email=?,phone=?,gender=?,branch=?,tenth=?,twe=?,btech=?,nob=? where sn=?");					   
					    	
							ps.setString(1,student_id);
							ps.setString(2,fname);
							ps.setString(3,lname);
							ps.setString(4,email);
							ps.setString(5,phone);
							ps.setString(6,gender);
							ps.setString(7,branch);
							ps.setInt(8,tenth);
							ps.setInt(9,twe);
							ps.setInt(10,btech);
							ps.setInt(11,nob);
							ps.setInt(12,sn);
						
						if(ps.executeUpdate()>0){
						   JOptionPane.showMessageDialog(null,"Record updated");
						   this.setVisible(false);
						   Delete1 i = new Delete1("student");
						   i.setSize(600,600);
						   i.setVisible(true);
					   }
					   else{
						   JOptionPane.showMessageDialog(null,"All Field Required");
					   }
			    }
				else if(flag==2){		    	   
						PreparedStatement ps = cn.prepareStatement("Delete from student where sn=?");		   
						ps.setInt(1,sn);
						
						if(ps.executeUpdate()>0){
						   JOptionPane.showMessageDialog(null,"Record Deleted");
						   this.setVisible(false);
						   Delete1 i = new Delete1("student");
						   i.setSize(600,600);
						   i.setVisible(true);
					    }
					    else{
						   JOptionPane.showMessageDialog(null,"All Field Required");
					    }
			    }
		    }
			else if(e.getSource()==jb1 || e.getSource()==jb2){				
				int sn = Integer.parseInt(jt1.getText());
				ResultSet rs = st.executeQuery("select * from student where sn ="+sn+"");
				if(rs.next()){
					if(e.getSource()==jb1){
						flag=1;
					}
					else if(e.getSource()==jb2){
						flag=2;
					}
					
					jt2.setText(rs.getString(2));
					jt3.setText(rs.getString(3));
					jt4.setText(rs.getString(4));
					jt5.setText(rs.getString(5));
					jt6.setText(rs.getString(6));
					
					if(rs.getString(7).equals("male")){
						jr1.setSelected(true);
					}
					else if(rs.getString(7).equals("female")){
						jr2.setSelected(true);
					}
					if(rs.getString(8).equals("CS")){
						jr3.setSelected(true);
					}
					else if(rs.getString(8).equals("IT")){
						jr4.setSelected(true);
					}
					else if(rs.getString(8).equals("ECE")){
						jr5.setSelected(true);
					}
					
					jt7.setText(Integer.toString(rs.getInt(9)));
					jt8.setText(Integer.toString(rs.getInt(10)));
					jt9.setText(Integer.toString(rs.getInt(11)));
					jt10.setText(Integer.toString(rs.getInt(12)));		
					  
				}
				else{
					JOptionPane.showMessageDialog(null,"Record not Foumd");
				}
				
			}
			
		   cn.close();	
	    }
        catch(ClassNotFoundException er){
			System.out.print(er.getMessage());
		}
		catch(SQLException er){
			System.out.print(er.getMessage());
		}
    }
	
	public static void main(String[] arr){
		Delete1 i = new Delete1("student");
		i.setSize(600,600);
		i.setVisible(true);
	}
    
}
