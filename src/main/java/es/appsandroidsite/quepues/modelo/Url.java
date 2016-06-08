package es.appsandroidsite.quepues.modelo;

import java.io.Serializable;

public class Url implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4087064931273487961L;
	
	private Integer id;
    private String categoria;
    private String test;
    private String subCategoria;
    private String url;
    private String ultimaMod;
    
     @Override
	public String toString() {
		return  categoria+ "-"+test+"-"+subCategoria+ "-"+ url;
	}

	public Url() {
   }

   public Url(String categoria, String test, String subCategoria, String url) {
		super();
		this.categoria = categoria;
		this.test = test;
		this.subCategoria = subCategoria;
		this.url = url;
	}

public Integer getId() {
       return id;
   }

   public void setId(Integer id) {
       this.id = id;
   }

   public String getCategoria() {
       return categoria;
   }

   public void setCategoria(String categoria) {
       this.categoria = categoria;
   }

   public String getTest() {
       return test;
   }

   public void setTest(String test) {
       this.test = test;
   }

   public String getSubCategoria() {
       return subCategoria;
   }

   public void setSubCategoria(String subCategoria) {
       this.subCategoria = subCategoria;
   }

   public String getUrl() {
       return url;
   }

   public void setUrl(String url) {
       this.url = url;
   }

   public String getUltimaMod() {
       return ultimaMod;
   }

   public void setUltimaMod(String ultimaMod) {
       this.ultimaMod = ultimaMod;
   }

   
   
}