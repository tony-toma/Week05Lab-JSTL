/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShoppingListServlet extends HttpServlet {

  

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        
        if(session.getAttribute("username") == null) {
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        if(session.getAttribute("username") != null) {
            String action = request.getParameter("action");
            if(action != null && action.equalsIgnoreCase("logout")) {
                session.invalidate();
               request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            
            request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
       
        
        if(action.equalsIgnoreCase("register")) {
            String username = request.getParameter("username");
            session.setAttribute("username", username);
            ArrayList<String> list = new ArrayList<String>();
            session.setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        
         
        
        if(action.equalsIgnoreCase("add") && session.getAttribute("username") != null) {
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
            String item = request.getParameter("item");
            list.add(item);
            session.setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        
        if(action.equalsIgnoreCase("delete")) {
            String pickedItem = request.getParameter("listItem");
            ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
            System.out.println(pickedItem);
            list.remove(pickedItem);
            session.setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        
        if(action.equalsIgnoreCase("logout")) {
            session.invalidate();
             response.sendRedirect("/WEB-INF/register.jsp");
             return;
        }
        
        if(session.getAttribute("username") == null) {
            session.setAttribute("message", "Please enter a username");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
    }

}
