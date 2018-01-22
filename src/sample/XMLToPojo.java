//$Id$
package sample;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;

import edu.duke.FileResource;

public class XMLToPojo {
	 public static void main(String[] args) {
	        try {
	        	
	            String fileName = "Employee";
	            String filePath = "/home/obeth-zutk123/eclipse/ZIDE/Exercise/POJOFiles";
	 
	        	String packageName = "java.pojofile";
	        	
	        	
	        	String xmlPath = "/home/obeth-zutk123/eclipse/ZIDE/Exercise/JSON";
	        	String xmlFileName = "schema";
	        	
	        	
	        	String schemaFileName = "xmlschema";
	            String schemaPathName = "/home/obeth-zutk123/eclipse/ZIDE/Exercise/JSON";
	        	
	        	FileResource fr = new FileResource(xmlPath+"/"+xmlFileName+".xml");
	            JSONObject schemaJSON = XML.toJSONObject(fr.asString());
	           
	            
	            FileWriter  writer = new FileWriter(schemaPathName+"/"+schemaFileName+".json");
	            writer.write(schemaJSON.toString(4));
	            writer.close();
	            
	            JsonSchemaToPojo pojo =  new JsonSchemaToPojo();	    
	            System.out.println(pojo.jsonSchemaToPojo(fileName, filePath, packageName, schemaFileName,schemaPathName));
	            
	        } catch (JSONException je) {
	            System.out.println(je.toString());
	        }catch(Exception error){
	        	error.printStackTrace();
	        }
	    }
}