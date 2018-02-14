package com.example.viralvideo.video;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;
	
	public List<Video> getAllVideos()
	{
		List<Video>videos = new ArrayList<>();
		videoRepository.findAll().forEach(videos::add);
		
		return videos;
	}
	
	public Video getVideo(Long id)
	{
		return videoRepository.findOne(id);
	}
	
	public void addVideo(Video video)
	{
		videoRepository.save(video);
	}
	
	public void updateVideo(Long id, Video video)
	{
		videoRepository.save(video);
	}
	
	public void deleteVideo(Long id)
	{
		videoRepository.delete(id);
	}
}
