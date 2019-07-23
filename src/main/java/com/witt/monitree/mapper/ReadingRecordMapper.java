package com.witt.monitree.mapper;

import com.witt.monitree.entities.ReadingRecord;
import com.witt.monitree.model.Reading;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ReadingRecordMapper {

	public ReadingRecord mapToRecord(Reading reading) {
		ReadingRecord record = new ReadingRecord();
		record.setCreator(reading.getCreator().name());
		String date = reading.getDate();
		if(StringUtils.isEmpty(date)) {
			record.setDate(new Timestamp(System.currentTimeMillis()));
		} else {
			record.setDate(Timestamp.valueOf(date));
		}
		record.setHumidity(reading.getHumidity());
		record.setId(reading.getId());
		record.setMoisture(reading.getMoisture());
		record.setName(reading.getName());
		record.setLight(reading.getLight());
		record.setTemp(reading.getTemp());
		record.setWatered(reading.getWatered());
		return record;
	}

	public Reading mapToReturnReading(Optional<ReadingRecord> optional) {
		if(optional.isPresent()) {
			return mapToReturnReading(optional.get());
		} 
		return new Reading();
	}

	public List<Reading> mapRecordListToReturnList(Iterable<ReadingRecord> findTopByDateBetweenOrderByDate) {
		List<Reading> readings = new ArrayList<Reading>();
		for(ReadingRecord record : findTopByDateBetweenOrderByDate) {
			readings.add(mapToReturnReading(record));
		}
		return readings;
	}

	public Reading mapToReturnReading(ReadingRecord record) {
		Reading reading = new Reading();
		reading.setCreator(Reading.CreatorEnum.valueOf(record.getCreator()));
		reading.setDate(record.getDate().toString());
		reading.setHumidity(record.getHumidity());
		reading.setId(record.getId());
		reading.setMoisture(record.getMoisture());
		reading.setTemp(record.getTemp());
		reading.setLight(record.getLight());
		reading.setName(record.getName());
		reading.setWatered(record.getWatered());
		return reading;
	}

}
