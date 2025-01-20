/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BusDAO;
import DAO.RouteDAO;
import DAO.StopDAO;
import DAO.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Tra Pham
 */
@WebServlet(name = "DeleteController", urlPatterns = {"/delete"})
public class DeleteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String action = request.getParameter("action");
        if(action == null || action.isEmpty()){
            response.sendRedirect("load");
            return ;
        }
        
        HttpSession session = request.getSession();
        User currentUser = (User)session.getAttribute("currentUser");
         // need login to access
            if(currentUser == null){
            response.sendRedirect("AccessDenied.jsp");
            return ;
        }
            
        switch (action) {
            case "deleteStop":
                String StopID = request.getParameter("StopID");
                StopDAO stopDao = new StopDAO();
                stopDao.deleteStopByID(StopID);
                response.sendRedirect("load?action=loadRole00");
                break;
            case "deleteRoute":
                String RouteID = request.getParameter("RouteID");
                RouteDAO routeDao = new RouteDAO();
                routeDao.deleteRouteByID(RouteID);
                response.sendRedirect("load?action=loadRole00");
                break;
            case "deleteUser":
                if(currentUser.getRoleID() != 1){
                    response.sendRedirect("AccessDenied.jsp");
                    return ;
                }
                
                String UserID = request.getParameter("UserID");
                UserDAO userDao = new UserDAO();
                
                // check deleteUser difference from current Account
                User deleteUser =  userDao.getUserByID(UserID);
               if(deleteUser.getUserName().equalsIgnoreCase(currentUser.getUserName()) ){
                   // if equal can not delete
                   response.sendRedirect("load?action=loadRole01");
                break;
               }else{// if not equal can delete 
                   userDao.deleteUserByID(UserID);
                response.sendRedirect("load?action=loadRole01");
                break;
               }
                
                
            case "deleteBus":
                String BusID = request.getParameter("BusID");
                BusDAO busDao = new BusDAO();
                busDao.deleteBusbyID(BusID);
                response.sendRedirect("load?action=loadRole00");
                break;
            default: response.sendRedirect("load");

        }

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
        processRequest(request, response);
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
