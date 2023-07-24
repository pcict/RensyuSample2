package com.websarva.wings.android.rensyusample2;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //リスナーを取得
        CalcListener listener = new CalcListener();
        //ボタンを取得
        Button btCalc = findViewById(R.id.btCalc);
        //リスナーの紐付け
        btCalc.setOnClickListener(listener);

    }

    private class CalcListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //出力エリアの取得
            TextView output = findViewById(R.id.tv_output);
            try{
                //名前を取得
                EditText etName = findViewById(R.id.etName);
                String name = etName.getText().toString();
                if(name.length() == 0){
                    throw new Exception();
                }
                //身長を取得
                EditText etHeight = findViewById(R.id.etHeight);
                double height = Double.parseDouble(etHeight.getText().toString());
                if(height <= 0){
                    throw new Exception();
                }
                //体重を取得
                EditText etWeight = findViewById(R.id.etWeight);
                double weight = Double.parseDouble(etWeight.getText().toString());
                if(weight <= 0){
                    throw new Exception();
                }
                //Humanクラスの生成
                Human human = new Human(name,height,weight);
                //出力(BMI計算はHumanクラスで行う)
                output.setText(human.toString());
            }catch (Exception e){
                //エラーとして出力
                output.setText("正しく入力してください");
            }
        }
    }
}