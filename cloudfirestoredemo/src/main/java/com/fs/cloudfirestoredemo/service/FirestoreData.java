package com.fs.cloudfirestoredemo.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirestoreData {
	@PostConstruct
	private void init() throws IOException {
		FileInputStream serviceAccount =
				  new FileInputStream("./serviceAccountKey.json");

				FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setDatabaseUrl("https://myproject-3e382.firebaseio.com")
				  .build();

				FirebaseApp.initializeApp(options);
	}

}
