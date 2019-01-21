package Main;

import java.util.ArrayList;

import Controller.MainController;
import Model.FileMgr;

public class main {
	

	public static void main(String[] args) throws Exception, NullPointerException {
		// TODO Auto-generated method stub
		
		MainController maincontorller = new MainController();

		
		//Set Crawler target
		String IndexURL = maincontorller.getUDNUrl();
		//System.out.println(IndexURL);
		
		//Execute Crawler method
		//first parameter is page
		//second parameter is UDN URL
		maincontorller.Crawlerprocess(1, IndexURL);
		
		
		
		
		}
}
