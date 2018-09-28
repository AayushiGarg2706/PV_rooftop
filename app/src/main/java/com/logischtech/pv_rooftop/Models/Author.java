package com.logischtech.pv_rooftop.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Aayushi.Garg on 13-09-2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author  implements Serializable{

    @SerializedName("name")
    public String name ;
    public String getName(){
        return this.name ;
    }


    @SerializedName("id")
    public String id ;
    public String getId(){
        return this.id ;
    }


}
