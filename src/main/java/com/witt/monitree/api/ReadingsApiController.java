package com.witt.monitree.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.witt.monitree.delegate.ReadingService;
import com.witt.monitree.model.Reading;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-09-02T14:42:09.252Z")

@Controller
public class ReadingsApiController implements ReadingsApi {

	@Autowired
	ReadingService readingDelegate;

	@Override
	public ResponseEntity<Reading> createHistory(@ApiParam(value = "the reading to create"  )  @Valid @RequestBody Reading reading) {
        return new ResponseEntity<Reading>(readingDelegate.save(reading), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteReadingById(@ApiParam(value = "Reading id",required=true ) @PathVariable("id") Long id) {
        readingDelegate.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Reading> getReadingById(@ApiParam(value = "reading id",required=true ) @PathVariable("id") Long id) {
        return new ResponseEntity<Reading>(readingDelegate.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Reading> updateReadingById(@ApiParam(value = "Reading id",required=true ) @PathVariable("id") Long id,
        @ApiParam(value = "The reading you want to update" ,required=true )  @Valid @RequestBody Reading reading) {
        return new ResponseEntity<Reading>(readingDelegate.updateById(id, reading), HttpStatus.OK);
    }

	@Override
	public ResponseEntity<List<Reading>> getHistory(String startDate, String endDate, String name) {
    	return new ResponseEntity<List<Reading>>(readingDelegate.getReadingsByQuery(startDate, endDate, name), HttpStatus.OK);
	}

}
