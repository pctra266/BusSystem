/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BusDAO;
import DAO.RouteDAO;
import DAO.StopDAO;
import DAO.UserDAO;
import Model.Bus;
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
@WebServlet(name = "UpdateController", urlPatterns = {"/update"})
public class UpdateController extends HttpServlet {

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
            out.println("<title>Servlet UpdateController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

    private boolean isValidStop(String StopName, ArrayList<Stop> listStop) {
        for (Stop stop : listStop) {
            if (stop.getStopName().equalsIgnoreCase(StopName)) {
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
        doPost(request, response);
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
            case "updateRoute":
                String RouteIDUpdate = request.getParameter("RouteID");
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
                Route oldRoute = routeDao.getRouteByID(RouteIDUpdate);
                routeDao.updateRoute(RouteIDUpdate, RouteName, StartPoint, EndPoint, StartTime, EndTime, Frequency, listStopID, listOrder);
                
                // check valid update bus
                Route currentRoute =routeDao.getRouteByID(RouteIDUpdate);
                ArrayList<Route> listRoute = routeDao.getAllRoute();
                //take index
                int index = -1;
                for (int i = 0; i < listRoute.size(); i++) {
                    if(listRoute.get(i).getRouteID() == Integer.parseInt(RouteIDUpdate)){
                        index = i;
                    }
                    
                }
                // remove that index
                listRoute.remove(index);
                
                if(isValidRoute(currentRoute, listRoute)){
                    response.sendRedirect("load?action=loadRole00");
                break;
                }else{// roll back
                    System.out.println("Current route is: ");
                    System.out.println(currentRoute);
                    System.out.println("list compare is: ");
                    for (Route route : listRoute) {
                        System.out.println(route);
                    }
                    System.out.println("Go to roll back route update bro !!");
                    routeDao.updateRoute(RouteIDUpdate,oldRoute.getRouteName(), 
                            oldRoute.getStartPoint(), 
                            oldRoute.getEndPoint(), 
                            oldRoute.getStartTime(), 
                            oldRoute.getEndTime(), 
                            oldRoute.getFrequency(), 
                            listStopID, listOrder);
                    response.sendRedirect("load?action=loadUpdateRoute&RouteID="+RouteIDUpdate);
                    break;
                }
                
                

            case "updateStop":
                String StopID = request.getParameter("StopID");
                String StopName = request.getParameter("StopName");
                ArrayList<Stop> listS = stopDao.getAllStop();

                if (isValidStop(StopName, listS)) {// if valid update
                    stopDao.updateStop(StopID, StopName);
                    response.sendRedirect("load?action=loadRole00");
                    break;
                } else {// not valid not create and load to updateStop
                    response.sendRedirect("load?action=loadUpdateStop&StopID="+StopID);
                    break;
                }
            case "updateBus":
                String BusNumber = request.getParameter("busNum");
                String BusID = request.getParameter("busID");
                String RouteID = request.getParameter("routeID");
                BusDAO busDao = new BusDAO();
                Bus updateBus = busDao.getBusByID(BusID);
                busDao.updateBus(BusID, BusNumber, RouteID, updateBus.getRouteName() != null);
                response.sendRedirect("load?action=loadRole00");
                break;
            case "updateUser":
                UserDAO userDao = new UserDAO();
                ArrayList<User> listUser = userDao.getAllUser();

                String UserID = request.getParameter("UserID");
                String UserName = request.getParameter("UserName");
                String Password = request.getParameter("Password");
                String RoleID = request.getParameter("RoleID");
                if (isValidUser(UserName, listUser)) {
                    userDao.updateUser(UserName, Password, RoleID, UserID);
                    response.sendRedirect("load?action=loadRole01");
                } else {
                    response.sendRedirect("load?action=loadUpdateUser&UserID=" + UserID + "&error=1");
                }

                break;
            default:
                response.sendRedirect("load");
        }

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
