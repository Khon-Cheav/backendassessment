package com.assessment.backendassessment.repository;

import com.assessment.backendassessment.entity.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel,Integer> {

}
