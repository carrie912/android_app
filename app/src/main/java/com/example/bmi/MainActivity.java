package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText a;
    EditText b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = (EditText)findViewById(R.id.et1);
        b = (EditText)findViewById(R.id.et2);
        Button submit = (Button)findViewById(R.id.to);


        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                if ( !("".equals(a.getText().toString())
                        || "".equals(b.getText().toString())) )
                {
                    float fh = Float.parseFloat(a.getEditableText().toString());
                    float fw = Float.parseFloat(b.getEditableText().toString());
                    float fresult;
                    TextView result = (TextView)findViewById(R.id.result);
                    fh = fh/100;
                    fh = fh*fh;

                    NumberFormat nf = NumberFormat.getInstance();
                    fresult = fw/fh;
                    result.setText(nf.format(fw/fh) +"");
                    TextView dia = (TextView)findViewById(R.id.text);


                    if (fresult<18.5)
                        dia.setText("您過輕喔!!");
                    else if (18.5 <= fresult && fresult< 24)
                        dia.setText("您的體重正常");
                    else if (24 <=fresult && fresult < 27)
                        dia.setText("您有點過重");
                    else if (27 <=fresult && fresult < 30)
                        dia.setText("輕度肥胖了喔");
                    else if (30 <= fresult && fresult < 35)
                        dia.setText("中度肥胖了喔");
                    else if (fresult >= 35)
                        dia.setText("重度肥胖!!!!        ");
                }
            }
        });
    }
}
