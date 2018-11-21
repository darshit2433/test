/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.Serializable;

/**
 *
 * @author DPadhya
 */
public class Std implements Serializable {
    
String name;
String age;

    public Std() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    @Override
	public String toString(){
		return getAge() + ", "+getName();
	}
}
