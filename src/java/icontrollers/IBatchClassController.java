/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.BatchClass;

/**
 *
 * @author arman
 */
public interface IBatchClassController {

    String save(BatchClass batchClass);
    
    List<BatchClass> getAll();
}
