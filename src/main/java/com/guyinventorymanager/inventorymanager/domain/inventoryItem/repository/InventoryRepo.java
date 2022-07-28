package com.guyinventorymanager.inventorymanager.domain.inventoryItem.repository;

import com.guyinventorymanager.inventorymanager.domain.inventoryItem.model.InventoryItem;
import com.guyinventorymanager.inventorymanager.domain.inventoryItem.model.InventoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepo extends JpaRepository<InventoryItem, Long> {
    Optional<InventoryItem> findByName(String name);
    List<InventoryItem> findByInventoryType(InventoryType inventoryType);
}
