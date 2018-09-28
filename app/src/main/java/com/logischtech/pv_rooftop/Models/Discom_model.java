package com.logischtech.pv_rooftop.Models;

/**
 * Created by Aayushi.Garg on 27-09-2018.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Discom_model  implements Serializable {

    @SerializedName("user")
    public User user ;
    public User getUser(){
        return this.user ;
    }


    @SerializedName("id")
    public String id ;
    public String getId(){
        return this.id ;
    }


}

