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

	public List<Reading> getReadingsByQuery(String startDate, String endDate, String name) {
		if (null == name) {
			return getReadingsWithinDateRange(startDate, endDate);
		}
		return getReadingsWithDateRangeAndName(startDate, endDate, name);
	}

	private List<Reading> getReadingsWithinDateRange(String startDate, String endDate) {
		return mapper.mapRecordListToReturnList(recordRepo.findTopByDateBetweenOrderByDate(Timestamp.valueOf(startDate), Timestamp.valueOf(endDate)));
	}

	private List<Reading> getReadingsWithDateRangeAndName(String startDate, String endDate, String name) {
		return mapper.mapRecordListToReturnList(recordRepo.findTopByDateBetweenAndNameOrderByDate(Timestamp.valueOf(startDate), Timestamp.valueOf(endDate), name));
	}

	public Reading getById(Long id) {
		return mapper.mapToReturnReading(recordRepo.findOne(id));
	}

	public Reading updateById(Long id, Reading reading) {
		return mapper.mapToReturnReading(recordRepo.save(mapper.mapToRecord(reading)));
	}

}
