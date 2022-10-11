package com.mycompany.maven;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonParser {
    public static List<Student> parseJSOn(String url) throws ParseException {
        List<Student> studentList = new ArrayList();
        Client client = Client.create();
        WebResource webResource = client.resource(url);

        ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
        if (clientResponse.getStatus() != 200) {
            throw new RuntimeException("Failed"+ clientResponse.toString());
        }

        JSONArray jsonArray = (JSONArray) new  JSONParser().parse(clientResponse.getEntity(String.class));

        Iterator<Object> it = jsonArray.iterator();

        double id;
        String firstName;
        String gender;
        String email;
        double gpa;
        while (it.hasNext()){
            JSONObject jsonObject = (JSONObject)it.next();
            id = Double.parseDouble((String)jsonObject.get("id"));
            firstName = (String)jsonObject.get("first_name");
            gpa = Double.parseDouble((String)jsonObject.get("gpa"));
            email = (String)jsonObject.get("email");
            gender = (String)jsonObject.get("gender");
            studentList.add(new Student(id,firstName,gpa,email,gender));
        }

        return studentList;
    }

    public static void main(String[] args) throws ParseException {

        List<Student> studentList = parseJSOn("https://hccs-advancejava.s3.amazonaws.com/student.json");
        for ( Student student: studentList){
            System.out.println(student.toString());
        }
    }
    
    public void searchByNameOrGender(String nameOrGender){
        boolean dataFound = false;
        Student studentDetails = null;
        for (Student student: studentList) {
            if (student.first_name.equalsIgnoreCase(nameOrGender) || student.gender.equalsIgnoreCase(nameOrGender)){
                dataFound = true;
                studentDetails = student;
                break;
                } else {
                dataFound = false;
                }
            }

            if (dataFound){
                System.out.println("Found: Student name: " + studentDetails.first_name);
            } else {
            System.out.println("Not found");
            }
    }
}
