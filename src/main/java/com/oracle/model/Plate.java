
// ------------------------------------------------------------------------
// -- DISCLAIMER:
// --    This script is provided for educational purposes only. It is NOT
// --    supported by Oracle World Wide Technical Support.
// --    The script has been tested and appears to work as intended.
// --    You should always run new scripts on a test instance initially.
// --
// ------------------------------------------------------------------------

package com.oracle.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
public class Plate implements Serializable {

  private static final long serialVersionUID = 1L;

  @SequenceGenerator(name="plate_sequence", sequenceName="plateid_sequence", allocationSize=1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="plate_sequence")
  @Id
  private int plateId;
  private String state;
  private String number;
  private String owner;
  private String address;

  @Version
  private int version;

  public Plate() {
  }

  public Plate(int plateId, String state, String number, String owner, String address) {
    this.plateId = plateId;
    this.state = state;
    this.number = number;
    this.owner = owner;
    this.address = address;
  }

//  public Auction withValues(float currPrice, float increment, AuctionStatus status) {
//    this.currPrice = currPrice;
//    this.bidIncrement = increment;
//    this.status = status;
//    return this;
//  }
//
//  public Auction withItemValues(String title, String description, ItemCondition condition, int imageId) {
//    this.description = description;
//    this.condition = condition;
//    this.imageId = imageId;
//    this.title = title;
//    return this;
//  }

  public int getPlateId() {
    return plateId;
  }

  public void setPlateId(int plateId) {
    this.plateId = plateId;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

}