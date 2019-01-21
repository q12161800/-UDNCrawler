package Model;

public class URL {
	private String url;
	private int currentpage;

	public URL(String url) {
		this.url = url;
	}
	
	public String URLPageNumber(int i){
		//http://www.libdb.yuntech.edu.tw:2051/ndapp/Searchdec2007?udndbid=udndata&page=1&SearchString=%AA%A9%A6%B8%3DA1%2B%A4%E9%B4%C1%3E%3D20131206%2B%A4%E9%B4%C1%3C%3D20161205%2B%B3%F8%A7%4F%3D%C1%70%A6%58%B3%F8&sharepage=10&select=1&kind=2&showUserSearch=+%3Cstrong%3E%3Cfont+color%3D%23333333+class%3Dtitle03%3E%B1%7A%A5%48%3C%2Ffont%3E+%3Cfont+color%3D%23FF6600+class%3Dtitle04%3E%AA%A9%A6%B8%3DA1%2B%A4%E9%B4%C1%3E%3D20131206%2B%A4%E9%B4%C1%3C%3D20161205%2B%B3%F8%A7%4F%3D%C1%70%A6%58%B3%F8%3C%2Ffont%3E+%3Cfont+color%3D%23333333+class%3Dtitle03%3E%A6%40%B7%6A%B4%4D%A8%EC%3C%2Ffont%3E+%3Cfont+color%3D%23FF6600+class%3Dtitle04%3E3718%3C%2Ffont%3E+%3Cfont+color%3D%23333333+class%3Dtitle03%3E%B5%A7%B8%EA%AE%C6%3C%2Ffont%3E%3C%2Fstrong%3E
		
		
		int page_befor = url.indexOf("udndata&");
		int page_after = url.indexOf("&SearchString");
		String page = url.substring(page_befor, page_after); //udndata&page=1
		
		this.url = this.url.replace(page, "udndata&page=" + i);
		
		return url;
	}
	
	
	
	
	
	
	
}
