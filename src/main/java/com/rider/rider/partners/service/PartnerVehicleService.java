package com.rider.rider.partners.service;

import com.rider.rider.partners.dto.normal.PartnerVehicleNormal;
import com.rider.rider.partners.dto.request.AddPartnerVehicleRequest;
import com.rider.rider.partners.dto.request.GetPartnerVehicleByIdRequest;
import com.rider.rider.partners.dto.request.GetPartnerVehicleByPartnerRequest;
import com.rider.rider.partners.dto.request.UpdatePartnerVehicleRequest;
import com.rider.rider.partners.dto.response.*;
import com.rider.rider.partners.entity.Partner;
import com.rider.rider.partners.entity.PartnerVehicle;
import com.rider.rider.partners.entity.PartnerVehicleModel;
import com.rider.rider.partners.repository.PartnerVehicleModelRepository;
import com.rider.rider.partners.repository.PartnerVehicleRepository;
import com.rider.rider.partners.utils.mapper.PartnerMapper;
import com.rider.rider.partners.utils.mapper.PartnerVehicleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PartnerVehicleService {
    private final PartnerVehicleRepository partnerVehicleRepository;
    private final PartnerService partnerService;
    private final PartnerVehicleModelRepository partnerVehicleModelRepository;

    public PartnerVehicleService(PartnerVehicleRepository partnerVehicleRepository, PartnerService partnerService, PartnerVehicleModelRepository partnerVehicleModelRepository) {
        this.partnerVehicleRepository = partnerVehicleRepository;
        this.partnerService = partnerService;
        this.partnerVehicleModelRepository = partnerVehicleModelRepository;
    }

    public GetPartnerVehicleByIdResponse getPartnerVehicleById(GetPartnerVehicleByIdRequest getPartnerVehicleByIdRequest) {
        PartnerVehicle partnerVehicle = this.partnerVehicleRepository.findById(UUID.fromString(getPartnerVehicleByIdRequest.getPartnerVehicleId())).orElseThrow();
        return new GetPartnerVehicleByIdResponse(PartnerVehicleMapper.toNormal(partnerVehicle));
    }

    public GetPartnerVehicleByPartnerResponse getPartnerVehicleByPartner(GetPartnerVehicleByPartnerRequest getPartnerVehicleByPartnerRequest) {
        List<PartnerVehicle> partnerVehicles = this.partnerVehicleRepository.findAllByPartner_Id(UUID.fromString(getPartnerVehicleByPartnerRequest.getPartnerId()));
        List<PartnerVehicleNormal> partnerVehicleNormalList = partnerVehicles.stream().map(PartnerVehicleMapper::toNormal).toList();
        return new GetPartnerVehicleByPartnerResponse(partnerVehicleNormalList);
    }

    public GetAllPartnerVehiclesResponse getAllPartnerVehiclesResponse() {
        List<PartnerVehicleNormal> partnerVehicleNormalList = this.partnerVehicleRepository.findAll().stream().map(PartnerVehicleMapper::toNormal).toList();
        return new GetAllPartnerVehiclesResponse(partnerVehicleNormalList);
    }

    public AddPartnerVehicleResponse addPartnerVehicle(AddPartnerVehicleRequest request) {
        // Step 1: Fetch partner and convert
        GetPartnerByIdResponse partnerResponse = partnerService.getPartnerById(request.getPartnerId());
        Partner partner = PartnerMapper.toEntity(partnerResponse.getPartnerNormal());

        // Step 2: Create and save PartnerVehicleModel
        PartnerVehicleModel model = new PartnerVehicleModel();
        model.setCompany(request.getPartnerVehicleCompany());
        model.setModelName(request.getPartnerVehicleModelName());
        model.setModelYear(request.getPartnerVehicleModelYear());

        PartnerVehicleModel savedModel = partnerVehicleModelRepository.save(model);

        // Step 3: Create PartnerVehicle and set model
        PartnerVehicle vehicle = new PartnerVehicle();
        vehicle.setPartner(partner);
        vehicle.setPartnerVehicleModel(savedModel); // Set saved model
        vehicle.setPartnerVehicleRegistrationNumber(request.getPartnerVehicleRegistrationNumber());
        vehicle.setPartnerVehicleType(request.getPartnerVehicleType());
        vehicle.setColor(request.getPartnerVehicleColor());

        // Step 4: Set reverse relation
        savedModel.setPartnerVehicle(vehicle);

        // Step 5: Add to partner's vehicle list (optional depending on cascade)
        partner.getPartnerVehicles().add(vehicle);

        // Step 6: Save vehicle
        PartnerVehicle savedVehicle = partnerVehicleRepository.save(vehicle);

        return new AddPartnerVehicleResponse(savedVehicle.getId().toString());
    }

    public void updatePartnerVehicle(UpdatePartnerVehicleRequest updatePartnerVehicleRequest) {
        PartnerVehicle partnerVehicle = this.partnerVehicleRepository.findById(UUID.fromString(updatePartnerVehicleRequest.getPartnerVehicleId())).orElseThrow();
        GetPartnerByIdResponse getPartnerByIdResponse = this.partnerService.getPartnerById(updatePartnerVehicleRequest.getPartnerId());

        PartnerVehicleModel partnerVehicleModel = partnerVehicle.getPartnerVehicleModel();
        partnerVehicleModel.setCompany(updatePartnerVehicleRequest.getPartnerVehicleCompany());
        partnerVehicleModel.setModelName(updatePartnerVehicleRequest.getModelName());
        partnerVehicleModel.setModelYear(updatePartnerVehicleRequest.getModelYear());

        partnerVehicle.setPartner(PartnerMapper.toEntity(getPartnerByIdResponse.getPartnerNormal()));
        partnerVehicle.setPartnerVehicleModel(partnerVehicleModel);
        partnerVehicle.setPartnerVehicleType(updatePartnerVehicleRequest.getPartnerVehicleType());
        partnerVehicle.setPartnerVehicleRegistrationNumber(updatePartnerVehicleRequest.getPartnerVehicleRegistrationNumber());

        this.partnerVehicleRepository.save(partnerVehicle);
    }

}
