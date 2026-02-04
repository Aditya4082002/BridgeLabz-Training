package com.json_handling;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonObject {

	public static void main(String[] args) {
		JSONObject student = new JSONObject();
		student.put("name", "Aditya");
		student.put("age", 22);
		
		JSONArray subjects = new JSONArray();
        subjects.put("Mathematics");
        subjects.put("Physics");
        subjects.put("Computer Science");
        
        student.put("subjects", subjects);
        
        System.out.println(student.toString());
	}
}