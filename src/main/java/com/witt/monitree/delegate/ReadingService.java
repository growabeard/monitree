package com.witt.monitree.delegate;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witt.monitree.mapper.ReadingRecordMapper;
import com.witt.monitree.model.Reading;
import com.witt.monitree.repositories.ReadingRecordRepository;

@Service
public class ReadingService {

	private ReadingRecordRepository recordRepo;

	@Autowired
	public ReadingService(
	ReadingRecordRepository recordRepo) {
		this.recordRepo = recordRepo;
	}
	
	ReadingRecordMapper mapper = new ReadingRecordMapper();
	
	public Reading save(Reading reading) {
		return mapper.mapToReturnReading(recordRepo.save(mapper.mapToRecord(reading)));
	}

	public void delete(Long id) {
		recordRepo.delete(id);		
	}

	public List<Reading> getReadingsInDateRange(String startDate, String endDate) {
		return mapper.mapRecordListToReturnList(recordRepo.findTopByDateBetweenOrderByDate(Timestamp.valueOf(startDate), Timestamp.valueOf(endDate)));
	}

	public Reading getById(Long id) {
		return mapper.mapToReturnReading(recordRepo.findOne(id));
	}

	public Reading updateById(Long id, Reading reading) {
		return mapper.mapToReturnReading(recordRepo.save(mapper.mapToRecord(reading)));
	}

}
