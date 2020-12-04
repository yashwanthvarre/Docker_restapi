package com.spring.springbootstart.states;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;


//import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;




@RestController
@RequestMapping("/users")
public class statecontroller {
	
//private String currentDirectory = System.getProperty("user.dir");

	@RequestMapping()
	public JsonNode getUsers() throws JsonProcessingException, IOException,FileNotFoundException{
		
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("/home/akarsh/Documents/fall_2020_course_documents/Internet Computing CS612/Assignment_3/springboot-api/src/main/java/com/spring/springbootstart/contents.json").getAbsoluteFile();
		JsonNode jsonNode = objectMapper.readTree(file);
		return (jsonNode);
	}
	@RequestMapping("/{userId}")
	public JsonNode getId(@PathVariable("userId") int userId)  throws IOException,FileNotFoundException{
		
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("/home/akarsh/Documents/fall_2020_course_documents/Internet Computing CS612/Assignment_3/springboot-api/src/main/java/com/spring/springbootstart/contents.json").getAbsoluteFile();
		JsonNode jsonNode = objectMapper.readTree(file);
		for(JsonNode root : jsonNode) {	
			if(userId == root.path("userId").asInt()) {	
				return root;
			}
		}
		return (jsonNode);
	}
@RequestMapping("/{userId}/orders")
public List<String> getUserOrders(@PathVariable("userId") int userId)  throws IOException,FileNotFoundException{
	
	ObjectMapper objectMapper = new ObjectMapper();
	JsonNode jsonNode = objectMapper.readTree(new File("/home/akarsh/Documents/fall_2020_course_documents/Internet Computing CS612/Assignment_3/springboot-api/src/main/java/com/spring/springbootstart/contents.json"));
//	List<Integer> id = new ArrayList<Integer>();
	List<String> userList = new ArrayList<String>();
	for(JsonNode root : jsonNode) {	
		if(userId == root.path("userId").asInt()) {	

			 JsonNode ordersNode = root.path("orders");
		 
			 for( JsonNode order : ordersNode) {
				 userList.add(order.asText());
			 
			 }
		}				
	}
	return (userList);
}

@RequestMapping("/{userId}/orders/{orderId}")
public List<String> getUserOrders(@PathVariable("userId") int userId,
		@PathVariable("orderId") String orderId)  throws IOException,FileNotFoundException{
	
	ObjectMapper objectMapper = new ObjectMapper();
	JsonNode jsonNode = objectMapper.readTree(new File("/home/akarsh/Documents/fall_2020_course_documents/Internet Computing CS612/Assignment_3/springboot-api/src/main/java/com/spring/springbootstart/contents.json"));
//	List<Integer> id = new ArrayList<Integer>();
	List<String> userList = new ArrayList<String>();
	for(JsonNode root : jsonNode) {	
		if(userId == root.path("userId").asInt()) {	
			 JsonNode ordersNode = root.path("orders");
			 Iterator<Entry<String, JsonNode>> fields = ordersNode.fields();
			
			 while(fields.hasNext()) {
				 Entry<String, JsonNode> jsonField = fields.next();
				 
				 if(jsonField.getKey().equals(orderId)) {					 
					 userList.add(jsonField.getValue().asText());
					 break;
				 }
			 }	
		}				
	}
	return (userList);
}
	
}


