package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JsonFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonFile() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	public void destroy() {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("try doGet");
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/comments");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			int response1 = connection.getResponseCode();
			System.out.println("Response Code : "  + response1);
			
			BufferedReader reader = null;
			String readline = new String();
			StringBuilder line = new StringBuilder();
			
			StringBuilder addline = new StringBuilder();
			
			if(response1 >= 200 && response1 <= 300) {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			}
			
			while((readline = reader.readLine()) != null) {
				addline = line.append(readline);
			}
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(addline.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
