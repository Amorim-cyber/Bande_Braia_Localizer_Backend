package com.bandebraia.braiaLocalizerbackend.repository;

import com.bandebraia.braiaLocalizerbackend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("SELECT location "+
            "FROM Location location "+
            "WHERE location.bikeSrc = :bikeSrc AND "+
            "location.carSrc = :carSrc AND "+
            "location.footSrc = :footSrc AND "+
            "location.localName = :localName ")
    Optional<Location> findByLocation(String bikeSrc, String carSrc, String footSrc, String localName);

    @Query("SELECT location "+
            "FROM Location location "+
            "WHERE location.localName = :localName AND location.id <> :id ")
    Optional<Location> findByOfferUpdate(String localName, Long id);
}
