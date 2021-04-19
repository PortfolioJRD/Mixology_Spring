package com.mixology.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Recipe implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Ingredients ing;
	
	@Id
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Drink drink;

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drink == null) ? 0 : drink.hashCode());
		result = prime * result + ((ing == null) ? 0 : ing.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		if (drink == null) {
			if (other.drink != null)
				return false;
		} else if (!drink.equals(other.drink))
			return false;
		if (ing == null) {
			if (other.ing != null)
				return false;
		} else if (!ing.equals(other.ing))
			return false;
		return true;
	}

	public Recipe(Ingredients ing, Drink drink) {
		super();
		this.ing = ing;
		this.drink = drink;
	}

	public Ingredients getIng() {
		return ing;
	}

	public void setIng(Ingredients ing) {
		this.ing = ing;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	@Override
	public String toString() {
		return "Recipe [ing=" + ing + ", drink=" + drink + "]";
	}
	
	
	

}
