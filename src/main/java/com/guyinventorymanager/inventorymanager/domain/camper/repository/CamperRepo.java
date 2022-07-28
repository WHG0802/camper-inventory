package com.guyinventorymanager.inventorymanager.domain.camper.repository;

import com.guyinventorymanager.inventorymanager.domain.camper.model.Camper;
import com.guyinventorymanager.inventorymanager.domain.camper.model.CamperType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CamperRepo extends JpaRepository<Camper,Long> {
    Optional<Camper> findByEmail(String email);
    List<Camper> findByLastName(String lastName);
    List<Camper> findByCamperType(CamperType camperType);
}
