package misprimos.netmind.com.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by A5Alumno on 21/11/2016.
 */
public class SecondActivity extends Activity implements View.OnClickListener{

    private static final String TAG = SecondActivity.class.getSimpleName();
    private EditText mEditTextReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Button buttonOk = (Button) findViewById(R.id.buttonOk);
        this.mEditTextReturn = (EditText) findViewById(R.id.editTextReturn);

        buttonOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("returnedString", this.mEditTextReturn.getText().toString());
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
