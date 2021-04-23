package com.mixology.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Drink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private User user;
	
	private double drink_percent;
	private String drinkname;
	private String description;
	
	public Drink() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(drink_percent);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((drinkname == null) ? 0 : drinkname.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Drink other = (Drink) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(drink_percent) != Double.doubleToLongBits(other.drink_percent))
			return false;
		if (drinkname == null) {
			if (other.drinkname != null)
				return false;
		} else if (!drinkname.equals(other.drinkname))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	public Drink(int id, User user, double drink_percent, String drinkname, String description) {
		super();
		this.id = id;
		this.user = user;
		this.drink_percent = drink_percent;
		this.drinkname = drinkname;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getDrink_percent() {
		return drink_percent;
	}
	public void setDrink_percent(double drink_percent) {
		this.drink_percent = drink_percent;
	}
	public String getDrinkname() {
		return drinkname;
	}
	public void setDrinkname(String drinkname) {
		this.drinkname = drinkname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Drink [id=" + id + ", user=" + user + ", drink_percent=" + drink_percent + ", drinkname="
				+ drinkname + ", description=" + description + "]";
	}
	
	
	
}
