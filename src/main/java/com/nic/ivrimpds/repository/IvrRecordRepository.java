package com.nic.ivrimpds.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nic.ivrimpds.model.IvrRecord;

public interface IvrRecordRepository extends JpaRepository<IvrRecord, Integer> {
}
