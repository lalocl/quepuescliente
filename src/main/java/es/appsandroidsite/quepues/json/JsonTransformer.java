package es.appsandroidsite.quepues.json;

public interface JsonTransformer {
    String toJson(Object data);
    Object fromJson(String json, Class clazz);
    
}
