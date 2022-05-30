package com.example.multigaming;

        import android.content.Intent;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import com.google.android.gms.auth.api.signin.GoogleSignIn;
        import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
        import com.google.android.gms.auth.api.signin.GoogleSignInClient;
        import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
        import com.google.android.gms.common.api.ApiException;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthCredential;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.auth.GoogleAuthProvider;

public class SignInActivity extends AppCompatActivity {

    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN = 123 ;
    private FirebaseAuth mauth;
    TextView registerbutton;
    Button loginbutton;
    EditText uemail , pass;


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mauth.getCurrentUser();
        if(user!= null){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        uemail = findViewById(R.id.uemail);
        pass = findViewById(R.id.pass);
        loginbutton = findViewById(R.id.loginbutton);
        loginbutton.setOnClickListener(view -> {
            loginUser();
        });
        createRequest();
        mauth = FirebaseAuth.getInstance();
        registerbutton = findViewById(R.id.registerbutton);
        findViewById(R.id.sign_in_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        registerbutton.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
            startActivity(intent);
        });


    }
    public void createRequest(){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this,gso);
    }

    private void signIn(){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent , RC_SIGN_IN);
    }
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

                try {
                    // Google Sign In was successful, authenticate with Firebase
                    GoogleSignInAccount account = task.getResult(ApiException.class);
                            Log.d("SignInActivity", "firebaseAuthWithGoogle:" + account);
                    firebaseAuthWithGoogle(account);
                } catch (ApiException e) {
                    // Google Sign In failed, update UI appropriately
                    Log.w("SignInActivity", "Google sign in failed", e);
                }
            } else {
                Log.w("SignInActivity","Exception" );
            }
        }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mauth.signInWithCredential(credential)
                .addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                       @Override
                        public void onComplete(@NonNull Task<AuthResult> task){
                        if (task.isSuccessful()) {
                            FirebaseUser user = mauth.getCurrentUser();
                // Sign in success, update UI with the signed-in user's information
//                Log.d("SignInActivity", "signInWithCredential:success")
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                finish();
            } else {
                // If sign in fails, display a message to the user.
                Log.d("SignInActivity", "signInWithCredential:failure");
            }
        }
    });

}
    private void loginUser(){
        String email = uemail.getText().toString();
        String password = pass.getText().toString();

        if (TextUtils.isEmpty(email)){
            uemail.setError("Email cannot be empty");
            uemail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            pass.setError("Password cannot be empty");
            pass.requestFocus();
        }else{
            mauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignInActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignInActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(SignInActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
