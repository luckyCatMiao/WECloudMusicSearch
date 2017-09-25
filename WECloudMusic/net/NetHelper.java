package WECloudMusic.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.json.JSONObject;

import WECloudMusic.bean.QueryBean;
import WECloudMusic.util.Util;

public class NetHelper {

	public static String sendPost(String searchurl, QueryBean queryBean) {
		
		
		String queryString=Util.beanToQueryString(queryBean);
		try {
			return sendPost(searchurl, queryString);
		} catch (IOException e) {
			System.out.println(searchurl+":"+queryString);
			e.printStackTrace();
		}
		return queryString;
		

	}

	private static String sendPost(String searchurl, String queryString) throws IOException {

		
			
				URLConnection connection=getConnection(searchurl);
				connection.setDoOutput(true);
		
		       
		       
		       PrintStream printStream=new PrintStream(connection.getOutputStream());
		       printStream.println(queryString);
		       
		       
		      return readReasponce(connection);
				
	}

	public static String sendGet(String searchurl) {
		
		try {
			return sendGet(searchurl,"");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	private static String sendGet(String searchurl, String queryString) throws IOException {
		

		URLConnection connection=getConnection(searchurl+queryString);
		
		return readReasponce(connection);

	
	}

	private static URLConnection getConnection(String searchurl) {
		URL url;
		URLConnection connection = null;
		try {
			url = new URL(searchurl);
			 connection=url.openConnection();
			   connection.setRequestProperty("Cookie","appver=1.5.0.75771");
		       connection.setRequestProperty("Referer","http://music.163.com/");
		       
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	       
		return connection;
	}

	
	public static String sendGet(String searchurl, HashMap<String, String> map) {
		
		String queryString=Util.mapToqueryString(map);
		URLConnection connection=getConnection(searchurl+queryString);
		
		
		return readReasponce(connection);

	}

	private static String readReasponce(URLConnection connection) {

		 String line = null;
        try {
        	BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
         
			if((line=reader.readLine())!=null)
			{
				return line;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}

	
	
}
