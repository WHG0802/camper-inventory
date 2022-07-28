package com.guyinventorymanager.inventorymanager.domain.inventoryItem.controller;

import com.guyinventorymanager.inventorymanager.domain.inventoryItem.model.InventoryItem;
import com.guyinventorymanager.inventorymanager.domain.inventoryItem.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class InventoryController {

    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @GetMapping
    public ResponseEntity<List<InventoryItem>> getAll() {
        List<InventoryItem> requests = inventoryService.getAll();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InventoryItem> create(@RequestBody InventoryItem inventoryItem){
        inventoryItem = inventoryService.create(inventoryItem);
        return new ResponseEntity<>(inventoryItem, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<InventoryItem> getById(@PathVariable("id") Long id){
        InventoryItem inventoryItem = inventoryService.getById(id);
        return new ResponseEntity<>(inventoryItem, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<InventoryItem> update(@PathVariable("id") Long id, @RequestBody InventoryItem itemDetail){
        itemDetail = inventoryService.update(id, itemDetail);
        return new ResponseEntity<>(itemDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        inventoryService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
