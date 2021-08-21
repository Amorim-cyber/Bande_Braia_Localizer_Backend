package com.bandebraia.braiaLocalizerbackend.service;

import com.bandebraia.braiaLocalizerbackend.exceptions.BusinessException;
import com.bandebraia.braiaLocalizerbackend.exceptions.NotFoundException;
import com.bandebraia.braiaLocalizerbackend.mapper.LocationMapper;
import com.bandebraia.braiaLocalizerbackend.model.Location;
import com.bandebraia.braiaLocalizerbackend.model.dto.LocationDTO;
import com.bandebraia.braiaLocalizerbackend.repository.LocationRepository;
import com.bandebraia.braiaLocalizerbackend.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationMapper locationMapper;

    @Transactional
    public LocationDTO save(LocationDTO dto) {

        Optional<Location> optionalLocation = locationRepository.findByLocation(dto.getBikeSrc(),
                dto.getCarSrc(),dto.getFootSrc(),dto.getLocalName());
        if(optionalLocation.isPresent()){
            throw new BusinessException(MessageUtils.LOCATION_ALREADY_EXISTS);
        }
        Location offer = locationMapper.toEntity(dto);
        locationRepository.save(offer);
        return locationMapper.toDto(offer);
    }

    @Transactional
    public List<LocationDTO> save(List<LocationDTO> listDto) {

        listDto.stream().forEach(x->save(x));

        return listDto;
    }

    @Transactional
    public LocationDTO update(LocationDTO dto) {

        Optional<Location> optionalLocation = locationRepository.findByOfferUpdate(dto.getLocalName(), dto.getId());
        if(optionalLocation.isPresent()){
            throw new BusinessException(MessageUtils.LOCATION_ALREADY_EXISTS);
        }

        Location location = locationMapper.toEntity(dto);
        locationRepository.save(location);
        return locationMapper.toDto(location);
    }

    @Transactional
    public List<LocationDTO> update(List<LocationDTO> listDto) {

        listDto.stream().forEach(x->update(x));

        return listDto;
    }

    @Transactional
    public LocationDTO delete(Long id) {
        LocationDTO dto = this.findById(id);

        locationRepository.deleteById(dto.getId());
        return dto;
    }

    @Transactional
    public List<LocationDTO> deleteAll(List<LocationDTO> listDto) {
        listDto.stream().forEach(x->delete(x.getId()));
        return listDto;
    }

    @Transactional(readOnly = true)
    public List<LocationDTO> findAll() {
        return locationMapper.toDto(locationRepository.findAll());
    }

    @Transactional(readOnly = true)
    public LocationDTO findById(Long id) {
        return locationRepository.findById(id).map(locationMapper::toDto).orElseThrow(NotFoundException::new);
    }

}
