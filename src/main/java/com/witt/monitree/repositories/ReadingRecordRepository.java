package com.witt.monitree.repositories;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.data.repository.CrudRepository;

import com.witt.monitree.entities.ReadingRecord;

public interface ReadingRecordRepository extends CrudRepository<ReadingRecord, Long> {

	Iterable<ReadingRecord> findTopByDateBetweenOrderByDate(Timestamp start, Timestamp stop);

	Iterable<ReadingRecord> findTopByDateBetweenAndNameOrderByDate(Timestamp valueOf, Timestamp valueOf2, String name);
	
}
