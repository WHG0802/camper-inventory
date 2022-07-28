package com.guyinventorymanager.inventorymanager;

import com.guyinventorymanager.inventorymanager.domain.camper.model.Camper;
import com.guyinventorymanager.inventorymanager.domain.camper.model.CamperType;
import com.guyinventorymanager.inventorymanager.domain.camper.services.CamperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InitialDataLoader implements CommandLineRunner {

    @Autowired
    private CamperService camperService;

    @Override
    public void run(String...args) throws Exception{
        Camper camper = new Camper("William", "Guy", "abc@123", CamperType.BOYSCOUT);
        camper = camperService.create(camper);
        log.info("Created a new camper" + camper.toString());
    }
}
