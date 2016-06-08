package es.appsandroidsite.quepues.soap;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import es.appsandroidsite.quepues.modelo.Url;

public class HacerPeticiones extends Thread{
	
	private Peticion p;
	private Url url;
	private boolean enviado;
	private static ArrayList<Url>noenviadas= new ArrayList<Url>();
	
	
	
	public HacerPeticiones(Url url){
		this.url=url;
		
		
	}
	@Override
	public void run(){

		
		
		Peticion p= new Peticion();
		if(p.insertaUrl(url)==HttpURLConnection.HTTP_OK){
			setEnviado(true);
		}else{
			setEnviado(false);
			noenviadas.add(url);
		}
		
		
	}
	public static ArrayList<Url> getNoenviadas() {
		return noenviadas;
	}
	public static void resetNoenviadas() {
		HacerPeticiones.noenviadas.clear();
	}
	public boolean isEnviado() {
		return enviado;
	}
	public void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}

}
