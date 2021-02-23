package com.example.retrofitex01;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int userId;

    private Integer id;

    private String title;

    @SerializedName("body")
    private String text;
}
