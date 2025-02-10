/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BusDAO;
import DAO.RouteDAO;
import DAO.StopDAO;
import DAO.UserDAO;
import Model.Route;
import Model.Stop;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Tra Pham
 */
@WebServlet(name = "CreateController", urlPatterns = {"/create"})
public class CreateController extends HttpServlet {

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
            out.println("<title>Servlet CreateController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateController at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        StopDAO stopDao = new StopDAO();
        switch (action) {
            case "createRoute":
                String RouteName = request.getParameter("RouteName");
                String StartPoint = request.getParameter("StartPoint");
                String EndPoint = request.getParameter("EndPoint");
                String StartTime = request.getParameter("StartTime");
                String EndTime = request.getParameter("EndTime");
                String Frequency = request.getParameter("Frequency");
                
                String[] listOrder = request.getParameterValues("listOrder");

                ArrayList<Stop> listStop = stopDao.getAllStop();
                int[] listStopID = new int[listStop.size()];

                for (int i = 0; i < listStop.size(); i++) {
                    listStopID[i] = (listStop.get(i).getStopID());
                }
                RouteDAO routeDao = new RouteDAO();
                routeDao.createRoute(RouteName, StartPoint, EndPoint, StartTime, EndTime, Frequency, listStopID, listOrder);
                // check valid new route which just created
                
                ArrayList<Route> listRoute = routeDao.getAllRoute();
                Route newRoute = listRoute.get(listRoute.size()-1);
                listRoute.remove(listRoute.size()-1);
                System.out.println("listRoute:");
                for (Route route : listRoute) {
                    System.out.println(route);
                }
                System.out.println("newRoute");
                System.out.println(newRoute);
                System.out.println("===EndnewRoute===");
                if(isValidRoute(newRoute, listRoute)){
                    response.sendRedirect("load?action=loadRole00");
                    break;
                }else{
                    routeDao.deleteRouteByID(String.valueOf(newRoute.getRouteID()));
                    response.sendRedirect("load?action=loadCreateRoute");
                    break;
                }


            case "createStop":
                String StopName = request.getParameter("StopName");
                ArrayList<Stop> listS = stopDao.getAllStop();
                if(isValidStop(StopName, listS)){// if valid creaate
                stopDao.createStop(StopName);
                response.sendRedirect("load?action=loadRole00");
                break;
            }else{// not valid not create and load to createStop
                    response.sendRedirect("load?action=loadCreateStop");
                    break;
                }
                
            case "createBus":
                String busNumber = request.getParameter("busNum");
                String routeID = request.getParameter("routeID");
                BusDAO busDao = new BusDAO();
                busDao.createBus(busNumber, routeID);
                response.sendRedirect("load?action=loadRole00");
                break;
            case "createUser":
                UserDAO userDao = new UserDAO();
                ArrayList<User> listUser = userDao.getAllUser();
                String UserName = request.getParameter("UserName");
                String Password = request.getParameter("Password");
                String RoleID = request.getParameter("RoleID");
                if (isValidUser(UserName, listUser)) {
                    userDao.createUser(UserName, Password, RoleID);
                    response.sendRedirect("load?action=loadRole01");
                } else {
                    response.sendRedirect("load?action=loadCreateUser&error=1");
                }

                break;
            default:
                response.sendRedirect("load");
        }

    }

    /**
     *
     * @param UserName String
     * @param listUser String
     * @return true if user valid, otherwise false
     */
    private boolean isValidUser(String UserName, ArrayList<User> listUser) {
        for (User user : listUser) {
            if (user.getUserName().equals(UserName)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidStop(String StopName, ArrayList<Stop> listStop){
        for (Stop stop : listStop) {
            if(stop.getStopName().equalsIgnoreCase(StopName)){
                return false;
            }
        }
        return true;
    }
    private boolean isValidRoute(Route checkRoute, ArrayList<Route> listRoute){
        for (Route route : listRoute) {
            if(checkRoute.getEndPoint().equalsIgnoreCase(route.getEndPoint())
               && checkRoute.getEndTime().equalsIgnoreCase(route.getEndTime())
               && checkRoute.getFrequency().equalsIgnoreCase(route.getFrequency())
               && checkRoute.getIntermediateStation().equalsIgnoreCase(route.getIntermediateStation())
               && checkRoute.getRouteName().equalsIgnoreCase(route.getRouteName())
               && checkRoute.getStartPoint().equalsIgnoreCase(route.getStartPoint())
               && checkRoute.getStartTime().equalsIgnoreCase(route.getStartTime())     ){
                return false;
            }
        }
        return true;
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
