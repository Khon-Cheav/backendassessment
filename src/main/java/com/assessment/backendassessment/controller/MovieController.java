package com.assessment.backendassessment.controller;

import com.assessment.backendassessment.entity.MovieModel;
import com.assessment.backendassessment.exception.ResourceNotFoundException;
import com.assessment.backendassessment.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/save")
    public ResponseEntity<Object> saveMovie(@RequestBody MovieModel movieModel) {
        return movieService.save(movieModel);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateById(@PathVariable("id") int id, @RequestBody MovieModel movieModel){
        return movieService.updateById(id,movieModel);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id){
        movieService.deleteById(id);
        return new ResponseEntity<>("id : "+id +" delete successful!",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public MovieModel findById(@PathVariable(value = "id") int id){
        return movieService.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id :" +id));
    }

    @GetMapping("/listMovie")
    public List<MovieModel> retrieveMovie(){
        return movieService.listAllMovie();

    }


}
