
// ------------------------------------------------------------------------
// -- DISCLAIMER:
// --    This script is provided for educational purposes only. It is NOT
// --    supported by Oracle World Wide Technical Support.
// --    The script has been tested and appears to work as intended.
// --    You should always run new scripts on a test instance initially.
// --
// ------------------------------------------------------------------------

package com.oracle.services;

import com.oracle.model.Plate;

import java.util.List;

public interface LicensePlateService {

  List<Plate> getAllPlates();

  Plate findPlateById(int auctionId);

  Plate addPlate(Plate auction);

  Plate updatePlate(Plate auction);

  void deleteAllPlates();

  List<Plate> findPlate(String requestedPlateNumber);

}
