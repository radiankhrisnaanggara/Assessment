/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.BatchClassController;
import controllers.BatchController;
import controllers.ClassesController;
import controllers.EmployeeController;
import icontrollers.IBatchClassController;
import icontrollers.IBatchController;
import icontrollers.IClassesController;
import icontrollers.IEmployeeController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Batch;
import models.BatchClass;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author arman
 */
@WebServlet(name = "ManageBatchClassServlet", urlPatterns = {"/managebatchclassservlet"})
public class ManageBatchClassServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private IBatchClassController ibcc = new BatchClassController(factory);
    private IBatchController ibc = new BatchController(factory);
    private IClassesController icc = new ClassesController(factory);
    private IEmployeeController iec = new EmployeeController(factory);
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            List<BatchClass> batchClasses = (List<BatchClass>)ibcc.getAll();
            request.getSession().setAttribute("batchClasses", batchClasses);
            response.sendRedirect("manageBatchClass.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String classes = request.getAttribute("class") + "";
        String batch = request.getAttribute("batch") + "";
        String trainer = request.getAttribute("trainer") + "";
        ibc.save(new Batch(batch));
        String status = ibcc.save(new BatchClass(classes + "/" + batch, ibc.getById(batch), icc.getById(classes), iec.getById(trainer)));
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
