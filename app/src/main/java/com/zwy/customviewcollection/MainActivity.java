package com.zwy.customviewcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AutoDivideLinearLayout horizontalLayout;
    private AutoDivideLinearLayout verticalLayout;

    private Button controlBtn1;
    private Button controlBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        horizontalLayout = findViewById(R.id.horizontal_layout);
        verticalLayout = findViewById(R.id.vertical_layout);

        controlBtn1 = findViewById(R.id.btn1);
        controlBtn2 = findViewById(R.id.btn2);

        controlBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view2 = findViewById(R.id.text2);
                boolean isVisible = view2.getVisibility() == View.VISIBLE;
                view2.setVisibility(isVisible ? View.GONE : View.VISIBLE);
            }
        });

        controlBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view6 = findViewById(R.id.text6);
                boolean isVisible = view6.getVisibility() == View.VISIBLE;
                view6.setVisibility(isVisible ? View.GONE : View.VISIBLE);
            }
        });

    }
}
