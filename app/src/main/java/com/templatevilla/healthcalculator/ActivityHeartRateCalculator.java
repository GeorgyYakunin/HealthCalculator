package com.templatevilla.healthcalculator;

import android.content.Context;
import android.content.Intent;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;




import java.text.NumberFormat;
import java.util.Objects;

import static com.templatevilla.healthcalculator.util.Constant.getShapeDrawble;

public class ActivityHeartRateCalculator extends AppCompatActivity {
    Spinner activitySp;
    int[] activity_img = {R.drawable.activity, R.drawable.activity, R.drawable.activity, R.drawable.activity};
    double age;
    Button chart;
    boolean check = false;
    EditText edAge;
    EditText edRhr;
    double factor1;
    double factor2;
    Spinner genderSp;
    int[] gender_img = {R.drawable.man, R.drawable.girl};
    public boolean male = true;
    double max;
    double mhr;
    double min;

    NumberFormat numberFormat;
    double rhr;
    String str_max;
    String str_mhr;
    String str_min;
    TextView tvActivity;
    TextView tvAge;
    TextView tvGender;
    TextView tvRhr;
    Toolbar toolbar;

    public class MyAdapter1 extends ArrayAdapter<String> {
        MyAdapter1(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view,@Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view,@Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityHeartRateCalculator.this.getResources().getString(R.string.male), ActivityHeartRateCalculator.this.getResources().getString(R.string.female)};
            View inflate = ActivityHeartRateCalculator.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityHeartRateCalculator.this.gender_img[i]);
            return inflate;
        }
    }

    public class MyAdapter4 extends ArrayAdapter<String> {
        MyAdapter4(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view,@Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view,@Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityHeartRateCalculator.this.getResources().getString(R.string.moderate), ActivityHeartRateCalculator.this.getResources().getString(R.string.little_diff), ActivityHeartRateCalculator.this.getResources().getString(R.string.moderately_diff), ActivityHeartRateCalculator.this.getResources().getString(R.string.hard)};
            View inflate = ActivityHeartRateCalculator.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityHeartRateCalculator.this.activity_img[i]);
            return inflate;
        }
    }

    int primaryColor;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.YellowTheme);

        setContentView(R.layout.act_heart_rate);
        String[] strArr = {getResources().getString(R.string.male), getResources().getString(R.string.female)};
        String[] strArr2 = {getResources().getString(R.string.moderate), getResources().getString(R.string.little_diff), getResources().getString(R.string.moderately_diff), getResources().getString(R.string.hard)};

        init();
        Button button = findViewById(R.id.calc);
        Button button2 = findViewById(R.id.reset);


        init();
        Button chart = findViewById(R.id.chart);


        button.setBackground(getShapeDrawble(false, primaryColor));
        button2.setBackground(getShapeDrawble(true, primaryColor));
        chart.setBackground(getShapeDrawble(false, primaryColor));


        chart.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityHeartRateCalculator.this.startActivity(new Intent(ActivityHeartRateCalculator.this, ActivityChartHeart.class));
            }
        });
        numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);
        genderSp.setAdapter(new MyAdapter1(this, R.layout.act_spinner_down_blue, strArr));
        activitySp.setAdapter(new MyAdapter4(this, R.layout.act_spinner_down_blue, strArr2));


        activitySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String obj = ActivityHeartRateCalculator.this.activitySp.getSelectedItem().toString();
                if (obj.equals(ActivityHeartRateCalculator.this.getResources().getString(R.string.moderate))) {
                    ActivityHeartRateCalculator activityHeartRateCalculator = ActivityHeartRateCalculator.this;
                    activityHeartRateCalculator.factor1 = 0.6d;
                    activityHeartRateCalculator.factor2 = 0.65d;
                } else if (obj.equals(ActivityHeartRateCalculator.this.getResources().getString(R.string.little_diff))) {
                    ActivityHeartRateCalculator activityHeartRateCalculator2 = ActivityHeartRateCalculator.this;
                    activityHeartRateCalculator2.factor1 = 0.65d;
                    activityHeartRateCalculator2.factor2 = 0.7d;
                } else if (obj.equals(ActivityHeartRateCalculator.this.getResources().getString(R.string.moderately_diff))) {
                    ActivityHeartRateCalculator activityHeartRateCalculator3 = ActivityHeartRateCalculator.this;
                    activityHeartRateCalculator3.factor1 = 0.7d;
                    activityHeartRateCalculator3.factor2 = 0.75d;
                } else {
                    ActivityHeartRateCalculator activityHeartRateCalculator4 = ActivityHeartRateCalculator.this;
                    activityHeartRateCalculator4.factor1 = 0.75d;
                    activityHeartRateCalculator4.factor2 = 0.8d;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        genderSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityHeartRateCalculator.this.male = ActivityHeartRateCalculator.this.genderSp.getSelectedItem().toString().equals(ActivityHeartRateCalculator.this.getResources().getString(R.string.male));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "";
                ActivityHeartRateCalculator.this.edAge.setText(str);
                ActivityHeartRateCalculator.this.edRhr.setText(str);
                ActivityHeartRateCalculator.this.edAge.requestFocus();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                try {
                    ActivityHeartRateCalculator.this.age = Double.parseDouble(ActivityHeartRateCalculator.this.edAge.getText().toString());
                } catch (NumberFormatException unused) {
                    ActivityHeartRateCalculator.this.check = true;
                }
                try {
                    ActivityHeartRateCalculator.this.rhr = Double.parseDouble(ActivityHeartRateCalculator.this.edRhr.getText().toString());
                } catch (NumberFormatException unused2) {
                    ActivityHeartRateCalculator.this.check = true;
                }
                if (ActivityHeartRateCalculator.this.check) {
                    Toast.makeText(ActivityHeartRateCalculator.this.getApplicationContext(), ActivityHeartRateCalculator.this.getResources().getString(R.string.valid), Toast.LENGTH_SHORT).show();
                    ActivityHeartRateCalculator.this.check = false;
                    return;
                }
                if (ActivityHeartRateCalculator.this.male) {
                    ActivityHeartRateCalculator.this.age *= 0.8d;
                    ActivityHeartRateCalculator activityHeartRateCalculator = ActivityHeartRateCalculator.this;
                    activityHeartRateCalculator.mhr = 214.0d - activityHeartRateCalculator.age;
                } else {
                    ActivityHeartRateCalculator.this.age *= 0.9d;
                    ActivityHeartRateCalculator activityHeartRateCalculator2 = ActivityHeartRateCalculator.this;
                    activityHeartRateCalculator2.mhr = 209.0d - activityHeartRateCalculator2.age;
                }
                ActivityHeartRateCalculator activityHeartRateCalculator3 = ActivityHeartRateCalculator.this;
                activityHeartRateCalculator3.str_mhr = activityHeartRateCalculator3.numberFormat.format(ActivityHeartRateCalculator.this.mhr);
                ActivityHeartRateCalculator.this.mhr -= ActivityHeartRateCalculator.this.rhr;
                ActivityHeartRateCalculator activityHeartRateCalculator4 = ActivityHeartRateCalculator.this;
                activityHeartRateCalculator4.min = (activityHeartRateCalculator4.mhr * ActivityHeartRateCalculator.this.factor1) + ActivityHeartRateCalculator.this.rhr;
                ActivityHeartRateCalculator activityHeartRateCalculator5 = ActivityHeartRateCalculator.this;
                activityHeartRateCalculator5.max = (activityHeartRateCalculator5.mhr * ActivityHeartRateCalculator.this.factor2) + ActivityHeartRateCalculator.this.rhr;
                ActivityHeartRateCalculator activityHeartRateCalculator6 = ActivityHeartRateCalculator.this;
                activityHeartRateCalculator6.str_min = activityHeartRateCalculator6.numberFormat.format(ActivityHeartRateCalculator.this.min);
                ActivityHeartRateCalculator activityHeartRateCalculator7 = ActivityHeartRateCalculator.this;
                activityHeartRateCalculator7.str_max = activityHeartRateCalculator7.numberFormat.format(ActivityHeartRateCalculator.this.max);
                Intent intent = new Intent(ActivityHeartRateCalculator.this, ActivityHeartRateResult.class);

                intent.putExtra("value1", ActivityHeartRateCalculator.this.str_min);
                intent.putExtra("value2", ActivityHeartRateCalculator.this.str_max);
                ActivityHeartRateCalculator.this.startActivity(intent);
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(null);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        TextView text_title = findViewById(R.id.text_title);
        text_title.setText(getResources().getString(R.string.targethrrate));
        ImageView img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        edAge = findViewById(R.id.edAge);
        edRhr = findViewById(R.id.edRhr);
        tvAge = findViewById(R.id.tvAge);
        tvGender = findViewById(R.id.tvGender);
        tvRhr = findViewById(R.id.tvRhr);
        tvActivity = findViewById(R.id.tvActivity);
        genderSp = findViewById(R.id.genderSp);
        activitySp = findViewById(R.id.activitySp);
        chart = findViewById(R.id.chart);
        primaryColor = ContextCompat.getColor(getApplicationContext(), R.color.yellowcolorPrimary);

        ImageView img_age = findViewById(R.id.image_age);
        ImageView image_heart = findViewById(R.id.image_heart);
        ImageView img_itensity = findViewById(R.id.img_itensity);
        setThemeColor(img_age);
        setThemeColor(image_heart);
        setThemeColor(img_itensity);


    }

    public void setThemeColor(ImageView imageView) {
        imageView.getDrawable().setColorFilter(primaryColor, PorterDuff.Mode.SRC_IN);
    }
}
