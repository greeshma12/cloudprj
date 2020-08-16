package com.fs.cloudfirestoredemo.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.fs.cloudfirestoredemo.model.Cafe;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {
	
	public String savecafe(Cafe cafe) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("cafes").document(cafe.getName()).set(cafe);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
	
	public Cafe getCafeDetails(String name) throws InterruptedException, ExecutionException {
		Firestore db=FirestoreClient.getFirestore();
		DocumentReference dref=db.collection("cafes").document(name);
		ApiFuture<DocumentSnapshot> future=dref.get();
		DocumentSnapshot document=future.get();
		Cafe cafe=null;
		if(document.exists()) {
			cafe=document.toObject(Cafe.class);
			return cafe;
		}else {
			return null;
		}	
	}
	
	public String updatecafe(Cafe cafe) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("cafes").document(cafe.getName()).set(cafe);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deletecafe(String name) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("cafes").document(name).delete();
        return "Document with Cafe "+name+" has been deleted";
    }
}
