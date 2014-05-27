package com.example.dutyroster2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
//import android.widget.Toast;
import android.widget.DatePicker.OnDateChangedListener;

public class SpeedSearch extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.speedsearch);
		final TextView textView = (TextView) findViewById(R.id.rosterText1);
		
		textView.setText("����:"
				+ InforCalc.CalculateRoster(ForToday.today));
		
		DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker1);
		
		datePicker.setCalendarViewShown(false);//�ر��ұߵ����� ���ֺ�֮ǰ�汾һ���� ����������
		
		datePicker.init(ForToday.year, ForToday.month-1, ForToday.dayofMonth,
				new OnDateChangedListener(){
					public void onDateChanged(DatePicker view, int year,
							int month, int dayOfMonth) {
						month = month + 1;
						String formonth = String.valueOf(month);
						String forday = String.valueOf(dayOfMonth);
						
						String fordate = String.valueOf(year) +"/"+ formonth +"/"+ forday;
						textView.setText(String.valueOf(month) + "��"
								+ String.valueOf(dayOfMonth) + "��:"
								+ InforCalc.CalculateRoster(fordate));
						//Toast.makeText(getApplicationContext(), date, Toast.LENGTH_SHORT).show();
					}

				});
	}
}

