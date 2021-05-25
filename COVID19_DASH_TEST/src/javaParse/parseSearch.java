package javaParse;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class parseSearch {
    Document doc;
    public String sumLine;
    
    public String getSumLine(int i) {
        Elements sumLine = doc.select(".number");
        String parseSumLine = sumLine.text();
        String parseNo = parseSumLine.replaceAll(",", "");
        String[] Result = parseNo.split(" ");
        return Result[i];
    }

    public void search() {

        try {
           Connection.Response excute =  Jsoup.connect("http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=").execute();
           doc = Jsoup.parse(excute.body());
//        	doc =  Jsoup.connect("http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=").get();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException Error");
        }
    }
    
}