package cst438wk1;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MovieRatingCntlr {
	
	@Autowired
	MovieRatingRepository movieRatingRepository;
	
	
	@GetMapping("/movies/new")
	public String createMovieRating(Model model) {
		MovieRating movieRating = new MovieRating();
		model.addAttribute("movieRating", movieRating);
		return "movie_rating_form";
	}
	
	@PostMapping("/movies/new")
	public String processMovieRatingForm(@Valid MovieRating movieRating,
									BindingResult result,
									Model model) {
		if(result.hasErrors()) {
			return "movie_rating_form";
		}
		movieRatingRepository.save(movieRating);
		Iterable<MovieRating> movieRatings = movieRatingRepository.findAll();
		model.addAttribute("movieRatings",movieRatings);
		return "movie_rating_show";
	}
	
	@GetMapping("/movies")
	public String getAllMovies(Model model) {
		Iterable<MovieRating> movieRatings =movieRatingRepository.findAllMovieRatingsOrderByTitleDateDesc();
		model.addAttribute("movieRatings",movieRatings);
		return "movie_rating_list";
	}
	

}
