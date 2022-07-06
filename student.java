/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author LOKESH DEV
 */
public class student extends JFrame implements ActionListener{
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,header;
    JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8,jt9,jt10;     
    JRadioButton jr1,jr2,jr3,jr4,jr5;
	JButton jb,jb1,jb2,jb3;
	
	int flag = 0;
       
    public student(String s){
		super(s);
        setLayout(null);
		jl1 = new JLabel("Roll No");
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
		jl12 = new JLabel("No. of back");
        jt10 = new JTextField(20);
		
		header = new JLabel(new ImageIcon("bgstudent1.jpg"));
		
		jb = new JButton("Submit");
		jb1 = new JButton("Edit");
		jb2 = new JButton("Delete");
		jb3 = new JButton("Home");
        
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(jr1);
        bg1.add(jr2);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(jr3);
        bg2.add(jr4);
		bg2.add(jr5);
		
		header.setBounds(0,0,1920,1080);
		jl1.setBounds(250,50,200,40);jt1.setBounds(450,50,300,40);	jb3.setBounds(850,50,100,40);
		jl2.setBounds(250,120,200,40);jt2.setBounds(450,120,300,40);
		jl3.setBounds(250,190,200,40);jt3.setBounds(450,190,300,40);
		jl4.setBounds(250,260,200,40);jt4.setBounds(450,260,300,40);
		jl5.setBounds(250,330,200,40);jt5.setBounds(450,330,300,40);
		jl6.setBounds(250,400,200,40);jt6.setBounds(450,400,300,40);
		jl7.setBounds(250,470,200,40);jr1.setBounds(450,470,100,40);jr2.setBounds(560,470,100,40);
		jl8.setBounds(250,540,200,40);jr3.setBounds(450,540,100,40);jr4.setBounds(560,540,100,40);jr5.setBounds(670,540,80,40);
		jl9.setBounds(250,610,200,40);jt7.setBounds(450,610,300,40);
		jl10.setBounds(250,680,200,40);jt8.setBounds(450,680,300,40);
		jl11.setBounds(250,750,200,40);jt9.setBounds(450,750,300,40);
		jl12.setBounds(250,820,200,40);jt10.setBounds(450,820,300,40);
		
		jb.setBounds(250,900,100,40);jb1.setBounds(450,900,100,40);jb2.setBounds(650,900,100,40);
		
		jl1.setFont(new Font("Verdana",Font.PLAIN, 20));
		jl2.setFont(new Font("Verdana",Font.PLAIN, 20));
		jl3.setFont(new Font("Verdana",Font.PLAIN, 20));
		jl4.setFont(new Font("Verdana",Font.PLAIN, 20));
		jl5.setFont(new Font("Verdana",Font.PLAIN, 20));
		jl6.setFont(new Font("Verdana",Font.PLAIN, 20));
		jl7.setFont(new Font("Verdana",Font.PLAIN, 20));
		jl8.setFont(new Font("Verdana",Font.PLAIN, 20));
		jl9.setFont(new Font("Verdana",Font.PLAIN, 20));
		jl10.setFont(new Font("Verdana",Font.PLAIN, 20));
		jl11.setFont(new Font("Verdana",Font.PLAIN, 20));
		jl12.setFont(new Font("Verdana",Font.PLAIN, 20));
		
		jr1.setFont(new Font("Verdana",Font.PLAIN, 18));
		jr2.setFont(new Font("Verdana",Font.PLAIN, 18));
		jr3.setFont(new Font("Verdana",Font.PLAIN, 18));
		jr4.setFont(new Font("Verdana",Font.PLAIN, 18));
		jr5.setFont(new Font("Verdana",Font.PLAIN, 18));
		
		jb.setFont(new Font("Verdana",Font.PLAIN, 18));
		jb1.setFont(new Font("Verdana",Font.PLAIN, 18));
		jb2.setFont(new Font("Verdana",Font.PLAIN, 18));
		jb3.setFont(new Font("Verdana",Font.PLAIN, 18));
		
		jb.setForeground(Color.WHITE);jb.setBackground(Color.BLUE);		
		jb1.setForeground(Color.WHITE);jb1.setBackground(Color.GRAY);	
		jb2.setForeground(Color.RED);
		jb3.setForeground(Color.WHITE);jb3.setBackground(Color.DARK_GRAY);	
		
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
		add(jb3);
		add(header);

        jb.addActionListener(this);  
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
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
						student i = new student("student");
						i.setSize(1920,1080);
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
						   student i = new student("student");
							i.setSize(1920,1080);
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
						   student i = new student("student");
							i.setSize(1920,1080);
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
			else if(e.getSource() == jb3){
				this.setVisible(false);
				management mg = new management("Management");
				mg.setSize(1920,1080);
				mg.setVisible(true);
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
		student i = new student("Student");
		i.setSize(1920,1080);
		i.setVisible(true);
	}
    
}
