package com.witt.monitree.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.witt.monitree.entities.ReadingRecord;
import com.witt.monitree.model.Reading;

public class ReadingRecordMapper {

	public ReadingRecord mapToRecord(Reading reading) {
		ReadingRecord record = new ReadingRecord();
		record.setCreator(reading.getCreator().name());
		record.setDate(Timestamp.valueOf(reading.getDate()));
		record.setHumidity(reading.getHumidity());
		record.setId(reading.getId());
		record.setMoisture(reading.getMoisture());
		record.setName(reading.getName());
		record.setTemp(reading.getTemp());
		record.setWatered(reading.getWatered());
		return record;
	}

	public Reading mapToReturnReading(ReadingRecord save) {
		Reading reading = new Reading();
		reading.setCreator(Reading.CreatorEnum.valueOf(save.getCreator()));
		reading.setDate(save.getDate().toString());
		reading.setHumidity(save.getHumidity());
		reading.setId(save.getId());
		reading.setMoisture(save.getMoisture());
		reading.setTemp(save.getTemp());
		reading.setName(save.getName());
		reading.setWatered(save.getWatered());
		return reading;
	}

	public List<Reading> mapRecordListToReturnList(Iterable<ReadingRecord> findTopByDateBetweenOrderByDate) {
		List<Reading> readings = new ArrayList<Reading>();
		for(ReadingRecord record : findTopByDateBetweenOrderByDate) {
			readings.add(mapToReturnReading(record));
		}
		return readings;
	}

}
