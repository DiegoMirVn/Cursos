package com.curso.java;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletResgistroCurso
 */
public class ServletResgistroCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession sesion = request.getSession();

		String curso = request.getParameter("curso");
		PersonaCursos ps = (PersonaCursos) sesion.getAttribute("datosPersona");
		ps.setListaCursos(curso);

		out.println("<!DOCTYPE html>");
		out.println("<html lang='es'>");
		out.println("<meta charset='UTF-8'>");
		out.println("<titule>Listado Cursos</title>");
		out.println("<head>");
		out.println("<body>");
		out.println("<h2>Has sido matriculado con exito<h2>");
		out.println("<form action='ServletCursos' method='post'>");
		out.println("<input type='submit' value='Volver'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		out.close();

	
		/**
		 * RequestDispatcher dispatch = request.getRequestDispatcher("ServletCursos");
		dispatch.include(request, response);
		 */

	}

}
