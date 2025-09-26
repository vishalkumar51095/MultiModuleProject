package com.nic.ivrimpds.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nic.ivrimpds.model.IvrRecord;
import com.nic.ivrimpds.repository.IvrRecordRepository;

@Service
public class IvrService {

    private final IvrRecordRepository repository;

    public IvrService(IvrRecordRepository repository) {
        this.repository = repository;
    }


    public List<IvrRecord> getAllRecords() {
        return repository.findAll();
    }

    public IvrRecord saveRecord(IvrRecord record) {
        return repository.save(record);
    }
}

