package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.News;

public class mysql {
	private Connection con = null; // Database objects
	// 連接object
	private Statement stat = null;
	// 執行,傳入之sql為完整字串
	private ResultSet rs = null;
	// 結果集
	private PreparedStatement pst = null;

	// 執行,傳入之sql為預儲之字申,需要傳入變數之位置
	// 先利用?來做標示
	public mysql() {
		try {
			Class.forName("com.mysql.jdbc.Driver");// com.mysql.jdbc.Driver
			// 註冊driver 140.125.84.46:3306
			con = DriverManager
					.getConnection(
							"jdbc:mysql://140.125.84.60:3306/namedentity_lda_news?useUnicode=true&characterEncoding=utf-8",
							"root", "root");// tmqcas , ntuh_yun
			// 取得connection
			// jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=Big5
			// localhost是主機名,test是database名
			// useUnicode=true&characterEncoding=Big5使用的編碼
			// System.out.println("成功連結");
		} catch (ClassNotFoundException e) {
			System.out.println("DriverClassNotFound :" + e.toString());
		} // 有可能會產生sqlexception
		catch (SQLException x) {
			System.out.println("Exception :" + x.toString());
		}
	}
	public void insert_news(News news) {

		try {
			String sql = "insert into news2013_2015 (url, date, title, subtitle, classen, classcn, content, publisher, newsauthor) "
					+ "values(?,?,?,?,?,?,?,?,?) ";
			pst = con.prepareStatement(sql);

			pst.setString(1, news.getURL().trim());
			pst.setString(2, news.getDate().trim());
			pst.setString(3, news.getTitle().trim());
			pst.setString(4, news.getSubtitle().trim());
			pst.setString(5, news.getClass_number().trim());
			pst.setString(6, news.getClass_name().trim());
			pst.setString(7, news.getContext().trim());
			pst.setString(8, news.getPublisher().trim());
			pst.setString(9, news.getAuthor().trim());

			pst.executeUpdate();

			System.out.println(news.getTitle() + " insert 成功!!");
			
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			Close();
		}
	}
	public void Close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stat != null) {
				stat.close();
				stat = null;
			}
			if (pst != null) {
				pst.close();
				pst = null;
			}
		} catch (SQLException e) {
			System.out.println("Close Exception :" + e.toString());
		}
	}
}
