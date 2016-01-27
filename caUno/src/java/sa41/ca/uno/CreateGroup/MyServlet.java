/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sa41.ca.uno.CreateGroup;

import sa41.ca.uno.CreateGroup.MemberBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sa41.ca.uno.LogInOut.Member;

/**
 *
 * @author sha6
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {

     @EJB private MemberBean memberBean;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Member m = new Member();
        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
         m.setPassword(request.getParameter("password"));
         m.setGroupid(request.getParameter("group_id"));
     
         System.out.println(">>> member: " + m.getName() + ">>> email: " + m.getEmail() + ">>> group: " + m.getGroupid() + ">>>password;" +m.getPassword());

   
        memberBean.addMember(m);
        
//        response.sendRedirect("http://localhost:8080/caUno/index");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
