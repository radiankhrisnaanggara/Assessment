/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.ILessonController;
import daos.GeneralDAO;
import idaos.IGeneralDAO;
import models.Lesson;
import org.hibernate.SessionFactory;

/**
 *
 * @author arman
 */
public class LessonController implements ILessonController {
    private IGeneralDAO igd;

    public LessonController(SessionFactory factory) {
        igd = new GeneralDAO<>(factory, Lesson.class);
    }
    
    @Override
    public String save(Lesson lesson) {
        String result = "";
        try {
            if (igd.saveOrDelete(lesson, true)) {
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
