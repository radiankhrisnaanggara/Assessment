/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import models.Classes;

/**
 *
 * @author arman
 */
public interface IClassesController {

    String save(Classes classes);
    Classes getById(String id);
}
