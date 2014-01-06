package net.shootlearnshoot.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShootingString {
	
	private int id;
	private String name;
	private Recipe recipe; // Link to cartridge recipe(ammo) that this shooting string used
	
	private List<Integer> string = new ArrayList<Integer>();

	private String weather;
	private Date date;
	private String notes;
	
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public List<Integer> getString() {
		return string;
	}
	public void setString(List<Integer> string) {
		this.string = string;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
