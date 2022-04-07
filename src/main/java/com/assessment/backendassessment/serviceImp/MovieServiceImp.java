package com.assessment.backendassessment.serviceImp;

import com.assessment.backendassessment.entity.MovieModel;
import com.assessment.backendassessment.exception.ResourceNotFoundException;
import com.assessment.backendassessment.repository.MovieRepository;
import com.assessment.backendassessment.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    MovieRepository movieRepository;
    static final String USER_NOTFOUND="User not found with id :";

    @Override
    public ResponseEntity<Object> save(MovieModel movieModel) {
        try {
            if(movieModel.getStarRating()>=0.5 && movieModel.getStarRating()<=5){
                MovieModel movie = movieRepository.save(movieModel);
                return new ResponseEntity<>(movie, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException("startRating must be value between 0.5 to 5");
        }
        return new ResponseEntity<>("startRating must be value between 0.5 to 5", HttpStatus.CREATED);

    }


    /*
    it find data in database if id has it will update
    else it throw Exception
    */
    @Override
    public ResponseEntity<Object> updateById(int id,MovieModel movieModel) {
        MovieModel movie=movieRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(USER_NOTFOUND+ id));
        if(movieModel.getStarRating()>=0.5 && movieModel.getStarRating()<=5){

            movie.setTitle(movieModel.getTitle());
            movie.setCategory(movieModel.getCategory());
            movie.setStarRating(movieModel.getStarRating());
            movieRepository.save(movie);
            return new ResponseEntity<>(movie, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("startRating must be value between 0.5 to 5", HttpStatus.CREATED);
    }

    /*
    it find it first before delete if it has
    else it will throw Exception with response message
    */
    @Override
    public void deleteById(int movieId) {
        MovieModel deleteMovie=movieRepository.findById(movieId)
                .orElseThrow(()->new ResourceNotFoundException(USER_NOTFOUND + movieId));
        movieRepository.delete(deleteMovie);
    }

    @Override
    public Optional<MovieModel> findById(int id) {
        return movieRepository.findById(id);
    }

    @Override
    public List<MovieModel> listAllMovie() {
        return movieRepository.findAll();
    }
}
