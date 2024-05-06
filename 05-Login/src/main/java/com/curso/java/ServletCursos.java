package com.curso.java;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ServletCursos
 */
public class ServletCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellidos");
		String tlf = request.getParameter("telefono");
		PersonaCursos ps;

		if (request.getAttribute("datosPersona") != null) {
			
			HttpSession sesion = request.getSession();
			ps = (PersonaCursos) sesion.getAttribute("datosPersona");
			
		} else {

			HttpSession sesion = request.getSession();
			ps = new PersonaCursos(nombre, apellido, tlf);
			sesion.setAttribute("datosPersona", ps);
		}

		out.println("<!DOCTYPE html>");
		out.println("<html lang='es'>");
		out.println("<meta charset='UTF-8'>");
		out.println("<titule>Listado Cursos</title>");
		out.println("<head>");
		out.println("<body>");
		out.println("<h2> Hola " + ps.getNombre() + "</h2>");
		out.println("<ul>");
		out.println("<li>");
		out.println("<a href = 'ServletResgistroCurso?curso=Java'>Java</a>");
		out.println("</li>");
		out.println("<li>");
		out.println("<a href = 'ServletResgistroCurso?curso=Python'>Python</a>");
		out.println("</li>");
		out.println("<li>");
		out.println("<a href = 'ServletResgistroCurso?curso=Php'>Php</a>");
		out.println("</li>");
		out.println("</ul>");
		out.println("<h2> Hola " + ps.getNombre() + ", mira el listado de cursos en los que estas matriculado :</h2>");
		out.println("<a href = 'ServletRecuentoCurso'>ComprobarLista</a>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		out.close();

	}

}
