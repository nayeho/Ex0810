package com.example.ex0810;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText et_id, et_pw;
    Button btn_login;
    String[][] members = {{"nayeho", "1234"}, {"smhrd", "4321"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 주석
        et_id = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_pw);
        btn_login = findViewById(R.id.btn_login);

        // btn_login 클릭 시 et_id, et_pw의 값과
        // 배열 내 id, pw값과 비교
        // 만약, 일치하면 그 때의 id를 가지고 MainActivity로 넘어가주세요

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = et_id.getText().toString();
                String pw = et_pw.getText().toString();

                for (int i = 0; i < members.length; i++){
                    if (id.equals(members[i][0]) && pw.equals(members[i][1])){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
                        break;
                    }
                }
            }
        });


    }
}