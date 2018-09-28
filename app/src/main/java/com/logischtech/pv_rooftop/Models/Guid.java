package com.logischtech.pv_rooftop.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Aayushi.Garg on 12-09-2018.
 */
public class Guid  implements Serializable{


    @SerializedName("rendered")
    public String rendered ;
    public String getRendered(){
        return this.rendered ;
    }
}
