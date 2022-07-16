/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FeedbackDAO;
import DAO.NotificationDAO;
import DAO.ReplyFeedBackDAO;
import Model.Account;
import Model.Feedback;
import Model.Notification;
import Model.ReplyFeedBack;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ReplyFeedBackControl", urlPatterns = {"/replyfeedback"})
public class ReplyFeedBackControl extends HttpServlet {

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
            out.println("<title>Servlet ReplyFeedBackControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReplyFeedBackControl at " + request.getContextPath() + "</h1>");
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
        int fid = Integer.parseInt(request.getParameter("fid"));
        FeedbackDAO fdao = new FeedbackDAO();
        Feedback feedback = fdao.getFeedbackById(fid);
        request.setAttribute("feedback", feedback);
        request.getRequestDispatcher("ReplyFeedBack.jsp").forward(request, response);
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
        String reply = request.getParameter("rep");
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
         NotificationDAO ndao = new NotificationDAO();
        ReplyFeedBackDAO fbdao = new ReplyFeedBackDAO();
        Feedback feedback = (Feedback) session.getAttribute("feedback");
        ReplyFeedBack fb = new ReplyFeedBack(id, acc.getUserId(), reply);
        fbdao.addReplyFeedBack(fb);
        Notification notification = new Notification(feedback.getUserId(), 0, reply);
        ndao.addNotification(notification);
        request.setAttribute("mess", "Send message sucessfully!!!");
        request.getRequestDispatcher("ReplyFeedBack.jsp").forward(request, response);
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
