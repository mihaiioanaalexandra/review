package com.disertatie.skimanagement.review.model;

public class Review {

    private String reviewerName;
    private Integer grade;
    private String reviewerAccount;
    private String comment;
    private String reviewedEntity;

    public Review(String reviewerName, Integer grade, String reviewerAccount, String comment, String reviewedEntity) {
        this.reviewerName = reviewerName;
        this.grade = grade;
        this.reviewerAccount = reviewerAccount;
        this.comment = comment;
        this.reviewedEntity = reviewedEntity;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getReviewerAccount() {
        return reviewerAccount;
    }

    public void setReviewerAccount(String reviewerAccount) {
        this.reviewerAccount = reviewerAccount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReviewedEntity() {
        return reviewedEntity;
    }

    public void setReviewedEntity(String reviewedEntity) {
        this.reviewedEntity = reviewedEntity;
    }
}
