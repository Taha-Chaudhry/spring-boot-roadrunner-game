package com.roadrunner.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "levels")
public class Level {
	private @Id @GeneratedValue() Long id;
	private String levelname;
	
	public Level() {
		
	}
	
	public Level(String levelname) {
		this.levelname = levelname;
	}
	
	public Long getId() {
		return id;
	}	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "level_name", nullable = false)
	public String getLevelName() {
		return levelname;
	}
	public void setLevelName(String levelname) {
		this.levelname = levelname;
	}
    
    @Override
	public String toString() {
		return "Level [id=" + id + ", levelname=" + levelname
				+ "]";
	}
}