package com.disertatie.skimanagement.review.repository;

import com.disertatie.skimanagement.review.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {

    Iterable<ReviewEntity> findByReviewedEntityContaining(String reviewedEntity);

    @Query(nativeQuery = true, value = "SELECT avg(grade) from review where reviewed_entity=:reviewedEntity")
    Float findAvgGradeByReviewEntity(String reviewedEntity);

    @Query(nativeQuery = true, value = "SELECT count(idreview) from review where reviewed_entity=:reviewedEntity")
    Integer findCountReviewByReviewEntity(String reviewedEntity);

}
