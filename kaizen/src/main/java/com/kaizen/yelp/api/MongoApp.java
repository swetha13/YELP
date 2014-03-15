package com.kaizen.yelp.api.MongoApp;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoApp {

  private static final Log log = LogFactory.getLog(MongoApp.class);

  public static void main(String[] args) throws Exception {

	  Mongo mongo = new Mongo();
	  DB db = mongo.getDB("273project");
	  DBCollection coll = db.getCollection("docs");
	  
   
	  
	  Pattern Restaurants = Pattern.compile("Restaurant?s",
				Pattern.CASE_INSENSITIVE);

		BasicDBObject searchQuery = new BasicDBObject("categories", Restaurants);
		
		DBCursor cursor = coll.find(searchQuery);

/*
		  Pattern Open = Pattern.compile("open",
					Pattern.CASE_INSENSITIVE);
	BasicDBObject hourssearch = new BasicDBObject("hours" , Open);
	//BasicDBList 
	 DBCursor cursor = coll.find(hourssearch);
	 
	 */
		try {

			while (cursor.hasNext()) {
				System.out.println(cursor.next());

			}
		} finally {
			cursor.close();
		}
  }
}
