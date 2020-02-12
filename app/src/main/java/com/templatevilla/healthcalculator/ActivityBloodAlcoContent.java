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


import java.text.NumberFormat;
import java.util.Objects;

import static com.templatevilla.healthcalculator.util.Constant.getShapeDrawble;

public class ActivityBloodAlcoContent extends AppCompatActivity {
    double alcohollevel;
    double bac;
    boolean check = false;
    EditText edAlcoholLevel;
    EditText edTime;
    EditText edVolDrinked;
    EditText edWeight;
    int factor = 0;
    int factor2 = 0;
    Spinner genderSp;
    int[] gender_img = {R.drawable.man, R.drawable.girl};

    /* renamed from: kg */
    public boolean kgs = true;
    public boolean male = true;

    /* renamed from: nf */
    NumberFormat numberFormat;
    String str_bac;
    double time;
    Spinner timeSp;
    int[] time_img = {R.drawable.time, R.drawable.time, R.drawable.time};
    TextView tvAlcoholLevel;
    TextView tvGender;
    TextView tvPercent;
    TextView tvTime;
    TextView tvVolDrinked;
    TextView tvWeight;
    double volDrinked;
    int[] vol_img = {R.drawable.volume, R.drawable.volume, R.drawable.volume};
    Spinner volumeSp;
    double weight;
    Spinner weightSp;
    int[] weight_img = {R.drawable.weight, R.drawable.weight};
    Toolbar toolbar;


    public class MyAdapter1 extends ArrayAdapter<String> {
        public MyAdapter1(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBloodAlcoContent.this.getResources().getString(R.string.male), ActivityBloodAlcoContent.this.getResources().getString(R.string.female)};
            View inflate = ActivityBloodAlcoContent.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBloodAlcoContent.this.gender_img[i]);
            return inflate;
        }
    }

    public class MyAdapter2 extends ArrayAdapter<String> {
        MyAdapter2(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBloodAlcoContent.this.getResources().getString(R.string.ounces), ActivityBloodAlcoContent.this.getResources().getString(R.string.ml), ActivityBloodAlcoContent.this.getResources().getString(R.string.cup)};
            View inflate = ActivityBloodAlcoContent.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBloodAlcoContent.this.vol_img[i]);
            return inflate;
        }
    }

    public class MyAdapter3 extends ArrayAdapter<String> {
        MyAdapter3(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBloodAlcoContent.this.getResources().getString(R.string.kilograms), ActivityBloodAlcoContent.this.getResources().getString(R.string.pounds)};
            View inflate = ActivityBloodAlcoContent.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBloodAlcoContent.this.weight_img[i]);
            return inflate;
        }
    }

    public class MyAdapter4 extends ArrayAdapter<String> {
        MyAdapter4(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBloodAlcoContent.this.getResources().getString(R.string.hour), ActivityBloodAlcoContent.this.getResources().getString(R.string.minute), ActivityBloodAlcoContent.this.getResources().getString(R.string.day)};
            View inflate = ActivityBloodAlcoContent.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBloodAlcoContent.this.time_img[i]);
            return inflate;
        }
    }

    int primaryColor;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.GrayTheme);
        setContentView(R.layout.act_blood_alco_calc);
        String[] strArr = {getResources().getString(R.string.male), getResources().getString(R.string.female)};
        String[] strArr2 = {getResources().getString(R.string.kilograms), getResources().getString(R.string.pounds)};
        String[] strArr3 = {getResources().getString(R.string.hour), getResources().getString(R.string.minute), getResources().getString(R.string.day)};
        String[] strArr4 = {getResources().getString(R.string.ounces), getResources().getString(R.string.ml), getResources().getString(R.string.cup)};

        Button button = findViewById(R.id.calc);
        Button button2 = findViewById(R.id.reset);
        Button chart = findViewById(R.id.chart);

        init();


        chart.setBackground(getShapeDrawble(false, primaryColor));
        button.setBackground(getShapeDrawble(false, primaryColor));
        button2.setBackground(getShapeDrawble(true, primaryColor));


        numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(3);
        genderSp.setAdapter(new MyAdapter1(this, R.layout.act_spinner_down_blue, strArr));
        volumeSp.setAdapter(new MyAdapter2(this, R.layout.act_spinner_down_blue, strArr4));
        weightSp.setAdapter(new MyAdapter3(this, R.layout.act_spinner_down_blue, strArr2));
        timeSp.setAdapter(new MyAdapter4(this, R.layout.act_spinner_down_blue, strArr3));
        findViewById(R.id.chart).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityBloodAlcoContent.this.startActivity(new Intent(ActivityBloodAlcoContent.this, ActivityChartAlcohol.class));
            }
        });


        weightSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityBloodAlcoContent.this.kgs = ActivityBloodAlcoContent.this.weightSp.getSelectedItem().toString().equals(ActivityBloodAlcoContent.this.getResources().getString(R.string.kilograms));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        genderSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityBloodAlcoContent.this.male = ActivityBloodAlcoContent.this.genderSp.getSelectedItem().toString().equals(ActivityBloodAlcoContent.this.getResources().getString(R.string.male));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        volumeSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String obj = ActivityBloodAlcoContent.this.volumeSp.getSelectedItem().toString();
                if (obj.equals(ActivityBloodAlcoContent.this.getResources().getString(R.string.ounces))) {
                    ActivityBloodAlcoContent.this.factor = 1;
                } else if (obj.equals(ActivityBloodAlcoContent.this.getResources().getString(R.string.ml))) {
                    ActivityBloodAlcoContent.this.factor = 2;
                } else {
                    ActivityBloodAlcoContent.this.factor = 3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        timeSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String obj = ActivityBloodAlcoContent.this.timeSp.getSelectedItem().toString();
                if (obj.equals(ActivityBloodAlcoContent.this.getResources().getString(R.string.hour))) {
                    ActivityBloodAlcoContent.this.factor2 = 1;
                } else if (obj.equals(ActivityBloodAlcoContent.this.getResources().getString(R.string.minute))) {
                    ActivityBloodAlcoContent.this.factor2 = 2;
                } else {
                    ActivityBloodAlcoContent.this.factor2 = 3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "";
                ActivityBloodAlcoContent.this.edAlcoholLevel.setText(str);
                ActivityBloodAlcoContent.this.edWeight.setText(str);
                ActivityBloodAlcoContent.this.edTime.setText(str);
                ActivityBloodAlcoContent.this.edAlcoholLevel.requestFocus();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                try {
                    ActivityBloodAlcoContent.this.alcohollevel = Double.parseDouble(ActivityBloodAlcoContent.this.edAlcoholLevel.getText().toString());
                } catch (NumberFormatException unused) {
                    ActivityBloodAlcoContent.this.check = true;
                }
                try {
                    ActivityBloodAlcoContent.this.volDrinked = Double.parseDouble(ActivityBloodAlcoContent.this.edVolDrinked.getText().toString());
                } catch (NumberFormatException unused2) {
                    ActivityBloodAlcoContent.this.check = true;
                }
                try {
                    ActivityBloodAlcoContent.this.weight = Double.parseDouble(ActivityBloodAlcoContent.this.edWeight.getText().toString());
                } catch (NumberFormatException unused3) {
                    ActivityBloodAlcoContent.this.check = true;
                }
                try {
                    ActivityBloodAlcoContent.this.time = Double.parseDouble(ActivityBloodAlcoContent.this.edTime.getText().toString());
                } catch (NumberFormatException unused4) {
                    ActivityBloodAlcoContent.this.check = true;
                }
                if (ActivityBloodAlcoContent.this.check) {
                    Toast.makeText(ActivityBloodAlcoContent.this.getApplicationContext(), ActivityBloodAlcoContent.this.getResources().getString(R.string.valid), Toast.LENGTH_SHORT).show();
                    ActivityBloodAlcoContent.this.check = false;
                    return;
                }
                if (ActivityBloodAlcoContent.this.kgs) {
                    ActivityBloodAlcoContent.this.weight *= 2.20462d;
                } else {
                }
                if (ActivityBloodAlcoContent.this.factor == 1) {
                } else if (ActivityBloodAlcoContent.this.factor == 2) {
                    ActivityBloodAlcoContent.this.volDrinked *= 0.033814d;
                } else {
                    ActivityBloodAlcoContent.this.volDrinked *= 8.0d;
                }
                ActivityBloodAlcoContent.this.alcohollevel /= 100.0d;
                ActivityBloodAlcoContent.this.volDrinked *= ActivityBloodAlcoContent.this.alcohollevel;
                if (ActivityBloodAlcoContent.this.factor2 == 1) {
                } else if (ActivityBloodAlcoContent.this.factor2 == 2) {
                    ActivityBloodAlcoContent.this.time *= 0.0166d;
                } else {
                    ActivityBloodAlcoContent.this.time *= 24.0d;
                }
                ActivityBloodAlcoContent activityBloodAlcoContent4 = ActivityBloodAlcoContent.this;
                activityBloodAlcoContent4.weight = 5.14d / activityBloodAlcoContent4.weight;
                ActivityBloodAlcoContent.this.time *= 0.015d;
                if (ActivityBloodAlcoContent.this.male) {
                    ActivityBloodAlcoContent activityBloodAlcoContent5 = ActivityBloodAlcoContent.this;
                    activityBloodAlcoContent5.bac = ((activityBloodAlcoContent5.volDrinked * ActivityBloodAlcoContent.this.weight) * 0.73d) - ActivityBloodAlcoContent.this.time;
                } else {
                    ActivityBloodAlcoContent activityBloodAlcoContent6 = ActivityBloodAlcoContent.this;
                    activityBloodAlcoContent6.bac = ((activityBloodAlcoContent6.volDrinked * ActivityBloodAlcoContent.this.weight) * 0.66d) - ActivityBloodAlcoContent.this.time;
                }
                ActivityBloodAlcoContent activityBloodAlcoContent7 = ActivityBloodAlcoContent.this;
                activityBloodAlcoContent7.str_bac = activityBloodAlcoContent7.numberFormat.format(ActivityBloodAlcoContent.this.bac);
                Intent intent = new Intent(ActivityBloodAlcoContent.this, ActivityBloodAlcoResult.class);
                ActivityBloodAlcoContent.this.startActivity(intent);
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(null);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        TextView text_title = findViewById(R.id.text_title);
        text_title.setText(getResources().getString(R.string.bloodalcohol));
        ImageView img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        edTime = findViewById(R.id.edTime);
        edWeight = findViewById(R.id.edWeight);
        edAlcoholLevel = findViewById(R.id.edAlcoholLevel);
        edVolDrinked = findViewById(R.id.edVolDrinked);
        tvPercent = findViewById(R.id.tvPercent);
        tvWeight = findViewById(R.id.tvWeight);
        tvVolDrinked = findViewById(R.id.tvVolDrinked);
        tvGender = findViewById(R.id.tvGender);
        tvAlcoholLevel = findViewById(R.id.tvAlcoholLevel);
        tvTime = findViewById(R.id.tvTime);
        weightSp = findViewById(R.id.weightSp);
        volumeSp = findViewById(R.id.volumeSp);
        genderSp = findViewById(R.id.genderSp);
        timeSp = findViewById(R.id.timeSp);
        primaryColor = ContextCompat.getColor(getApplicationContext(), R.color.graycolorPrimary);


        ImageView img_gender = findViewById(R.id.img_gender);
        ImageView img_cocktail = findViewById(R.id.img_cocktail);
        ImageView img_drink = findViewById(R.id.img_drink);
        ImageView img_time = findViewById(R.id.img_time);
        ImageView img_weight = findViewById(R.id.img_weight);

        setThemeColor(img_cocktail);
        setThemeColor(img_gender);
        setThemeColor(img_drink);
        setThemeColor(img_time);
        setThemeColor(img_weight);


    }


    public void setThemeColor(ImageView imageView) {
        imageView.getDrawable().setColorFilter(primaryColor, PorterDuff.Mode.SRC_IN);
    }

}
