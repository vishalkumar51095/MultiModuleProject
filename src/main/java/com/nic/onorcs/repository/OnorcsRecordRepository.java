package com.nic.onorcs.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nic.ivrimpds.model.IvrRecord;
import com.nic.onorcs.model.OnorcsRecord;

@Repository
public interface OnorcsRecordRepository extends JpaRepository<OnorcsRecord, Integer> {

	IvrRecord save(IvrRecord record);
}
