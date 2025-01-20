/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BusDAO;
import DAO.BusStopDAO;
import DAO.RoleDAO;
import DAO.RouteDAO;
import DAO.StopDAO;
import DAO.UserDAO;
import Model.Bus;
import Model.BusStop;
import Model.ListOrderOfRoute;
import Model.Role;
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
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Tra Pham
 */
@WebServlet(name = "LoadController", urlPatterns = {"/load"})
public class LoadController extends HttpServlet {

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
            out.println("<title>Servlet LoadController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadController at " + request.getContextPath() + "</h1>");
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
        BusDAO busDao = new BusDAO();
        UserDAO userDao = new UserDAO();
        RouteDAO daoRoute = new RouteDAO();
        StopDAO daoStop = new StopDAO();
        RoleDAO daoRole = new RoleDAO();

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        if (action == null) {

            // get all Route
            ArrayList<Route> listRoute = daoRoute.getAllRoute();
            request.setAttribute("listR", listRoute);
            // get all BusStop
            BusStopDAO daoBus = new BusStopDAO();
            ArrayList<BusStop> listBusStop = daoBus.getAllBusStop();
            request.setAttribute("listBS", listBusStop);

            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } else {
            // need login to access
            if (currentUser == null) {
                response.sendRedirect("AccessDenied.jsp");
                return;
            }

            switch (action) {
                case "loadUpdateRoute":
                    String RouteID = request.getParameter("RouteID");
                    Route updateRoute = daoRoute.getRouteByID(RouteID);
                    ArrayList<Stop> listStopRouteUpdate = daoStop.getAllStop();
                    ArrayList<ListOrderOfRoute> listStopHasOrder = daoRoute.getListStopBusHasOrderByRouteID(RouteID);

                    request.setAttribute("listStopHasOrder", listStopHasOrder);
                    request.setAttribute("updateRoute", updateRoute);
                    request.getRequestDispatcher("UpdateRoute.jsp").forward(request, response);

                    break;
                case "loadCreateRoute":
                    ArrayList<Stop> listStopRoute = daoStop.getAllStop();
                    request.setAttribute("listStop", listStopRoute);
                    request.getRequestDispatcher("CreateRoute.jsp").forward(request, response);
                    break;
                case "loadUpdateStop":
                    String StopID = request.getParameter("StopID");
                    Stop updateStop = daoStop.getStopByID(StopID);
                    request.setAttribute("updateStop", updateStop);
                    request.getRequestDispatcher("UpdateStop.jsp").forward(request, response);
                    break;
                case "loadCreateStop":
                    response.sendRedirect("CreateStop.jsp");
                    break;
                case "loadCreateBus":
                    ArrayList<Route> listRoute = daoRoute.getAllRoute();
                    request.setAttribute("listRoute", listRoute);
                    request.getRequestDispatcher("CreateBus.jsp").forward(request, response);
                    break;
                case "logout":
                    session.invalidate();
                    response.sendRedirect("load");
                    break;
                case "loadRole00":
                    ArrayList<Route> listRouteEdit = daoRoute.getAllRoute();
                    request.setAttribute("listR", listRouteEdit);
                    ArrayList<Bus> listBus = busDao.getAllBusDAO();
                    request.setAttribute("listB", listBus);
                    ArrayList<Stop> listStop = daoStop.getAllStop();
                    request.setAttribute("listStop", listStop);
                    request.getRequestDispatcher("TestRole00.jsp").forward(request, response);
                    break;
                case "loadRole01":
                    if (currentUser.getRoleID() != 1) {
                        response.sendRedirect("AccessDenied.jsp");
                        return;
                    }
                    ArrayList<User> list = userDao.getAllUser();
                    request.setAttribute("listUser", list);
                    request.getRequestDispatcher("TestRole01.jsp").forward(request, response);
                    break;
                case "loadUpdateBus":
                    ArrayList<Route> listRouteUpdate = daoRoute.getAllRoute();
                    request.setAttribute("listRoute", listRouteUpdate);
                    String BusID = request.getParameter("BusID");
                    Bus updateBus = busDao.getBusByID(BusID);
                    request.setAttribute("updateBus", updateBus);
                    request.getRequestDispatcher("UpdateBus.jsp").forward(request, response);
                    break;
                case "loadUpdateUser":
                    //check authority
                    if (currentUser.getRoleID() != 1) {
                        response.sendRedirect("AccessDenied.jsp");
                        return;
                    }
                    // if has error send mess
                    String errorUpdate = request.getParameter("error");
                    if (errorUpdate != null) {
                        switch (errorUpdate) {
                            case "1":
                                request.setAttribute("mess", "user name already exist, try another name");
                                break;
                            default : break;

                        }
                        
                    }
                    
                    String UserID = request.getParameter("UserID");
                    User userUpdate = userDao.getUserByID(UserID);
                    request.setAttribute("userUpdate", userUpdate);
                    request.setAttribute("listRole", daoRole.getAllRole());
                    request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
                    break;
                    
                case "loadCreateUser":
                    //check authority   
                    if (currentUser.getRoleID() != 1) {
                        response.sendRedirect("AccessDenied.jsp");
                        return;
                    }
                    // if has error send mess
                    String errorCreate = request.getParameter("error");
                    if (errorCreate != null) {
                        switch (errorCreate) {
                            case "1":
                                request.setAttribute("mess", "user name already exist, try another name");
                                break;
                            default : break;

                        }
                        
                    }
                    request.setAttribute("listRole", daoRole.getAllRole());
                    request.getRequestDispatcher("CreateUser.jsp").forward(request, response);
                    break;
                default:
                    response.sendRedirect("load");
            }
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
        String StopID1 = request.getParameter("StopID1");
        String StopID2 = request.getParameter("StopID2");

        // get all Route by StopID
        RouteDAO daoRoute = new RouteDAO();
        ArrayList<Route> listRoute = daoRoute.getRouteByStopID(StopID1, StopID2);
        request.setAttribute("listR", listRoute);

        // get all BusStop
        BusStopDAO daoBus = new BusStopDAO();
        ArrayList<BusStop> listBusStop = daoBus.getAllBusStop();
        request.setAttribute("listBS", listBusStop);

        request.setAttribute("StopID1", StopID1);
        request.setAttribute("StopID2", StopID2);

        request.getRequestDispatcher("HomePage.jsp").forward(request, response);

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
