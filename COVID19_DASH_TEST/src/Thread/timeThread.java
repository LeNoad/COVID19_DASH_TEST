package Thread;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;

import Time.dateTime;
import UI.coronaUI;

public class timeThread extends Thread {
	private JLabel timedate = new JLabel();
	coronaUI corona = new coronaUI();
	
	public void timeThread() {
		
		while(true) {
			dateTime time = new dateTime();
			timedate.setText("현재 시간 : "+time.dateTime());
			timedate.setFont(corona.font1);
			timedate.setForeground(Color.BLACK);
			timedate.setBounds(20,70,210,25);
			coronaUI.frm.add(timedate);
		try {
			timedate.repaint();
			Thread.sleep(1000);		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			}
		}
	}
	public void run() {
		timeThread();
	}
}
