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
	
	private JButton refBtn = new JButton("DB 갱신");
	private JButton exitBtn = new JButton("종료");
	
	public static Font font = new Font("Aharoni 굵게", Font.BOLD, 14);
	public static Font font1 = new Font("Aharoni 굵게", Font.BOLD, 12);
	
	public static JFrame frm = new JFrame();
	public static JFrame log = new JFrame();
	
	private JLabel allconfirmText = new JLabel("총확진자");
	private JLabel curedText = new JLabel("완치자");
	private JLabel deathText = new JLabel("사망자");

	
	public coronaUI(){
		
		frm.setTitle("대한민국 COVID-19 실시간 상황");
		frm.setSize(400,150); // 사이즈 조절
		frm.setVisible(true); //화면 속성
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료
		frm.getContentPane().setLayout(null); // 레이아웃 설정
		frm.setResizable(false);//창 크기 변경 불가
		frm.setLocation(50, 50);
		
		log.setTitle("DataBase insert Log");
		log.setSize(400,150);
		log.setVisible(true);
		log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		log.getContentPane().setLayout(null);
		log.setResizable(false);
		log.setLocation(50, 200);
		
		//총확진자 데이터설명 
		allconfirmText.setFont(font);      //폰트     
		allconfirmText.setBounds(20,10,80,25);// 위치
		//완치자 데이터 설명
		curedText.setFont(font);
		curedText.setBounds(180,10,80,25);
		//사망자 데이터설명
		deathText.setFont(font);// 폰트 설정
		deathText.setBounds(315,10,80,25); // 위치
		// 프레임에 추가
		frm.add(allconfirmText);
		frm.add(curedText);
		frm.add(deathText);
		
		

		refBtn.setBounds(270,70,97,25); // 새로운 데이터 받아온 값
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
			
//		exitBtn.setBounds(290,70,80,25); // 종료 버튼 설정
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
