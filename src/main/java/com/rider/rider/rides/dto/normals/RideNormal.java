package com.rider.rider.rides.dto.normals;

import com.rider.rider.partners.dto.normal.PartnerNormal;
import com.rider.rider.ratings.dto.normals.RatingNormal;
import com.rider.rider.rides.enums.RideStatus;
import com.rider.rider.rides.enums.RideType;
import com.rider.rider.users.dto.normals.UserNormal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RideNormal {
    private String rideId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserNormal user;
    private PartnerNormal partner;
    private RideLocationInfoNormal rideLocationInfo;
    private RideTimingInfoNormal rideTimingInfo;
    private RidePaymentInfoNormal ridePaymentInfo;
    private List<RideTrackingNormal> rideTracking;
//    private RatingNormal rating;
    private String rideRequestId;
    private RideStatus rideStatus;
    private RideType rideType;
}
