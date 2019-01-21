package Model;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class News {

	private String Title = "";
	private String Subtitle = "";
	private String Context = "";
	private String Date = "";
	private String Author = "";//記者
	private String Class_number = "";//版次
	private String Class_name = "";//版名
	private	String URL = "";	
	private String Publisher = "";//報社
	
	private Document doc;

	public News(Document doc,String url) {
		this.doc = doc;
		this.URL = url;
	}

	public void NewsPageAnalysis() {

		// 主標題
		for (int i = 0; i < doc.getElementsByClass("story_title").size(); i++) {
			if (!doc.getElementsByClass("story_title").get(i).text().equals("")) {
				if (i != 0)
					if (!this.Title.equals(""))
						this.Title += ":" + doc.getElementsByClass("story_title").get(i).text();
					else
						this.Title += doc.getElementsByClass("story_title").get(i).text();
				else
					this.Title += doc.getElementsByClass("story_title").get(i).text();
			}
		}
		// 副標題
		for (int i = 0; i < doc.getElementsByClass("story_sub_title").size(); i++) {
			if (!doc.getElementsByClass("story_sub_title").get(i).text().equals("")) {
				if (i != 0)
					if (!this.Subtitle.equals(""))
						this.Subtitle += ":" + doc.getElementsByClass("story_sub_title").get(i).text();
					else
						this.Subtitle += doc.getElementsByClass("story_sub_title").get(i).text();
				else
					this.Subtitle += doc.getElementsByClass("story_sub_title").get(i).text();
			}
		}

		/*
		 * for (Element link : doc.getElementsByClass("story_title")) { if
		 * (!link.text().equals("")) { this.Title += ":" + link.text(); } }
		 * 
		 * for (Element link : doc.getElementsByClass("story_sub_title")) { if
		 * (!link.text().equals("")) { this.Subtitle += ":" + link.text(); } }
		 * 
		 */
		
		//System.out.println(doc.getElementsByClass("story").get(0).getElementsByTag("p").size());
		
		for(int i=0; i < doc.getElementsByClass("story").get(0).getElementsByTag("p").size();i++){
			
			if(i ==  doc.getElementsByClass("story").get(0).getElementsByTag("p").size()-2){
				this.Date = doc.getElementsByClass("story").get(0).getElementsByTag("p").get(i).text().split("/")[0].replace("【", "");
				this.Publisher =  doc.getElementsByClass("story").get(0).getElementsByTag("p").get(i).text().split("/")[1].trim();
				this.Class_number = doc.getElementsByClass("story").get(0).getElementsByTag("p").get(i).text().split("/")[2].trim();
				this.Class_name = doc.getElementsByClass("story").get(0).getElementsByTag("p").get(i).text().split("/")[3].trim().replace("】", "");
			}else{
				this.Context += doc.getElementsByClass("story").get(0).getElementsByTag("p").get(i).text();
			}
				
		
		}
		
		//記者
		for (Element link : doc.getElementsByClass("story_author")) {
			this.Author = link.text();
		}
		
		
		/*
		for (Element link : doc.getElementsByClass("story")) {
			this.Context += link.text();
		}
*/
		
		//System.out.println("URL:" + this.URL);
		System.out.println("標題:" + this.Title);
		System.out.println("副標題:" +this.Subtitle);
		System.out.println("內文:" +this.Context);
		System.out.println("日期:" +this.Date);
		System.out.println("報社:" +this.Publisher);
		System.out.println("記者:" +this.Author);
		System.out.println("版次:" +this.Class_number);
		System.out.println("版名:" +this.Class_name);
		
		
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getSubtitle() {
		return Subtitle;
	}

	public void setSubtitle(String subtitle) {
		Subtitle = subtitle;
	}

	public String getContext() {
		return Context;
	}

	public void setContext(String context) {
		Context = context;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getClass_number() {
		return Class_number;
	}

	public void setClass_number(String class_number) {
		Class_number = class_number;
	}

	public String getClass_name() {
		return Class_name;
	}

	public void setClass_name(String class_name) {
		Class_name = class_name;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	

}
