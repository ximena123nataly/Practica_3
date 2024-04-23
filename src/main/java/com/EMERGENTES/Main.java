/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMERGENTES;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String op = request.getParameter("op");
       registro objest = new registro();
        int id, pos;
        HttpSession ses = request.getSession();
        ArrayList<registro> lista = (ArrayList<registro>) ses.getAttribute("listaest");
        switch (op) {
            case "nuevo":
              
                request.setAttribute("miobjest", objest);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                objest = lista.get(pos);
                request.setAttribute("miobjest", objest);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                if (pos >= 0) {
                    lista.remove(pos);
                }
                request.setAttribute("listaper", lista);
                response.sendRedirect("index.jsp");
                break;
            default:
        }
    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          int id = Integer.parseInt(request.getParameter("id"));
    HttpSession ses = request.getSession();
    ArrayList<registro> lista = (ArrayList<registro>) ses.getAttribute("listaest");
    registro objest;
    
    if (id != 0) {
        
        int pos = buscarPorIndice(request, id);
        objest = lista.get(pos);
    } else {
        objest = new registro();
        id = obtenerId(request);
        objest.setId(id);
        lista.add(objest);
    }
    
    
    objest.setFecha(request.getParameter("fecha"));
    objest.setNombre(request.getParameter("nombre"));
    objest.setApellido(request.getParameter("apellidos"));
    objest.setTurno(request.getParameter("turno"));
   
String[] seminarioValues = request.getParameterValues("seminario");

if (seminarioValues != null && seminarioValues.length > 0) {
    StringBuilder seminarioConcatenado = new StringBuilder();
    for (int i = 0; i < seminarioValues.length; i++) {
        seminarioConcatenado.append(seminarioValues[i]);
        if (i < seminarioValues.length - 1) {
            seminarioConcatenado.append(", ");
        }
    }
  
    objest.setSeminarios(seminarioConcatenado.toString());
} else {
   
    objest.setSeminarios("");
}

    response.sendRedirect("index.jsp");
    }

    
    public int buscarPorIndice(HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        ArrayList<registro> lista = (ArrayList<registro>) ses.getAttribute("listaest");
        int pos = -1;
        if (lista != null) {
            for (registro est : lista) {
                ++pos;
                if (est.getId() == id) {
                    break;
                }
            }
        }
        return pos;
    }
    public int obtenerId(HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<registro> lista = (ArrayList<registro>) ses.getAttribute("listaest");

        int idn = 0;
        for (registro est : lista) {
            idn = est.getId();
        }
        return idn + 1;
    }
}
