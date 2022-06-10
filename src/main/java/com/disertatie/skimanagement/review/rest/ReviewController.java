package com.disertatie.skimanagement.review.rest;

import com.disertatie.skimanagement.review.entity.ReviewEntity;
import com.disertatie.skimanagement.review.model.Review;
import com.disertatie.skimanagement.review.model.ReviewRecomendation;
import com.disertatie.skimanagement.review.services.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/skimanagement/api/v2/review")
public class ReviewController {
    private static final Logger log = LoggerFactory.getLogger(ReviewController.class);
    public ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping()
    public ResponseEntity<ReviewEntity> createReview(@Valid @RequestBody Review review){

        log.info("Received request to create review: {}", review);
        ReviewEntity savedReview = reviewService.processPostReview(review);

        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public ResponseEntity<Iterable<ReviewEntity>> getReview(@RequestParam(required = false) String reviewedEntity) {
        log.info("Received request to get review registration with reviewedEntity: {}", reviewedEntity);
        Iterable<ReviewEntity> returnedReviewEntity;
        if(reviewedEntity==null) {
            returnedReviewEntity = reviewService.processGetAllReviews();
        }
        else {
            returnedReviewEntity = reviewService.processFindByReviewedEntityContaining(reviewedEntity);
        }
        log.info("Created returnedReviewEntity with id: {}", reviewedEntity);
        if (returnedReviewEntity == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Review with name: " + reviewedEntity + " not found in the database");
        }
        return new ResponseEntity<>(returnedReviewEntity, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/recommendation")
    public ResponseEntity<Iterable<ReviewRecomendation>> getRecommendationByReviews(@RequestParam(required = false) List<String> reviewedEntity) {

        Iterable<ReviewRecomendation> returnedReviewEntity=reviewService.processGetAllReviewsByAvgGrade(reviewedEntity);


        if (returnedReviewEntity == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No reviews found in the database");
        }

        return new ResponseEntity<>(returnedReviewEntity, HttpStatus.OK);
    }
}
