package com.disertatie.skimanagement.review.entity;


import com.disertatie.skimanagement.review.model.Review;

import javax.persistence.*;

@Entity
@Table(name="review")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idreview", insertable = false, updatable = false)
    private int id;

    @Column(name="reviewer_name")
    private String reviewerName;

    @Column(name="grade")
    private Integer grade;

    @Column(name="reviewer_account")
    private String reviewerAccount;

    @Column(name="comment")
    private String comment;

    @Column(name="reviewed_entity")
    private String reviewedEntity;

    public ReviewEntity(){}

    public ReviewEntity(int id, String reviewerName, Integer grade, String reviewerAccount, String comment, String reviewedEntity) {
        this.id = id;
        this.reviewerName = reviewerName;
        this.grade = grade;
        this.reviewerAccount = reviewerAccount;
        this.comment = comment;
        this.reviewedEntity = reviewedEntity;
    }

    public ReviewEntity(Review review){
        this.reviewerName = review.getReviewerName();
        this.grade = review.getGrade();
        this.reviewerAccount = review.getReviewerAccount();
        this.comment = review.getComment();
        this.reviewedEntity = review.getReviewedEntity();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
