package es.appsandroidsite.quepues;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import modelo.Url;

public class Main {
	public static Scanner teclado = new Scanner(System.in);
	// TODO Auto-generated method stub

	public static void main(String[] args) {
		Client cliente = ClientBuilder.newClient();
		Url url = cliente.target("http://localhost:8080/tests/api/Url/?ultima_mod=2016-04-20 10:25:47.0").request(MediaType.APPLICATION_JSON_TYPE).get(Url.class);
		System.out.println(url.getId());
		System.out.println(url.getSubCategoria());
		System.out.println(url.getUrl());
		
		

	}
	
	public static void menu(){
		
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
		
		
		
		
	}

}
