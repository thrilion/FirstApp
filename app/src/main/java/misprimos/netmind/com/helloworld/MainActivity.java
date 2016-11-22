package misprimos.netmind.com.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //comentario para hacer el first dev branch commit
        //segundo comentario para dev branch commit
        //tercer comentario para dev branch commit

        //llamamos a SecondActivity
        Intent myIntent = new Intent(this, SecondActivity.class);
        //startActivity(myIntent);
        startActivityForResult(myIntent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, "Todo controlado, resultado devuelto", Toast.LENGTH_LONG).show();
    }
}
