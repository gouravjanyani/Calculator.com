package com.firebase.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firebase.dao.LoginDao;
import com.firebase.model.Login;
import com.google.api.core.ApiFuture;
//import com.google.api.services.storage.Storage.BucketAccessControls.List;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firestore.v1.WriteResult;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String firstname = request.getParameter("firstname");
		if(firstname.equals(""))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('First Name cannot be empty!');");
			out.println("location='index.html';");
			out.println("</script>");
			return;
		}
		String lastname = request.getParameter("lastname");
		if(lastname.equals(""))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Last Name cannot be empty!');");
			out.println("location='index.html';");
			out.println("</script>");
			return;
		}
		String strSalary = request.getParameter("salary");
		if(strSalary.isEmpty() )
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please enter correct salary!');");
			out.println("location='index.html';");
			out.println("</script>");
			return;
		}
		long salary = Long.parseLong(strSalary);




		
		try {



			LoginDao loginDaoObj = new LoginDao();

			Firestore db = loginDaoObj.getConnection(request);

			
						

			long result = 0;
			String output = "";
			if (salary <= 500000) {
				output += "<div>According to your income slab, your are not eligible for tax deduction ";

			} else if (salary > 500000 && salary <= 750000) {
				result = salary - ((salary * 10) / 100);
				output += "<div>According to your income slab, your income after tax deduction will be " + result;
			} else if (salary > 750000 && salary <= 1000000) {
				result = salary - ((salary * 15) / 100);
				output += "<div>According to your income slab, your income after tax deduction will be " + result;
			}
			if (salary > 1000000 && salary <= 1250000) {
				result = salary - ((salary * 20) / 100);
				output += "<div>According to your income slab, your income after tax deduction will be " + result;
			}
			if (salary > 1250000 && salary <= 1500000) {
				result = salary - ((salary * 25) / 100);
				output += "<div>According to your income slab, your income after tax deduction will be " + result;
			}
			if (salary > 1500000) {
				result = salary - ((salary * 25) / 100);
				output += "<div>According to your income slab, your income after tax deduction will be " + result;
			}
			
			Map<String, Object> docData = new HashMap<>();
			docData.put("firstname", firstname);
			docData.put("lastname", lastname);
			docData.put("salary", salary);
			docData.put("result", result);
			docData.put("tax deducted", salary-result);
			// add a document to collection
			ApiFuture<DocumentReference> document = db.collection("UserMst").add(docData);
			ApiFuture<QuerySnapshot> future = db.collection("UserMst").get();
			
			request.setAttribute("output", output);
			RequestDispatcher rd = request.getRequestDispatcher("WelcomeDashboard.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			out.println("Exception occured : Error 404");
			e.printStackTrace();
		}


	}

}
