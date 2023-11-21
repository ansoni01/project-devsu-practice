package com.devsu.cuentamovimientos.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.jboss.logging.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonUtil {
	
	private static final Logger LOGGER = Logger.getLogger(JsonUtil.class);
	
    public static <T> T convertirCadenaJsonPostAObjeto(String cadena, Class<T> clase) throws Exception{        
    	  try {
  			return new ObjectMapper().readValue(cadena, clase);
  		} catch (JsonParseException e) {
  			LOGGER.error(e.getMessage(), e);
  		} catch (JsonMappingException e) {
  			LOGGER.error(e.getMessage(), e);
  		} catch (IOException e) {
  			LOGGER.error(e.getMessage(), e);
  		}
  		return null;
	}
    
    public static List<Map<String, Object>> convertirCadenaJsonAListaMapa(String json) throws Exception{        
    	List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
    	ObjectMapper mapper = new ObjectMapper();
		lista = mapper.readValue(json, new TypeReference<List<Map<String, Object>>>(){});
		return lista;
    }
    
    
    public static String convertirObjetoACadenaJson(Object objeto){ 
        String json;
		try {
			json = new ObjectMapper().writeValueAsString(objeto);
			return json;
		} catch (JsonProcessingException e) {	
			LOGGER.error(e.getMessage(), e);
			return null;
		}
    }   
    
    public static <T> List<T> convertirCadenaJsonAArrayList(String json, Class<T> tClass) throws Exception{                
    	try{
    		if(json == null){ return null;}
	    	ObjectMapper mapper = new ObjectMapper();    	
	    	CollectionType listType = mapper.getTypeFactory()
	                .constructCollectionType(ArrayList.class, tClass);
	    	List<T> lista = mapper.readValue(json, listType);
			return lista;
    	} catch (JsonProcessingException e) {	
			return null;
		}
    }
    
}
