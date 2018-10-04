package com.witt.monitree.delegate;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.witt.monitree.entities.ReadingRecord;
import com.witt.monitree.mapper.ReadingRecordMapper;
import com.witt.monitree.repositories.ReadingRecordRepository;

public class ReadingServiceTest {

	private static final ReadingRecordRepository MOCK = Mockito.mock(ReadingRecordRepository.class);
	private ReadingService readingService;

	@Before
	public void setUp() throws Exception {
		when(MOCK.findAllByDateBetweenAndNameOrderByDate(any(Timestamp.class), any(Timestamp.class), anyString())).thenReturn(Arrays.asList(new ReadingRecord()));
		when(MOCK.findAllByDateBetweenOrderByDate(any(Timestamp.class), any(Timestamp.class))).thenReturn(Arrays.asList(new ReadingRecord()));
		readingService = new ReadingService(MOCK, Mockito.mock(ReadingRecordMapper.class));
	}

	@Test
	public void testGetReadingsByQuery() {
		readingService.getReadingsByQuery("09-10-2018 10:00:00", "10-10-2018 10:00:00", null);
		Timestamp startDate = Timestamp.valueOf("2018-09-10 10:00:00");
		Timestamp endDate = Timestamp.valueOf("2018-10-10 10:00:00");
		
		verify(MOCK, times(1)).findAllByDateBetweenOrderByDate(startDate, endDate);
	}

}
