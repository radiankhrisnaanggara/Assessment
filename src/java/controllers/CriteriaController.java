/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.ICriteriaController;
import daos.GeneralDAO;
import idaos.IGeneralDAO;
import models.Criteria;
import org.hibernate.SessionFactory;

/**
 *
 * @author arman
 */
public class CriteriaController implements ICriteriaController {
    private IGeneralDAO igd;

    public CriteriaController(SessionFactory factory) {
        igd = new GeneralDAO<>(factory, Criteria.class);
    }
    
    @Override
    public String save(Criteria criteria) {
        String result = "";
        try {
            if (igd.saveOrDelete(criteria, true)) {
                result = "Save Data Berhasil";
            } else {
                result = "Save Data Gagal";
            }
        } catch (Exception e) {
            result = "Save Data Gagal Error";
        }
        return result;
    }
}
