package com.example.viralvideo.video;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public String title;
	public String description;
	public String url;
	public long viewCount;
	
	public Video() {};
	
	public Video(String title, String description, String url) {
		super();
		this.title = title;
		this.description = description;
		this.url = url;
		this.viewCount = 0;
	}

	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	public String getUrl()
	{
		return url;
	}
	
	public void increaseViewCount()
	{
		this.viewCount++;
	}
	
	public long getViewCount() {
		return viewCount;
	}
	
	
}
