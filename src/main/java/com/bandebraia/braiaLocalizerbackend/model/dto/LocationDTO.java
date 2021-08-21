package com.bandebraia.braiaLocalizerbackend.model.dto;

import javax.validation.constraints.NotNull;

public class LocationDTO {

    private Long id;

    @NotNull
    private String localName;

    @NotNull
    private String bikeSrc;

    @NotNull
    private String footSrc;

    @NotNull
    private String carSrc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getBikeSrc() {
        return bikeSrc;
    }

    public void setBikeSrc(String bikeSrc) {
        this.bikeSrc = bikeSrc;
    }

    public String getFootSrc() {
        return footSrc;
    }

    public void setFootSrc(String footSrc) {
        this.footSrc = footSrc;
    }

    public String getCarSrc() {
        return carSrc;
    }

    public void setCarSrc(String carSrc) {
        this.carSrc = carSrc;
    }
}
