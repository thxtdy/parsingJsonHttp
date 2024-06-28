package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class parshing {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/comments");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			int response = connection.getResponseCode();
			System.out.println("Response Code : "  + response);
			
			BufferedReader reader = null;
			String readline = new String();
			StringBuilder line = new StringBuilder();
			
			if(response >= 200 && response >= 300) {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			}
			
			while((readline = reader.readLine()) != null) {
				line.append(readline);
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
