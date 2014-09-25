package fr.afcepf.atod21.coVoiturage.bigData;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;

/**
 * Servlet implementation class pub
 */
public class pub extends HttpServlet {
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
	        DB db = mongo.getDB("bannieres");
	        DBCollection coll = db.getCollection("ads");
	        
	        String destination = request.getParameter("destination");
	        BasicDBObject regexQuery = new BasicDBObject();
	        regexQuery.put("ville", new BasicDBObject("$regex", destination).append("$options", "i"));
	        
	        DBCursor cursor = coll.find(regexQuery);
	        
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
