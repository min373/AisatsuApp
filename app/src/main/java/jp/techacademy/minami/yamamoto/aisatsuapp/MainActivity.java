package jp.techacademy.minami.yamamoto.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v){

        showTimePickerDialog();

    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //TimePickerDialogが表示されたら時刻に応じてTextViewを変更
                if (hourOfDay >= 18 || hourOfDay < 2){
                    mTextView.setText("こんばんは");
                } else if (hourOfDay >= 10 && hourOfDay < 18){
                    mTextView.setText("こんにちは");
                } else if (hourOfDay >= 2 && hourOfDay < 10){
                    mTextView.setText("おはよう");
                }
            }
        },
                12,
                0,
                true);
        timePickerDialog.show();

    }
}
