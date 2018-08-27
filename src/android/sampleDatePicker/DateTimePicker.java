//package com.example.administrator.sampledatetimepicker;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//import android.widget.DatePicker;
//import android.widget.LinearLayout;
//import android.widget.TimePicker;
//
//import java.util.Calendar;
//
//public class DateTimePicker extends LinearLayout {
//    public static interface OnDateTimeChangedListener{
//        void onDateTimeChanged(DateTimePicker view, int year, int monthOfYear, int dayOfYear, int hourOfDay, int minute);
//    }
//    private OnDateTimeChangedListener listener;
//    private DatePicker datePicker;
//    private TimePicker timePicker;
//    private CheckBox enableTimeCheckBox;
//
//    public DateTimePicker(Context context){
//        super(context);
//        init(context);
//    }
//    public DateTimePicker(Context context, AttributeSet attrs){
//        super(context, attrs);
//        init(context);
//    }
//
//    private void init(Context context){
//        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        inflater.inflate(R.layout.picker,this,true);
//
//        Calendar calendar = Calendar.getInstance();
//        final int curYear = calendar.get(Calendar.YEAR);
//        final int curMonth = calendar.get(Calendar.MONTH);
//        final int curDay = calendar.get(Calendar.DAY_OF_MONTH);
//        final int curHour = calendar.get(Calendar.HOUR_OF_DAY);
//        final int curMinute = calendar.get(Calendar.MINUTE);
//
//        datePicker = (DatePicker)findViewById(R.id.datePicker);
//        datePicker.init(curYear, curMonth, curDay, new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//
//                if(listener!=null){
//                    listener.onDateTimeChanged(DateTimePicker.this, year, monthOfYear,dayOfMonth,timePicker.getCurrentHour(),timePicker.getCurrentMinute());
//                }
//            }
//        });
//
//        enableTimeCheckBox = (CheckBox)findViewById(R.id.enableTimeCheckBox);
//        enableTimeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                timePicker.setEnabled(isChecked);
//                timePicker.setVisibility((enableTimeCheckBox).isChecked()? View.VISIBLE:View.INVISIBLE);
//            }
//        });
//
//        timePicker = (TimePicker)findViewById(R.id.timePicker);
//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                if(listener != null){
//                    listener.onDateTimeChanged(DateTimePicker.this,datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth(),hourOfDay,minute);
//                }
//            }
//        });
//
//        timePicker.setCurrentHour(curHour);
//        timePicker.setCurrentMinute(curMinute);
//        timePicker.setEnabled(enableTimeCheckBox.isChecked());
//        timePicker.setVisibility((enableTimeCheckBox.isChecked()?View.VISIBLE:View.INVISIBLE));
//    }
//
//    public void setOnDateTimeChangedListener(OnDateTimeChangedListener dateTimeListener){
//        this.listener=dateTimeListener;
//    }
//
//    public void updateDateTime(int year, int monthOfYear, int dayOfMonth, int currentHour, int currentMinute){
//        datePicker.updateDate(year,monthOfYear,dayOfMonth);
//        timePicker.setCurrentHour(currentHour);
//        timePicker.setCurrentMinute(currentMinute);
//    }
//
//    public void setIs24HourView(final boolean is24HourView){
//        timePicker.setIs24HourView(is24HourView);
//    }
//
//    public int getYear() {
//        return datePicker.getYear();
//    }
//
//    public int getMonth() {
//        return datePicker.getMonth();
//    }
//
//    public int getDayOfMonth() {
//        return datePicker.getDayOfMonth();
//    }
//
//    public int getCurrentHour() {
//        return timePicker.getCurrentHour();
//    }
//
//    public int getCurrentMinute() {
//        return timePicker.getCurrentMinute();
//    }
//
//    public boolean enableTime() {
//        return enableTimeCheckBox.isChecked();
//    }
//}
