package com.vindiltrue.ratingsdataservice.resources;

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

}
