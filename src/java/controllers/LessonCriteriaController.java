/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.ILessonCriteriaController;
import daos.GeneralDAO;
import idaos.IGeneralDAO;
import models.LessonCriteria;
import org.hibernate.SessionFactory;

/**
 *
 * @author arman
 */
public class LessonCriteriaController implements ILessonCriteriaController {
    private IGeneralDAO igd;

    public LessonCriteriaController(SessionFactory factory) {
        igd = new GeneralDAO<>(factory, LessonCriteria.class);
    }
    
    @Override
    public String save(LessonCriteria lessonCriteria) {
        String result = "";
        try {
            if (igd.saveOrDelete(lessonCriteria, true)) {
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
