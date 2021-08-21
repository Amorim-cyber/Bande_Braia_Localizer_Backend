package com.bandebraia.braiaLocalizerbackend.mapper;

import com.bandebraia.braiaLocalizerbackend.model.Location;
import com.bandebraia.braiaLocalizerbackend.model.dto.LocationDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationMapper {

    public Location toEntity(LocationDTO dto) {
        Location location = new Location();
        location.setId(dto.getId());
        location.setLocalName(dto.getLocalName());
        location.setBikeSrc(dto.getBikeSrc());
        location.setFootSrc(dto.getFootSrc());
        location.setCarSrc(dto.getCarSrc());
        return location;
    }

    public LocationDTO toDto(Location location) {
        LocationDTO dto = new LocationDTO();
        dto.setId(location.getId());
        dto.setLocalName(location.getLocalName());
        dto.setBikeSrc(location.getBikeSrc());
        dto.setFootSrc(location.getFootSrc());
        dto.setCarSrc(location.getCarSrc());
        return dto;
    }

    public List<LocationDTO> toDto(List<Location> list){
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }
}
