package com.nic.ivrimpds.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nic.ivrimpds.model.IvrRecord;
import com.nic.ivrimpds.service.IvrService;

@RestController
@RequestMapping("/ivr")
public class IvrRecordController {

    private final IvrService service;

    public IvrRecordController(IvrService service) {
        this.service = service;
    }

    @GetMapping("/records")
    public List<IvrRecord> getRecords() {
        return service.getAllRecords();
    }

    @PostMapping("/records")
    public IvrRecord addRecord(@RequestBody IvrRecord record) {
        return service.saveRecord(record);
    }
}
