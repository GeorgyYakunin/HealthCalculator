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

import android.widget.LinearLayout;
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

public class ActivityBodyMassIndex extends AppCompatActivity {
    double age;
    double bmi;
    Button chart;
    boolean check = false;
    public boolean cms = true;
    EditText edAge;
    EditText edHeight;
    EditText edHeight2;
    LinearLayout tvInputHeight2;
    EditText edWeight;
    Spinner genderSp;
    int[] gender_img = {R.drawable.man, R.drawable.girl};
    double height;
    double height2;
    Spinner heightSp;
    int[] height_img = {R.drawable.height, R.drawable.height};
    public boolean isKG = true;
    NumberFormat numberFormat;
    String str_bmi;
    TextView tvAge;
    TextView tvGender;
    TextView tvHeight;
    TextView tvWeight;
    TextView tvcm;
    TextView tvin;
    double weight;
    Spinner weightSp;
    int[] weight_img = {R.drawable.weight, R.drawable.weight};
    Toolbar toolbar;

    public class MyAdapter1 extends ArrayAdapter<String> {
        MyAdapter1(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, @Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, @Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBodyMassIndex.this.getResources().getString(R.string.male), ActivityBodyMassIndex.this.getResources().getString(R.string.female)};
            View inflate = ActivityBodyMassIndex.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyMassIndex.this.gender_img[i]);
            return inflate;
        }
    }

    int primaryColor;

    public class MyAdapter2 extends ArrayAdapter<String> {
        MyAdapter2(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, @Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, @Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBodyMassIndex.this.getResources().getString(R.string.centimeters), ActivityBodyMassIndex.this.getResources().getString(R.string.feets)};
            View inflate = ActivityBodyMassIndex.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyMassIndex.this.height_img[i]);
            return inflate;
        }
    }

    public class MyAdapter3 extends ArrayAdapter<String> {
        MyAdapter3(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, @Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, @Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBodyMassIndex.this.getResources().getString(R.string.kilograms), ActivityBodyMassIndex.this.getResources().getString(R.string.pounds)};
            View inflate = ActivityBodyMassIndex.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyMassIndex.this.weight_img[i]);
            return inflate;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.BlueTheme);
        setContentView(R.layout.act_body_mass_index);

        String[] strArr = {getResources().getString(R.string.male), getResources().getString(R.string.female)};
        String[] strArr2 = {getResources().getString(R.string.centimeters), getResources().getString(R.string.feets)};
        String[] strArr3 = {getResources().getString(R.string.kilograms), getResources().getString(R.string.pounds)};
//
        init();
        Button button = findViewById(R.id.calc);
        Button button2 = findViewById(R.id.reset);
        Button chart = findViewById(R.id.chart);
        button.setBackground(getShapeDrawble(false, primaryColor));
        button2.setBackground(getShapeDrawble(true, primaryColor));
        chart.setBackground(getShapeDrawble(false, primaryColor));

        edHeight2.setEnabled(false);
        edHeight.setEnabled(true);
        tvcm.setText(getResources().getString(R.string.cm));
        tvin.setText("");
        tvInputHeight2.setVisibility(View.GONE);
        chart = findViewById(R.id.chart);
        chart.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityBodyMassIndex.this.startActivity(new Intent(ActivityBodyMassIndex.this, ActivityChart.class));
            }
        });
        numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);


        genderSp.setAdapter(new MyAdapter1(this, R.layout.act_spinner_down_blue, strArr));


        heightSp.setAdapter(new MyAdapter2(this, R.layout.act_spinner_down_blue, strArr2));

        weightSp.setAdapter(new MyAdapter3(this, R.layout.act_spinner_down_blue, strArr3));


        heightSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (ActivityBodyMassIndex.this.heightSp.getSelectedItem().toString().equals(ActivityBodyMassIndex.this.getResources().getString(R.string.centimeters))) {
                    ActivityBodyMassIndex activityBodyMassIndex = ActivityBodyMassIndex.this;
                    activityBodyMassIndex.cms = true;
                    activityBodyMassIndex.edHeight.setEnabled(true);
                    ActivityBodyMassIndex.this.edHeight2.setEnabled(false);
                    ActivityBodyMassIndex.this.tvInputHeight2.setVisibility(View.GONE);
                    ActivityBodyMassIndex.this.tvcm.setText(ActivityBodyMassIndex.this.getResources().getString(R.string.cm));
                    ActivityBodyMassIndex.this.tvin.setText("");
                    return;
                }
                ActivityBodyMassIndex activityBodyMassIndex2 = ActivityBodyMassIndex.this;
                activityBodyMassIndex2.cms = false;
                activityBodyMassIndex2.edHeight.setEnabled(true);
                ActivityBodyMassIndex.this.edHeight2.setEnabled(true);
                ActivityBodyMassIndex.this.tvcm.setText(ActivityBodyMassIndex.this.getResources().getString(R.string.ft));
                ActivityBodyMassIndex.this.tvin.setText(ActivityBodyMassIndex.this.getResources().getString(R.string.in));
                ActivityBodyMassIndex.this.tvInputHeight2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        weightSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityBodyMassIndex.this.isKG = ActivityBodyMassIndex.this.weightSp.getSelectedItem().toString().equals(ActivityBodyMassIndex.this.getResources().getString(R.string.kilograms));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "";
                ActivityBodyMassIndex.this.edHeight.setText(str);
                ActivityBodyMassIndex.this.edWeight.setText(str);
                ActivityBodyMassIndex.this.edAge.setText(str);
                ActivityBodyMassIndex.this.edHeight2.setText(str);
                ActivityBodyMassIndex.this.edAge.requestFocus();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                try {
                    ActivityBodyMassIndex.this.height = Double.parseDouble(ActivityBodyMassIndex.this.edHeight.getText().toString());
                } catch (NumberFormatException unused) {
                    ActivityBodyMassIndex.this.check = true;
                }
                try {
                    ActivityBodyMassIndex.this.weight = Double.parseDouble(ActivityBodyMassIndex.this.edWeight.getText().toString());
                } catch (NumberFormatException unused2) {
                    ActivityBodyMassIndex.this.check = true;
                }
                try {
                    ActivityBodyMassIndex.this.age = Double.parseDouble(ActivityBodyMassIndex.this.edAge.getText().toString());
                } catch (NumberFormatException unused3) {
                    ActivityBodyMassIndex.this.check = true;
                }
                try {
                    ActivityBodyMassIndex.this.height2 = Double.parseDouble(ActivityBodyMassIndex.this.edHeight2.getText().toString());
                } catch (NumberFormatException unused4) {
                    ActivityBodyMassIndex.this.height2 = 0.0d;
                }
                if (ActivityBodyMassIndex.this.check) {
                    Toast.makeText(ActivityBodyMassIndex.this.getApplicationContext(), ActivityBodyMassIndex.this.getResources().getString(R.string.valid), Toast.LENGTH_SHORT).show();
                    ActivityBodyMassIndex.this.check = false;
                    return;
                }
                if (ActivityBodyMassIndex.this.cms) {
                    ActivityBodyMassIndex.this.height /= 100.0d;
                } else {
                    ActivityBodyMassIndex.this.height *= 12.0d;
                    ActivityBodyMassIndex.this.height += ActivityBodyMassIndex.this.height2;
                    ActivityBodyMassIndex.this.height *= 0.0254d;
                }

                if (!ActivityBodyMassIndex.this.isKG) {
                    ActivityBodyMassIndex.this.weight *= 0.453592d;
                }
                ActivityBodyMassIndex activityBodyMassIndex2 = ActivityBodyMassIndex.this;
                activityBodyMassIndex2.bmi = (activityBodyMassIndex2.weight / (ActivityBodyMassIndex.this.height * ActivityBodyMassIndex.this.height));
                ActivityBodyMassIndex activityBodyMassIndex3 = ActivityBodyMassIndex.this;
                activityBodyMassIndex3.str_bmi = activityBodyMassIndex3.numberFormat.format(ActivityBodyMassIndex.this.bmi);
                Intent intent = new Intent(ActivityBodyMassIndex.this, ActivityResult.class);
//                intent.putExtra(ConditionalUserProperty.VALUE, ActivityBodyMassIndex.this.str_bmi);
                ActivityBodyMassIndex.this.startActivity(intent);
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(null);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        TextView text_title = findViewById(R.id.text_title);
        text_title.setText(getResources().getString(R.string.bmi_title));
        ImageView img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        edHeight = findViewById(R.id.edHeight);
        edWeight = findViewById(R.id.edWeight);
        edAge = findViewById(R.id.edAge);
        edHeight2 = findViewById(R.id.edHeight2);
        tvInputHeight2 = findViewById(R.id.tvInputHeight2);
        edHeight2 = findViewById(R.id.edHeight2);
        tvHeight = findViewById(R.id.tvHeight);
        tvWeight = findViewById(R.id.tvWeight);
        tvAge = findViewById(R.id.tvAge);
        tvGender = findViewById(R.id.tvGender);
        tvcm = findViewById(R.id.tvcm);
        tvin = findViewById(R.id.tvin);
        weightSp = findViewById(R.id.weightSp);
        heightSp = findViewById(R.id.heightSp);
        genderSp = findViewById(R.id.genderSp);
        tvInputHeight2.setVisibility(View.GONE);

        primaryColor = ContextCompat.getColor(getApplicationContext(), R.color.bluecolorPrimary);
        ImageView img_age = findViewById(R.id.image_age);
        ImageView img_height = findViewById(R.id.img_height);
        ImageView img_centimeter = findViewById(R.id.img_centimeter);
        ImageView img_inch = findViewById(R.id.img_inch);
        ImageView img_weight = findViewById(R.id.img_weight);
        setThemeColor(img_age);
        setThemeColor(img_height);
        setThemeColor(img_centimeter);
        setThemeColor(img_weight);
        setThemeColor(img_inch);


    }

    public void setThemeColor(ImageView imageView) {
        imageView.getDrawable().setColorFilter(primaryColor, PorterDuff.Mode.SRC_IN);
    }

}
