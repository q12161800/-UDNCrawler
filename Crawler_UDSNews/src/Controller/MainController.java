package Controller;

import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import DataBase.mysql;
import Model.News;
import Models.URL;
import Model.URLlist;
import Crawler.UDS_Crawler;
import Tool.LoadProps;

public class MainController {
	
	private LoadProps loadprops;
	private UDS_Crawler crawler ;
	private mysql db;
	private URL url;
	
	public MainController() throws Exception{
		loadprops = new LoadProps();
		crawler = new UDS_Crawler();
		url = new URL();
		//db = new mysql();
	}
	
	public void Crawlerprocess(int page, String IndexURL) throws Exception{

		ArrayList<String> urllist = url.getURLList();

		//Document searchresult = null;
//		for (String url : urllist) {//版次A1 A2
//			System.out.println(url);
//			while (true) {
//				URL urlpage = new URL();
//
//				url = urlpage.getURL(url,page);// url.replace("&page=" + i,
//													// "&page=" + (i + 1));
//				System.out.println("第" + page + "頁:" + url);
//				System.out.println("URL list:");
//				searchresult = crawler.SearchResultPage(url.split("===")[1]);// crawler.PostSearch("財經",//
//																				// "");
//																				// //
//																				// //crawler.PostLogin();
//				// System.out.println(searchresult);
//				Elements linkslist = searchresult.select("a[href^=/ndapp/Story2007?no=]");
//				// System.out.println(linkslist);
//				if (linkslist.size() == 0) {
//					break;
//				} else {
//					for (Element link : linkslist) {
//						// System.out.println(link.attr("abs:href"));
//						String newsurl = link.toString().split(" ")[1].replace("href=\"", "").replace("\"", "")
//								.replace("&amp", "").replace(";", "&");
//						System.out.println(IndexURL + newsurl);
//						//Document newspage = crawler.NewsPage(newsurl);
//						//News news = new News(newspage, IndexURL+newsurl);
//						//news.NewsPageAnalysis();
//						// System.out.println(newspage);
//						//db.insert_news(news);
//					}
//					page++;
//				}
//			}
//		}
	}
	
	public String getUDNUrl(){
		return loadprops.getProperties("newsurl");
	}
}
