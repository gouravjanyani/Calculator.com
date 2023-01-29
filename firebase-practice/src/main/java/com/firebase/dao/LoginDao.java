package com.firebase.dao;

import java.io.FileInputStream;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.firebase.model.Login;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;

//import vo.ResultObjectVO;

public class LoginDao {

	private static DatabaseReference database;
	private static Firestore db = null;

	public Firestore getConnection(HttpServletRequest request) throws Exception {

		try {

			if (db == null) {

				ServletContext servletContext = request.getServletContext();

				String path = servletContext.getRealPath("practicefirestore.json");

				FileInputStream serviceAccount = new FileInputStream(path);

				// TO be commented before deployment

				FirebaseOptions options = new FirebaseOptions.Builder()
						.setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
				/*
				 * .setDatabaseUrl(DATABASE_URL) .build();
				 */
				if (FirebaseApp.getApps().isEmpty()) {

					FirebaseApp.initializeApp(options);
				}
				db = FirestoreClient.getFirestore();
			}



		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return db;

	}

}
