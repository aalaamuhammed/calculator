package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME="CalculatorResult.txt";
    int R1=0;
    EditText num1,num2;
    TextView result;
    Button add,sub,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 =  (EditText) findViewById(R.id.firstone);
        num2 =  (EditText) findViewById(R.id.secondone);
        result=(TextView) findViewById(R.id.result);
        add =  (Button) findViewById(R.id.add);
        sub =  (Button) findViewById(R.id.subtract);
        mul =  (Button) findViewById(R.id.multiply);
        div =  (Button) findViewById(R.id.devide);


        System.out.print(num1.getText().toString());
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int N1= Integer.parseInt(num1.getText().toString());
                int N2= Integer.parseInt(num2.getText().toString());
                R1 =N1+N2;
                result.setText(String.valueOf(R1));
                System.out.println(R1);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int N1= Integer.parseInt(num1.getText().toString());
                int N2= Integer.parseInt(num2.getText().toString());
                int R1=N1-N2;
                result.setText(String.valueOf(R1));
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int N1= Integer.parseInt(num1.getText().toString());
                int N2= Integer.parseInt(num2.getText().toString());
                int R1=N1*N2;
                result.setText(String.valueOf(R1));
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int N1= Integer.parseInt(num1.getText().toString());
                int N2= Integer.parseInt(num2.getText().toString());
                float R1=N1/N2;
                result.setText(String.valueOf(R1));
            }
        });


    }
    public void save(View v){
        String text=String.valueOf(R1);
        FileOutputStream fos=null;
        try {
            fos=openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(this, "Saved to " + getFilesDir() + FILE_NAME, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
