package com.aim.Java.movie.MovieDB.rating;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/ratings")
public class RatingCotroller {
    
    @Autowired
    
    private RatingRepository ratingRepository;

    @GetMapping(path = "")
    public Iterable<Rating>getAllRatings(){
    return ratingRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Rating getRating(@PathVariable(value = "id") Integer id) {
        Optional<Rating> rating = ratingRepository.findById(id);
        return rating.get();
    }

    @PostMapping(path = "/")
    public Rating createRating(@RequestBody Rating rating) {
        return ratingRepository.save(rating);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateRating(@PathVariable(value = "id") Integer id, @RequestBody Rating ratingDetails) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        Rating rating = optionalRating.get();

        rating.setRating(ratingDetails.getRating());
        rating.setDescription(ratingDetails.getDescription());

        ratingRepository.save(ratingDetails);
        return "Updated";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteRating(@PathVariable(value = "id") Integer id) {
        ratingRepository.deleteById(id);
        return "Deleted";
    }
}
