package dev.kaua.squash.Firebase;

import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class myFirebaseHelper {
    private static FirebaseAnalytics firebaseAnalytics;
    private static FirebaseAuth firebaseAuth;
    private static FirebaseUser firebaseUser;
    private static StorageReference firebaseStorage;
    private static FirebaseDatabase firebaseDatabase;

    public static FirebaseAnalytics getFirebaseAnalytics(Context context){
        if (firebaseAnalytics == null) firebaseAnalytics = FirebaseAnalytics.getInstance(context);
        return firebaseAnalytics;
    }

    public static FirebaseAuth getFirebaseAuth(){
        if (firebaseAuth == null) firebaseAuth = FirebaseAuth.getInstance();
        return firebaseAuth;
    }

    public static FirebaseDatabase getFirebaseDatabase(){
        if (firebaseDatabase == null) firebaseDatabase = FirebaseDatabase.getInstance();
        return firebaseDatabase;
    }

    public static FirebaseUser getFirebaseUser(){
        if (firebaseUser == null) firebaseUser = getFirebaseAuth().getCurrentUser();
        return firebaseUser;
    }

    public static StorageReference getFirebaseStorage(){
        if (firebaseStorage == null) firebaseStorage = FirebaseStorage.getInstance().getReference();
        return firebaseStorage;
    }

    public static void LogOut(){
        getFirebaseAuth().signOut();
        firebaseAnalytics = null;
        firebaseAuth = null;
        firebaseUser = null;
        firebaseStorage = null;
        firebaseDatabase = null;
    }
}