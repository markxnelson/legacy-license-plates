
// ------------------------------------------------------------------------
// -- DISCLAIMER:
// --    This script is provided for educational purposes only. It is NOT
// --    supported by Oracle World Wide Technical Support.
// --    The script has been tested and appears to work as intended.
// --    You should always run new scripts on a test instance initially.
// --
// ------------------------------------------------------------------------

package com.oracle.servlets;

import com.oracle.model.Plate;
import com.oracle.services.LicensePlateService;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreatePlateServlet", urlPatterns = {"/CreatePlateServlet"})
@MultipartConfig
public class CreatePlateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Inject
  private LicensePlateService plateService;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String plateUser = (String) request.getSession().getAttribute("plateUser");
    if (plateUser == null) {
      response.sendError(HttpServletResponse.SC_FORBIDDEN);
      return;
    }

    String plateNumber = request.getParameter("plateNumber");
    String state = request.getParameter("state");
    String owner = request.getParameter("owner");
    String address = request.getParameter("address");
    String imageURL = request.getParameter("imageURL");

    Plate plate = new Plate();
    plate.setPlateNumber(plateNumber);
    plate.setState(state);
    plate.setOwner(owner);
    plate.setAddress(address);
    plate.setImageURL(imageURL);

    plateService.addPlate(plate);
    request.setAttribute("message", "Plate created");
    request.getRequestDispatcher("/ListServlet").forward(request, response);
  }
}
