package com.witt.monitree.mapper;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.witt.monitree.entities.ReadingRecord;
import com.witt.monitree.model.Reading;

public class ReadingRecordMapperTest {

	private ReadingRecordMapper mapper;

	@Before
	public void setUp() throws Exception {
		mapper = new ReadingRecordMapper();
	}

	@Test
	public void test() {
		List<Reading> mapRecordListToReturnList = mapper.mapRecordListToReturnList(Arrays.asList(buildRecord("APP"), buildRecord("APP")));
		assertEquals(2, mapRecordListToReturnList.size());
	}

	private ReadingRecord buildRecord(String creator) {
		ReadingRecord readingRecord = new ReadingRecord();
		readingRecord.setCreator(creator);
		readingRecord.setDate(new Timestamp(System.currentTimeMillis()));
		return readingRecord;
	}

}
