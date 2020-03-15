package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView resultText;
    //we are crreating container for storing value
    public enum Operation{ADD,SUBTRACT,DIVIDE,MULTIPLY,EQUAL}

    String runningNumber = "";
    String leftvalue = "";
    String rightvalue = "";
    Operation currentOpeartion;
    float result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button oneBtn = (Button)findViewById(R.id.oneBtn);
        Button twoBtn = (Button)findViewById(R.id.twoBtn);
        Button threeBtn = (Button)findViewById(R.id.threeBtn);
        Button fourBtn = (Button)findViewById(R.id.fourBtn);
        Button fiveBtn = (Button)findViewById(R.id.fiveBtn);
        Button sixBtn = (Button)findViewById(R.id.sixBtn);
        Button sevenBtn = (Button)findViewById(R.id.sevenBtn);
        Button eightBtn = (Button)findViewById(R.id.eightBtn);
        Button nineBtn = (Button)findViewById(R.id.nineBtn);
        Button zeroBtn = (Button)findViewById(R.id.zeroBtn);

        ImageButton calcbtn = (ImageButton)findViewById(R.id.calcBtn);
        ImageButton divideBtn = (ImageButton)findViewById(R.id.divideBtn);
        ImageButton subBtn = (ImageButton)findViewById(R.id.subBtn);
        ImageButton multiplyBtn = (ImageButton)findViewById(R.id.multiplyBtn);
        ImageButton addBtn = (ImageButton)findViewById(R.id.addBtn);

        Button clearBtn = (Button)findViewById(R.id.clearBtn);
        Button delBtn = (Button)findViewById(R.id.delBtn);
        resultText = (TextView)findViewById(R.id.resultText);
        // as onCreate method called we have to set resultText is balank;
        resultText.setText(" ");

        //set onClickListener on Every possible Button
        //here we have instansitate OnClickListener method with View
        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(1);
            }
        });
        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);
            }
        });
        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);
            }
        });
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);
            }
        });
        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });
        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });
        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });
        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);
            }
        });
        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);
            }
        });
        calcbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOpeartion(Operation.EQUAL);

            }
        });
        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOpeartion(Operation.DIVIDE);

            }
        });
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOpeartion(Operation.SUBTRACT);

            }
        });
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOpeartion(Operation.MULTIPLY);

            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOpeartion(Operation.ADD);

            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftvalue = "";
                rightvalue = "";
                result = 0;
                runningNumber = "";
                currentOpeartion = null;
                resultText.setText("");
            }
        });
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //s = s.substring(0,s.length()-1);
                //resultText.setText(s);
                    String s = remove();
                    resultText.setText(s);
                    leftvalue = "";
                    rightvalue = "";
                    runningNumber = "";
                   // resultText.setText("");
                    //
            }
        });
    }
    void processOpeartion(Operation opeartion)
    {
        if(currentOpeartion != null)
        {
            if(leftvalue.isEmpty())
            {
                leftvalue= runningNumber;
                runningNumber = "";
                currentOpeartion = opeartion;
                return ;
            }
            else if(runningNumber != "")
            {
                    rightvalue = runningNumber;
                    runningNumber = "";
                    switch (currentOpeartion)
                    {
                        case ADD:
                            result    = Float.parseFloat(leftvalue) + Float.parseFloat(rightvalue);
                            break;
                        case SUBTRACT:
                            result    = Float.parseFloat(leftvalue) - Float.parseFloat(rightvalue);
                            break;
                        case MULTIPLY:
                            result    = Float.parseFloat(leftvalue) * Float.parseFloat(rightvalue);
                            break;
                        case DIVIDE:
                            result    = Float.parseFloat(leftvalue) / Float.parseFloat(rightvalue);
                            break;
                    }
                    //here we are sending number from one buccjet to another;
                    //like simple calculator do (takes a vale and send to leftvale after doing some operstion like airthmetic one
                    // take anothe value anad send into again left avlue final after all opeartion setting left avlue to ""(balnk
                    leftvalue = String.valueOf(result);
                    resultText.setText(leftvalue);
            }
            currentOpeartion = opeartion;
        }
        else
        {
            leftvalue = runningNumber;
            runningNumber = "";
            currentOpeartion = opeartion;
        }
    }
    void numberPressed(int number)
    {
        runningNumber += String.valueOf(number);
        resultText.setText(runningNumber);
    }
    public  String remove()
    {
        String s = resultText.getText().toString();
        String s2 = "";
        for(int i = 0;i<s.length()-1;i++)
        {
            s2 += s.charAt(i);
        }
        return s2;
    }
}
