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

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;


import java.util.Objects;

import static com.templatevilla.healthcalculator.util.Constant.getShapeDrawble;

public class ActivityBodyFatHome extends AppCompatActivity {
    double age;
    boolean check = false;
    EditText edAge;
    Spinner genderSp;
    int[] gender_img = {R.drawable.man, R.drawable.girl};
    public boolean male = true;
    TextView tvAge;
    TextView tvGender;
    Toolbar toolbar;

    public class MyAdapter1 extends ArrayAdapter<String> {
        MyAdapter1(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBodyFatHome.this.getResources().getString(R.string.male), ActivityBodyFatHome.this.getResources().getString(R.string.female)};
            View inflate = ActivityBodyFatHome.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyFatHome.this.gender_img[i]);
            return inflate;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.BlueTheme);

        setContentView(R.layout.act_body_fat_home);
        String[] strArr = {getResources().getString(R.string.male), getResources().getString(R.string.female)};
//
        findViewById(R.id.chart).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityBodyFatHome.this.startActivity(new Intent(ActivityBodyFatHome.this, ActivityChartFat.class));
            }
        });
        Button button = findViewById(R.id.calc);
        Button button2 = findViewById(R.id.reset);

        init();
        Button chart = findViewById(R.id.chart);
        button.setBackground(getShapeDrawble(false, primaryColor));
        button2.setBackground(getShapeDrawble(true, primaryColor));
        chart.setBackground(getShapeDrawble(false, primaryColor));


        genderSp.setAdapter(new MyAdapter1(this, R.layout.act_spinner_down_blue, strArr));


        genderSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ActivityBodyFatHome.this.male = ActivityBodyFatHome.this.genderSp.getSelectedItem().toString().equals(ActivityBodyFatHome.this.getResources().getString(R.string.male));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityBodyFatHome.this.edAge.setText("");
                ActivityBodyFatHome.this.edAge.requestFocus();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                try {
                    ActivityBodyFatHome.this.age = Double.parseDouble(ActivityBodyFatHome.this.edAge.getText().toString());
                } catch (NumberFormatException unused) {
                    ActivityBodyFatHome.this.check = true;
                }
                if (ActivityBodyFatHome.this.check) {
                    Toast.makeText(ActivityBodyFatHome.this.getApplicationContext(), ActivityBodyFatHome.this.getResources().getString(R.string.valid), Toast.LENGTH_SHORT).show();
                    ActivityBodyFatHome.this.check = false;
                } else if (ActivityBodyFatHome.this.male) {
                    ActivityBodyFatHome.this.startActivity(new Intent(ActivityBodyFatHome.this, ActivityBodyFatMale.class));
                } else {
                    ActivityBodyFatHome.this.startActivity(new Intent(ActivityBodyFatHome.this, ActivityBodyFatFem.class));
                }
            }
        });
    }

    int primaryColor;

    private void init() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(null);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        TextView text_title = findViewById(R.id.text_title);
        text_title.setText(getResources().getString(R.string.bodyfat));
        ImageView img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        edAge = findViewById(R.id.edAge);
        tvAge = findViewById(R.id.tvAge);
        tvGender = findViewById(R.id.tvGender);
        genderSp = findViewById(R.id.genderSp);

        primaryColor = ContextCompat.getColor(getApplicationContext(), R.color.bluecolorPrimary);
        ImageView img_age = findViewById(R.id.image_age);

        setThemeColor(img_age);


    }


    public void setThemeColor(ImageView imageView) {
        imageView.getDrawable().setColorFilter(primaryColor, PorterDuff.Mode.SRC_IN);
    }

}
