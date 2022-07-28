package com.guyinventorymanager.inventorymanager.domain.camper;

import com.guyinventorymanager.inventorymanager.domain.camper.model.Camper;
import com.guyinventorymanager.inventorymanager.domain.camper.model.CamperType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CamperTest {

    @Test
    public void userConstructorTest(){
        Camper camper = new Camper("William", "Guy", "abc@123", CamperType.BOYSCOUT);
        camper.setId(1L);
        String expected = "1 William Guy abc@123 BOYSCOUT";
        String actual = camper.toString();
        Assertions.assertEquals(expected,actual);
    }
}
