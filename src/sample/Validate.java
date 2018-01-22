package sample;


import java.io.IOException;
import java.io.File;
import edu.duke.*;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;

class Employee{
	String name ;
	String field; 
	String company;
	String email;
	int age;
	long phone_number;
	int experience;
	long salary;
	
	public Employee(String name,String field , String company , String email , int age ,long phone_number,int experience,long salary){
		this.name = name ;
		this.field = field; 
		this.company = company;
		this.email = email;
		this.age = age;
		this.phone_number = phone_number;
		this.experience = experience;
		this.salary = salary;
	}
	
	public String toString(){
		String obj = "{ \"name\"  : \""+this.name+"\" ,\"salary\" : "+this.salary+" , \"company\" : \""+this.company+"\" , \"age\" : "+this.age+" , \"email\" : \""+this.email+"\" , \"experience\"  : "+this.experience+" , \"field\" : \""+this.field+"\" , \"phone_number\" : "+this.phone_number+"}";
		return obj;
	}
	
}



public class Validate {
	 public static void main( String[] args ) throws IOException, ProcessingException
	 {
		 FileResource schemaFile = new FileResource("/home/obeth-zutk123/eclipse/ZIDE/Exercise/JSON/schema.json");
		 String schema  = schemaFile.asString();
		 Employee emp = new Employee("Obeth" , "Development", "zoho" , "obethsamuel@zoho.com" , 19 , 9080245591l,2,9000);
	     ProcessingReport report = ValidatorUtils.isJsonValid(schema, emp.toString());
	     String[] status = report.toString().split("com.github.fge.jsonschema.core.report.ListProcessingReport: ");	     
	     if(status[1].trim().equals("success")){
	    	 System.out.println("Status    :    Success \n Message  :  Your Object is vaid Object");
	    	 return;
	     }System.out.println(status[1].trim().equals("success"));
	     status[1] = status[1].substring(status[1].indexOf("--- BEGIN MESSAGES ---")+23, status[1].indexOf("---  END MESSAGES  ---"));
	     String[] errors = status[1].split("error:");
	     System.out.println("Some Mistates occurrences in your Object. The Errors : \n");
	     for(int i = 1 ; i < errors.length;i++){
	    	 errors[i] = i+".  Error :"+ errors[i].substring(0, errors[i].indexOf("level"))+""+ errors[i].substring(errors[i].indexOf("keyword:"));
	    	 System.out.println(errors[i]);
	     }
	 }	     
}  