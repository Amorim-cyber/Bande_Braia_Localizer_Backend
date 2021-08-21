package com.bandebraia.braiaLocalizerbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "local_name")
    private String localName;

    @Column(name = "bike_src")
    private String bikeSrc;

    @Column(name = "foot_src")
    private String footSrc;

    @Column(name = "car_src")
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
