package com.lcwd.rating.RatingService.Entitiy;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Rating {
        @Id
        private String ratingId;
        private String userId;
        private String hotelId;
        private int rating;
        private String feedback;
}

