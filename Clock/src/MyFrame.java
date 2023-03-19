import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.*;


public class MyFrame extends JFrame {
	
	Calendar calendar;
	SimpleDateFormat timeFormat; 
	SimpleDateFormat dateFormat;
	SimpleDateFormat dayFormat;
	JLabel timeLabel;
	JLabel dateLabel;
	JLabel dayLabel;
	String time;
	String date;
	String day;
	
	MyFrame() {
		
		//Frame Design
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Clock");
		this.setLayout(new FlowLayout());
		this.setSize(302,200);
		this.setResizable(false);
		
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a");  //Time format based on:  https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#text
		dateFormat =  new SimpleDateFormat("dd/MM/yyyy");	  //Date format based on:  https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#text
		dayFormat =  new SimpleDateFormat("EEEEEEE");     //Day format based on:   https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#text
		
		
		//Time Design
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Ink Free", Font.PLAIN,50));
		//timeLabel.setForeground(new Color(0x00FF00));
		//timeLabel.setBackground(Color.black);
		//timeLabel.setOpaque(true);
		
		//Date Design
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Ink Free", Font.PLAIN,35));
		
		
		//Day Design
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Ink Free", Font.PLAIN,35));
		
		
		
		time = timeFormat.format(Calendar.getInstance().getTime());
		timeLabel.setText(time);
		
		
		this.add(timeLabel);
		this.add(dateLabel);
		this.add(dayLabel);
		this.setVisible(true);
		
		
		setTime();
	}
		//update clock every sec
	public void setTime() {
		
		//Getting current time,date,day
		while(true) {
			
		time = timeFormat.format(Calendar.getInstance().getTime()); 
		timeLabel.setText(time);
		
		date = dateFormat.format(Calendar.getInstance().getTime());
		dateLabel.setText(date);
		
		day = dayFormat.format(Calendar.getInstance().getTime());
		dayLabel.setText(day);
		
		//How long does the clock refresh
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		}
	
}
