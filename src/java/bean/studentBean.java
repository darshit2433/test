/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;
//import com.mongodb.client.MongoDatabase; 
import com.mongodb.*; 
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;
import javax.swing.text.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
//import com.mongodb.MongoCredential;  


/**
 *
 * @author DPadhya
 */
@Controller
public class studentBean {

    public Iterator connect() {
        // Creating a Mongo client 
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

      // Getting the iterator 
       return iterDoc.iterator(); 
    
     
      //Creating a collection 
      //database.createCollection("sampleCollection"); 
    //  System.out.println("Collection created successfully"); 
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public studentBean() {
    }
    
}
