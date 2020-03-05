package org.sample.inntention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    EditText editTextName;
    Button btnSendBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle b = getIntent().getExtras();
        String name = b.getString("test_name");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        editTextName = findViewById(R.id.editName);
        btnSendBack = findViewById(R.id.btnSendBack);
    }


    public void sendBackResult(View view) {
        String inputName = editTextName.getText().toString();
        Intent i = new Intent();
        i.putExtra("result_data",inputName);
        setResult(5678, i);
        finish();
    }
}
