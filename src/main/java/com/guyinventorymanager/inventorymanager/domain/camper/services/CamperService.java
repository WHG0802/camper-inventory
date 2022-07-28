package com.guyinventorymanager.inventorymanager.domain.camper.services;


import com.guyinventorymanager.inventorymanager.domain.camper.model.Camper;
import com.guyinventorymanager.inventorymanager.domain.camper.model.CamperType;
import com.guyinventorymanager.inventorymanager.domain.core.ResourceCreationException;
import com.guyinventorymanager.inventorymanager.domain.core.ResourceNotFoundException;

import java.util.List;

public interface CamperService {
    Camper create(Camper camper) throws ResourceCreationException;
    Camper getById(Long id) throws ResourceNotFoundException;
    Camper getByEmail(String email) throws ResourceNotFoundException;
    List<Camper> getByLastName(String lastName) throws ResourceNotFoundException;
    List<Camper> getByCamperType(CamperType camperType) throws ResourceNotFoundException;
    List<Camper> getAll();
    Camper update(Long id, Camper camperDetail) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
