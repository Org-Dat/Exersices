//$Id$
package parser;

import org.json.*;
import java.util.*;

public class JsonSchemaToPojoParser {
	
	
	  private String defineMethods(String type , String methodName){   
    	  String setMethod =  "public "+type+"  set"+methodName+"("+type+" "+methodName+"){ \n\tthis."+methodName+" = "+methodName+";\n}";
    	  String getMethod = "public "+type+"  get"+methodName+"(){\n\t return this."+methodName+"; \n}";
    	  return setMethod+"\n\n"+getMethod;
    	  
      }
      
      private String defineFields(String type , String fieldName){    	
		 return "private "+type+"  "+fieldName+";";
      }
      
      
      private String defineImports(){
    	  return "import java.util.*;";
      }
      
      public String  pojoCreator(JSONObject schemaJSON , String packageName,String fileName){
    	  StringBuilder javaStr = new StringBuilder("");
    	  try{
		    	 if(((String)(schemaJSON.get("type"))).equals("object") == false){
		    		  return null;
		    	  }
		    	  schemaJSON = schemaJSON.getJSONObject("properties");
		    	  
		    	  if(schemaJSON == null){
		    		  return null;
		    	  }
		    	  
		    	  StringBuilder methodString = new StringBuilder("");
		    	  StringBuilder fieldString = new StringBuilder("");
		    	  Set<String> keys = schemaJSON.keySet();
		    	  boolean needImport = false;
		    	 
		    	  for(String key : keys){
		    		  JSONObject  detail = schemaJSON.getJSONObject(key);
		    		  String type = null;
		    		  try{
		    			  type = detail.getString("type").trim().toLowerCase();
		    			  if (type.equals("array")){
			    			  needImport = true;
			    		  }
		    			  if(type.equals("boolean") == false){
		    				  type = typeMaker(type);
		    			  }
		    			  
		    		  }catch(JSONException e){
		    			  
		    		  }   		  
		    		  
		    		  if(type == null && detail.getString("format") == null){
		    			  type = "Object";
		    		  }else if(type == null && detail.getString("format") != null){
		    			  type = "String";
		    		  }
		    		  
		    		  
		    		  methodString.append(defineMethods(type , key)+"\n\n");
		    		  fieldString.append(defineFields(type , key)+"\n");
		    	  }
		    	  
		    	  
		    	  javaStr.append("package "+packageName+";\n");
		    	  
		    	  if(needImport){
		    		  javaStr.append("\n\n"+defineImports()+"\n\n");
		    	  }
		    	  
		    	  javaStr.append(" public class "+fileName+"{ \n");
		    	  javaStr.append(fieldString.toString()+"\n\n");
		    	  javaStr.append(methodString.toString()+"\n\n");
		    	  javaStr.append("}");
		    	  
    	  }catch(Exception e){
    		  e.printStackTrace();
    		  return null;
    	  }
    	  
    	  return javaStr.toString();
      }
      
      private String typeMaker(String type){
    	   if(type.equals("array")){
    		   type = "list<Object>";
    	   }    	   
    	   return (type.charAt(0)+"").toUpperCase()+type.substring(1);
      }
}
