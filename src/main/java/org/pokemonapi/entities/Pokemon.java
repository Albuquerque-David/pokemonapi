package org.pokemonapi.entities;

import java.util.Objects;

public class Pokemon {
	private String name;
	private String description;
	
	public Pokemon()
	{
		
	}
	
	public Pokemon(String name, String description)
	{
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", description=" + description + "]";
	}
	
	@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pokemon)) {
            return false;
        }

        Pokemon other = (Pokemon) obj;

        return Objects.equals(other.name, this.name);
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

}
