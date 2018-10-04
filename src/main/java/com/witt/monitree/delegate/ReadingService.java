package com.witt.monitree.delegate;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witt.monitree.mapper.ReadingRecordMapper;
import com.witt.monitree.model.Reading;
import com.witt.monitree.repositories.ReadingRecordRepository;

@Service
public class ReadingService {

	private ReadingRecordRepository recordRepo;
	private ReadingRecordMapper mapper;
	
	private SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");

	@Autowired
	public ReadingService(
	ReadingRecordRepository recordRepo, ReadingRecordMapper mapper) {
		this.recordRepo = recordRepo;
		this.mapper = mapper;
	}
	
	
	public Reading save(Reading reading) {
		return mapper.mapToReturnReading(recordRepo.save(mapper.mapToRecord(reading)));
	}

	public void delete(Long id) {
		recordRepo.delete(id);		
	}

	public List<Reading> getReadingsByQuery(String startDate, String endDate, String name) {
		try {
			Timestamp startStamp = new Timestamp(format.parse(startDate).getTime());
			Timestamp endStamp = new Timestamp(format.parse(endDate).getTime());
			if (null == name) {
				return getReadingsWithinDateRange(startStamp, endStamp);
			}
			return getReadingsWithDateRangeAndName(startStamp, endStamp, name);
		} catch (ParseException e) {
			throw new InternalError("There was an error parsing the input dates", e);
		}
	}

	private List<Reading> getReadingsWithinDateRange(Timestamp startDate, Timestamp endDate) {
		return mapper.mapRecordListToReturnList(recordRepo.findTopByDateBetweenOrderByDate(startDate, endDate));
	}

	private List<Reading> getReadingsWithDateRangeAndName(Timestamp startDate, Timestamp endDate, String name) {
		return mapper.mapRecordListToReturnList(recordRepo.findTopByDateBetweenAndNameOrderByDate(startDate, endDate, name));
	}

	public Reading getById(Long id) {
		return mapper.mapToReturnReading(recordRepo.findOne(id));
	}

	public Reading updateById(Long id, Reading reading) {
		return mapper.mapToReturnReading(recordRepo.save(mapper.mapToRecord(reading)));
	}

}
