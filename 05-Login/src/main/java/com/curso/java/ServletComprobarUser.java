package com.curso.java;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletComprobarUser
 */
public class ServletComprobarUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String passVerificada = "Pepito";
		boolean estadoSesion;
		PrintWriter out = response.getWriter();

		if (request.getParameter("user") != null) {

			if (request.getParameter("pass").equals(passVerificada)) {

				HttpSession sesion = request.getSession();
				User user = new User(request.getParameter("user"), request.getParameter("pass"));
				sesion.setAttribute("usuario", user);
				RequestDispatcher dispatch = request.getRequestDispatcher("ServletLoginCorrecto");
				dispatch.forward(request, response);

			} else {
				out.println("No has introducido bien la password");
				response.sendRedirect("formulario1.html");
			}
		} else {
			out.println("No has introducido bien el usuario");
		}

	}

}
