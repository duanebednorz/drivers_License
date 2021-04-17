package com.Duane.driversLicense.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="First name cannot be blank")
	private String first_name;
	
	@NotEmpty(message="Last name cannot be blank")
	private String last_name;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="person", fetch = FetchType.LAZY)
    private List<License> license;

	public List<License> getLicense() {
		return license;
	}

	public void setLicense(List<License> license) {
		this.license = license;
	}

	public Person() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
//	@PrePersist
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
	
//	@PreUpdate
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}
	
};
