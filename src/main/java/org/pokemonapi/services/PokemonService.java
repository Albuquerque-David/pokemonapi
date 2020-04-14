package org.pokemonapi.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.bson.Document;

import org.pokemonapi.entities.Pokemon;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

@ApplicationScoped
public class PokemonService {
	
	@Inject MongoClient mongoClient;
	
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
	
	public void add(Pokemon pokemon)
	{
		 Document document = new Document()
                  .append("name", pokemon.getName())
                  .append("description", pokemon.getDescription());
        getCollection().insertOne(document);
	}
	
	private MongoCollection<Document> getCollection()
	{
		return mongoClient.getDatabase("pokemon").getCollection("pokemon");
	}
}

