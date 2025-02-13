package br.com.etecia.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    Button btnLoginEntrar, btnLoginEsqSenha, btnLoginCriarConta;
    TextInputEditText txtLoginEmail, txtLoginSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Apresentando as variáveis do java para o xml

        btnLoginEntrar = findViewById(R.id.btnLoginEntrar);
        btnLoginEsqSenha = findViewById(R.id.btnLoginEsqSenha);
        btnLoginCriarConta = findViewById(R.id.btnLoginCriarConta);

        txtLoginEmail = findViewById(R.id.txtLoginEmail);
        txtLoginSenha = findViewById(R.id.txtLoginSenha);

        //Verificar a senha e o e-mail


        btnLoginEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;

                email = txtLoginEmail.getText().toString().trim();
                password = txtLoginSenha.getText().toString().trim();

                if (email.equals("etecia") && password.equals("etecia")) {
                    startActivity(new Intent(getApplicationContext(),
                            MenuActivity.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Usuários ou senha inválidos",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Leva do "Login" para o "Esqueci a senha"


        btnLoginEsqSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), EsqSenhaActivity.class));
                finish();

            }
        });

        //Leva do "Login" para o "Cadastrar"

        btnLoginCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), CadastrarActivity.class));
                finish();

            }
        });

    }
}