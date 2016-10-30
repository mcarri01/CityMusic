package com.example.mcarr.practiceapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.DatePicker;

/**
 * Created by mcarr on 9/26/2016.
 */
public class Calender extends Activity {

    private int departDay = 0;
    private int departMonth = 0;
    private int departYear = 0;
    private int returnDay = 0;
    private int returnMonth = 0;
    private int returnYear = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calenderwindow);
        /* Initialize depart dates*/
        DatePicker departureDate = (DatePicker) findViewById(R.id.departureDates);
        departDay = departureDate.getDayOfMonth();
        departMonth = departureDate.getMonth() + 1;
        departYear = departureDate.getYear();
        setContentView(R.layout.returnlayout);

        /* Initialize return dates */
        DatePicker returnDate = (DatePicker) findViewById(R.id.returnDates);
        returnDay = returnDate.getDayOfMonth();
        returnMonth = returnDate.getMonth() + 1;
        returnYear = returnDate.getYear();
        setContentView(R.layout.calenderwindow);


        /* Set up activity window */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout(width, height);
    }
    public void checkReturn(View view) {
        DatePicker departureDate = (DatePicker) findViewById(R.id.departureDates);
        departDay = departureDate.getDayOfMonth();
        departMonth = departureDate.getMonth();
        departYear = departureDate.getYear();
        setContentView(R.layout.returnlayout);
        DatePicker returnDate = (DatePicker) findViewById(R.id.returnDates);
        returnDate.updateDate(returnYear, returnMonth, returnDay);
    }
    public void checkDepart(View view) {
        DatePicker returnDate = (DatePicker) findViewById(R.id.returnDates);
        returnDay = returnDate.getDayOfMonth();
        returnMonth = returnDate.getMonth();
        returnYear = returnDate.getYear();
        setContentView(R.layout.calenderwindow);
        DatePicker departureDate = (DatePicker) findViewById(R.id.departureDates);
        departureDate.updateDate(departYear, departMonth, departDay);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("departday", departDay);
        bundle.putInt("departmonth", departMonth);
        bundle.putInt("departyear", departYear);
        bundle.putInt("returnday", returnDay);
        bundle.putInt("returnmonth", returnMonth);
        bundle.putInt("returnyear", returnYear);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }

}