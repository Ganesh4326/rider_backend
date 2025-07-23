package com.rider.rider.partners.dto.response;

import com.rider.rider.partners.dto.normal.PartnerNormal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetPartnerByIdResponse {
    private PartnerNormal partnerNormal;
}
