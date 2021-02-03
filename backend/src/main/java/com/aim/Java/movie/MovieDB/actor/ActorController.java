package com.aim.Java.movie.MovieDB.actor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api/actors")
public class ActorController {
    @Autowired
    private ActorRepository actorRepository;

    @GetMapping(path = "")
    public @ResponseBody Iterable<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Actor getActor(@PathVariable(value = "id") Integer id) {
        Optional<Actor> actor = actorRepository.findById(id);
        return actor.get();
    }

    @PostMapping(path = "/")
    public @ResponseBody String createActor(@RequestBody Actor actor) {
        actorRepository.save(actor);
        return "Saved";
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateActor(@PathVariable(value = "id") Integer id, @RequestBody Actor actorDetails) {
       
        Optional<Actor> optionalActor = actorRepository.findById(id);
        Actor actor = optionalActor.get();

        actor.setFirstName(actorDetails.getFirstName());
        actor.setLastName(actorDetails.getLastName());
        actor.setDateOfBirth(actorDetails.getDateOfBirth());

        actorRepository.save(actorDetails);
        return "Updated";

    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteActor(@PathVariable(value = "id") Integer id) {
        actorRepository.deleteById(id);
        return "Deleted";
    }
}
