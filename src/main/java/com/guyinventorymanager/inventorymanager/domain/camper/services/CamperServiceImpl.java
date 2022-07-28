package com.guyinventorymanager.inventorymanager.domain.camper.services;

import com.guyinventorymanager.inventorymanager.domain.camper.model.Camper;
import com.guyinventorymanager.inventorymanager.domain.camper.model.CamperType;
import com.guyinventorymanager.inventorymanager.domain.camper.repository.CamperRepo;
import com.guyinventorymanager.inventorymanager.domain.core.ResourceCreationException;
import com.guyinventorymanager.inventorymanager.domain.core.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CamperServiceImpl implements CamperService {

    private CamperRepo camperRepo;

    @Autowired
    public CamperServiceImpl(CamperRepo camperRepo) {
        this.camperRepo = camperRepo;

    }

    @Override
    public Camper create(Camper camper) throws ResourceCreationException {
        Optional<Camper> optional = camperRepo.findByEmail(camper.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Email already exist");
        return camperRepo.save(camper);
    }

    @Override
    public Camper getById(Long id) throws ResourceNotFoundException {
        Camper camper = camperRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Camper with id: " + id));
        return camper;
    }

    @Override
    public Camper getByEmail(String email) throws ResourceNotFoundException {
        Camper camper = camperRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No Camper with email: " + email));
        return camper;
    }

    @Override
    public List<Camper> getByLastName(String lastName) throws ResourceNotFoundException {
        List<Camper> campers = camperRepo.findByLastName(lastName);
        return campers;
    }

    @Override
    public List<Camper> getByCamperType(CamperType camperType) throws ResourceNotFoundException {
        List<Camper> campers = camperRepo.findByCamperType(camperType);
        return campers;
    }

    @Override
    public List<Camper> getAll() {
        return (List<Camper>) camperRepo.findAll();
    }

    @Override
    public Camper update(Long id, Camper camperDetail) throws ResourceNotFoundException {
        Camper camper = getById(id);
        camper.setLastName(camperDetail.getLastName());
        camper.setEmail(camperDetail.getEmail());
        camper.setCamperType(camperDetail.getCamperType());
        camper = camperRepo.save(camper);
        return camper;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Camper camper = getById(id);
        camperRepo.delete(camper);
    }
}
