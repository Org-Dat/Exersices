//$Id$
package sample;

import java.io.*;
import java.net.URL;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.RuleFactory;
import edu.duke.FileResource;
import com.sun.codemodel.JCodeModel;

public class JsonSchemaToPojo {

    public static void main(String[] args){
    	JsonSchemaToPojo pojo =  new JsonSchemaToPojo();
    	
    	String fileName = "Employee";
    	String pathName = "/home/obeth-zutk123/eclipse/ZIDE/Exercise/POJOFiles";
    	String packageName = "java.pojofile";
    	
    	
    	String schemaFileName = "schema";
    	String schemaPathName = "/home/obeth-zutk123/eclipse/ZIDE/Exercise/JSON";
    	
    	
    	System.out.println(pojo.jsonSchemaToPojo(fileName, pathName, packageName, schemaFileName,schemaPathName));
    }
    
    
    public String jsonSchemaToPojo(String fileName,String pathName , String packageName,String schemaFileName,String schemaPathName){
    	try{
    		
	        JCodeModel codeModel = new JCodeModel();
	        URL source = new URL("file://"+schemaPathName+"/"+schemaFileName+".json");
	        GenerationConfig config = new DefaultGenerationConfig() {
	            @Override
	            public boolean isGenerateBuilders() { 
	                return true;
	            }
	        };
	    
	        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(), new SchemaStore()), new SchemaGenerator());
	        mapper.generate(codeModel, fileName, packageName, source);
	        System.out.print("File Path = "+pathName);
	        codeModel.build(new File(pathName));
	        
	        System.out.print("\nFile Content  : \n");
	        FileResource pojoFile = new FileResource(pathName+"/"+packageName.replace(".", "/")+"/"+fileName+".java");
	        return (pojoFile.asString());
    	
    	}catch(IOException e){
    		return (" . This File Path is invalid");
    	
    	}catch(StringIndexOutOfBoundsException e){
    		return ("File Name is Empty String");
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		return ("Invalid XML Schema Content");
    	}    	
    	
    }

}