<%@page import="com.EMERGENTES.registro"%>
<%@page import="java.util.ArrayList" %>
<%
    if (session.getAttribute("listaest") == null) {
        ArrayList<registro> lisaux = new ArrayList<registro>();
        session.setAttribute("listaest", lisaux);
    }
    ArrayList<registro> lista = (ArrayList<registro>) session.getAttribute("listaest");
%>      

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Seminario</title>
        <style>
            body {
                text-align: center;
            }
            .encabezado {
                border: 2px solid black;
                padding: 10px;
                margin: 20px auto; 
                width: 50%; 
            }
            .tabla {
                margin: 20px auto; 
                width: 80%; 
                border-collapse: collapse;
            }
            .tabla th, .tabla td {
                border: 1px solid black;
                padding: 8px;
            }
            .contenedor-botones {
                text-align: left; 
                margin-left: 120px;
            }
        </style>
    </head>
    <body>
        <div class="encabezado">
            <h1>Lista de Registros</h1>
        </div>

        <div class="contenedor-botones">
            <button  onclick="window.location.href = 'MainServlet?op=nuevo'">Nuevo registro</button>
        </div>



        <table class="tabla" border="1" >
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Fecha</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Turno</th>
                    <th>Seminario</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
                <%
                    if (lista != null) {
                        for (registro item : lista) {

                %>
                <tr>
                    <td><%= item.getId()%></td>
                    <td><%= item.getFecha()%></td>
                    <td><%= item.getNombre()%></td>
                    <td><%= item.getApellido()%></td>
                    <td><%= item.getTurno()%></td>
                    <td><%= item.getSeminarios()%></td>

                    <td>
                        <a href="MainServlet?op=editar&id=<%= item.getId()%>">Editar</a>
                    </td>
                    <td>
                        <a href="MainServlet?op=eliminar&id=<%= item.getId()%>"
                           onclick="return (confirm('Esta seguro de eliminar??'))" >Eliminar</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
        </table>
    </body>
</html>
