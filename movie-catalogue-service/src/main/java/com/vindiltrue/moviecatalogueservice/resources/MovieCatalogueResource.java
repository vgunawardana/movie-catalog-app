package com.vindiltrue.moviecatalogueservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vindiltrue.moviecatalogueservice.models.CatalogItem;
import com.vindiltrue.moviecatalogueservice.models.Movie;
import com.vindiltrue.moviecatalogueservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogueResource {
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		RestTemplate restTemplate = new RestTemplate();
		//restTemplate.getForObject("http://localhost:8082/movie/foo", Movie.class);
		
		
		List<Rating> ratings = Arrays.asList(

				new Rating("0001",4),
				new Rating("0002",3)
		);
		
		return ratings.stream().map(rating -> {
				Movie movie = restTemplate.getForObject("http://localhost:8082/movie/"+rating.getMovieId(), Movie.class);
				return new CatalogItem(movie.getName(), "Test", rating.getRatings());
		}).collect(Collectors.toList());
		
		
		/*
		 * return Collections.singletonList( new CatalogItem("Transformers", "Test", 4)
		 * );
		 */
		
		
	}

}
