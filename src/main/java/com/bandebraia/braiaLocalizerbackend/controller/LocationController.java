package com.bandebraia.braiaLocalizerbackend.controller;


import com.bandebraia.braiaLocalizerbackend.model.dto.LocationDTO;
import com.bandebraia.braiaLocalizerbackend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/principal")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationDTO> save(@RequestBody LocationDTO dto){
        return ResponseEntity.ok(locationService.save(dto));
    }

    @PostMapping(value = "/createAll",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocationDTO>> save(@Valid @RequestBody List<LocationDTO> list){
        return ResponseEntity.ok(locationService.save(list));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationDTO> update(@RequestBody LocationDTO dto){
        return ResponseEntity.ok(locationService.update(dto));
    }

    @PutMapping(value = "/updateAll",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocationDTO>> update(@RequestBody List<LocationDTO> list){
        return ResponseEntity.ok(locationService.update(list));
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocationDTO>> findAll(){

        return ResponseEntity.ok(locationService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public  ResponseEntity<LocationDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(locationService.findById(id));

    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(locationService.delete(id));
    }

    @DeleteMapping(value = "/deleteAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocationDTO>> deleteAll(@RequestBody List<LocationDTO> list){
        return ResponseEntity.ok(locationService.deleteAll(list));
    }


}
