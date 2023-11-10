package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PropertyBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-10-01T20:14:45.365242941Z[GMT]")


public class PropertyBody   {
  @JsonProperty("address")
  private String street = null;

  @JsonProperty("price")
  private BigDecimal price = null;

  @JsonProperty("monthlyRent")
  private Integer monthlyRent = null;

  public PropertyBody street(String street, BigDecimal price, Integer monthlyRent) {
    this.street = street;
    this.price = price;
    this.monthlyRent = monthlyRent;
    return this;
  }


  @Schema(description = "")
  
    public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }


  @Schema(description = "")
  
    @Valid
    public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Schema(description = "")
  
    public Integer getmonthlyRent() {
    return monthlyRent;
  }

  public void setmonthlyRent(Integer monthlyRent) {
    this.monthlyRent = monthlyRent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PropertyBody propertyBody = (PropertyBody) o;
    return Objects.equals(this.street, propertyBody.street) &&
        Objects.equals(this.price, propertyBody.price) &&
        Objects.equals(this.monthlyRent, propertyBody.monthlyRent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, price, monthlyRent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PropertyBody {\n");
    
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    monthlyRent: ").append(toIndentedString(monthlyRent)).append("\n");
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
