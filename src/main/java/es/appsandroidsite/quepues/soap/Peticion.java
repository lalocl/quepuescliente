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
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONTokener;

import org.json.simple.JSONObject;



import es.appsandroidsite.quepues.json.JsonTransformer;
import es.appsandroidsite.quepues.json.JsonTransformerImplJackson;
import es.appsandroidsite.quepues.modelo.Url;
import es.appsandroidsite.qupues.persitencia.Conectar;

public class Peticion{
	
	private JSONObject jsonParam;
	private JSONArray jsonArray;
	private String metodo;
	private HttpURLConnection urlConnection;
	private JsonTransformer json;
	
	

	public int insertaUrl(Url url){
		
		Url nuevaUrl=null;
		Conectar conexion= new Conectar();
		conexion.on("Url", "POST");
		urlConnection= conexion.getUrlConnection();
		 int HttpResult=-1;
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
        HttpResult = urlConnection.getResponseCode();
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
		return HttpResult;
   
		
		
	}
	
	public ArrayList<Url> verListaUrls(){
		JsonTransformer json= new JsonTransformerImplJackson();
		Url nuevaUrl=null;
		Conectar conexion= new Conectar();
		conexion.on("Url", "GET");
		urlConnection= conexion.getUrlConnection();
		ArrayList<Url> lista= new ArrayList<Url> ();
		
	      
	       try{
	        
	       /*   URL url=new URL("http://localhost:8080/tests/api/Urls");
	          URLConnection con = (URLConnection) url.openConnection();
	          con.setDoOutput(true);*/
	   
	    	 //  urlConnection.setDoInput(true);
	          //Recibimos los datos
	    	   System.out.println("Recibir datos");
	          BufferedReader recv = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	          //Los mostramos por pantalla
	          String s=recv.readLine();
	          String stringJson;
	          String stringArrayJson=s;
	          while(s!=null){
	        	  
	                  System.out.println(s);
	                  stringArrayJson=stringArrayJson+s;
	                  s=recv.readLine();
	                  
	                 
	                }
	          System.out.println("Enviado");
	          jsonArray= new JSONArray();
	          
	          jsonArray=(JSONArray) new JSONTokener(stringArrayJson).nextValue();
	          
	//          Iterator<JsonObject> iterator = listOfStates.iterator();  
	          org.json.JSONObject j;
	      
	       for(int i=0;i< jsonArray.length();i++){
	    	   
	    	   j=jsonArray.getJSONObject(i);
	        	
	    	 // public Url(String categoria, String test, String subCategoria, String url) {
	    	//   nuevaUrl= (Url) json.fromJson(stringJson, Url.class);
	        	stringJson=j.toString();
	        	nuevaUrl= (Url) json.fromJson(stringJson, Url.class);
	         
	          
	          
	          System.out.println(nuevaUrl.getCategoria());
	          System.out.println(nuevaUrl.getSubCategoria());
	          System.out.println(nuevaUrl.getUrl());
	          lista.add(nuevaUrl);
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
		return lista;

	}
	
	
}
