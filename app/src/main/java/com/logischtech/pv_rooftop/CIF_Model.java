package com.logischtech.pv_rooftop;

import com.google.gson.annotations.SerializedName;
import com.logischtech.pv_rooftop.Models.Discom_model;
import com.logischtech.pv_rooftop.Models.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Aayushi.Garg on 27-09-2018.
 */

public class CIF_Model implements Serializable {

    @SerializedName("data")
    public List<Discom_model> data ;
    public List<Discom_model> getData(){
        return this.data ;
    }

    @SerializedName("count")
    public Integer count ;
    public Integer getCount(){
        return this.count ;
    }




}
