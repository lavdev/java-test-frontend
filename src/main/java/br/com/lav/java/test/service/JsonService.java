package br.com.lav.java.test.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Stream;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lav.java.test.domain.Employee;
import br.com.lav.java.test.domain.Skill;

/***
 * Json Service class provide feature to consume REST data
 * @author laverson
 *
 */
public class JsonService implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	private final ObjectMapper mapper = new ObjectMapper();

	// client setup
	private static ResteasyClient client;
	// consume setup
    private static ResteasyWebTarget target;

	/**
	 * Client setup
	 */
	static {
        client = new ResteasyClientBuilder().build();        
    }
    
    /***
     * Get the Skill list
     * @return Skill[]
     */
    public Skill[] getSkillList() {
    	target = client.target("http://localhost:8080/skill");
    	Response response = target.request().get();
    	String value = response.readEntity(String.class);
    	Skill[] skills = null;
    	try {
			JsonNode rootNode = mapper.readTree(value);
			skills = mapper.readValue(rootNode.toString(), Skill[].class);
		} catch (IOException e) {
			System.err.println(e);
		}
    	response.close();
    	return skills;
    }
    
    /***
     * Get the Employee list
     * @return Employee[]
     */
    public Employee[] getEmployeeList() {
    	target = client.target("http://localhost:8080/employee");
    	Response response = target.request().get();
    	String value = response.readEntity(String.class);
    	Employee[] employees = null;
    	try {
			JsonNode rootNode = mapper.readTree(value);
			employees = mapper.readValue(rootNode.toString(), Employee[].class);
		} catch (IOException e) {
	        System.err.println( e );
		}
    	response.close();
    	return employees;
    }

	/***
	 * Get list of Employee
	 * @param selected
	 * @return Employee[]
	 */
	public Employee[] getEmployeeList(String selected) {
    	target = client.target("http://localhost:8080/employee/skill/?filter=" + selected);
    	Response response = target.request().get();
    	String value = response.readEntity(String.class);
    	
    	Employee[] objects = null;
    	try {
			JsonNode rootNode = mapper.readTree(value);
			objects = mapper.readValue(rootNode.toString(), Employee[].class);
		} catch (IOException e) {
			System.err.println(e);
		}
    	response.close();
    	return objects;
	}
}
