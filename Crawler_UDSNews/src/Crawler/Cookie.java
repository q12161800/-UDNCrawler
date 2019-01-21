package Crawler;

import java.io.*;

public class Cookie {
	private String cookie = "";

	public String getCookie() throws IOException {
		FileReader fr = new FileReader("cookie.txt");

		BufferedReader br = new BufferedReader(fr);
		while (br.ready()) {
			this.cookie = br.readLine().trim();
		}
		fr.close();
		return this.cookie;
	}
}
