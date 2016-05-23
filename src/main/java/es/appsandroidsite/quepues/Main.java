package es.appsandroidsite.quepues;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;

import java.lang.Object;

import com.fasterxml.jackson.core.JsonParser;


import es.appsandroidsite.quepues.json.JsonTransformer;
import es.appsandroidsite.quepues.json.JsonTransformerImplJackson;
import es.appsandroidsite.quepues.modelo.Url;
import es.appsandroidsite.quepues.soap.Peticion;



public class Main {
	public static Scanner teclado = new Scanner(System.in);
//	private Gson gson = new Gson();
	// TODO Auto-generated method stub

	public static void main(String[] args) {
		
		
	//	estableceComunicacion();
	//	recibirInfoUrl();
		
		if(insertarNuevaUrl()){
			System.out.println("Insertada correctamente");
			
		}else{
			System.out.println("No se ha podido insertar");
		}
		
}
/*
	private static void estableceComunicacion() {
		
		String http = "http://localhost:8080/tests/api/Url";  


		HttpURLConnection urlConnection=null;  
		try {  
		    URL url = new URL(http);  
		    urlConnection = (HttpURLConnection) url.openConnection();
		    urlConnection.setDoOutput(true);   
		    urlConnection.setRequestMethod("POST");  
		    urlConnection.setUseCaches(false);  
		    urlConnection.setConnectTimeout(10000);  
		    urlConnection.setReadTimeout(10000);  
		    urlConnection.setRequestProperty("Content-Type","application/json");   

		    urlConnection.setRequestProperty("Host", "android.schoolportal.gr");
		    urlConnection.connect();  
		
		
		
		//Creación del objeto json
		
		    System.out.println("Crear json..."); 
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("id","null");
		jsonParam.put("categoria","H");
		jsonParam.put("test","a10"); 
		jsonParam.put("subCategoria","Hosteleria y Turismo");
		jsonParam.put("url","http://aula10formacion.com/cursos-de/idiomas/"); 
		//jsonParam.put("ultimaMod","null");
		System.out.println("Creado"); 
	        
	      
	            //Usamos URLencode para poder enviar la cadena
	        //    jsonOutput = URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode(jsonOutput, "UTF-8");
	            //Establecemos la conexion y enviamos los datos
	         //   URL url=new URL("http://localhost:8080/tests/api/Url");
	            
	         //   HttpURLConnection con = (HttpURLConnection) url.openConnection();
	         //   con.setRequestMethod("POST");
	         //   con.setDoOutput(true);
		System.out.println("Enviando Json..."); 
	            OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
	            wr.write(jsonParam.toString());
	            wr.flush();
	    System.out.println("Enviado Json"); 
	            
	            int HttpResult = urlConnection.getResponseCode();
	            System.out.println("Resultado " +HttpResult);
	            if(HttpResult ==HttpURLConnection.HTTP_OK){
	            //Recibimos los datos
	            System.out.println("Respuesta OK ");
	            BufferedReader recv = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	            //Los mostramos por pantalla
	            String s=recv.readLine();
	            while(s!=null){
	                    System.out.println(s);
	                    s=recv.readLine();
	                  }
	            }else{
	            	System.out.println(urlConnection.getResponseMessage()); 
	            }
	        } catch (MalformedURLException e) {  

	            e.printStackTrace();  
	  
	        }catch (IOException e) {  

	                e.printStackTrace();  
	                } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }finally{  
	                if(urlConnection!=null)  
	                urlConnection.disconnect();  
	            }  
		
		 
		}
	
	private static void recibirInfoUrl() {
		
		Peticion p= new Peticion();
		
		ArrayList<Url> lista = p.verListaUrls();
		
		for(int i=0;i<lista.size();i++){
			System.out.println(lista.get(i).getUrl());
		}
		
		/*
	     
	JsonTransformer json= new JsonTransformerImplJackson();
	
		      
	       try{
	        
	          URL url=new URL("http://localhost:8080/tests/api/Urls");
	          URLConnection con = (URLConnection) url.openConnection();
	          con.setDoOutput(true);
	   
	          //Recibimos los datos
	          BufferedReader recv = new BufferedReader(new InputStreamReader(con.getInputStream()));
	          //Los mostramos por pantalla
	          String s=recv.readLine();
	          String stringJson=s;
	          while(s!=null){
	        	  
	                  System.out.println(s);
	                  stringJson=stringJson+s;
	                  s=recv.readLine();
	                  
	                 
	                }
	          System.out.println("Enviado");
	          Url nuevaUrl= (Url) json.fromJson(stringJson, Url.class);
	          System.out.println(nuevaUrl.getCategoria());
	          System.out.println(nuevaUrl.getSubCategoria());
	          System.out.println(nuevaUrl.getUrl());
	          
	      	
	          
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	       }

	    */

//	}
	
	/*
	public String obtenerDatos(String stringUrl){
		
		
		String json=null;
		
		return json;
		
		
		
		/*
		 JSONParser parser = new JSONParser();
		  URL url;
		  try {
			  URL oracle = new URL("http://localhost:8080/tests/api/Urls"); // URL to Parse
	            URLConnection yc = oracle.openConnection();
	            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	            
	            String inputLine;
	            while ((inputLine = in.readLine()) != null) {               
	                JSONArray a = (JSONArray) parser.parse(inputLine);
	                
	                // Loop through each item
	                for (Object o : a) {
	                    JSONObject tutorials = (JSONObject) o;

	                    Long id = (Long) tutorials.get("ID");
	                    System.out.println("Post ID : " + id);

	                    String title = (String) tutorials.get("post_title");
	                    System.out.println("Post Title : " + title);

	                    System.out.println("\n");
	                }
	            }
	            in.close();
			  
		  }catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }   
		 
		
		
		/*	Client cliente = ClientBuilder.newClient();
		Url url = cliente.target("http://localhost:8080/tests/api/Urls").request(MediaType.APPLICATION_JSON_TYPE).get(Url.class);
		System.out.println(url.getId());
		System.out.println(url.getSubCategoria());
		System.out.println(url.getUrl());*/
		
	//}
	
	public static boolean insertarNuevaUrl(){
		boolean insertado=false;
		
		System.out.println("Introduzca nueva url:");
		String url=teclado.nextLine();
		System.out.println("Introduzca nombre de la subcategoria:");
		String subCategoria=teclado.nextLine();
		System.out.println("Introduzca el c�digo de la categoria a la que pertence:");
		String codCategoria=teclado.nextLine();
		System.out.println("Introduzca el c�digo del test al que pertence:");
		String codTest=teclado.nextLine();
		
		 // public Url(String categoria, String test, String subCategoria, String url) {
		Url nuevaUrl= new Url(codCategoria,codTest,subCategoria,url);
		Peticion p= new Peticion();
		if(p.insertaUrl(nuevaUrl)!=null){
			insertado=true;
		}
		
		return insertado;
		
		
	}

}
