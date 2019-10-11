package com.vindiltrue.movieinfoservice.resources;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vindiltrue.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movie")
public class MovieInfoResource {
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		
				return new Movie(movieId,"Oz");
	
		
	}

}
