package com.assessment.backendassessment.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tblMovie")
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "title should not be empty")
    private String title;

    @NotNull(message = "category should not be empty")
    private String category;

    @DecimalMin(value = "0.5",message = "Min star rating 0.5")
    @DecimalMax(value = "5", message = "Max star rating 5")
    private Double starRating;


}
