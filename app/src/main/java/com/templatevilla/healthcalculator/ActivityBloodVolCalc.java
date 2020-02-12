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

public class ActivityBloodVolCalc extends AppCompatActivity {

    double bloodVol;
    boolean check = false;
    public boolean cms = true;
    EditText edHeight;
    EditText edHeight2;
    EditText edWeight;
    Spinner genderSp;
    int[] gender_img = {R.drawable.man, R.drawable.girl};
    double height;
    double height2;
    Spinner heightSp;
    int[] height_img = {R.drawable.height, R.drawable.height};

    public boolean isKG = true;
    LinearLayout tvInputHeight2;
    public boolean male = true;

    NumberFormat numberFormat;
    String str_bv;
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
            String[] strArr = {ActivityBloodVolCalc.this.getResources().getString(R.string.male), ActivityBloodVolCalc.this.getResources().getString(R.string.female)};
            View inflate = ActivityBloodVolCalc.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBloodVolCalc.this.gender_img[i]);
            return inflate;
        }
    }

    public class MyAdapter2 extends ArrayAdapter<String> {
        MyAdapter2(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view,@Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view,@Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBloodVolCalc.this.getResources().getString(R.string.centimeters), ActivityBloodVolCalc.this.getResources().getString(R.string.feets)};
            View inflate = ActivityBloodVolCalc.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBloodVolCalc.this.height_img[i]);
            return inflate;
        }
    }

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
            String[] strArr = {ActivityBloodVolCalc.this.getResources().getString(R.string.kilograms), ActivityBloodVolCalc.this.getResources().getString(R.string.pounds)};
            View inflate = ActivityBloodVolCalc.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBloodVolCalc.this.weight_img[i]);
            return inflate;
        }
    }

    int primaryColor;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.CyanTheme);
        setContentView(R.layout.act_blood_volume);
        String[] strArr = {getResources().getString(R.string.male), getResources().getString(R.string.female)};
        String[] strArr2 = {getResources().getString(R.string.centimeters), getResources().getString(R.string.feets)};
        String[] strArr3 = {getResources().getString(R.string.kilograms), getResources().getString(R.string.pounds)};
//
        Button button = findViewById(R.id.calc);
        Button button2 = findViewById(R.id.reset);
        init();


        button.setBackground(getShapeDrawble(false, primaryColor));
        button2.setBackground(getShapeDrawble(true, primaryColor));
        edHeight2.setEnabled(false);
        edHeight.setEnabled(true);
        tvcm.setText(getResources().getString(R.string.cm));
        tvin.setText("");
        tvInputHeight2.setVisibility(View.GONE);
        numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);
        genderSp.setAdapter(new MyAdapter1(this, R.layout.act_spinner_down_blue, strArr));

        heightSp.setAdapter(new MyAdapter2(this, R.layout.act_spinner_down_blue, strArr2));

        weightSp.setAdapter(new MyAdapter3(this, R.layout.act_spinner_down_blue, strArr3));


        heightSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (ActivityBloodVolCalc.this.heightSp.getSelectedItem().toString().equals(ActivityBloodVolCalc.this.getResources().getString(R.string.centimeters))) {
                    ActivityBloodVolCalc activityBloodVolCalc = ActivityBloodVolCalc.this;
                    activityBloodVolCalc.cms = true;
                    activityBloodVolCalc.edHeight.setEnabled(true);
                    ActivityBloodVolCalc.this.edHeight2.setEnabled(false);
                    ActivityBloodVolCalc.this.tvInputHeight2.setVisibility(View.GONE);
                    ActivityBloodVolCalc.this.tvcm.setText(ActivityBloodVolCalc.this.getResources().getString(R.string.cm));
                    ActivityBloodVolCalc.this.tvin.setText("");
                    return;
                }
                ActivityBloodVolCalc activityBloodVolCalc2 = ActivityBloodVolCalc.this;
                activityBloodVolCalc2.cms = false;
                activityBloodVolCalc2.edHeight.setEnabled(true);
                ActivityBloodVolCalc.this.edHeight2.setEnabled(true);
                ActivityBloodVolCalc.this.tvcm.setText(ActivityBloodVolCalc.this.getResources().getString(R.string.ft));
                ActivityBloodVolCalc.this.tvin.setText(ActivityBloodVolCalc.this.getResources().getString(R.string.in));
                ActivityBloodVolCalc.this.edHeight2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        weightSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityBloodVolCalc.this.isKG = ActivityBloodVolCalc.this.weightSp.getSelectedItem().toString().equals(ActivityBloodVolCalc.this.getResources().getString(R.string.kilograms));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        genderSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityBloodVolCalc.this.male = ActivityBloodVolCalc.this.genderSp.getSelectedItem().toString().equals(ActivityBloodVolCalc.this.getResources().getString(R.string.male));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "";
                ActivityBloodVolCalc.this.edHeight.setText(str);
                ActivityBloodVolCalc.this.edWeight.setText(str);
                ActivityBloodVolCalc.this.edHeight2.setText(str);
                ActivityBloodVolCalc.this.edHeight.requestFocus();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                try {
                    ActivityBloodVolCalc.this.height = Double.parseDouble(ActivityBloodVolCalc.this.edHeight.getText().toString());
                } catch (NumberFormatException unused) {
                    ActivityBloodVolCalc.this.check = true;
                }
                try {
                    ActivityBloodVolCalc.this.weight = Double.parseDouble(ActivityBloodVolCalc.this.edWeight.getText().toString());
                } catch (NumberFormatException unused2) {
                    ActivityBloodVolCalc.this.check = true;
                }
                try {
                    ActivityBloodVolCalc.this.height2 = Double.parseDouble(ActivityBloodVolCalc.this.edHeight2.getText().toString());
                } catch (NumberFormatException unused3) {
                    ActivityBloodVolCalc.this.height2 = 0.0d;
                }
                if (ActivityBloodVolCalc.this.check) {
                    Toast.makeText(ActivityBloodVolCalc.this.getApplicationContext(), ActivityBloodVolCalc.this.getResources().getString(R.string.valid), Toast.LENGTH_SHORT).show();
                    ActivityBloodVolCalc.this.check = false;
                    return;
                }
                if (ActivityBloodVolCalc.this.cms) {
                    ActivityBloodVolCalc.this.height /= 100.0d;
                } else {
                    ActivityBloodVolCalc.this.height *= 12.0d;
                    ActivityBloodVolCalc.this.height += ActivityBloodVolCalc.this.height2;
                    ActivityBloodVolCalc.this.height *= 2.54d;
                    ActivityBloodVolCalc.this.height /= 100.0d;
                }
                if (!ActivityBloodVolCalc.this.isKG) {
                    ActivityBloodVolCalc.this.weight *= 0.453592d;
                }
                if (ActivityBloodVolCalc.this.male) {
                    ActivityBloodVolCalc.this.weight *= 0.03219d;
                    ActivityBloodVolCalc.this.weight += 0.6041d;
                    ActivityBloodVolCalc activityBloodVolCalc2 = ActivityBloodVolCalc.this;
                    activityBloodVolCalc2.height = activityBloodVolCalc2.height * ActivityBloodVolCalc.this.height * ActivityBloodVolCalc.this.height;
                    ActivityBloodVolCalc.this.height *= 0.3669d;
                } else {
                    ActivityBloodVolCalc.this.weight *= 0.03308d;
                    ActivityBloodVolCalc.this.weight += 0.1833d;
                    ActivityBloodVolCalc activityBloodVolCalc3 = ActivityBloodVolCalc.this;
                    activityBloodVolCalc3.height = activityBloodVolCalc3.height * ActivityBloodVolCalc.this.height * ActivityBloodVolCalc.this.height;
                    ActivityBloodVolCalc.this.height *= 0.3561d;
                }
                ActivityBloodVolCalc activityBloodVolCalc4 = ActivityBloodVolCalc.this;
                activityBloodVolCalc4.bloodVol = activityBloodVolCalc4.weight + ActivityBloodVolCalc.this.height;
                ActivityBloodVolCalc activityBloodVolCalc5 = ActivityBloodVolCalc.this;
                activityBloodVolCalc5.str_bv = activityBloodVolCalc5.numberFormat.format(ActivityBloodVolCalc.this.bloodVol);
                Intent intent = new Intent(ActivityBloodVolCalc.this, ActivityBloodVolResult.class);
//                intent.putExtra(ConditionalUserProperty.VALUE, ActivityBloodVolCalc.this.str_bv);
                ActivityBloodVolCalc.this.startActivity(intent);
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(null);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        TextView text_title = findViewById(R.id.text_title);
        text_title.setText(getResources().getString(R.string.bloodvol));
        ImageView img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        edHeight = findViewById(R.id.edHeight);
        edWeight = findViewById(R.id.edWeight);
        edHeight2 = findViewById(R.id.edHeight2);
        tvInputHeight2 = findViewById(R.id.tvInputHeight2);
        tvHeight = findViewById(R.id.tvHeight);
        tvWeight = findViewById(R.id.tvWeight);
        tvGender = findViewById(R.id.tvGender);
        tvcm = findViewById(R.id.tvcm);
        tvin = findViewById(R.id.tvin);
        weightSp = findViewById(R.id.weightSp);
        heightSp = findViewById(R.id.heightSp);
        genderSp = findViewById(R.id.genderSp);


        primaryColor = ContextCompat.getColor(getApplicationContext(), R.color.cyancolorPrimary);
        ImageView img_age = findViewById(R.id.image_age);
        ImageView img_height = findViewById(R.id.img_height);
        ImageView img_centimeter = findViewById(R.id.img_centimeter);
        ImageView img_inch = findViewById(R.id.img_inch);
        ImageView img_weight = findViewById(R.id.img_weight);
        setThemeColor(img_age);
        setThemeColor(img_height);
        setThemeColor(img_centimeter);
        setThemeColor(img_inch);
        setThemeColor(img_weight);

    }


    public void setThemeColor(ImageView imageView) {
        imageView.getDrawable().setColorFilter(primaryColor, PorterDuff.Mode.SRC_IN);
    }

}
