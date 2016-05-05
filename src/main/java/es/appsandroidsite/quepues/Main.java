package es.appsandroidsite.quepues;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import modelo.Url;

public class Main {
	public static Scanner teclado = new Scanner(System.in);
	// TODO Auto-generated method stub

	public static void main(String[] args) {
		Client cliente = ClientBuilder.newClient();
		Url url = cliente.target("").request(MediaT);
		
		
		

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
