package com.example.mvvmtest.model;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private long id;
    private String url;
    private String title;
    private long year;
    private double rating;
    private long runtime;
    private String summary;
    private String medium_cover_image;

    @BindingAdapter("mediumCoverImage")
    public static void loadImage(RoundedImageView view, String medium_cover_image){
        Glide
                .with(view.getContext())
                .load(medium_cover_image)
                .into(view);
    }

}
