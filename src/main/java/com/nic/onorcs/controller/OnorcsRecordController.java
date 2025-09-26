package com.nic.onorcs.controller;



import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nic.onorcs.model.OnorcsRecord;
import com.nic.onorcs.service.OnorcsRecordService;



@RestController
@RequestMapping("/onorcs")
public class OnorcsRecordController {

    private final OnorcsRecordService service;

    public OnorcsRecordController(OnorcsRecordService service) {
        this.service = service;
    }

    // Get all ONORCS records
    @GetMapping("/records")
    public List<OnorcsRecord> getRecords() {
        return service.getAllRecords();
    }

    // Add a new ONORCS record
    @PostMapping("/records")
    public OnorcsRecord addRecord(@RequestBody OnorcsRecord record) {
        return service.saveRecord(record);
    }

    // Optional: Get a record by ID
    @GetMapping("/records/{id}")
    public OnorcsRecord getRecordById(@PathVariable Integer id) {
        return service.getRecordById(id);
    }

    // Optional: Delete a record
    @DeleteMapping("/records/{id}")
    public void deleteRecord(@PathVariable Integer id) {
        service.deleteRecord(id);
    }
}
