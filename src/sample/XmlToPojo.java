//$Id$
package sample;

import java.io.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import edu.duke.*;
import java.io.File;
//
public class XmlToPojo {
	  public static void main(String[] args) throws JAXBException {  
		  
		  FileResource fr = new FileResource("/home/obeth-zutk123/eclipse/ZIDE/Exercise/JSON/schema.xml");
		  String xmlString = fr.asString();
		  JAXBContext context = JAXBContext.newInstance(Person.class);
		  Unmarshaller um = context.createUnmarshaller();
		  Person obj = (Person) um.unmarshal(new StringReader(xmlString));

     }
}


//

//public class JAXBObjectToXmlFile {
//    public static void main(String[] args) {
//        Track track = new Track();
//        track.setId(2);
//        track.setTitle("She Loves You");
//
//        try {
//            JAXBContext context = JAXBContext.newInstance(Track.class);
//
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            File output = new File("Track.xml");
//            marshaller.marshal(track, output);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }
//}