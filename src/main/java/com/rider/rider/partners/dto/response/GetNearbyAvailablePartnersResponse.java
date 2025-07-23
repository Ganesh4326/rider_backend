package com.rider.rider.partners.dto.response;

import com.rider.rider.partners.dto.normal.PartnerNormal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetNearbyAvailablePartnersResponse {
    private List<PartnerNormal> partnersList;
}
