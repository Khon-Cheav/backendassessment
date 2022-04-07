package com.assessment.backendassessment;

import com.assessment.backendassessment.entity.MovieModel;
import com.assessment.backendassessment.repository.MovieRepository;
import com.assessment.backendassessment.service.MovieService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class BackendassessmentApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	MovieRepository movieRepository;
	@Autowired
	MovieService movieService;
	MovieModel movieModel=MovieModel.builder()
			.title("true love")
			.category("Korea")
			.starRating(0.5).build();

	 /*
		test save with Junit
	 */
	@Test
	public void testSave(){

		movieRepository.save(movieModel);
		Assertions.assertThat(movieModel.getId()).isGreaterThan(0);

	}

	@Test
	public void update(){
		Assertions.assertThat(movieService.updateById(8,movieModel));
	}

	/*
     test findId with Junit
   */
	@Test
	public void findById(){
		Assertions.assertThat(movieService.findById(10));

	}

	/*
		retrieve a list of movies from database
	 */
	@Test
	public void findList(){
		List<MovieModel> movieList=movieService.listAllMovie();
		movieList.forEach((p)->{
			System.out.println(p.getId()+"\t"+p.getTitle()+"\t"+p.getCategory()+"\t"+p.getStarRating());
		});
	}




}
