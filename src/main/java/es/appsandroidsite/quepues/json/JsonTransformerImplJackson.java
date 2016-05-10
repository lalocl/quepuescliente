package es.appsandroidsite.quepues.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTransformerImplJackson implements JsonTransformer{

    /*
    * Pasamos un objecto y el método nos devuelve un String Json con los campos de ese Objecto
    */
   
    public String toJson(Object data) {
        ObjectMapper objectMapper = new ObjectMapper();
         
        try {
       /*           objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true); 
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); */
            
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException ex) {
             throw new RuntimeException(ex);
        }
    }

    /*
    *Pasamos un Json y el nombre de una clase, y el método devuelve un Objeto de esa clase.
    */

    public Object fromJson(String json, Class clazz) {
         ObjectMapper objectMapper = new ObjectMapper();
        try {
        
          
            objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true); 
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); 
            return objectMapper.readValue(json, clazz);
        } catch (IOException ex) {
         throw new RuntimeException(ex);
        }
       
        
        
    }
    
}
