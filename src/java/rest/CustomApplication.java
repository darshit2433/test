/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author DPadhya
 */
public class CustomApplication extends Application
{
    //Add Service APIs
    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> resources = new HashSet<Class<?>>();
// 
//        //register REST modules
//        resources.add(JerseyService.class);
// 
//        //Manually adding MOXyJSONFeature
//        resources.add(org.glassfish.jersey.moxy.json.MoxyJsonFeature.class);
// 
//        //Configure Moxy behavior
//        resources.add(JsonMoxyConfigurationContextResolver.class);
// 
        return resources;
    }
}
