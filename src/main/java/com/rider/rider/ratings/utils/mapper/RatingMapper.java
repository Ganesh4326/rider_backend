package com.rider.rider.ratings.utils.mapper;

import com.rider.rider.ratings.dto.normals.RatingNormal;
import com.rider.rider.ratings.entity.Rating;

public class RatingMapper {
    public static Rating toEntity(RatingNormal ratingNormal) {
        return new Rating();
    }

    public static RatingNormal toNormal(Rating rating) {
        return new RatingNormal();
    }
}
