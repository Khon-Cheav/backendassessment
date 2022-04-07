package com.assessment.backendassessment.service;

import com.assessment.backendassessment.entity.MovieModel;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;


public interface MovieService {

    Optional<MovieModel> findById(int id);
    List<MovieModel> listAllMovie();
    ResponseEntity<Object> updateById(int id,MovieModel movieModel);
    void deleteById(int movieId);
    ResponseEntity<Object> save(MovieModel movieModel);
}
