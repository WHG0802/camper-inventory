package com.guyinventorymanager.inventorymanager.domain.camper.controller;

import com.guyinventorymanager.inventorymanager.domain.camper.model.Camper;
import com.guyinventorymanager.inventorymanager.domain.camper.services.CamperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/campers")
public class CamperController {

    private CamperService camperService;

    public CamperController(CamperService camperService) {
        this.camperService = camperService;
    }

    @GetMapping
    public ResponseEntity<List<Camper>> getAll(){
        List<Camper> requests = camperService.getAll();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Camper> create(@RequestBody Camper camper){
        camper = camperService.create(camper);
        return new ResponseEntity<>(camper, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Camper> getById(@PathVariable("id") Long id){
        Camper camper = camperService.getById(id);
        return new ResponseEntity<>(camper, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Camper> getByEmail(@RequestParam String email){
        Camper camper = camperService.getByEmail(email);
        return new ResponseEntity<>(camper, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Camper> update(@PathVariable("id") Long id, @RequestBody Camper camperDetail){
        camperDetail = camperService.update(id, camperDetail);
        return new ResponseEntity<>(camperDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        camperService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
