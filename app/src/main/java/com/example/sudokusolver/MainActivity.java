package com.example.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText[] arr=new EditText[9];
    Button submitButton;
    char[][] board;
    TextView[] ret=new TextView[9];
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arr[0]=(EditText)findViewById(R.id.e1);
        arr[1]=(EditText)findViewById(R.id.e2);
        arr[2]=(EditText)findViewById(R.id.e3);
        arr[3]=(EditText)findViewById(R.id.e4);
        arr[4]=(EditText)findViewById(R.id.e5);
        arr[5]=(EditText)findViewById(R.id.e6);
        arr[6]=(EditText)findViewById(R.id.e7);
        arr[7]=(EditText)findViewById(R.id.e8);
        arr[8]=(EditText)findViewById(R.id.e9);
        ret[0]=(TextView)findViewById(R.id.o1);
        ret[1]=(TextView)findViewById(R.id.o2);
        ret[2]=(TextView)findViewById(R.id.o3);
        ret[3]=(TextView)findViewById(R.id.o4);
        ret[4]=(TextView)findViewById(R.id.o5);
        ret[5]=(TextView)findViewById(R.id.o6);
        ret[6]=(TextView)findViewById(R.id.o7);
        ret[7]=(TextView)findViewById(R.id.o8);
        ret[8]=(TextView)findViewById(R.id.o9);
        board=new char[9][0];
        submitButton=(Button)findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                for(int i=0;i<9;++i)
                    board[i]=arr[i].getText().toString().toCharArray();
                Solve.solveSudoku(board);
                for(int i=0;i<9;++i)
                    ret[i].setText(new String(board[i]));
            }
        });
    }
}