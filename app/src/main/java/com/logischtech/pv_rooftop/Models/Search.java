package com.logischtech.pv_rooftop.Models;

import android.content.Context;
import android.content.Intent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.bind.TimeTypeAdapter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Aayushi.Garg on 14-09-2018.
 */
@JsonIgnoreProperties(ignoreUnknown =  true)
public class Search implements Serializable {
    @SerializedName("id")
    public String id;

    public String getId(){
        return this.id ;
    }

    @SerializedName("date")
    public String date ;
    public String getDate(){
        return this.date ;
    }

    @SerializedName("date_gmt")
    public String date_gmt ;
    public String getDate_gmt(){
        return this.date_gmt ;
    }




    @SerializedName("status")
    public String status ;

    public String getStatus(){
        return this.status ;
    }
    @SerializedName("type")
    public String type ;
    public String getType(){
        return this.type ;
    }

    @SerializedName("link")
    public String  link ;
    public  String getLink(){
        return this.link ;
    }

    @SerializedName("title")
    public Title title ;
    public Title getTitle(){
        return this.title ;
    }


    @SerializedName("content")
    public Content content ;

    public Content getContent(){
        return this.content ;
    }


    @SerializedName("excerpt")
    public Excerpt excerpt ;
    public Excerpt getExcerpt(){
        return this.excerpt ;
    }

    @SerializedName("author")
    public String author ;
    public String getAuthor(){
        return this.author ;
    }

    @SerializedName("categories")
    public List<Integer> categories ;
    public List<Integer> getCategories(){
        return this.categories ;
    }
    @SerializedName("tags")
    public List<Integer> tags ;
    public List<Integer>  getTags(){
        return this.tags ;
    }





}
