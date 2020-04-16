package org.pokemonapi.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.pokemonapi.entities.Pokemon;
import org.pokemonapi.services.PokemonService;

@Path("/pokemons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PokemonResource {

    @Inject PokemonService pokemonService;

    @POST
    public List<Pokemon> create(Pokemon pokemon) 
    {
    	pokemonService.create(pokemon);
    	return list();
    }
    
    @GET
    public List<Pokemon> list() 
    {
        return pokemonService.list();
    }

    @GET
    @Path("{name}")
    public Pokemon findByName(@PathParam("name") String pokemonName) 
    {
    	return pokemonService.findByName(pokemonName);
    }
    
    @PUT
    @Path("{pokemonName},{newName}")
    public List<Pokemon> updateName(@PathParam("pokemonName") String pokemonName, @PathParam("newName") String newName) 
    {
        pokemonService.update(pokemonName, newName);
        return list();
    }
    
    @DELETE
    @Path("{pokemonName}")
    public List<Pokemon> deleteByName(@PathParam("pokemonName") String pokemonName) 
    {
        pokemonService.delete(pokemonName);
        return list();
    }
}