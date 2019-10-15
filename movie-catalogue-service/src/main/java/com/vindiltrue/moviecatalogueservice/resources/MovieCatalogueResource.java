package com.vindiltrue.moviecatalogueservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.vindiltrue.moviecatalogueservice.models.CatalogItem;
import com.vindiltrue.moviecatalogueservice.models.Movie;
import com.vindiltrue.moviecatalogueservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogueResource {

	@Autowired
	private RestTemplate restTemplate;

	// @Autowired
	// private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		// RestTemplate restTemplate = new RestTemplate();
		// restTemplate.getForObject("http://localhost:8082/movie/foo", Movie.class);

		// Create a builder
		// WebClient.Builder builder = WebClient.builder();

		
		  List<Rating> ratings = Arrays.asList(
		  
		  new Rating("0001",4), new Rating("0002",3) );
		 

		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movie/" + rating.getMovieId(), Movie.class);

			/*
			 * Movie movie = webClientBuilder.build() .get()
			 * .uri("http://localhost:8082/movie/"+rating.getMovieId()) .retrieve()
			 * .bodyToMono(Movie.class) .block();
			 */
			return new CatalogItem(movie.getName(), "Test", rating.getRatings());
		}).collect(Collectors.toList());

		/*
		 * return Collections.singletonList( new CatalogItem("Transformers", "Test", 4)
		 * );
		 */

	}

}
