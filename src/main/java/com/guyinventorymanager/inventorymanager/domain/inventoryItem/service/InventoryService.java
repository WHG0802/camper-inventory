package com.guyinventorymanager.inventorymanager.domain.inventoryItem.service;


import com.guyinventorymanager.inventorymanager.domain.core.ResourceNotFoundException;
import com.guyinventorymanager.inventorymanager.domain.inventoryItem.model.InventoryItem;
import com.guyinventorymanager.inventorymanager.domain.inventoryItem.model.InventoryType;

import java.util.List;

public interface InventoryService {
    InventoryItem create (InventoryItem inventoryItem) throws ResourceNotFoundException;
    InventoryItem getById(Long id) throws ResourceNotFoundException;
    List<InventoryItem> getAll();
    List<InventoryItem> getByInventoryType(InventoryType inventoryType) throws ResourceNotFoundException;
    InventoryItem update(Long id, InventoryItem itemDetail) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
