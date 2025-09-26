package com.nic.onorcs.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nic.onorcs.model.OnorcsRecord;
import com.nic.onorcs.repository.OnorcsRecordRepository;



@Service
public class OnorcsRecordService {

    private final OnorcsRecordRepository repository;

    public OnorcsRecordService(OnorcsRecordRepository repository) {
        this.repository = repository;
    }

    public List<OnorcsRecord> getAllRecords() {
        return repository.findAll();
    }

    public OnorcsRecord saveRecord(OnorcsRecord record) {
        return repository.save(record);
    }

    public OnorcsRecord getRecordById(Integer id) {
        Optional<OnorcsRecord> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public void deleteRecord(Integer id) {
        repository.deleteById(id);
    }
}
