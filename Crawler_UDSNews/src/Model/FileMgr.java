package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileMgr {
	
	public ArrayList<String> getURLList(){
		ArrayList<String> urllist = new ArrayList<String>();
		return urllist;
	}
	
	public ArrayList<String> ReadSingleText(String foldername, String msg) throws Exception{
	
		ArrayList<String> urllist = new ArrayList<String>();
		
		File urlfile = new File(foldername,msg);
		System.out.println(urlfile);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(urlfile), "UTF-8"));

		while (br.ready()) {
			System.out.println(br.readLine().trim());
			urllist.add(br.readLine().trim());
			
		}
		
		return urllist;
		
	}
	
	//test function
//	public static void main(String[] arg) throws IOException{
//		FileMgr f = new FileMgr();
//		ArrayList<String> array = f.ReadSingleText("resource", "URLlist.txt");
//		for(String S : array){
//			System.out.println(S);
//		}
//		
//	}

}
