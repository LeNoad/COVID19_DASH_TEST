package DB;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Time.dateTime;
import javaParse.parseSearch;

public class DBManager {
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://192.168.0.4:3306/COVID_DASH?characterEncoding=UTF-8&serverTimezone=UTC";
    private final String USER_NAME ="root";
    private final String PASSWORD = "as153462";
    
    Connection conn = null;
    Statement state = null;
    ResultSet rs = null;
    
    String[] sibe = {"../imgs/����Ư����.jpg",
			"../imgs/�λ걤����.jpg",
			"../imgs/�뱸������.png",
			"../imgs/��õ������.jpg",
			"../imgs/���ֱ�����.png",
			"../imgs/����������.gif",
			"../imgs/��걤����.png",
			"../imgs/����Ư����ġ��.png",
			"../imgs/��⵵.jpg",
			"../imgs/������.png",
			"../imgs/��û�ϵ�.png",
			"../imgs/��û����.png",
			"../imgs/����ϵ�.gif",
			"../imgs/���󳲵�.jpg",
			"../imgs/���ϵ�.png",
			"../imgs/��󳲵�.png",
			"../imgs/����Ư����ġ��.jpg",};
    
    String[] sibeName = {"����","�λ�","�뱸","��õ","����","����","���","����","��⵵","������","��û�ϵ�","��û����","����ϵ�","���󳲵�","���ϵ�","��󳲵�","���ֵ�"};
    
    public DBManager() {
       
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
            System.out.println("[MySQL Connection]");
   
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(int i, int j, int k) {
    	
        // search �Լ� ȣ��
    	parseSearch parse = new parseSearch();
    	parse.search();
    	dateTime time = new dateTime();
    	
    	//�����ͺ��̽��� ���� �ð� ���� 
    	System.out.print(time.date());
    	System.out.print(time.dateTime());
    	
    	//������ �Է�
    	String sqlsum = "insert into area_parse (date, datetime, cityname, confirmed_p) Values ('"+time.date()+"', '"+time.dateTime()+"', '"+sibeName[j]+"', '"+parse.getSumLine(i)+"');";
    	String sqlsum2 = "insert into covid_parse (date, confirmed_p, recov_p, death_p) Values ('"+time.date()+"', '"+parse.getSumLine(3)+"', '"+parse.getSumLine(5)+"', '"+parse.getSumLine(6)+"');";
    	
    	System.out.println(time.dateTime()+":"+sqlsum);
    	System.out.println(time.dateTime()+":"+sqlsum2);
    	
    	try {
    		
    		 OutputStream out = new FileOutputStream("E:\\SQL_Event_Log.txt");
    		 OutputStream out2 = new FileOutputStream("E:\\SQL_Event_Log2.txt");
    		 
    		 byte[] outSQL = sqlsum.getBytes();
    		 byte[] outSQL2 = sqlsum2.getBytes();
    		 
			 out.write(outSQL);
			 out2.write(outSQL2);
			 
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
    		 Class.forName(JDBC_DRIVER);
    		 conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
    		 state = conn.createStatement();
    		 
    		 state.execute(sqlsum);
    		 state.execute(sqlsum2);
    		 
    		 state.close();
    		 conn.close();

    	} catch (ClassNotFoundException e) {
			// TODO: handle exception
    		e.printStackTrace();
    		
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
    }
}