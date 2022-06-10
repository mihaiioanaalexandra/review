package com.disertatie.skimanagement.review.services;

import com.disertatie.skimanagement.review.entity.ReviewEntity;
import com.disertatie.skimanagement.review.model.Review;
import com.disertatie.skimanagement.review.model.ReviewRecomendation;
import com.disertatie.skimanagement.review.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;
    private static final Logger log = LoggerFactory.getLogger(ReviewService.class);

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    //get all
    public Iterable<ReviewEntity> processGetAllReviews() {
        return reviewRepository.findAll();
    }

    //get by reviewed entity's name
    public Iterable<ReviewEntity> processFindByReviewedEntityContaining(String reviedEntity) {
        return reviewRepository.findByReviewedEntityContaining(reviedEntity);
    }

    //post
    public ReviewEntity processPostReview(
            Review review) {

        ReviewEntity reviewEntity = new ReviewEntity(review);

        return reviewRepository.save(reviewEntity);

    }
    //sort all by avg grade
    public Iterable<ReviewRecomendation> processGetAllReviewsByAvgGrade(List<String> reviewedEntities) {
        List<ReviewRecomendation> reviewRecomendationList = new ArrayList<>();


        for(String reviewedEntity: reviewedEntities)
        {

            ReviewRecomendation reviewRecomendation =  new ReviewRecomendation();
            reviewRecomendation.setEntitiesByAvgGrade(reviewRepository.findAvgGradeByReviewEntity(reviewedEntity));
            reviewRecomendation.setNoOfReviews(reviewRepository.findCountReviewByReviewEntity(reviewedEntity));

            reviewRecomendation.setRelevance(0.65*reviewRecomendation.getEntitiesByAvgGrade() + reviewRecomendation.getNoOfReviews()*0.35);
            reviewRecomendation.setReviewedEntity(reviewedEntity);

            reviewRecomendationList.add(reviewRecomendation);
        }
        log.info("reviewRecomendationList "+ reviewRecomendationList);
        return reviewRecomendationList;
    }
}
