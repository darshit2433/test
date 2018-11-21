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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author DPadhya
 */
@RestController("rout")
public class Rout {
       @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request){
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
        return "welcomecall.jsp";
        
   
    }
}
