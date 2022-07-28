package com.guyinventorymanager.inventorymanager.domain.inventoryItem.service;

import com.guyinventorymanager.inventorymanager.domain.core.ResourceCreationException;
import com.guyinventorymanager.inventorymanager.domain.core.ResourceNotFoundException;
import com.guyinventorymanager.inventorymanager.domain.inventoryItem.model.InventoryItem;
import com.guyinventorymanager.inventorymanager.domain.inventoryItem.model.InventoryType;
import com.guyinventorymanager.inventorymanager.domain.inventoryItem.repository.InventoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepo inventoryRepo;

    @Autowired
    public InventoryServiceImpl(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    @Override
    public InventoryItem create(InventoryItem inventoryItem) throws ResourceNotFoundException {
        Optional<InventoryItem> optional = inventoryRepo.findByName(inventoryItem.getName());
        if(optional.isPresent())
            throw new ResourceCreationException("Email already exist");
        return inventoryRepo.save(inventoryItem);
    }

    @Override
    public InventoryItem getById(Long id) throws ResourceNotFoundException {
        InventoryItem inventoryItem = inventoryRepo.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("No Inventory Item with id: " + id));
        return inventoryItem;
    }

    @Override
    public List<InventoryItem> getByInventoryType(InventoryType inventoryType) throws ResourceNotFoundException {
        List<InventoryItem> items = inventoryRepo.findByInventoryType(inventoryType);
        return items;
    }


    @Override
    public List<InventoryItem> getAll() {
        return inventoryRepo.findAll();
    }


    @Override
    public InventoryItem update(Long id, InventoryItem itemDetail) throws ResourceNotFoundException {
        InventoryItem inventoryItem = getById(id);
        inventoryItem.setName(itemDetail.getName());
        inventoryItem.setInventoryType(itemDetail.getInventoryType());
        inventoryItem = inventoryRepo.save(inventoryItem);
        return inventoryItem;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        InventoryItem inventoryItem = getById(id);
        inventoryRepo.delete(inventoryItem);
    }
}