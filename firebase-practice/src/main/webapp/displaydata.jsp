<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="
	com.google.cloud.firestore.Query,
	com.google.cloud.firestore.CollectionReference,
	com.google.cloud.firestore.DocumentSnapshot,
	com.firebase.dao.LoginDao,
	com.google.api.core.ApiFuture,
	com.google.cloud.firestore.Firestore,
	com.google.cloud.firestore.QueryDocumentSnapshot,
	com.google.cloud.firestore.QuerySnapshot,
	com.google.api.core.ApiFuture, com.google.cloud.firestore.QueryDocumentSnapshot ,javax.servlet.http.HttpServletRequest ,java.io.PrintWriter , java.util.*, com.firebase.dao.LoginDao, com.google.api.core.ApiFuture, com.google.cloud.firestore.QuerySnapshot "%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	out.print(request.getParameter("q"));
/* 	LoginDao loginDaoObj = new LoginDao();

	Firestore db;
	try {

		db = loginDaoObj.getConnection(request);

		ApiFuture<QuerySnapshot> future = db.collection("UserMst").get(); */
		/* ).whereEqualTo("firstname",request.getParameter("q") ).whereNotEqualTo("firstname", null). */
/* 		List<QueryDocumentSnapshot> documents = future.get().getDocuments(); */
/* 		out.println("<table class=\"table table-hover\"> ");
 		out.println(
		"<thead><tr><th scope=\"col\">First Name</th><th scope=\"col\">Last Name</th><th scope=\"col\">Salary</th><th scope=\"col\">Tax Deduction</th> <th scope=\"col\">In-hand Salary</th></tr></thead>");
		out.println("<tbody>"); */ 
		
/* 		for (DocumentSnapshot document : documents) {
			
			if(document.getString("firstname") == request.getParameter("q"))
			{
				out.println("haan bhai");
			out.println("<tr class=\"\">" + "<td>" + document.getString("firstname") + "</td>" + "<td>"
			+ document.getString("lastname") + "</td>" + "<td>" + document.getLong("salary") + "</td>" + "<td>"
			+ document.getLong("tax deducted") + "</td>" + "<td>" + document.getLong("result") + "</td>" + "</tr>");
			}
		} */
/* 		out.println("</tbody></table>");
	} catch (Exception e) {

		e.printStackTrace();
	} */
	%>
</body>
</html>