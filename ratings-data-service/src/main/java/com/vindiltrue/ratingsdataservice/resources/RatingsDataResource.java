package com.vindiltrue.ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vindiltrue.ratingsdataservice.models.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingsDataResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRatingsData(@PathVariable("movieId") String movieId) {
		
		return new Rating(movieId,4);
	}
	
	@RequestMapping("users/{userId}")
	public List<Rating> getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("0001",5),
				new Rating("0002", 4)
				);
		
		
		return ratings;
	}

}
