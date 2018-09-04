package com.witt.monitree.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.witt.monitree.model.Reading.CreatorEnum;

@Entity (name = "record")
public class ReadingRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (name = "name")
	private String name;

	@Column (name = "date")
	private Timestamp date;

	@Column (name = "temp")
	private Double temp;
	
	@Column (name = "creator")
	private String creator;

	@Column (name = "moisture")
	private Double moisture;

	@Column (name = "humidity")
	private Double humidity;

	@Column (name = "watered")
	private Boolean watered;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDate() {
		return date;
	}
	
	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Double getMoisture() {
		return moisture;
	}

	public void setMoisture(Double moisture) {
		this.moisture = moisture;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Boolean getWatered() {
		return watered;
	}

	public void setWatered(Boolean watered) {
		this.watered = watered;
	}

}
