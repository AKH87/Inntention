package org.sample.inntention;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchWeb(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://erail.in/"));
        startActivity(i);
    }

    public void launchDialer(View view) {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel: 7008096418"));
        startActivity(i);
    }

    public void launchActivitySecond(View view) {
        Bundle b = new Bundle();
        b.putString("test_name", "Sidhant");
        Intent i = new Intent(getApplicationContext(),SecondActivity.class);
        i.putExtras(b);
        startActivityForResult(i, 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == 5678){
            String r = data.getStringExtra("result_data");
            Toast.makeText(this, r, Toast.LENGTH_SHORT).show();
        }


    }
}
