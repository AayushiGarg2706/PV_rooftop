package com.logischtech.pv_rooftop.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Aayushi.Garg on 12-09-2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class Content  implements Serializable{

    @SerializedName("rendered")
    public String rendered ;
    public String getRendered(){
        return this.rendered ;
    }

  //  @SerializedName("protected")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public Boolean  protect ;
    public Boolean getProtect(){
        return this.protect;

    }


}
