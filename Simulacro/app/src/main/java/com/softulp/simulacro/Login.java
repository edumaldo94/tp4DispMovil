package com.softulp.simulacro;

import static android.Manifest.permission.CALL_PHONE;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModel;

import com.softulp.simulacro.databinding.ActivityMainBinding;
import com.softulp.simulacro.ui.Llamada;

public class Login extends AppCompatActivity {

    private EditText txtUser;

    private EditText txtPass;
private ActivityMainBinding binding;
    private Button btnLogin;
    private Llamada llamada;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
      //  binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_login);

        solicitarPermisos();
        registrarBroadcast();

        txtUser = findViewById(R.id.idUser);
        txtPass = findViewById(R.id.idPassword);
        btnLogin = findViewById(R.id.btnLogin);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUser.getText().toString();


                String password = txtPass.getText().toString();


                // Inicio de sesión exitoso
                Intent intent;
                if (username.equals("admin") && password.equals("123")) {
                    intent = new Intent(getApplicationContext(), MainActivity.class);

                   startActivity(intent);
             //   finish();
            }
                else{
                    // Credenciales inválidas
                    Toast.makeText(getApplicationContext(), "Contraseña incorrecta",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(llamada);

    }
    public void solicitarPermisos(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && checkSelfPermission(CALL_PHONE)
        != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{CALL_PHONE}, 1000);

        }
    }
private void registrarBroadcast(){
        this.llamada= new Llamada();
        registerReceiver(llamada, new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));

    }


}