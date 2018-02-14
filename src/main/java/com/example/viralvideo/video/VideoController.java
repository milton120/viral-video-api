package com.example.viralvideo.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

	@Autowired
	private VideoService videoService;
	
	@RequestMapping("/videos")
	public List<Video> getAllVideos()
	{
		return videoService.getAllVideos();
	}
	
	@RequestMapping("/videos/{id}")
	public ResponseEntity<Video> getVideo(@PathVariable Long id)
	{
		Video video = videoService.getVideo(id);
		
		if(video == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		video.increaseViewCount();
		videoService.updateVideo(id, video);
		
		return ResponseEntity.ok().body(video);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/videos")
	public ResponseEntity<String> addVideo(@RequestBody Video video)
	{
		videoService.addVideo(video);
		
		return ResponseEntity.ok().body("Video added successfully.");
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/videos/{id}")
	public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody Video video)
	{
		Video updatedData = videoService.getVideo(id);
		
		if(updatedData == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		updatedData.setTitle(video.getTitle());
		updatedData.setDescription(video.getDescription());
		updatedData.setUrl(video.getUrl());
		
		videoService.updateVideo(id, updatedData);
		
		return ResponseEntity.ok().body(updatedData);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/videos/{id}")
	public ResponseEntity<Video> deleteVideo(@PathVariable Long id)
	{
		Video video = videoService.getVideo(id);
		
		if(video == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		videoService.deleteVideo(id);
		
		return ResponseEntity.ok().body(video);
	}
	
	
}
