package com.example.dutyroster2;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView textView = (TextView) findViewById(R.id.rosterText);

		textView.setText("今天:"
				+ InforCalc.CalculateRoster(ForToday.today));
		
		CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView1);
		calendarView.setOnDateChangeListener(new OnDateChangeListener() {
			public void onSelectedDayChange(CalendarView view, int year,
					int month, int dayOfMonth) {
				// TODO Auto-generated method stub
				month = month + 1;
				String formonth = String.valueOf(month);
				String forday = String.valueOf(dayOfMonth);
				/*
				 * if (month < 10) formonth = "0" + month; else { formonth =
				 * String.valueOf(month); } if (dayOfMonth < 10) forday = "0" +
				 * dayOfMonth; else { forday = String.valueOf(dayOfMonth); }
				 */
				String date = year + "年" + month + "月" + dayOfMonth + "日";
				String fordate = String.valueOf(year) + "/" + formonth + "/"
						+ forday;
				textView.setText(String.valueOf(month) + "月"
						+ String.valueOf(dayOfMonth) + "日:"
						+ InforCalc.CalculateRoster(fordate));
				Toast.makeText(getApplicationContext(), date,
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 1, "快速查询");
		menu.add(0, 2, 2, "退出");
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == 1) {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, SpeedSearch.class);
			startActivity(intent);
		} else if (item.getItemId() == 2) {
			confirmExit();
		}
		return true;
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 如果是返回键,直接返回到桌面
		if (keyCode == KeyEvent.KEYCODE_BACK
				|| keyCode == KeyEvent.KEYCODE_HOME) {
			confirmExit();
		}

		return super.onKeyDown(keyCode, event);
	}

	public void confirmExit() {
		new AlertDialog.Builder(MainActivity.this)
				.setMessage("确定要退出吗？( >﹏<。)～")
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						System.exit(0);
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				}).show();
	}

	/*
	 * public String CalculateRoster(String calDay) { String beginDay =
	 * "20130101"; int result = BetweenDays.betweenTwoDays(beginDay, calDay) %
	 * 6; if (result == 1 || result == 3 || result == 5) return s[0]; else if
	 * (result == 0) return s[1]; else if (result == 2) return s[2]; else if
	 * (result == 4) return s[3]; else { return "error"; } }
	 */
}
