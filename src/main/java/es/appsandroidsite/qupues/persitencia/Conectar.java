package es.appsandroidsite.qupues.persitencia;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class Conectar {
	
	final String HTTP="http://192.168.56.1:8080/tests/api/";
	private HttpURLConnection urlConnection;
	

	private String metodo;
	
	
	
	public HttpURLConnection on(String ext,String metodo){
		
		URL url;
		try {
			url = new URL(HTTP+ext);
		 
	    urlConnection = (HttpURLConnection) url.openConnection();
	    urlConnection.setDoOutput(true);   
	    urlConnection.setRequestMethod(metodo);  
	    urlConnection.setUseCaches(false);  
	    urlConnection.setConnectTimeout(10000);  
	    urlConnection.setReadTimeout(10000);  
	    urlConnection.setRequestProperty("Content-Type","application/json");   

	    urlConnection.setRequestProperty("Host", "android.schoolportal.gr");
	    urlConnection.connect(); 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return urlConnection;
		
	}
	
	
	public void off() {
		urlConnection.disconnect();
		
	}


	public String getMetodo() {
		return metodo;
	}


	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public HttpURLConnection getUrlConnection() {
		return urlConnection;
	}


	public void setUrlConnection(HttpURLConnection urlConnection) {
		this.urlConnection = urlConnection;
	}


	public String getHTTP() {
		return HTTP;
	}

	
	
	

}
