package com.witt.monitree.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Reading
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-10-10T08:47:27.764-04:00")

public class Reading   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("date")
  private String date = null;

  @JsonProperty("temp")
  private Double temp = null;

  /**
   * The origin of the reading.
   */
  public enum CreatorEnum {
    SENSOR("sensor"),

    APP("app");

    private String value;

    CreatorEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CreatorEnum fromValue(String text) {
      for (CreatorEnum b : CreatorEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("creator")
  private CreatorEnum creator = null;

  @JsonProperty("moisture")
  private Double moisture = null;

  @JsonProperty("humidity")
  private Double humidity = null;

  @JsonProperty("light")
  private Double light = null;

  @JsonProperty("watered")
  private Boolean watered = null;

  public Reading id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * the id of the reading
   * @return id
   **/
  @ApiModelProperty(value = "the id of the reading")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Reading name(String name) {
    this.name = name;
    return this;
  }

  /**
   * the name of the object source of the reading
   * @return name
   **/
  @ApiModelProperty(value = "the name of the object source of the reading")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Reading date(String date) {
    this.date = date;
    return this;
  }

  /**
   * the string representation of the date the reading was taken
   * @return date
   **/
  @ApiModelProperty(value = "the string representation of the date the reading was taken")


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Reading temp(Double temp) {
    this.temp = temp;
    return this;
  }

  /**
   * the temperature at the time of the reading, in fahrenheit
   * @return temp
   **/
  @ApiModelProperty(value = "the temperature at the time of the reading, in fahrenheit")


  public Double getTemp() {
    return temp;
  }

  public void setTemp(Double temp) {
    this.temp = temp;
  }

  public Reading creator(CreatorEnum creator) {
    this.creator = creator;
    return this;
  }

  /**
   * The origin of the reading.
   * @return creator
   **/
  @ApiModelProperty(value = "The origin of the reading.")


  public CreatorEnum getCreator() {
    return creator;
  }

  public void setCreator(CreatorEnum creator) {
    this.creator = creator;
  }

  public Reading moisture(Double moisture) {
    this.moisture = moisture;
    return this;
  }

  /**
   * The level of moisture in the soil
   * @return moisture
   **/
  @ApiModelProperty(value = "The level of moisture in the soil")


  public Double getMoisture() {
    return moisture;
  }

  public void setMoisture(Double moisture) {
    this.moisture = moisture;
  }

  public Reading humidity(Double humidity) {
    this.humidity = humidity;
    return this;
  }

  /**
   * The level of humidity in the air
   * @return humidity
   **/
  @ApiModelProperty(value = "The level of humidity in the air")


  public Double getHumidity() {
    return humidity;
  }

  public void setHumidity(Double humidity) {
    this.humidity = humidity;
  }

  public Reading light(Double light) {
    this.light = light;
    return this;
  }

  /**
   * The light read from the sensor
   * @return light
   **/
  @ApiModelProperty(value = "The light read from the sensor")


  public Double getLight() {
    return light;
  }

  public void setLight(Double light) {
    this.light = light;
  }

  public Reading watered(Boolean watered) {
    this.watered = watered;
    return this;
  }

  /**
   * Was the pump run?
   * @return watered
   **/
  @ApiModelProperty(value = "Was the pump run?")


  public Boolean getWatered() {
    return watered;
  }

  public void setWatered(Boolean watered) {
    this.watered = watered;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reading reading = (Reading) o;
    return Objects.equals(this.id, reading.id) &&
            Objects.equals(this.name, reading.name) &&
            Objects.equals(this.date, reading.date) &&
            Objects.equals(this.temp, reading.temp) &&
            Objects.equals(this.creator, reading.creator) &&
            Objects.equals(this.moisture, reading.moisture) &&
            Objects.equals(this.humidity, reading.humidity) &&
            Objects.equals(this.light, reading.light) &&
            Objects.equals(this.watered, reading.watered);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, date, temp, creator, moisture, humidity, light, watered);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reading {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    temp: ").append(toIndentedString(temp)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    moisture: ").append(toIndentedString(moisture)).append("\n");
    sb.append("    humidity: ").append(toIndentedString(humidity)).append("\n");
    sb.append("    light: ").append(toIndentedString(light)).append("\n");
    sb.append("    watered: ").append(toIndentedString(watered)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

