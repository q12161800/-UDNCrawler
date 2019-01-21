package Models;

import java.io.IOException;
import java.util.ArrayList;

import Model.FileMgr;


public class URL {
	
	public FileMgr filemgr;
	
	public URL(){
	}
	
	public ArrayList<String> getURLList() throws Exception, IOException {
		
		ArrayList<String> array = filemgr.ReadSingleText("resource", "URLlist.txt");
		for(String S : array){
			System.out.println(S);
		}
		
		return array;
		
	}
	
	public String getURL(String s , int i){
		
		int page_befor = s.indexOf("udndata&");
		int page_after = s.indexOf("&SearchString");
		String page = s.substring(page_befor, page_after); //udndata&page=1
		
		s = s.replace(page, "udndata&page=" + i);
		
		return s;
	}
	
	

}
