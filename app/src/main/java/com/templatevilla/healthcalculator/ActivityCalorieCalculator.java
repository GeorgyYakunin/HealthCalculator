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

import com.github.pdfviewer.PDFView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Objects;

import static com.templatevilla.healthcalculator.util.Constant.getShapeDrawble;
import static com.github.pdfviewer.PDFViewPager.VERTICAL;

public class ActivityCalorieCalculator extends AppCompatActivity {
    Spinner activitySp;
    int[] activity_img = {R.drawable.activity, R.drawable.activity, R.drawable.activity, R.drawable.activity, R.drawable.activity};
    double age;
    double bmr;
    Button chart;
    boolean check = false;
    public boolean cms = true;
    EditText edAge;
    EditText edHeight;
    EditText edHeight2;
    EditText edWeight;
    double factor = 0.0d;
    Spinner genderSp;
    LinearLayout tvInputHeight2;
    int[] gender_img = {R.drawable.man, R.drawable.girl};
    double height;
    double height2;
    Spinner heightSp;
    int[] height_img = {R.drawable.height, R.drawable.height};

    public boolean isKG = true;
    public boolean male = true;

    NumberFormat numberFormat;
    Button pdf;
    String str_bmr;
    TextView tvActivity;
    TextView tvAge;
    TextView tvGender;
    TextView tvHeight;
    TextView tvWeight;
    TextView tvcm;
    TextView tvin;
    double weight;
    Spinner weightSp;
    Toolbar toolbar;
    int[] weight_img = {R.drawable.weight, R.drawable.weight};

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
            String[] strArr = {ActivityCalorieCalculator.this.getResources().getString(R.string.male), ActivityCalorieCalculator.this.getResources().getString(R.string.female)};
            View inflate = ActivityCalorieCalculator.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityCalorieCalculator.this.gender_img[i]);
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
            String[] strArr = {ActivityCalorieCalculator.this.getResources().getString(R.string.centimeters), ActivityCalorieCalculator.this.getResources().getString(R.string.feets)};
            View inflate = ActivityCalorieCalculator.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityCalorieCalculator.this.height_img[i]);
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
            String[] strArr = {ActivityCalorieCalculator.this.getResources().getString(R.string.kilograms), ActivityCalorieCalculator.this.getResources().getString(R.string.pounds)};
            View inflate = ActivityCalorieCalculator.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityCalorieCalculator.this.weight_img[i]);
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
            String[] strArr = {ActivityCalorieCalculator.this.getResources().getString(R.string.sedentary), ActivityCalorieCalculator.this.getResources().getString(R.string.lightly_active), ActivityCalorieCalculator.this.getResources().getString(R.string.moderately_active), ActivityCalorieCalculator.this.getResources().getString(R.string.very_active), ActivityCalorieCalculator.this.getResources().getString(R.string.extremely_active)};
            View inflate = ActivityCalorieCalculator.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityCalorieCalculator.this.activity_img[i]);
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
        setContentView(R.layout.act_calorie_calc);
        String[] strArr = {getResources().getString(R.string.male), getResources().getString(R.string.female)};
        String[] strArr2 = {getResources().getString(R.string.centimeters), getResources().getString(R.string.feets)};
        String[] strArr3 = {getResources().getString(R.string.kilograms), getResources().getString(R.string.pounds)};
        String[] strArr4 = {getResources().getString(R.string.sedentary), getResources().getString(R.string.lightly_active), getResources().getString(R.string.moderately_active), getResources().getString(R.string.very_active), getResources().getString(R.string.extremely_active)};
//
        init();
        Button button = findViewById(R.id.calc);
        Button button2 = findViewById(R.id.reset);
        Button chart = findViewById(R.id.chart);
        Button pdf = findViewById(R.id.pdf);

        chart.setBackground(getShapeDrawble(false, primaryColor));
        pdf.setBackground(getShapeDrawble(false, primaryColor));
        button.setBackground(getShapeDrawble(false, primaryColor));
        button2.setBackground(getShapeDrawble(true, primaryColor));

        edHeight2.setEnabled(false);
        edHeight.setEnabled(true);
        tvcm.setText(getResources().getString(R.string.cm));
        tvin.setText("");
        tvInputHeight2.setVisibility(View.GONE);
        chart.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityCalorieCalculator.this.startActivity(new Intent(ActivityCalorieCalculator.this, ActivityCharCalorie.class));
            }
        });
        pdf.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                final String SAMPLE_FILE = "food_calorie_list.pdf";
                try {
                    File file = new File(getCacheDir(), SAMPLE_FILE);
                    if (!file.exists()) {

                        try {
                            InputStream asset = getAssets().open(SAMPLE_FILE);
                            FileOutputStream output;
                            output = new FileOutputStream(file);
                            final byte[] buffer = new byte[1024];
                            int size;
                            while ((size = asset.read(buffer)) != -1) {
                                output.write(buffer, 0, size);
                            }
                            asset.close();
                            output.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    PDFView.with(ActivityCalorieCalculator.this).setfilepath(file.getAbsolutePath())
                            .setSwipeOrientation(VERTICAL)
                            .start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);
        genderSp.setAdapter(new MyAdapter1(this, R.layout.act_spinner_down_blue, strArr));
        heightSp.setAdapter(new MyAdapter2(this, R.layout.act_spinner_down_blue, strArr2));
        weightSp.setAdapter(new MyAdapter3(this, R.layout.act_spinner_down_blue, strArr3));
        activitySp.setAdapter(new MyAdapter4(this, R.layout.act_spinner_down_blue, strArr4));


        heightSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (ActivityCalorieCalculator.this.heightSp.getSelectedItem().toString().equals(ActivityCalorieCalculator.this.getResources().getString(R.string.centimeters))) {
                    ActivityCalorieCalculator activityCalorieCalculator = ActivityCalorieCalculator.this;
                    activityCalorieCalculator.cms = true;
                    activityCalorieCalculator.edHeight.setEnabled(true);
                    ActivityCalorieCalculator.this.edHeight2.setEnabled(false);
                    ActivityCalorieCalculator.this.tvInputHeight2.setVisibility(View.GONE);
                    ActivityCalorieCalculator.this.tvcm.setText(ActivityCalorieCalculator.this.getResources().getString(R.string.cm));
                    ActivityCalorieCalculator.this.tvin.setText("");
                    return;
                }
                ActivityCalorieCalculator activityCalorieCalculator2 = ActivityCalorieCalculator.this;
                activityCalorieCalculator2.cms = false;
                activityCalorieCalculator2.edHeight.setEnabled(true);
                ActivityCalorieCalculator.this.edHeight2.setEnabled(true);
                ActivityCalorieCalculator.this.tvcm.setText(ActivityCalorieCalculator.this.getResources().getString(R.string.ft));
                ActivityCalorieCalculator.this.tvin.setText(ActivityCalorieCalculator.this.getResources().getString(R.string.in));
                ActivityCalorieCalculator.this.tvInputHeight2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        weightSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityCalorieCalculator.this.isKG = ActivityCalorieCalculator.this.weightSp.getSelectedItem().toString().equals(ActivityCalorieCalculator.this.getResources().getString(R.string.kilograms));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        activitySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String obj = ActivityCalorieCalculator.this.activitySp.getSelectedItem().toString();
                if (obj.equals(ActivityCalorieCalculator.this.getResources().getString(R.string.sedentary))) {
                    ActivityCalorieCalculator.this.factor = 1.2d;
                } else if (obj.equals(ActivityCalorieCalculator.this.getResources().getString(R.string.lightly_active))) {
                    ActivityCalorieCalculator.this.factor = 1.375d;
                } else if (obj.equals(ActivityCalorieCalculator.this.getResources().getString(R.string.moderately_active))) {
                    ActivityCalorieCalculator.this.factor = 1.55d;
                } else if (obj.equals(ActivityCalorieCalculator.this.getResources().getString(R.string.very_active))) {
                    ActivityCalorieCalculator.this.factor = 1.725d;
                } else {
                    ActivityCalorieCalculator.this.factor = 1.9d;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        genderSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityCalorieCalculator.this.male = ActivityCalorieCalculator.this.genderSp.getSelectedItem().toString().equals(ActivityCalorieCalculator.this.getResources().getString(R.string.male));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "";
                ActivityCalorieCalculator.this.edHeight.setText(str);
                ActivityCalorieCalculator.this.edWeight.setText(str);
                ActivityCalorieCalculator.this.edAge.setText(str);
                ActivityCalorieCalculator.this.edHeight2.setText(str);
                ActivityCalorieCalculator.this.edAge.requestFocus();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                try {
                    ActivityCalorieCalculator.this.height = Double.parseDouble(ActivityCalorieCalculator.this.edHeight.getText().toString());
                } catch (NumberFormatException unused) {
                    ActivityCalorieCalculator.this.check = true;
                }
                try {
                    ActivityCalorieCalculator.this.weight = Double.parseDouble(ActivityCalorieCalculator.this.edWeight.getText().toString());
                } catch (NumberFormatException unused2) {
                    ActivityCalorieCalculator.this.check = true;
                }
                try {
                    ActivityCalorieCalculator.this.age = Double.parseDouble(ActivityCalorieCalculator.this.edAge.getText().toString());
                } catch (NumberFormatException unused3) {
                    ActivityCalorieCalculator.this.check = true;
                }
                try {
                    ActivityCalorieCalculator.this.height2 = Double.parseDouble(ActivityCalorieCalculator.this.edHeight2.getText().toString());
                } catch (NumberFormatException unused4) {
                    ActivityCalorieCalculator.this.height2 = 0.0d;
                }
                if (ActivityCalorieCalculator.this.check) {
                    Toast.makeText(ActivityCalorieCalculator.this.getApplicationContext(), ActivityCalorieCalculator.this.getResources().getString(R.string.valid), Toast.LENGTH_SHORT).show();
                    ActivityCalorieCalculator.this.check = false;
                    return;
                }
                if (!ActivityCalorieCalculator.this.cms) {
                    ActivityCalorieCalculator.this.height *= 12.0d;
                    ActivityCalorieCalculator.this.height += ActivityCalorieCalculator.this.height2;
                    ActivityCalorieCalculator.this.height *= 2.54d;
                }
                if (!ActivityCalorieCalculator.this.isKG) {
                    ActivityCalorieCalculator.this.weight *= 0.453592d;
                }
                if (ActivityCalorieCalculator.this.male) {
                    ActivityCalorieCalculator.this.weight *= 13.7d;
                    ActivityCalorieCalculator.this.weight += 66.0d;
                    ActivityCalorieCalculator.this.height *= 5.0d;
                    ActivityCalorieCalculator.this.age *= 6.8d;
                } else {
                    ActivityCalorieCalculator.this.weight *= 9.6d;
                    ActivityCalorieCalculator.this.weight += 655.0d;
                    ActivityCalorieCalculator.this.height *= 1.8d;
                    ActivityCalorieCalculator.this.age *= 4.7d;
                }
                ActivityCalorieCalculator activityCalorieCalculator3 = ActivityCalorieCalculator.this;
                activityCalorieCalculator3.bmr = (activityCalorieCalculator3.weight + ActivityCalorieCalculator.this.height) - ActivityCalorieCalculator.this.age;
                ActivityCalorieCalculator.this.bmr *= ActivityCalorieCalculator.this.factor;
                ActivityCalorieCalculator activityCalorieCalculator4 = ActivityCalorieCalculator.this;
                activityCalorieCalculator4.str_bmr = activityCalorieCalculator4.numberFormat.format(ActivityCalorieCalculator.this.bmr);
                Intent intent = new Intent(ActivityCalorieCalculator.this, ActivityCalorieResult.class);
//                intent.putExtra(ConditionalUserProperty.VALUE, ActivityCalorieCalculator.this.str_bmr);
                ActivityCalorieCalculator.this.startActivity(intent);
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(null);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        TextView text_title = findViewById(R.id.text_title);
        text_title.setText(getResources().getString(R.string.calories));
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
        tvHeight = findViewById(R.id.tvHeight);
        tvWeight = findViewById(R.id.tvWeight);
        tvAge = findViewById(R.id.tvAge);
        tvGender = findViewById(R.id.tvGender);
        tvcm = findViewById(R.id.tvcm);
        tvin = findViewById(R.id.tvin);
        tvActivity = findViewById(R.id.tvActivity);
        weightSp = findViewById(R.id.weightSp);
        heightSp = findViewById(R.id.heightSp);
        genderSp = findViewById(R.id.genderSp);
        activitySp = findViewById(R.id.activitySp);
        tvInputHeight2 = findViewById(R.id.tvInputHeight2);
        chart = findViewById(R.id.chart);
        pdf = findViewById(R.id.pdf);


        primaryColor = ContextCompat.getColor(getApplicationContext(), R.color.graycolorPrimary);

        ImageView img_age = findViewById(R.id.image_age);
        ImageView img_height = findViewById(R.id.img_height);
        ImageView img_centimeter = findViewById(R.id.img_centimeter);
        ImageView img_inch = findViewById(R.id.img_inch);
        ImageView img_weight = findViewById(R.id.img_weight);
        ImageView img_activity = findViewById(R.id.img_activity);
        setThemeColor(img_age);
        setThemeColor(img_height);
        setThemeColor(img_centimeter);
        setThemeColor(img_inch);
        setThemeColor(img_weight);
        setThemeColor(img_activity);


    }

    public void setThemeColor(ImageView imageView) {
        imageView.getDrawable().setColorFilter(primaryColor, PorterDuff.Mode.SRC_IN);
    }
}
