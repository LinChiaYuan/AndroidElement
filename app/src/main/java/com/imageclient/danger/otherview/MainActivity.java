package com.imageclient.danger.otherview;
/**
 *
 *  author  :   Chia Yuan Lin (林家源)
 *
 *  email   :   lo919201@gmail.com
 *
 * **/
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{
    TextView mTextView;
    Spinner mSpinner;
    RadioGroup mRadioGroup;
    RadioButton mRadioButton1, mRadioButton2, mRadioButton3;
    CheckBox mCheckBox1, mCheckBox2, mCheckBox3;
    Switch mSwitch;
    ProgressBar mProgressBar;
    Button mButton;
    SeekBar mSeekbar;
    Button mBtnCa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.txt);

        mSpinner = (Spinner) findViewById(R.id.spin);
        final String[] mClass = {"台北","台中","台南","台東"};
        ArrayAdapter<String> ClassList = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mClass);
        mSpinner.setAdapter(ClassList);
        mSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String SelClass = parent.getSelectedItem().toString();
                mTextView.setText(SelClass);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });

        mRadioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        mRadioButton1 = (RadioButton) findViewById(R.id.radiobtn1);
        mRadioButton2 = (RadioButton) findViewById(R.id.radiobtn2);
        mRadioButton3 = (RadioButton) findViewById(R.id.radiobtn3);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                if(i == R.id.radiobtn1)
                {
                    String Msg = mRadioButton1.getText().toString();
                    mTextView.setText(Msg);
                }
                else if(i == R.id.radiobtn2)
                {
                    String Msg = mRadioButton2.getText().toString();
                    mTextView.setText(Msg);
                }
                else if(i == R.id.radiobtn3)
                {
                    String Msg = mRadioButton3.getText().toString();
                    mTextView.setText(Msg);
                }
            }
        });

        mCheckBox1 = (CheckBox) findViewById(R.id.checkbox1);
        mCheckBox2 = (CheckBox) findViewById(R.id.checkbox2);
        mCheckBox3 = (CheckBox) findViewById(R.id.checkbox3);
        mCheckBox1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String Msg = "";
                if(mCheckBox1.isChecked())
                    Msg = mCheckBox1.getText().toString() + ",";
                if(mCheckBox2.isChecked())
                    Msg = Msg + mCheckBox2.getText().toString() + ",";
                if(mCheckBox3.isChecked())
                    Msg = Msg + mCheckBox3.getText().toString();
                mTextView.setText(Msg);
            }
        });
        mCheckBox2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String Msg = "";
                if(mCheckBox1.isChecked())
                    Msg = mCheckBox1.getText().toString() + ",";
                if(mCheckBox2.isChecked())
                    Msg = Msg + mCheckBox2.getText().toString() + ",";
                if(mCheckBox3.isChecked())
                    Msg = Msg + mCheckBox3.getText().toString();
                mTextView.setText(Msg);
            }
        });
        mCheckBox3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String Msg = "";
                if(mCheckBox1.isChecked())
                    Msg = mCheckBox1.getText().toString() + ",";
                if(mCheckBox2.isChecked())
                    Msg = Msg + mCheckBox2.getText().toString() + ",";
                if(mCheckBox3.isChecked())
                    Msg = Msg + mCheckBox3.getText().toString();
                mTextView.setText(Msg);
            }
        });

        mSwitch = (Switch) findViewById(R.id.switch1);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(b)
                    mTextView.setText("單身");
                else
                    mTextView.setText("不好說");

            }
        });

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mButton = (Button) findViewById(R.id.btnstart);
        mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int progress = mProgressBar.getProgress();
                        while ((progress + 1) <= 100)
                        {
                            try
                            {
                                Thread.sleep(100);
                            }
                            catch (InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                            mProgressBar.setProgress(progress);
                            progress = progress + 1;
                        }
                    }
                }).start();
            }
        });

        mSeekbar = (SeekBar) findViewById(R.id.seek_bar);
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                mTextView.setText("" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                mTextView.setText("我要換囉");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                mTextView.setText("結束");
            }
        });

        mBtnCa = (Button) findViewById(R.id.btncalendarview);
        mBtnCa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                CalendarView mCalendarView = new CalendarView(MainActivity.this);
                mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
                {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day)
                    {
                        mTextView.setText(year + "/" + (month+1) + "/" + day );
                    }
                });
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, 2018);
                calendar.set(Calendar.MONTH, 6);
                calendar.set(Calendar.DAY_OF_MONTH, 7);
                mCalendarView.setDate(calendar.getTimeInMillis());
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                });
                builder.setView(mCalendarView);
                builder.setCancelable(true);
                builder.show();
            }
        });
    }
}
