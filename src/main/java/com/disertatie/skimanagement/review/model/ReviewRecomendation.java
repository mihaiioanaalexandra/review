package com.disertatie.skimanagement.review.model;

public class ReviewRecomendation {

    private  Float entitiesByAvgGrade;
    private Integer noOfReviews;
    private Double relevance;
    private String reviewedEntity;


    public ReviewRecomendation() {}

    public ReviewRecomendation(Float entitiesByAvgGrade, Integer noOfReviews, Double relevance, String reviewedEntity) {
        this.entitiesByAvgGrade = entitiesByAvgGrade;
        this.noOfReviews = noOfReviews;
        this.relevance = relevance;
        this.reviewedEntity = reviewedEntity;
    }

    public String getReviewedEntity() {
        return reviewedEntity;
    }

    public void setReviewedEntity(String reviewedEntity) {
        this.reviewedEntity = reviewedEntity;
    }

    public Float getEntitiesByAvgGrade() {
        return entitiesByAvgGrade;
    }

    public void setEntitiesByAvgGrade(Float entitiesByAvgGrade) {
        this.entitiesByAvgGrade = entitiesByAvgGrade;
    }

    public Integer getNoOfReviews() {
        return noOfReviews;
    }

    public void setNoOfReviews(Integer noOfReviews) {
        this.noOfReviews = noOfReviews;
    }

    public Double getRelevance() {
        return relevance;
    }

    public void setRelevance(Double relevance) {
        this.relevance = relevance;
    }
}
