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
			
			allConfirm.setFont(corona.font1); //��Ʈ
			allConfirm.setBounds(20,30,80,25); // ��ġ
			allConfirm.setForeground(Color.RED); // ����
			allConfirm.setText(parse.getSumLine(3)); // setText
			//��ġ�� �����Ͱ�
			
			cured.setFont(corona.font1);// ��Ʈ
			cured.setBounds(180,30,80,25); // ��ġ
			cured.setForeground(Color.RED); // ����
			cured.setText(parse.getSumLine(5)); // setText
			//����� �����Ͱ�
			
			death.setFont(corona.font1);// ��Ʈ ����
			death.setBounds(315,30,80,25); //�����
			death.setForeground(Color.RED); // death ���ڻ� 
			death.setText(parse.getSumLine(6)); //setText
			//���Žð� ǥ��
			
			refreshTime.setFont(corona.font1);
			refreshTime.setBounds(20,50,210,25);
			refreshTime.setForeground(Color.GRAY);
			refreshTime.setText("���� �ð� : "+date.dateTime());
			//�����ӿ� �߰�
			
			corona.frm.add(allConfirm);
			corona.frm.add(cured);
			corona.frm.add(death);
			corona.frm.add(refreshTime);
			
			logDate.setFont(corona.font);
			logDate.setBounds(20,30,350,25);
			logDate.setForeground(Color.BLACK);
			logDate.setText("�迭(3) : "+parse.getSumLine(3)+" �迭(5) : "+parse.getSumLine(5)+" �迭(6) : "+parse.getSumLine(6));
			
			logrefreshTime.setFont(corona.font1);
			logrefreshTime.setBounds(20,50,210,25);
			logrefreshTime.setForeground(Color.GRAY);
			logrefreshTime.setText("���� �ð� : "+date.dateTime());
			
			corona.log.add(logrefreshTime);
			corona.log.add(logDate);
			System.out.println("�޾ƿ½ð� : "+date.dateTime());
			
			System.out.println("coronaUI �� �޾ƿ� parseSearch �迭(3)�� : "+parse.getSumLine(3));
			System.out.println("coronaUI �� �޾ƿ� parseSearch �迭(5)�� : "+parse.getSumLine(5));
			System.out.println("coronaUI �� �޾ƿ� parseSearch �迭(6)�� : "+parse.getSumLine(6));

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
