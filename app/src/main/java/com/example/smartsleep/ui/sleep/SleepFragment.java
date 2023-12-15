package com.example.smartsleep.ui.sleep;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.smartsleep.R;
import com.example.smartsleep.SleepRecord;

import android.text.format.DateFormat;
import android.widget.Toast;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

import static com.example.smartsleep.MainActivity.sleepDatabase;

public class SleepFragment extends Fragment {
    Button buttonBedtime, buttonWakeUp, buttonSave,buttonSleepDate, buttonWakeDate;
    TextView tvBedtimeTime, tvWakeUpTime, tvBedDate, tvWakeDate;
    int bedHour, bedMinute, wakeHour, wakeMinute;
    int dYear,  dMonth,  day;
    private SleepRecord sleep;
    private String validateString = "0000";

    private boolean validateData(){
        int currentDay = LocalDateTime.now().getDayOfMonth();
        if(Integer.parseInt(validateString) != Integer.parseInt("1111")){
            return false;
        }

        if(bedHour<wakeHour){
            return false;
        }

        if(Integer.parseInt(sleep.getEndDate().substring(8))-Integer.parseInt(sleep.getStartDate().substring(8))<=0){
            return false;
        }

        if(Integer.parseInt(sleep.getStartDate().substring(8))>currentDay){
            return false;
        }

        if(Integer.parseInt(sleep.getEndDate().substring(8))-Integer.parseInt(sleep.getStartDate().substring(8))>1){
            return false;
        }
        return true;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SleepViewModel homeViewModel = ViewModelProviders.of(this).get(SleepViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sleep, container, false);

        sleep = new SleepRecord();
        tvBedtimeTime = root.findViewById(R.id.bedtimeTimeText);
        tvWakeUpTime = root.findViewById(R.id.wakeUpTimeText);
        tvBedDate = root.findViewById(R.id.bedtimeDateText);
        tvWakeDate = root.findViewById(R.id.wakeUpDateText);
        buttonBedtime = root.findViewById(R.id.downArrowBedtime);
        buttonWakeUp = root.findViewById(R.id.downArrowWakeUpTime);
        buttonSave = root.findViewById(R.id.saveInputButton);
        buttonSleepDate = root.findViewById(R.id.downArrowBedDate);
        buttonWakeDate = root.findViewById(R.id.downArrowWakeDate);

        buttonBedtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                validateString =  '1' + validateString.substring(1);
                                System.out.println(validateString);
                                bedHour = hourOfDay;
                                bedMinute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,bedHour,bedMinute);
                                tvBedtimeTime.setText(DateFormat.format("HH:mm ", calendar));
                                sleep.setStartTime(DateFormat.format("HH:mm", calendar).toString());
                            }
                        },LocalTime.now().getHour(), LocalTime.now().getMinute(),true
                );
                //timePickerDialog.updateTime(bedHour,bedMinute);
                timePickerDialog.show();
            }
        });
        buttonWakeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                validateString = validateString.substring(0,2) + '1' + validateString.substring(3);
                                System.out.println(validateString);
                                wakeHour = hourOfDay;
                                wakeMinute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,wakeHour,wakeMinute);
                                tvWakeUpTime.setText(DateFormat.format("HH:mm ", calendar));
                                sleep.setEndTime(DateFormat.format("HH:mm", calendar).toString());
                            }
                        }, LocalTime.now().getHour(), LocalTime.now().getMinute(),true
                );
                //timePickerDialog.updateTime(wakeHour,wakeMinute);
                timePickerDialog.show();
            }
        });
        buttonSleepDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                validateString = validateString.substring(0,1) + '1' + validateString.substring(2);
                                System.out.println(validateString);
                                dYear = year;
                                day = dayOfMonth;
                                dMonth = month;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(dYear, dMonth, day);
                                tvBedDate.setText(DateFormat.format("yyyy-MM-dd", calendar));
                                sleep.setStartDate(DateFormat.format("yyyy-MM-dd", calendar).toString());
                            }
                        }, LocalDate.now().getYear(), LocalDate.now().getMonthValue() - 1, LocalDate.now().getDayOfMonth()
                );
                //datePickerDialog.updateDate(dYear, dMonth, day);
                datePickerDialog.show();
            }
        });
        buttonWakeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                validateString = validateString.substring(0,3) + '1';
                                System.out.println(validateString);
                                dYear = year;
                                day = dayOfMonth;
                                dMonth = month;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(dYear, dMonth, day);
                                tvWakeDate.setText(DateFormat.format("yyyy-MM-dd", calendar));
                                sleep.setEndDate(DateFormat.format("yyyy-MM-dd", calendar).toString());
                            }
                        }, LocalDate.now().getYear(), LocalDate.now().getMonthValue() - 1, LocalDate.now().getDayOfMonth()
                );
                //datePickerDialog.updateDate(dYear, dMonth, day);
                datePickerDialog.show();
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_sleep_to_navigation_profile);
                if (!validateData()){
                    Toast toast = Toast.makeText(getContext(),
                            "Data is incorrect!",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 250);
                    toast.show();
                    return;
                }
                sleepDatabase.sleepDAO().addRecord(sleep);
                sleep = new SleepRecord(); //reset the sleep record
                Toast toast = Toast.makeText(getContext(),
                        "Saved!",
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 250);
                toast.show();
            }
        });

        return root;
    }
}
