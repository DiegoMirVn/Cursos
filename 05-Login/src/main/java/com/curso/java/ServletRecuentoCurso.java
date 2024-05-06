package com.curso.java;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletRecuentoCurso
 */
public class ServletRecuentoCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession sesion = request.getSession();
		PersonaCursos persona = (PersonaCursos) sesion.getAttribute("datosPersona");

		out.println("<!DOCTYPE html>");
		out.println("<html lang='es'>");
		out.println("<meta charset='UTF-8'>");
		out.println("<titule>Listado Cursos</title>");

		out.println("<head>");
		out.println("<body>");

		if (persona.getListaCursos().size() < 1) {
			out.println("<h2>No estas matriculado en ningun curso</h2>");
		} else {
			out.println("<h2> Hola " + persona.getNombre() + ", estas matriculado en estos cursos:</h2>");
			for (String curso : persona.getListaCursos()) {
				out.print("<h3>" + curso + "</h3>");
			}
		}
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		out.close();

	}

}
