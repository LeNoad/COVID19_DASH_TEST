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
    private final String DB_URL = "jdbc:mysql://localhost:3306/COVID_DASH?characterEncoding=UTF-8&serverTimezone=UTC";
    private final String USER_NAME =""; // id
    private final String PASSWORD = ""; // pwd
    
    Connection conn = null;
    Statement state = null;
    ResultSet rs = null;
    
    String[] sibe = {"../imgs/서울특별시.jpg",
			"../imgs/부산광역시.jpg",
			"../imgs/대구광역시.png",
			"../imgs/인천광역시.jpg",
			"../imgs/광주광역시.png",
			"../imgs/대전광역시.gif",
			"../imgs/울산광역시.png",
			"../imgs/세종특별자치시.png",
			"../imgs/경기도.jpg",
			"../imgs/강원도.png",
			"../imgs/충청북도.png",
			"../imgs/충청남도.png",
			"../imgs/전라북도.gif",
			"../imgs/전라남도.jpg",
			"../imgs/경상북도.png",
			"../imgs/경상남도.png",
			"../imgs/제주특별자치도.jpg",};
    
    String[] sibeName = {"서울","부산","대구","인천","광주","대전","울산","세종","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도"};
    
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
    	
        // search 함수 호출
    	parseSearch parse = new parseSearch();
    	parse.search();
    	dateTime time = new dateTime();
    	
    	//데이터베이스에 들어가는 시간 포맷 
    	System.out.print(time.date());
    	System.out.print(time.dateTime());
    	
    	//쿼리문 입력
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
