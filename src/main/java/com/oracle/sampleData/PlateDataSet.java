
// ------------------------------------------------------------------------
// -- DISCLAIMER:
// --    This script is provided for educational purposes only. It is NOT
// --    supported by Oracle World Wide Technical Support.
// --    The script has been tested and appears to work as intended.
// --    You should always run new scripts on a test instance initially.
// --
// ------------------------------------------------------------------------

package com.oracle.sampleData;

import com.oracle.model.Plate;

import java.util.ArrayList;
import java.util.List;

public class PlateDataSet {

  private final List<PlateData> dataList = new ArrayList<PlateData>();

  public PlateDataSet() {
    dataList.add(
            new PlateData()
            .setPlate(
            new Plate("NJ", "ABC123", "John Doe", "25 Main Road, Smalltown, NJ 07011", "http://some.place/image1.jpeg")));
  }

  public List<PlateData> getDataList() {
    return dataList;
  }

}
