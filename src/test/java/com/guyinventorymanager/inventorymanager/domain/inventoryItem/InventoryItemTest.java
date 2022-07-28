package com.guyinventorymanager.inventorymanager.domain.inventoryItem;

import com.guyinventorymanager.inventorymanager.domain.inventoryItem.model.InventoryItem;
import com.guyinventorymanager.inventorymanager.domain.inventoryItem.model.InventoryType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryItemTest {

    @Test
    public void userConstructorTest(){
        InventoryItem inventoryItem = new InventoryItem("William","Bluetooth Speaker", InventoryType.ENTERTAINMENT);
        inventoryItem.setId(1L);
        String expected = "1 William Bluetooth Speaker ENTERTAINMENT";
        String actual = inventoryItem.toString();
        Assertions.assertEquals(expected, actual);
    }
}
