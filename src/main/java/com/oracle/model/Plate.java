
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
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  private String plateNumber;
  private String owner;
  private String address;
  private String imageURL;
  private Timestamp ts;

  public Plate() {
  }

  public Plate(String state, String plateNumber, String owner, String address, String imageURL) {
    this.state = state;
    this.plateNumber = plateNumber;
    this.owner = owner;
    this.address = address;
    this.imageURL = imageURL;
  }

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

  public String getPlateNumber() {
    return plateNumber;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
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

  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public Timestamp getTs() {
    return ts;
  }

  public void setTs(Timestamp ts) {
    this.ts = ts;
  }


}