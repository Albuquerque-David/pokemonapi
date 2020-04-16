package org.pokemonapi.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.Document;
import org.pokemonapi.entities.Pokemon;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

@ApplicationScoped
public class PokemonService {
	
	@Inject MongoClient mongoClient;
	
	
	public void create(Pokemon pokemon)
	{
		 Document document = new Document()
                  .append("name", pokemon.getName())
                  .append("description", pokemon.getDescription());
        getCollection().insertOne(document);
	}
	
	public List<Pokemon> list()
	{
		List<Pokemon> list = new ArrayList<>();
		MongoCursor<Document> cursor = getCollection().find().iterator();
		
		try 
		{
			while(cursor.hasNext())
			{
				Document document = cursor.next();
				Pokemon pokemon = new Pokemon();
				pokemon.setName(document.getString("name"));
				pokemon.setDescription(document.getString("description"));
				list.add(pokemon);
			}
		}
		finally
		{
			cursor.close();
		}
		return list;
	}
	
	public Pokemon findByName(String pokemonName)
	{
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("name", pokemonName);
		FindIterable<Document> queryResult = getCollection().find(whereQuery);
		Document document = queryResult.first();
		Pokemon response;
		if(document == null)
			response = new Pokemon();
		else
			response = new Pokemon(document.getString("name"), document.getString("description"));
		return response;
		
	}
	
	public void update(String pokemonName, String newPokemonName)
	{
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("name", pokemonName);
		
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("name", newPokemonName); // (2)

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument); 
		
		getCollection().updateOne(whereQuery, updateObject);
	}
	
	public void delete(String pokemonName)
	{
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("name",pokemonName);
		getCollection().deleteOne(whereQuery);
	}
	
	
	private MongoCollection<Document> getCollection()
	{
		return mongoClient.getDatabase("pokemon").getCollection("pokemon");
	}
}

