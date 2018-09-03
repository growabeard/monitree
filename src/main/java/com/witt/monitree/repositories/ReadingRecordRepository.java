package com.witt.monitree.repositories;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import com.witt.monitree.entities.ReadingRecord;

public interface ReadingRecordRepository extends CrudRepository<ReadingRecord, Long> {

	Iterable<ReadingRecord> findAllByUseridOrderByValueAsc(Long id);
	
	Iterable<ReadingRecord> findTopByDateBetweenOrderByDate(Date start, Date stop);
	
}
