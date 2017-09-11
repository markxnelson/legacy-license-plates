package com.oracle.rest;

// ------------------------------------------------------------------------
// -- DISCLAIMER:
// --    This code is provided for educational purposes only. It is NOT
// --    supported by Oracle World Wide Technical Support.
// --    The code has been tested and appears to work as intended.
// --    You should always run new scripts on a test instance initially.
// --
// ------------------------------------------------------------------------

import com.oracle.model.Plate;
import com.oracle.services.LicensePlateService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Collection;
import java.util.List;

@Path("/plates")
public class LicensePlateRestService {

    @Inject
    private LicensePlateService plateService;

    @GET
    @Path("/list")
    public List<Plate> listPlates() {
        return plateService.getAllPlates();
    }

    @POST
    @Consumes("application/json")
    @Path("/add")
    public List<Plate> addPlate(Plate newPlate) {
        if (newPlate != null) {
            plateService.addPlate(newPlate);
        }

        return plateService.getAllPlates();
    }

    @POST
    @Consumes("application/json")
    @Path("/add-all")
    public List<Plate> addPlate(Collection<Plate> newPlates) {
        if (newPlates != null && !newPlates.isEmpty()) {
            for (Plate plate : newPlates) {
                plateService.addPlate(plate);
            }
        }

        return plateService.getAllPlates();
    }

    @GET
    @Path("get/{id}")
    public Plate getPlate(@PathParam("id") String id) {
        return plateService.findPlateById(Integer.parseInt(id));
    }

    @GET
    @Path("get-latest")
    public Plate getLatestPlate() {
        List<Plate> plates = plateService.getAllPlates();
        return plates.get(plates.size()-1);
    }

    @GET
    @Path("delete-all")
    public List<Plate> deleteAllPlates() {
        plateService.deleteAllPlates();
        return plateService.getAllPlates();
    }

    @GET
    @Path("get-by-plate-number/{plate-number}")
    public List<Plate> getPlateByPlateNumber(@PathParam("plate-number") String requestedPlateNumber) {
        return plateService.findPlate(requestedPlateNumber);
    }
}
