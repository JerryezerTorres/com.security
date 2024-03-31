package com.security.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Table(name="user")
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lastName;
	private String email;
	private String direction;
	private String telephone;
	private String userName;
	private String password;
	private String image;
	
	
	@Column(columnDefinition = "TINYINT(1)")
	private boolean enabled;
	private String roles;

	
	
	public User() {
		super();
	}

	public User(Long id, String name, String lastName, String email, String direction, String telephone,
			String userName, String password, String image, boolean enabled, String roles, List<Pet> pet) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.direction = direction;
		this.telephone = telephone;
		this.userName = userName;
		this.password = password;
		this.image = image;
		this.enabled = enabled;
		this.roles = roles;
		this.pet = pet;
	}

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Pet> pet;

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", direction="
				+ direction + ", telephone=" + telephone + ", userName=" + userName + ", password=" + password
				+ ", image=" + image + ", enabled=" + enabled + ", roles=" + roles + ", pet=" + pet + "]";
	}

	
//	@Transient
//    private static PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        User.passwordEncoder = passwordEncoder;
//    }
//
//    public static User createUser(String username, String password) {
//        User user = new User();
//        user.setUserName(username);
//        user.setPassword(passwordEncoder.encode(password));
//        // Otros campos y configuraciones necesarios
//        return user;
//    }


	


	
	




	
	
	
	
	
	

}
