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

public class ActivityWaterIntakeCalc extends AppCompatActivity {
    double age;
    boolean check = false;
    double dwi;
    int dwi_int;
    EditText edAge;
    EditText edWeight;
    public boolean isKG = true;
    NumberFormat numberFormat;
    String str_dwi;
    TextView tvAge;
    TextView tvWeight;
    double weight;
    Spinner weightSp;
    int[] weight_img = {R.drawable.weight, R.drawable.weight};
    Toolbar toolbar;

    public class MyAdapter3 extends ArrayAdapter<String> {
        MyAdapter3(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view,@Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view,@Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityWaterIntakeCalc.this.getResources().getString(R.string.kilograms), ActivityWaterIntakeCalc.this.getResources().getString(R.string.pounds)};
            View inflate = ActivityWaterIntakeCalc.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityWaterIntakeCalc.this.weight_img[i]);
            return inflate;
        }
    }

    int primaryColor;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.OrangeTheme);
        setContentView(R.layout.act_water_in_take_calc);
        String[] strArr = {getResources().getString(R.string.kilograms), getResources().getString(R.string.pounds)};

        Button button = findViewById(R.id.calc);
        Button button2 = findViewById(R.id.reset);
        init();
        findViewById(R.id.chart).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityWaterIntakeCalc.this.startActivity(new Intent(ActivityWaterIntakeCalc.this, ActivityChartWater.class));
            }
        });
        Button chart = findViewById(R.id.chart);


        button.setBackground(getShapeDrawble(false, primaryColor));
        button2.setBackground(getShapeDrawble(true, primaryColor));
        chart.setBackground(getShapeDrawble(false, primaryColor));

        numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);
        weightSp.setAdapter(new MyAdapter3(this, R.layout.act_spinner_down_blue, strArr));


        weightSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityWaterIntakeCalc.this.isKG = ActivityWaterIntakeCalc.this.weightSp.getSelectedItem().toString().equals(ActivityWaterIntakeCalc.this.getResources().getString(R.string.kilograms));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "";
                ActivityWaterIntakeCalc.this.edWeight.setText(str);
                ActivityWaterIntakeCalc.this.edAge.setText(str);
                ActivityWaterIntakeCalc.this.edWeight.requestFocus();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                try {
                    ActivityWaterIntakeCalc.this.weight = Double.parseDouble(ActivityWaterIntakeCalc.this.edWeight.getText().toString());
                } catch (NumberFormatException unused) {
                    ActivityWaterIntakeCalc.this.check = true;
                }
                try {
                    ActivityWaterIntakeCalc.this.age = Double.parseDouble(ActivityWaterIntakeCalc.this.edAge.getText().toString());
                } catch (NumberFormatException unused2) {
                    ActivityWaterIntakeCalc.this.check = true;
                }
                if (ActivityWaterIntakeCalc.this.check) {
                    Toast.makeText(ActivityWaterIntakeCalc.this.getApplicationContext(), ActivityWaterIntakeCalc.this.getResources().getString(R.string.valid), Toast.LENGTH_SHORT).show();
                    ActivityWaterIntakeCalc.this.check = false;
                    return;
                }
                if (!ActivityWaterIntakeCalc.this.isKG) {
                    ActivityWaterIntakeCalc.this.weight /= 2.2d;
                }
                if (ActivityWaterIntakeCalc.this.age <= 30.0d) {
                    ActivityWaterIntakeCalc activityWaterIntakeCalc2 = ActivityWaterIntakeCalc.this;
                    activityWaterIntakeCalc2.dwi = activityWaterIntakeCalc2.weight * 40.0d;
                } else if (ActivityWaterIntakeCalc.this.age > 55.0d) {
                    ActivityWaterIntakeCalc activityWaterIntakeCalc3 = ActivityWaterIntakeCalc.this;
                    activityWaterIntakeCalc3.dwi = activityWaterIntakeCalc3.weight * 30.0d;
                } else {
                    ActivityWaterIntakeCalc activityWaterIntakeCalc4 = ActivityWaterIntakeCalc.this;
                    activityWaterIntakeCalc4.dwi = activityWaterIntakeCalc4.weight * 35.0d;
                }
                ActivityWaterIntakeCalc.this.dwi /= 28.3d;
                ActivityWaterIntakeCalc.this.dwi /= 8.0d;
                ActivityWaterIntakeCalc activityWaterIntakeCalc5 = ActivityWaterIntakeCalc.this;
                activityWaterIntakeCalc5.dwi_int = (int) activityWaterIntakeCalc5.dwi;
                ActivityWaterIntakeCalc activityWaterIntakeCalc6 = ActivityWaterIntakeCalc.this;
                activityWaterIntakeCalc6.str_dwi = String.valueOf(activityWaterIntakeCalc6.dwi_int);
                Intent intent = new Intent(ActivityWaterIntakeCalc.this, ActivityWaterIntakeResult.class);
//                intent.putExtra(ConditionalUserProperty.VALUE, ActivityWaterIntakeCalc.this.str_dwi);
                ActivityWaterIntakeCalc.this.startActivity(intent);
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(null);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        TextView text_title = findViewById(R.id.text_title);
        text_title.setText(getResources().getString(R.string.waterintake));
        ImageView img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        edWeight = findViewById(R.id.edWeight);
        edAge = findViewById(R.id.edAge);
        tvWeight = findViewById(R.id.tvWeight);
        tvAge = findViewById(R.id.tvAge);
        weightSp = findViewById(R.id.weightSp);
        primaryColor = ContextCompat.getColor(getApplicationContext(), R.color.orangecolorPrimary);

        ImageView img_age = findViewById(R.id.image_age);
        ImageView img_weight = findViewById(R.id.img_weight);

        setThemeColor(img_age);
        setThemeColor(img_weight);


    }


    public void setThemeColor(ImageView imageView) {
        imageView.getDrawable().setColorFilter(primaryColor, PorterDuff.Mode.SRC_IN);
    }
}
