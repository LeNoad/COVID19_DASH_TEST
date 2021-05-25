package UI;

import java.awt.Color;
import java.awt.Font;
//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.awt.FlowLayout;
//import java.awt.Frame;
//import java.awt.GridBagLayout;
//import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.beans.EventHandler;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.RepaintManager;
//import javax.swing.JPanel;

import DB.DBManager;
import Time.dateTime;
import javaParse.parseSearch;

public class coronaUI {
	private parseSearch parse = new parseSearch();
	
	private JButton refBtn = new JButton("DB ����");
	private JButton exitBtn = new JButton("����");
	
	public static Font font = new Font("Aharoni ����", Font.BOLD, 14);
	public static Font font1 = new Font("Aharoni ����", Font.BOLD, 12);
	
	public static JFrame frm = new JFrame();
	public static JFrame log = new JFrame();
	
	private JLabel allconfirmText = new JLabel("��Ȯ����");
	private JLabel curedText = new JLabel("��ġ��");
	private JLabel deathText = new JLabel("�����");

	
	public coronaUI(){
		
		frm.setTitle("���ѹα� COVID-19 �ǽð� ��Ȳ");
		frm.setSize(400,150); // ������ ����
		frm.setVisible(true); //ȭ�� �Ӽ�
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����
		frm.getContentPane().setLayout(null); // ���̾ƿ� ����
		frm.setResizable(false);//â ũ�� ���� �Ұ�
		frm.setLocation(50, 50);
		
		log.setTitle("DataBase insert Log");
		log.setSize(400,150);
		log.setVisible(true);
		log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		log.getContentPane().setLayout(null);
		log.setResizable(false);
		log.setLocation(50, 200);
		
		//��Ȯ���� �����ͼ��� 
		allconfirmText.setFont(font);      //��Ʈ     
		allconfirmText.setBounds(20,10,80,25);// ��ġ
		//��ġ�� ������ ����
		curedText.setFont(font);
		curedText.setBounds(180,10,80,25);
		//����� �����ͼ���
		deathText.setFont(font);// ��Ʈ ����
		deathText.setBounds(315,10,80,25); // ��ġ
		// �����ӿ� �߰�
		frm.add(allconfirmText);
		frm.add(curedText);
		frm.add(deathText);
		
		

		refBtn.setBounds(270,70,97,25); // ���ο� ������ �޾ƿ� ��
		frm.getContentPane().add(refBtn);
			refBtn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parseSearch parse = new parseSearch();
				parse.search();
				DBManager dbManager = new DBManager();
					int j = 0;
					int k = 0;
							for(int i=11; i<=139; i+=8) {
								dbManager.insert(i,j,k);
							k++;
							j++;
						}
				// TODO Auto-generated method stub
				
				}
			});
			
//		exitBtn.setBounds(290,70,80,25); // ���� ��ư ����
//		frm.getContentPane().add(exitBtn);
//		exitBtn.addActionListener( new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.exit(0);
//			}
//		});
	}
}
