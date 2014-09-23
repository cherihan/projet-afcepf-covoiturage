package com.formation.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;

public class ClientServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Connect to MongoDB
	    MongoClientURI mongoURI = new MongoClientURI("mongodb://localhost:27017");
	    MongoClient mongo = new MongoClient(mongoURI);
	    try { 
	        // Get "clients" collection from the "websites" DB.
	        DB db = mongo.getDB("customer");
	        DBCollection coll = db.getCollection("orders");
	        
	        // Find all DB object from the DB collection
	        DBCursor cursor = coll.find();
	        
	        //HTTP response is JSON
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("application/json");
	        
	        // write in the HTTP response, the JSON array of the cursor.
	        Writer writer = response.getWriter();
	        StringBuilder buf = new StringBuilder();
	        JSON.serialize(cursor, buf);
	        writer.write(buf.toString());
	        writer.flush();
	        
	    } finally {mongo.close();}
	    
	}

}
