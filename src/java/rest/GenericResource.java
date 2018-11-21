/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.connection.Connection;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
import java.sql.*;

/**
 * REST Web Service
 *
 * @author DPadhya
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public void getXml() {
        //TODO return proper representation object
     
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    @GET
    @Path("/welcome")
    @Produces(MediaType.APPLICATION_JSON)
    public String welcome(@RequestParam String action) throws IOException{
           MongoClient mongo =  new MongoClient( "127.0.0.1" ,27017 );; 
     
      // Creating Credentials 
        MongoDatabase database = mongo.getDatabase("mytest");  
        
       MongoCollection<org.bson.Document> collection = database.getCollection("student"); 
//        org.bson.Document document = new org.bson.Document("title", "MongoDB") 
//      .append("id", 1)
//      .append("description", "database") 
//      .append("likes", 100) 
//      .append("url", "http://www.tutorialspoint.com/mongodb/") 
//      .append("by", "tutorials point");  
//      collection.insertOne(document); 
 FindIterable<org.bson.Document> iterDoc = collection.find(); 
      int i = 1; 
//request.setAttribute("it",  iterDoc.iterator());
      // Getting the iterator
//      ModelAndView modelandview 
Iterator it=iterDoc.iterator();
List <Std>  stdLt =new ArrayList <>();
while (it.hasNext()) {  
             Document doc=(  Document) it.next();
        
                           Std std = new Std();
            std.setName((String)doc.get("fname")  );
            std.setAge((String)doc.get("lname")  );
            stdLt.add(std);

}
StringWriter json = new StringWriter();
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.writeValue(json,stdLt);
        return json.toString();
        
        
   
    }
   
    @GET
    @Path("/welcomeDb")
    @Produces(MediaType.APPLICATION_JSON)
    public String welcomeDb(@RequestParam String action) throws IOException, ClassNotFoundException, SQLException, ClassNotFoundException{
    Class.forName("com.mysql.jdbc.Driver");
    com.mysql.jdbc.Connection conn =(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "");
      
          
            Statement st;   
        st = conn.createStatement();
      st.execute("insert into std values(2,\'aa\',67)");
      
//Iterator it=iterDoc.iterator();
//List <Std>  stdLt =new ArrayList <>();
//while (it.hasNext()) {  
//             Document doc=(  Document) it.next();
//        
//                           Std std = new Std();
//            std.setName((String)doc.get("fname")  );
//            std.setAge((String)doc.get("lname")  );
//            stdLt.add(std);
//
//}
//StringWriter json = new StringWriter();
//ObjectMapper objectMapper = new ObjectMapper();
//objectMapper.writeValue(json,stdLt);
        return  "a";
        
        
   
    }
   
}
