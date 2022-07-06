import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class management extends JFrame implements ActionListener{
	JLabel header;
	JButton jb1,jb2,jb3;
	
	public management(String s){
		super(s);
        setLayout(null);
		header = new JLabel(new ImageIcon("search.jpg"));
		jb1 = new JButton("Student");
		jb2 = new JButton("Company");
		jb3 = new JButton("Search");
		
		header.setBounds(0,0,1920,1080);		
		jb1.setBounds(30,50,100,40);jb2.setBounds(150,50,100,40);jb3.setBounds(270,50,100,40);
		
		add(jb1);add(jb2);add(jb3);
		add(header);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jb1){
			this.setVisible(false);
			student i = new student("student");
			i.setSize(1920,1080);
			i.setVisible(true);
		}
		else if(e.getSource()==jb2){
			this.setVisible(false);
			company i = new company("company");
			i.setSize(1920,1080);
			i.setVisible(true);
		}
		else{
			this.setVisible(false);
			search i = new search("search");
			i.setSize(1920,1080);
			i.setVisible(true);
		}
				
	}
	
	public static void main(String[] arr){
		management i = new management("Management");
		i.setSize(1920,1080);
		i.setVisible(true);
	}
}	
		
		
		
		
		
		