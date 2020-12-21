package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvHello, tvResult;
    Button btnCopy, btnCalculate;
    EditText editTextHello, editText1, editText2;
    RadioGroup rgOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initinstances();
        tvHello.setText(Html.fromHtml("<b>He<u>ll</u>o</b> <i>World</i> <font color=\"#fafafa\">La la la</font> <a href=\"\">http://nuuneoi.com\">http://nuuneoi.com</a>"));

    }

    private void initinstances() {
        tvHello = (TextView) findViewById(R.id.tvHello);
        tvHello.setMovementMethod(LinkMovementMethod.getInstance());
        EditText editTextHello = (EditText) findViewById(R.id.editTextHello);
        editTextHello.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    tvHello.setText(editTextHello.getText());
                    return true;
                }
                return false;
            }
        });
        btnCopy = (Button) findViewById(R.id.btnCopy);
        btnCopy.setOnClickListener(this);


        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        rgOperator = (RadioGroup) findViewById(R.id.rgOperator);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val1 = 0;
                int val2 = 0;
                int sum = 0;
                try {
                    val1 = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException e) {
                }
                try {
                    val2 = Integer.parseInt(editText2.getText().toString());
                } catch (NumberFormatException e) {

                }
                switch (rgOperator.getCheckedRadioButtonId()) {
                    case R.id.rbPlus:
                        sum = val1 + val2;
                        break;
                    case R.id.rbMinus:
                        sum = val1 - val2;
                        break;
                    case R.id.rbMultiply:
                        sum = val1 * val2;
                        break;
                    case R.id.rbDivide:
                        sum = val1 / val2;
                        break;
                }
                tvResult.setText(sum + "");
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == btnCopy) {
            tvHello.setText(editTextHello.getText());
        }if(v == btnCalculate){
            tvResult.getText();
        }
    }


}