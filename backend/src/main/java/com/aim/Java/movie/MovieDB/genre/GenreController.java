package com.aim.Java.movie.MovieDB.genre;

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
@RequestMapping(path = "/api/genres")
public class GenreController {

    @Autowired

    private GenreRepository genreRepository;

    @GetMapping(path = "")
    public Iterable<Genre>getAllGenres(){
        return genreRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Genre getGenre(@PathVariable(value = "id") Integer id) {
        Optional<Genre> genre = genreRepository.findById(id);
        return genre.get();
    }

    @PostMapping(path = "/")
    public Genre createGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateGenre(@PathVariable(value = "id") Integer id, @RequestBody Genre genreDetails) {
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        Genre genre = optionalGenre.get();
        genre.setGenre(genreDetails.getGenre());

        genreRepository.save(genreDetails);
        return "Updated";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteGenre (@PathVariable(value = "id") Integer id) {
        genreRepository.deleteById(id);
        return "Deleted";
    }

    
}
