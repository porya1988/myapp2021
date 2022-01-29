package com.example.myapp2021.Registration.RInteractor;

import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.myapp2021.R;
import com.example.myapp2021.Registration.LoginActivity;
import com.example.myapp2021.Registration.RegisterListner.RegisterListner;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.model.IMessageListner;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class RInteractor {

    FirebaseAuth firebaseAuth;

    public RInteractor() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void getUser(HashMap<String, Object> user, RegisterListner listener) {

        String name = user.get("name").toString();
        String family = user.get("family").toString();
        String password = user.get("password").toString();
        String email = user.get("email").toString();

        if (name.isEmpty()) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.enter_your_name);
            listener.onNameError(error);
            Log.e("", "");
            return;
        }
        if (family.isEmpty()) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.enter_your_family);
            listener.onFamilyError(error);
            Log.e("", "");
            return;
        }
        if (password.isEmpty()) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.enter_password);
            listener.onPasswordError(error);
            Log.e("", "");
            return;
        }
        if (password.length() < 6) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.password_length);
            listener.onPasswordError(error);
            Log.e("", "");
            return;
        }
        if (email.isEmpty()) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.enter_email);
            listener.onEmailError(error);
            Log.e("", "");
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful()) {
                    FirebaseAuthException e = (FirebaseAuthException) task.getException();
                    Log.e("LoginActivity", "Failed Registration", e);
                    return;
                }


                if (task.isSuccessful()) {
                    String member = AppConfiguration.getContext().getResources().getString(R.string.you_are_a_member);
                    listener.onSuccess(member);
                    FirebaseFirestore database = FirebaseFirestore.getInstance();
                    String User_id = firebaseAuth.getUid();
                    if (User_id != null) {
                        user.put("User_id", User_id);
                        Log.e("", "");
                        database.collection("users")
                                .add(user)
                                .addOnSuccessListener(documentReference -> {
                                    Toast.makeText(AppConfiguration.getContext(), R.string.you_are_a_member, Toast.LENGTH_LONG).show();
                                    Log.e("", "");

                                })
                                .addOnFailureListener(e -> {
                                    Toast.makeText(AppConfiguration.getContext(), R.string.error_occured, Toast.LENGTH_LONG).show();
                                });
                    }
                } else {
                    String failed = AppConfiguration.getContext().getResources().getString(R.string.login_failed);
                    listener.onFailure(failed);
                }
            }
        });
    }

    public void LogUser(HashMap<String, Object> user, IMessageListner listener) {
        String password = user.get("password").toString();
        String email = user.get("email").toString();

        if (email.isEmpty()) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.enter_email);
            listener.onFailure(error);
        }

        if (password.isEmpty()) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.enter_password);
            listener.onFailure(error);
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful()) {
                    Log.e("", "");
                }


                if (task.isSuccessful()) {
                    String signed = AppConfiguration.getContext().getResources().getString(R.string.login_successful);
                    listener.onSuccess(signed);
                } else {
                    String sign_failed = AppConfiguration.getContext().getResources().getString(R.string.sign_failed);
                    listener.onFailure(sign_failed);
                }
            }
        });

    }
}