//$Id$
package jsonschema;

import java.util.*;
import org.json.*;

public class Validator {
	  
	  ArrayList<String> errors = new ArrayList<String>();
	  
      public void validate(JSONObject schema , JSONObject value){
    	  
      }      
      
      
      public ArrayList<String> checkProperties (JSONObject schema , JSONObject value) throws ClassCastException {    	 
    	  JSONObject properties = schema.getJSONObject("properties");
    	  Set<String> keys  = properties.keySet();
    	  JSONArray requireKeys = properties.getJSONArray("required");
    	  for(int i = 0 ; i < requireKeys.length() ;i++){
    		  String key  = (String) requireKeys.get(i);
    		  if(keys.contains(key) == false){
    			  errors.add(key + " Doesn't Exist");
    		  }
    	  }
    	  return errors;
    	  
      }
      
      public ArrayList<String> checkType(JSONObject schema , JSONObject value){
    	  JSONObject properties = schema.getJSONObject("properties");
    	  Set<String> keys  = properties.keySet();
    	  
    	  for(String i : keys){
    		  JSONObject  propertyDetail = (JSONObject) properties.get(i);
    		  if(convertType(propertyDetail.getString("type") , value.get(i)) == false){
    			  errors.add(i+"   Type  Mismatched");
    		  }
    	  }
    	  return errors;
      }
      
      public ArrayList<String> checkAttribute(JSONObject schema , JSONObject value){
    	  
    	  return errors;
      }
      
      
      private boolean checkLength(boolean min , String value , int count){
    	  try{
    		  if(min){
    			  return value.length() >= count;
    		  }else{
    			  return value.length() <= count;
    		  }
    	  }catch(Exception e){
    		  return false;
    	  }
      }
      
      private boolean checkSqu(boolean min , double value , double count){
    	  try{
    		  if(min){
    			  return Math.abs(value) >= Math.abs(count);
    		  }else{
    			  return Math.abs(value) <= Math.abs(count);
    		  }
    	  }catch(Exception e){
    		  return false;
    	  }
      }
      
      
      private boolean  convertType(String type,Object value){
    	  try{
    		  type = type.toLowerCase();
    		  if(type.equals("string")){
    			  String valueString = (String) value;
    		  }else if(type.equals("integer")){
    			  Integer valueString = (Integer) value;
    		  }else if(type.equals("number")){
    			  Number valueString = (Number) value;
    		  }else if(type.equals("boolean")){
    			  boolean valueString = (boolean) value;
    		  }else if(type.equals("array")){
    			  ArrayList<Object> valueString = (ArrayList<Object>) value;
    		  }else if(type.equals("object")){
    			  JSONObject valueString = (JSONObject) value;
    		  }else{
    			  return false;
    		  }
    		  return true;
    	  }catch(Exception e){
    		  return false;
    	  }    	 
      }
      
      
       
      
}
