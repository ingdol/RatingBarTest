package com.example.ratingbartest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { //클래스를 상속받아 MainActivity 클래스를 작성한다.

    private RatingBar ratingBar; //RatingBar를 ratingBar로 선언한다.
    private TextView value; //TextView를 value로 선언한다.
    private Button button; //Button을 button으로 선언한다.

    @Override
    public void onCreate(Bundle savedInstanceState) { //onCreate 메소드의 매개변수는 앱의 이전 실행 상태를 전달한다.
        super.onCreate(savedInstanceState); //부모클래스의 onCreate를 호출한다.
        setContentView(R.layout.activity_main); //메인을 띄운다.

        SetupRatingBar(); //RatingBar를 세팅한다.
        SetupButton(); //Button을 세팅한다.
    }

    public void SetupRatingBar(){ //SetupRatingBar 메소드

        ratingBar = (RatingBar) findViewById(R.id.ratingbar); //ratingbar의 정보를 가져온다.
        value = (TextView) findViewById(R.id.value); //value의 정보를 가져온다.

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            //setOnRatingBarChangListener 리스너를 설정한다.
            //레이팅바가 변경될 때 메소드가 자동 호출된다.
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //onRatingChanged 콜배 메소드 : 사용자가 레이팅을 설정했을 때 호출되어서 작업을 수정한다.
                value.setText(String.valueOf(rating));
                //새로운 점수 값을 string으로 변경해 토스트 메시지로 전달한다.

            }
        });
    }

    public void SetupButton(){ //버튼이 눌러지면
        ratingBar = (RatingBar) findViewById(R.id.ratingbar); //ratingbar의 정보를 가져오고
        button = (Button) findViewById(R.id.button); //button의 정보를 가져온다.

        button.setOnClickListener(new View.OnClickListener(){ //클릭하면
            @Override
            public void onClick(View v) { //클릭할 때
                Toast.makeText(getBaseContext(), //토스트 메시지를 생성한다.
                        String.valueOf(ratingBar.getRating()),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
