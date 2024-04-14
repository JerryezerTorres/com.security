package com.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="pet")
@Entity
public class Pet {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String race;
	private String typeOfPet;
	private String image;
	
	
	@Column(columnDefinition = "TINYINT(1)")
	private boolean enabled;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	
//	 @ManyToOne
//	 @JoinColumn(name = "user_id")
//	private User owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getTypeOfPet() {
		return typeOfPet;
	}

	public void setTypeOfPet(String typeOfPet) {
		this.typeOfPet = typeOfPet;
	}
	

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Pet () {
		
	}


	public Pet(Long id, String name, String race, String typeOfPet, String image, boolean enabled, User user) {
		super();
		this.id = id;
		this.name = name;
		this.race = race;
		this.typeOfPet = typeOfPet;
		this.image = image;
		this.enabled = enabled;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", race=" + race + ", typeOfPet=" + typeOfPet + ", image=" + image
				+ ", enabled=" + enabled + "]";
	}
	
	

//	@Override
//	public String toString() {
//		return "Pet [id=" + id + ", name=" + name + ", race=" + race + ", typeOfPet=" + typeOfPet + ", image=" + image
//				+ ", enabled=" + enabled + ", user=" + user + "]";
//	}
	
	


	
	
	
	 
	 

}
