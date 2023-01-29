package com.firebase.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firebase.dao.LoginDao;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		if (firstname.equals("")) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('First Name cannot be empty!');");
			out.println("location='AdminSignIn.html';");
			out.println("</script>");
//			RequestDispatcher rd = request.getRequestDispatcher("index.html");
//			rd.include(request, response);
			return;
		}
		if (lastname.equals("")) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Last Name cannot be empty!');");
			out.println("location='AdminSignIn.html';");
			out.println("</script>");
//			RequestDispatcher rd = request.getRequestDispatcher("index.html");
//			rd.include(request, response);
			return;
		}
		if (email.equals("") || !email.contains("@") || !email.contains(".")) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please enter correct Email Address!');");
			out.println("location='AdminSignIn.html';");
			out.println("</script>");
//			out.print("Please enter correct salary!");
//			RequestDispatcher rd = request.getRequestDispatcher("index.html");
//			rd.include(request, response);
			return;
		}

		try {

			LoginDao loginDaoObj = new LoginDao();

			Firestore db = loginDaoObj.getConnection(request);

			Map<String, Object> docData = new HashMap<>();
			docData.put("firstname", firstname);
			docData.put("lastname", lastname);
			docData.put("email", email);
			docData.put("password", email);
			// add a document to collection
			DocumentReference docRef = db.collection("Admin").document(firstname+lastname+password);
			ApiFuture<DocumentSnapshot> future = docRef.get();
			DocumentSnapshot document = future.get();
			if (document.exists()) {
				RequestDispatcher rd = request.getRequestDispatcher("AdminView.jsp");
				rd.forward(request, response);
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('The credentials are not correct! Please try again.');");
				out.println("location='AdminSignIn.html';");
				out.println("</script>");
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block

			out.println("Exception occured : Error 404");
			e.printStackTrace();
		}

	}

}
