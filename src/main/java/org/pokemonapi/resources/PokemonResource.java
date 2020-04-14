package org.pokemonapi.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.pokemonapi.entities.Pokemon;
import org.pokemonapi.services.PokemonService;

@Path("/pokemons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PokemonResource {

    @Inject PokemonService pokemonService;

    @GET
    public List<Pokemon> list() {
        return pokemonService.list();
    }

    @POST
    public List<Pokemon> add(Pokemon pokemon) {
        pokemonService.add(pokemon);
        return list();
    }
}