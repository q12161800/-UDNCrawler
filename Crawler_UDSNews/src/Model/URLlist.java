package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class URLlist {

	private ArrayList<String> urlist = new ArrayList<String>();
	private String urlfilepath = "URLlist.txt";

	public URLlist() throws Exception {

		File urlfile = new File(this.urlfilepath);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(urlfile), "UTF-8"));

		while (br.ready()) {
			urlist.add(br.readLine().trim());
		}
	}

	public ArrayList<String> getURLlist() {
		return this.urlist;
	}

}
