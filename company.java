import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class company extends JFrame implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6;
	JCheckBox jc1,jc2,jc3,jc4,jc5;
			
	JButton jb,jb1,jb2;
	
	int flag=0;
	
	public company(String s){
		super(s);
        setLayout(null);
		jl1 = new JLabel("Name");
        jt1 = new JTextField(20);
        jl2 = new JLabel("Package");
        jt2 = new JTextField(20);
        jl3 = new JLabel("Branch");
        jc1 = new JCheckBox("CS");
		jc2 = new JCheckBox("IT");
		jc3 = new JCheckBox("ECE");
		jc4 = new JCheckBox("Civil");
		jc5 = new JCheckBox("Mech");
        jl4 = new JLabel("Backlog");
        jt3 = new JTextField(20);
        jl5 = new JLabel("Aggregate");
        jt4 = new JTextField(20);
		jl6 = new JLabel("Location");
        jt5 = new JTextField(20);
        jl7 = new JLabel("Date");
        jt6 = new JTextField(20);		
		
		jb = new JButton("submit");
		jb1 = new JButton("Edit");
		jb2 = new JButton("Delete");
		
		jl1.setBounds(20,20,100,30);jt1.setBounds(120,20,100,30);
		jl2.setBounds(20,60,100,30);jt2.setBounds(120,60,100,30);
		jl3.setBounds(20,100,100,30);jc1.setBounds(120,100,60,30);jc2.setBounds(190,100,60,30);jc3.setBounds(260,100,60,30);jc4.setBounds(330,100,60,30);jc5.setBounds(400,100,60,30);
		jl4.setBounds(20,140,100,30);jt3.setBounds(120,140,100,30);
		jl5.setBounds(20,180,100,30);jt4.setBounds(120,180,100,30);
		jl6.setBounds(20,220,100,30);jt5.setBounds(120,220,100,30);
		jl7.setBounds(20,260,100,30);jt6.setBounds(120,260,100,30);
		
		jb.setBounds(20,280,100,30);
		jb1.setBounds(230,20,100,30);
		jb2.setBounds(230,60,100,30);
		
		add(jl1);add(jt1);
        add(jl2);add(jt2);
		add(jl3);add(jc1);add(jc2);add(jc3);add(jc4);add(jc5);
		add(jl4);add(jt3);
		add(jl5);add(jt4);
		add(jl6);add(jt5);
		add(jl7);add(jt6);
		
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
			Statement st1 = cn.createStatement();
						
			if(e.getSource()==jb){
				try{
					String name = jt1.getText();
					String pkg = jt2.getText();
					
					String branch = "";
					
					int backlog = Integer.parseInt(jt3.getText());
					int aggregate = Integer.parseInt(jt4.getText());
					String location = jt5.getText();
					String date = jt6.getText();
					
					if(flag==0){
						PreparedStatement ps = cn.prepareStatement("insert into company values(?,?,?,?,?,?)");
						PreparedStatement ps1 = cn.prepareStatement("insert into branch values(?,?)");
						
						if(jc1.isSelected()){
							branch = "CS";
							ps1.setString(1,name);
							ps1.setString(2,branch);
							ps1.execute();
						}
						if(jc2.isSelected()){
							branch = "IT";
							ps1.setString(1,name);
							ps1.setString(2,branch);
							ps1.execute();
						}
						if(jc3.isSelected()){
							branch = "ECE";
							ps1.setString(1,name);
							ps1.setString(2,branch);
							ps1.execute();
						}
						if(jc4.isSelected()){
							branch = "Civil";
							ps1.setString(1,name);
							ps1.setString(2,branch);
							ps1.execute();
						}
						if(jc5.isSelected()){
							branch = "Mech";
							ps1.setString(1,name);
							ps1.setString(2,branch);
							ps1.execute();
						}
						
						ps.setString(1,name);
						ps.setString(2,pkg);
						ps.setInt(3,backlog);
						ps.setInt(4,aggregate);
						ps.setString(5,location);
						ps.setString(6,date);							
						
						if(name.length()==0 || pkg.length()==0 || branch.length()==0 || date.length()==0 || location.length()==0 ){
							JOptionPane.showMessageDialog(null,"All Field Required");						
						}
						else if(ps.executeUpdate()>0){
							JOptionPane.showMessageDialog(null,"Record Inserted");	
							
							this.setVisible(false);
							company i = new company("company");
							i.setSize(1920,1080);
							i.setVisible(true);
						}
					}
					else if(flag==1){
						PreparedStatement ps = cn.prepareStatement("update company set package=?,backlog=?,aggregate=?,loc=?,date=? where name=?");	
						ps.setString(1,pkg);
						ps.setInt(2,backlog);
						ps.setInt(3,aggregate);
						ps.setString(4,location);
						ps.setString(5,date);
						ps.setString(6,name);
						
						PreparedStatement ps2 = cn.prepareStatement("delete from branch where company='"+name+"'");
						ps2.execute();
						
						PreparedStatement ps1 = cn.prepareStatement("insert into branch values(?,?)");
						
						if(jc1.isSelected()){
							branch = "CS";
							ps1.setString(1,name);
							ps1.setString(2,branch);
							ps1.execute();
						}
						if(jc2.isSelected()){
							branch = "IT";
							ps1.setString(1,name);
							ps1.setString(2,branch);
							ps1.execute();
						}
						if(jc3.isSelected()){
							branch = "ECE";
							ps1.setString(1,name);
							ps1.setString(2,branch);
							ps1.execute();
						}
						if(jc4.isSelected()){
							branch = "Civil";
							ps1.setString(1,name);
							ps1.setString(2,branch);
							ps1.execute();
						}
						if(jc5.isSelected()){
							branch = "Mech";
							ps1.setString(1,name);
							ps1.setString(2,branch);
							ps1.execute();
						}
							
						if(ps.executeUpdate()>0){
							JOptionPane.showMessageDialog(null,"Record updated");
							this.setVisible(false);
							company i = new company("company");
							i.setSize(1920,1080);
							i.setVisible(true);
						}
						else{
							JOptionPane.showMessageDialog(null,"All Field Required");
						}		
					}
					else if(flag==2){		    	   
							PreparedStatement ps = cn.prepareStatement("delete from company where name=?");	
							PreparedStatement ps1 = cn.prepareStatement("delete from branch where company=?");
							ps.setString(1,name);
							ps1.setString(1,name);
							
							if(ps.executeUpdate()>0 && ps1.executeUpdate()>0 ){
							   JOptionPane.showMessageDialog(null,"Record Deleted");
							   this.setVisible(false);
								company i = new company("company");
								i.setSize(1920,1080);
								i.setVisible(true);
							}
							else{
							   JOptionPane.showMessageDialog(null,"All Field Required");
							}
					}
				}
				catch(NumberFormatException et){
					JOptionPane.showMessageDialog(null,"Invalid input");
				}
				
			}
			else if(e.getSource()==jb1){				
				String name = jt1.getText();
				ResultSet rs = st.executeQuery("select * from company where name ='"+name+"'");
				if(rs.next()){
					flag=1;
					ResultSet rs1 = st1.executeQuery("select * from branch where company ='"+name+"'");
					while(rs1.next()){
						if(rs1.getString("branch").equals("CS")){
							jc1.setSelected(true);
						}
						if(rs1.getString("branch").equals("IT")){
							jc2.setSelected(true);
						}
						if(rs1.getString("branch").equals("ECE")){
							jc3.setSelected(true);
						}
						if(rs1.getString("branch").equals("Civil")){
							jc4.setSelected(true);
						}
						if(rs1.getString("branch").equals("Mech")){
							jc5.setSelected(true);
						}
					}
					jt2.setText(rs.getString(2));
					
					jt3.setText(Integer.toString(rs.getInt(3)));
					jt4.setText(Integer.toString(rs.getInt(4)));
					jt5.setText(rs.getString(5));
					jt6.setText(rs.getString(6));
						  
				}
				else{
					JOptionPane.showMessageDialog(null,"Record not Found");
				}
			}
			else if(e.getSource()==jb2){
				String name = jt1.getText();
				
				ResultSet rs = st.executeQuery("select * from company where name ='"+name+"'");				
				if(rs.next()){
					flag=2;
					ResultSet rs1 = st1.executeQuery("select * from branch where company ='"+name+"'");
					while(rs1.next()){
						if(rs1.getString("branch").equals("CS")){
							jc1.setSelected(true);
						}
						if(rs1.getString("branch").equals("IT")){
							jc2.setSelected(true);
						}
						if(rs1.getString("branch").equals("ECE")){
							jc3.setSelected(true);
						}
						if(rs1.getString("branch").equals("Civil")){
							jc4.setSelected(true);
						}
						if(rs1.getString("branch").equals("Mech")){
							jc5.setSelected(true);
						}
					}
					
					jt2.setText(rs.getString(2));
					jt3.setText(Integer.toString(rs.getInt(3)));
					jt4.setText(Integer.toString(rs.getInt(4)));
					jt5.setText(rs.getString(5));	
					jt6.setText(rs.getString(6));
						  
				}
				else{
					JOptionPane.showMessageDialog(null,"Record not Found");
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
	
	public static void main(String[] arr){
		company i = new company("company");
		i.setSize(1920,1080);
		i.setVisible(true);
	}
}