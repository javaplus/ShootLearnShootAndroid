package net.shootlearnshoot.domain;

public class Recipe {

	private long id;
	private String name;
	private String bullet;
	private String powderName;
	private String powderAmt;
	private String primer;
	private String notes;
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getPrimer() {
		return primer;
	}
	public void setPrimer(String primer) {
		this.primer = primer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBullet() {
		return bullet;
	}
	public void setBullet(String bullet) {
		this.bullet = bullet;
	}
	public String getPowderName() {
		return powderName;
	}
	public void setPowderName(String powderName) {
		this.powderName = powderName;
	}
	public String getPowderAmt() {
		return powderAmt;
	}
	public void setPowderAmt(String powderAmt) {
		this.powderAmt = powderAmt;
	}
	
}
