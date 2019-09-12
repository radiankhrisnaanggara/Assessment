/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.IBatchController;
import daos.GeneralDAO;
import idaos.IGeneralDAO;
import models.Batch;
import org.hibernate.SessionFactory;

/**
 *
 * @author arman
 */
public class BatchController implements IBatchController {
    private IGeneralDAO igd;

    public BatchController(SessionFactory factory) {
        igd = new GeneralDAO<>(factory, Batch.class);
    }
    
    @Override
    public String save(Batch batch) {
        String result = "";
        try {
            if (igd.saveOrDelete(batch, true)) {
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
