/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ELCOT
 */
public class NewServlet2 extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            book b[]=new book[3];
            b[0]=new book("Fairy Tales","Stilton",500,"Stone Publications","available",10);
            b[1]=new book("Ponniyin Selvan","Kalki",1000,"Tamil Publications","available",5);
            b[2]=new book("A-Z Mysteries","Ron Roy",250,"Alpha Publications","not available",0);
            String title=request.getParameter("t");
            String author=request.getParameter("a");
            
            for(int i=0;i<b.length;i++)
            {
                if(title.equals(b[i].Title) && author.equals(b[i].Author))
                {
                    out.println(b[i]);
                
                if(b[i].Stockpos=="available" && b[i].count<=10)
                {
                    out.println("Stock available and available copies is "+b[i].count);
                }
                }
                if(b[i].Stockpos!="available" && b[i].count>10)
                {
                    out.println("No such book available");
                }
                
                
            }
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
class book
{
    String Title,Author,Publisher,Stockpos;
    int price,count;
    book(String n,String a,int n1,String p,String pos,int c)
    {
        Title=n;
        Author=a;
        price=n1;
        Publisher=p;
        Stockpos=pos;
        count=c;
    
    }
    @Override
    public String toString()
    {
        return "Title: "+Title+" Author Name: "+Author+" Price: "+price+" Publisher: "+Publisher+" Stock Position: "+Stockpos+" No of copies: "+count;
    }
}
  