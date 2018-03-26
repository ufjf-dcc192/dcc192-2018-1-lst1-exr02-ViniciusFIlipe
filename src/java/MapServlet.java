/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ice
 */
@WebServlet(name = "MapServlet", urlPatterns = {"/index.html"})
public class MapServlet extends HttpServlet {

    Map<String, String> paises;

    public MapServlet() {
        paises = new HashMap<String, String>();
        paises.put("Brasil", "Red");
        paises.put("Alemanha", "Blue");
        paises.put("Holanda", "Green");
        paises.put("Suiça", "White");
        paises.put("Argentina", "Black");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comando = request.getParameter("comando");
        if ("ord".equals(comando)) {
           TreeMap treepaises=new TreeMap(paises);
	Iterator k=treepaises.keySet().iterator();
	while (k.hasNext()){
		String pais=(String)k.next();
		String cor=paises.get(pais);
		paises.put(pais,cor);

	}
        }
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Map</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Map</h1>");
            out.println("<ul>");
            for (String a : paises.keySet()) {
                String value = paises.get(a);
                out.println("<li>" + a + " = " + value + "</li>");
            }
            out.println("</ul>");
            out.println("<p><a href ='?comando=ord'>Ordenar</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
