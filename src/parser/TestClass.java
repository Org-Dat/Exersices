//$Id$
package parser;

import edu.duke.*;

import org.json.*;

import java.io.*;

public class TestClass {
    public static void main(String[] arg) throws IOException{
    	JsonSchemaToPojoParser j2p = new JsonSchemaToPojoParser();
    	FileResource fr = new FileResource("/home/obeth-zutk123/eclipse/ZIDE/Exercise/JSON/schema.json");
    	String packageName = "java.pojoFile";
    	String fileName = "Employee";
    	JSONObject schemaJSON = new JSONObject(fr.asString());
    	String fileContent = j2p.pojoCreator(schemaJSON, packageName, fileName);
    	System.out.println(fileContent);
    	File folder = new File("/home/obeth-zutk123/eclipse/ZIDE/Exercise/Java/"+packageName.replace(".", "/"));
    	if(folder.mkdirs()){
    		FileWriter  writer = new FileWriter("/home/obeth-zutk123/eclipse/ZIDE/Exercise/Java/"+packageName.replace(".", "/")+"/"+fileName+".java");
            writer.write(fileContent);
            writer.close();
    	};
    	
    }
}
