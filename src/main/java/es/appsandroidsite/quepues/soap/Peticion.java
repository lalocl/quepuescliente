package es.appsandroidsite.quepues.soap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONTokener;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import es.appsandroidsite.persitencia.Conectar;
import es.appsandroidsite.quepues.json.JsonTransformer;
import es.appsandroidsite.quepues.json.JsonTransformerImplJackson;
import es.appsandroidsite.quepues.modelo.Url;

public class Peticion {
	
	private JSONObject jsonParam;
	private JSONArray jsonArray;
	private String metodo;
	private HttpURLConnection urlConnection;
	private JsonTransformer json;
	
	

	public Url insertaUrl(Url url){
		
		Url nuevaUrl=null;
		Conectar conexion= new Conectar();
		conexion.on("Url", "POST");
		urlConnection= conexion.getUrlConnection();
		try {
		System.out.println("Crear json..."); 
		jsonParam = new JSONObject();
		jsonParam.put("id",url.getId());
		jsonParam.put("categoria",url.getCategoria());
		jsonParam.put("test",url.getTest()); 
		jsonParam.put("subCategoria",url.getSubCategoria());
		jsonParam.put("url",url.getUrl()); 
		System.out.println("Creado"); 
		
		System.out.println("Enviando Json..."); 
		OutputStreamWriter wr;
	
			wr = new OutputStreamWriter(urlConnection.getOutputStream());
		
			
		
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
        
       
        String stringJson=s;
        json= new JsonTransformerImplJackson();
       
        while(s!=null){
                System.out.println(s);
                stringJson=stringJson+s;
                s=recv.readLine();
              }
        nuevaUrl= (Url) json.fromJson(stringJson, Url.class);
        System.out.println(nuevaUrl.getCategoria());
        System.out.println(nuevaUrl.getSubCategoria());
        System.out.println(nuevaUrl.getUrl());
        
        
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
            conexion.off();  
        }  
		return nuevaUrl;
   
		
		
	}
	
	public ArrayList<Url> verListaUrls(){
		JsonTransformer json= new JsonTransformerImplJackson();
		Url nuevaUrl=null;
		Conectar conexion= new Conectar();
		conexion.on("Url", "GET");
		urlConnection= conexion.getUrlConnection();
		
	      
	       try{
	        
	       /*   URL url=new URL("http://localhost:8080/tests/api/Urls");
	          URLConnection con = (URLConnection) url.openConnection();
	          con.setDoOutput(true);*/
	   
	    	   urlConnection.setDoInput(true);
	          //Recibimos los datos
	          BufferedReader recv = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	          //Los mostramos por pantalla
	          String s=recv.readLine();
	          String stringJson=s;
	          String stringArrayJson=s;
	          while(s!=null){
	        	  
	                  System.out.println(s);
	                  stringArrayJson=stringArrayJson+s;
	                  s=recv.readLine();
	                  
	                 
	                }
	          System.out.println("Enviado");
	          
	          jsonArray=(JSONArray)new JSONTokener(stringArrayJson).nextValue();
	          
	          for(int i=0;i< jsonArray.size();i++){
	        	  
	        	//  jsonParam=jsonArray.
	       /*   Url nuevaUrl= (Url) json.fromJson(stringJson, Url.class);
	          System.out.println(nuevaUrl.getCategoria());
	          System.out.println(nuevaUrl.getSubCategoria());
	          System.out.println(nuevaUrl.getUrl());*/
	          }
	          
	      	
	          
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	       }
		return jsonArray;

	}
	
	
}
