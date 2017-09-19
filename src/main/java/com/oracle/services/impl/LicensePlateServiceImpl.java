
// ------------------------------------------------------------------------
// -- DISCLAIMER:
// --    This script is provided for educational purposes only. It is NOT
// --    supported by Oracle World Wide Technical Support.
// --    The script has been tested and appears to work as intended.
// --    You should always run new scripts on a test instance initially.
// --
// ------------------------------------------------------------------------

package com.oracle.services.impl;

import com.oracle.model.Plate;
import com.oracle.services.LicensePlateService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

@SuppressWarnings("unused")
@ApplicationScoped
public class LicensePlateServiceImpl implements LicensePlateService {

  private static final Logger LOG = Logger.getLogger(LicensePlateServiceImpl.class.getName());
  
  private final Map<Integer, Plate> plates;
  @PersistenceContext(unitName = "PlatePU")
  private EntityManager em;
  @Resource
  private UserTransaction utx;

  public LicensePlateServiceImpl() {
    plates = new HashMap<Integer, Plate>();
  }

  @SuppressWarnings("unchecked")
  public List<Plate> getAllPlates() {
    Query query = em.createQuery("Select a FROM Plate a order by a.ts desc");
    return query.getResultList();
  }

  public Plate addPlate(Plate plate) {
    try {
      utx.begin();
      plate.setTs(new Timestamp(System.currentTimeMillis()));
      em.persist(plate);
      utx.commit();
      return plate;
    } catch (Exception e) {
      LOG.log(Level.SEVERE, e.getMessage());
      throw new RuntimeException(e);
    }
  }

  public Plate findPlateById(int plateId) {
	Plate plate = null;
    try {
      plate = em.find(Plate.class, plateId);
    } catch (Exception e) {
      LOG.log(Level.SEVERE, e.getMessage());
    }
    return plate;
  }

  public Plate updatePlate(Plate plate) {
    try {
      utx.begin();
      int plateId = plate.getPlateId();
      em.find(Plate.class, plateId);
      plate = em.merge(plate);
      utx.commit();
      return plate;
    } catch (Exception ex) {
      Logger.getLogger(LicensePlateServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
      throw new RuntimeException(ex);
    }
  }

  public void deleteAllPlates() {
    try {
      utx.begin();
      List<Plate> plates = getAllPlates();
      for(Plate plate : plates) {
        em.remove(plate);
      }
      utx.commit();
    } catch (Exception ex) {
      Logger.getLogger(LicensePlateServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
      throw new RuntimeException(ex);
    }
  }

  public List<Plate> findPlate(String requestedPlateNumber) {
    List<Plate> plates = null;
    try {
      Query query = em.createQuery("Select a FROM Plate a where a.plateNumber like :requestedPlateNumber").setParameter("requestedPlateNumber", requestedPlateNumber);
      plates = query.getResultList();
    } catch (Exception e) {
      LOG.log(Level.SEVERE, e.getMessage());
    }
    return plates;
  }
}