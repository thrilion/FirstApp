package misprimos.netmind.com.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public String returnInfoString;
    private TextView txtReturned;
    private EditText editText;
    public static final int ACTIVITY_REQUEST_CODE = 0;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonDisplay = (Button) findViewById(R.id.buttonDisplay);
        final Button buttonNewActivity = (Button) findViewById(R.id.buttonNewActivity);
        this.txtReturned = (TextView) findViewById(R.id.txtReturned);
        this.editText = (EditText) findViewById(R.id.editTextReturn);

        buttonDisplay.setOnClickListener(this);
        buttonNewActivity.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e(MainActivity.TAG, "onActivityResult");
        if(resultCode == Activity.RESULT_OK && requestCode == MainActivity.ACTIVITY_REQUEST_CODE){
            if(data != null){
                Log.e(MainActivity.TAG, "onActivityResult, != null");
                this.returnInfoString = data.getStringExtra("returnedString");
                Log.e(MainActivity.TAG, this.returnInfoString);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putString("savedReturString", this.retInfoString);
        //outState.putString("currentTextViewString", this.dispInfo_TextView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonDisplay){

            Log.e(MainActivity.TAG, "onClick buttonDisplay");
            txtReturned.setText(this.returnInfoString);
        }else if(v.getId() == R.id.buttonNewActivity){
            //llamamos a SecondActivity
            Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(myIntent, MainActivity.ACTIVITY_REQUEST_CODE);
        }
    }
}
