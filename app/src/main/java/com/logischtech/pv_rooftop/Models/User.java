package com.logischtech.pv_rooftop.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Aayushi.Garg on 27-09-2018.
 */
public class User  implements Serializable{

    @SerializedName("name")
    public String name ;
    public String getName(){
        return this.name ;
    }



}
