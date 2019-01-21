package Crawler;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class UDS_Crawler {

	private String URL = "http://www.libdb.yuntech.edu.tw/yuntecherm/sendurl_api_v3.jsp?dbid=DB17235";
	private String IndexURL = "http://www.libdb.yuntech.edu.tw:2051";///ndapp/Index"; //無法解析
	//private HttpURLConnection conn;
	private Cookie cookie = new Cookie();
	//private URL url;
	InputStream inputStream ; 
	String string ;
	Document xmlDoc;
	
	public UDS_Crawler(){
		
	}
	
	public Document PostSearch(String keyword,String date) throws Exception {
		System.out.println("關鍵字:" + keyword + ", 日期:" + date);
		Document doc = Jsoup.connect(this.URL).data("SearchString", keyword.trim()).data("day1","1095")
		// and other hidden fields which are being passed in post request.
				.userAgent("Mozilla").post();
		return doc;
	}
	
	public Document NewsPage(String urlstr) throws Exception{
		URL url = new URL(this.IndexURL+urlstr);
		//System.out.println("NewsPage:" +  this.IndexURL+urlstr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5000);
		conn.setRequestProperty("Cookie", cookie.getCookie());
		conn.connect();
		InputStream inputStream = conn.getInputStream(); 
		String string = StreamUtils.getString(inputStream);
		Document xmlDoc = Jsoup.parse(string);
		return xmlDoc;
	}
	public Document SearchResultPage(String urlstr)throws Exception{
		URL url = new URL(urlstr);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5000);
		conn.setRequestProperty("Cookie", cookie.getCookie());
		conn.connect();
		InputStream inputStream = conn.getInputStream(); 
		String string = StreamUtils.getString(inputStream);
		Document xmlDoc = Jsoup.parse(string);
		
		return xmlDoc;
	}
	
}
