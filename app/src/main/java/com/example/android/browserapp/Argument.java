package com.example.android.browserapp;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nigelfrazier on 7/5/18.
 */

public class Argument implements Serializable {
    private String claim;
    private String evidence;
    private String justification;
    private String author;
    private String positionPhoto;
    private boolean agreement;
    private String webUrl;
    private String inquiry;
    private String key;
    private String argumentTitle;
    private Bitmap favicon;
    private ArrayList<String> votes;


    public Argument(String claim, String evidence, String justification, String webUrl) {
        this.claim = claim;
        this.evidence = evidence;
        this.justification = justification;
        this.webUrl = webUrl;
        votes = new ArrayList<>();
    }

    public Argument() {
        this("", "", "", "");
    }


    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPositionPhoto() {
        return positionPhoto;
    }

    public void setPositionPhoto(String positionPhoto) {
        this.positionPhoto = positionPhoto;
    }

    public boolean isAgreement() {
        return agreement;
    }

    public void setAgreement(boolean agreement) {
        this.agreement = agreement;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }

    public String getArgumentTitle() {
        return argumentTitle;
    }

    public void setArgumentTitle(String argumentTitle) {
        this.argumentTitle = argumentTitle;
    }

    public ArrayList<String> getVotes() {
        return votes;
    }

    public void setVotes(ArrayList<String> votes) {
        this.votes = votes;
    }


    public void clearArgument(){
        claim = "";
        evidence = "";
        justification = "";
        webUrl = "http://google.com/";
    }

    @Override
    public String toString() {
        String arg = "Claim: " + claim + "\nEvidence: " + evidence + "\nJustification: " + justification + "\nWebURL: " + webUrl;
        arg += "\nTitle: " + argumentTitle + "\nAuthor: " + author ;
        return arg;
    }


    //later with firebase
//    public Argument(String claim, String evidence, String justification, String author) {
//        this.claim = claim;
//        this.evidence = evidence;
//        this.justification = justification;
//        this.author = author;
//    }


}

