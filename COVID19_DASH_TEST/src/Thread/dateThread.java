package Thread;

import java.awt.Color;

import javax.swing.JLabel;

import Time.dateTime;
import UI.coronaUI;
import javaParse.parseSearch;

public class dateThread extends Thread{
	private parseSearch parse = new parseSearch();
	
	private JLabel allConfirm = new JLabel();
	private JLabel cured = new JLabel();
	private JLabel death = new JLabel();
	private JLabel refreshTime = new JLabel();
	
	private JLabel logDate = new JLabel();
	private JLabel logrefreshTime = new JLabel();
	
	private JLabel timedate = new JLabel();
	private coronaUI corona = new coronaUI();
	
	
	
	public void dateThread() {
		while(true) {
			parse.search();
			dateTime date = new dateTime();
			
			allConfirm.setFont(corona.font1); //폰트
			allConfirm.setBounds(20,30,80,25); // 위치
			allConfirm.setForeground(Color.RED); // 색상
			allConfirm.setText(parse.getSumLine(3)); // setText
			//완치자 데이터값
			
			cured.setFont(corona.font1);// 폰트
			cured.setBounds(180,30,80,25); // 위치
			cured.setForeground(Color.RED); // 색상
			cured.setText(parse.getSumLine(5)); // setText
			//사망자 데이터값
			
			death.setFont(corona.font1);// 폰트 설정
			death.setBounds(315,30,80,25); //사망자
			death.setForeground(Color.RED); // death 글자색 
			death.setText(parse.getSumLine(6)); //setText
			//갱신시간 표시
			
			refreshTime.setFont(corona.font1);
			refreshTime.setBounds(20,50,210,25);
			refreshTime.setForeground(Color.GRAY);
			refreshTime.setText("갱신 시간 : "+date.dateTime());
			//프레임에 추가
			
			corona.frm.add(allConfirm);
			corona.frm.add(cured);
			corona.frm.add(death);
			corona.frm.add(refreshTime);
			
			logDate.setFont(corona.font);
			logDate.setBounds(20,30,350,25);
			logDate.setForeground(Color.BLACK);
			logDate.setText("배열(3) : "+parse.getSumLine(3)+" 배열(5) : "+parse.getSumLine(5)+" 배열(6) : "+parse.getSumLine(6));
			
			logrefreshTime.setFont(corona.font1);
			logrefreshTime.setBounds(20,50,210,25);
			logrefreshTime.setForeground(Color.GRAY);
			logrefreshTime.setText("갱신 시간 : "+date.dateTime());
			
			corona.log.add(logrefreshTime);
			corona.log.add(logDate);
			System.out.println("받아온시간 : "+date.dateTime());
			
			System.out.println("coronaUI 에 받아온 parseSearch 배열(3)값 : "+parse.getSumLine(3));
			System.out.println("coronaUI 에 받아온 parseSearch 배열(5)값 : "+parse.getSumLine(5));
			System.out.println("coronaUI 에 받아온 parseSearch 배열(6)값 : "+parse.getSumLine(6));

			try {
				allConfirm.repaint();
				cured.repaint();
				death.repaint();
				refreshTime.repaint();
				logDate.repaint();
				logrefreshTime.repaint();
				Thread.sleep(10000);
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public void run() {
		dateThread();
	}
}
