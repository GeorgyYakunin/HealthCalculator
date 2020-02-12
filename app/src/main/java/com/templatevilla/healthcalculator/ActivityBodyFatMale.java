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

import static com.templatevilla.healthcalculator.util.Constant.getShapeDrawble;

public class ActivityBodyFatMale extends AppCompatActivity {

    double bf;
    boolean check = false;
    public boolean cms = true;
    public boolean cms2 = true;
    public boolean cms3 = true;
    EditText edHeight;
    EditText edHeight2;
    LinearLayout tvInputHeight2;
    EditText edNeck;
    EditText edWaist;
    EditText edWeight;
    double height;
    double height2;
    Spinner heightSp;
    int[] height_img = {R.drawable.height, R.drawable.height};

    public boolean isKG = true;
    double neck;
    Spinner neckSp;
    int[] neck_img = {R.drawable.height, R.drawable.height};

    NumberFormat numberFormat;
    double result1;
    double result2;
    String str_assess;
    String str_bf;
    TextView tvHeight;
    TextView tvNeck;
    TextView tvWaist;
    TextView tvWeight;
    TextView tvcm;
    TextView tvin;
    double waist;
    Spinner waistSp;
    int[] waist_img = {R.drawable.height, R.drawable.height};
    double weight;
    Spinner weightSp;
    int[] weight_img = {R.drawable.weight, R.drawable.weight};
    Toolbar toolbar;

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
            String[] strArr = {ActivityBodyFatMale.this.getResources().getString(R.string.centimeters), ActivityBodyFatMale.this.getResources().getString(R.string.feets)};
            View inflate = ActivityBodyFatMale.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyFatMale.this.height_img[i]);
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
            String[] strArr = {ActivityBodyFatMale.this.getResources().getString(R.string.kilograms), ActivityBodyFatMale.this.getResources().getString(R.string.pounds)};
            View inflate = ActivityBodyFatMale.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyFatMale.this.weight_img[i]);
            return inflate;
        }
    }

    public class MyAdapter4 extends ArrayAdapter<String> {
        MyAdapter4(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, @Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, @Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBodyFatMale.this.getResources().getString(R.string.centimeters), ActivityBodyFatMale.this.getResources().getString(R.string.feets)};
            View inflate = ActivityBodyFatMale.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyFatMale.this.waist_img[i]);
            return inflate;
        }
    }

    public class MyAdapter5 extends ArrayAdapter<String> {
        MyAdapter5(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, @Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, @Nullable ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBodyFatMale.this.getResources().getString(R.string.centimeters), ActivityBodyFatMale.this.getResources().getString(R.string.feets)};
            View inflate = ActivityBodyFatMale.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyFatMale.this.neck_img[i]);
            return inflate;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.BlueTheme);
        setContentView(R.layout.act_body_fat_male);
        String[] strArr = {getResources().getString(R.string.centimeters), getResources().getString(R.string.feets)};
        String[] strArr2 = {getResources().getString(R.string.kilograms), getResources().getString(R.string.pounds)};
        String[] strArr3 = {getResources().getString(R.string.centimeters), getResources().getString(R.string.inches)};
        String[] strArr4 = {getResources().getString(R.string.centimeters), getResources().getString(R.string.inches)};
//
        Button button = findViewById(R.id.calc);
        Button button2 = findViewById(R.id.reset);
        init();

        button.setBackground(getShapeDrawble(false, primaryColor));
        button2.setBackground(getShapeDrawble(true, primaryColor));
        numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);
        heightSp.setAdapter(new MyAdapter2(this, R.layout.act_spinner_down_blue, strArr));
        weightSp.setAdapter(new MyAdapter3(this, R.layout.act_spinner_down_blue, strArr2));
        waistSp.setAdapter(new MyAdapter4(this, R.layout.act_spinner_down_blue, strArr3));
        neckSp.setAdapter(new MyAdapter5(this, R.layout.act_spinner_down_blue, strArr4));


        heightSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (ActivityBodyFatMale.this.heightSp.getSelectedItem().toString().equals(ActivityBodyFatMale.this.getResources().getString(R.string.centimeters))) {
                    ActivityBodyFatMale activityBodyFatMale = ActivityBodyFatMale.this;
                    activityBodyFatMale.cms = true;
                    activityBodyFatMale.edHeight.setEnabled(true);
                    ActivityBodyFatMale.this.edHeight2.setEnabled(false);
                    ActivityBodyFatMale.this.tvInputHeight2.setVisibility(View.GONE);
                    ActivityBodyFatMale.this.tvcm.setText(ActivityBodyFatMale.this.getResources().getString(R.string.cm));
                    ActivityBodyFatMale.this.tvin.setText("");
                    return;
                }
                ActivityBodyFatMale activityBodyFatMale2 = ActivityBodyFatMale.this;
                activityBodyFatMale2.cms = false;
                activityBodyFatMale2.edHeight.setEnabled(true);
                ActivityBodyFatMale.this.edHeight2.setEnabled(true);
                ActivityBodyFatMale.this.tvcm.setText(ActivityBodyFatMale.this.getResources().getString(R.string.ft));
                ActivityBodyFatMale.this.tvin.setText(ActivityBodyFatMale.this.getResources().getString(R.string.in));
                ActivityBodyFatMale.this.tvInputHeight2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        waistSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (ActivityBodyFatMale.this.waistSp.getSelectedItem().toString().equals(ActivityBodyFatMale.this.getResources().getString(R.string.centimeters))) {
                    ActivityBodyFatMale activityBodyFatMale = ActivityBodyFatMale.this;
                    activityBodyFatMale.cms2 = true;
                    return;
                }
                ActivityBodyFatMale activityBodyFatMale2 = ActivityBodyFatMale.this;
                activityBodyFatMale2.cms2 = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        neckSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (ActivityBodyFatMale.this.neckSp.getSelectedItem().toString().equals(ActivityBodyFatMale.this.getResources().getString(R.string.centimeters))) {
                    ActivityBodyFatMale activityBodyFatMale = ActivityBodyFatMale.this;
                    activityBodyFatMale.cms3 = true;
                    return;
                }
                ActivityBodyFatMale activityBodyFatMale2 = ActivityBodyFatMale.this;
                activityBodyFatMale2.cms3 = false;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        weightSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityBodyFatMale.this.isKG = ActivityBodyFatMale.this.weightSp.getSelectedItem().toString().equals(ActivityBodyFatMale.this.getResources().getString(R.string.kilograms));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "";
                ActivityBodyFatMale.this.edHeight.setText(str);
                ActivityBodyFatMale.this.edHeight2.setText(str);
                ActivityBodyFatMale.this.edWeight.setText(str);
                ActivityBodyFatMale.this.edWaist.setText(str);
                ActivityBodyFatMale.this.edNeck.setText(str);
                ActivityBodyFatMale.this.edHeight.requestFocus();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                try {
                    ActivityBodyFatMale.this.height = Double.parseDouble(ActivityBodyFatMale.this.edHeight.getText().toString());
                } catch (NumberFormatException unused) {
                    ActivityBodyFatMale.this.check = true;
                }
                try {
                    ActivityBodyFatMale.this.height2 = Double.parseDouble(ActivityBodyFatMale.this.edHeight2.getText().toString());
                } catch (NumberFormatException unused2) {
                    ActivityBodyFatMale.this.height2 = 0.0d;
                }
                try {
                    ActivityBodyFatMale.this.weight = Double.parseDouble(ActivityBodyFatMale.this.edWeight.getText().toString());
                } catch (NumberFormatException unused3) {
                    ActivityBodyFatMale.this.check = true;
                }
                try {
                    ActivityBodyFatMale.this.waist = Double.parseDouble(ActivityBodyFatMale.this.edWaist.getText().toString());
                } catch (NumberFormatException unused4) {
                    ActivityBodyFatMale.this.check = true;
                }
                try {
                    ActivityBodyFatMale.this.neck = Double.parseDouble(ActivityBodyFatMale.this.edNeck.getText().toString());
                } catch (NumberFormatException unused5) {
                    ActivityBodyFatMale.this.check = true;
                }
                if (ActivityBodyFatMale.this.check) {
                    Toast.makeText(ActivityBodyFatMale.this.getApplicationContext(), ActivityBodyFatMale.this.getResources().getString(R.string.valid), Toast.LENGTH_SHORT).show();
                    ActivityBodyFatMale.this.check = false;
                    return;
                }
                if (ActivityBodyFatMale.this.isKG) {
                    ActivityBodyFatMale.this.weight *= 2.20462d;
                }
                if (ActivityBodyFatMale.this.cms) {
                    ActivityBodyFatMale.this.height *= 0.393701d;
                } else {
                    ActivityBodyFatMale.this.height *= 12.0d;
                    ActivityBodyFatMale.this.height += ActivityBodyFatMale.this.height2;
                }
                if (ActivityBodyFatMale.this.cms2) {
                    ActivityBodyFatMale.this.waist *= 0.393701d;
                }
                if (ActivityBodyFatMale.this.cms3) {
                    ActivityBodyFatMale.this.neck *= 0.393701d;
                }
                ActivityBodyFatMale activityBodyFatMale4 = ActivityBodyFatMale.this;
                activityBodyFatMale4.result1 = (activityBodyFatMale4.weight * 1.082d) + 94.42d;
                ActivityBodyFatMale activityBodyFatMale5 = ActivityBodyFatMale.this;
                activityBodyFatMale5.result2 = activityBodyFatMale5.result1 - (ActivityBodyFatMale.this.waist * 4.15d);
                ActivityBodyFatMale activityBodyFatMale6 = ActivityBodyFatMale.this;
                activityBodyFatMale6.bf = ((activityBodyFatMale6.weight - ActivityBodyFatMale.this.result2) * 100.0d) / ActivityBodyFatMale.this.weight;
                if (ActivityBodyFatMale.this.bf >= 2.0d && ActivityBodyFatMale.this.bf <= 5.0d) {
                    ActivityBodyFatMale activityBodyFatMale7 = ActivityBodyFatMale.this;
                    activityBodyFatMale7.str_assess = activityBodyFatMale7.getResources().getString(R.string.essential);
                } else if (ActivityBodyFatMale.this.bf >= 6.0d && ActivityBodyFatMale.this.bf <= 13.0d) {
                    ActivityBodyFatMale activityBodyFatMale8 = ActivityBodyFatMale.this;
                    activityBodyFatMale8.str_assess = activityBodyFatMale8.getResources().getString(R.string.typicalathlete);
                } else if (ActivityBodyFatMale.this.bf >= 14.0d && ActivityBodyFatMale.this.bf <= 17.0d) {
                    ActivityBodyFatMale activityBodyFatMale9 = ActivityBodyFatMale.this;
                    activityBodyFatMale9.str_assess = activityBodyFatMale9.getResources().getString(R.string.physicallyfit);
                } else if (ActivityBodyFatMale.this.bf < 18.0d || ActivityBodyFatMale.this.bf > 24.0d) {
                    ActivityBodyFatMale activityBodyFatMale10 = ActivityBodyFatMale.this;
                    activityBodyFatMale10.str_assess = activityBodyFatMale10.getResources().getString(R.string.obese);
                } else {
                    ActivityBodyFatMale activityBodyFatMale11 = ActivityBodyFatMale.this;
                    activityBodyFatMale11.str_assess = activityBodyFatMale11.getResources().getString(R.string.acceptable);
                }
                ActivityBodyFatMale activityBodyFatMale12 = ActivityBodyFatMale.this;
                activityBodyFatMale12.str_bf = activityBodyFatMale12.numberFormat.format(ActivityBodyFatMale.this.bf);
                Intent intent = new Intent(ActivityBodyFatMale.this, ActivityBodyFatResult.class);
//                intent.putExtra(ConditionalUserProperty.VALUE, ActivityBodyFatMale.this.str_bf);
                intent.putExtra("value2", ActivityBodyFatMale.this.str_assess);
                ActivityBodyFatMale.this.startActivity(intent);
            }
        });
    }

    int primaryColor;

    private void init() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(null);
        TextView text_title = findViewById(R.id.text_title);
        text_title.setText(getResources().getString(R.string.bodyfat));
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
        edWaist = findViewById(R.id.edWaist);
        edNeck = findViewById(R.id.edNeck);
        tvHeight = findViewById(R.id.tvHeight);
        tvWeight = findViewById(R.id.tvWeight);
        tvWaist = findViewById(R.id.tvWaist);
        tvNeck = findViewById(R.id.tvNeck);
        tvcm = findViewById(R.id.tvcm);
        tvin = findViewById(R.id.tvin);
        weightSp = findViewById(R.id.weightSp);
        heightSp = findViewById(R.id.heightSp);
        waistSp = findViewById(R.id.waistSp);
        neckSp = findViewById(R.id.neckSp);
        tvInputHeight2 = findViewById(R.id.tvInputHeight2);

        primaryColor = ContextCompat.getColor(getApplicationContext(), R.color.bluecolorPrimary);

        ImageView img_height = findViewById(R.id.img_height);
        ImageView img_waist = findViewById(R.id.img_waist);
        ImageView img_weight = findViewById(R.id.img_weight);
        ImageView img_centimeter = findViewById(R.id.img_centimeter);
        ImageView img_inch = findViewById(R.id.img_inch);
        ImageView img_neck = findViewById(R.id.img_neck);
        setThemeColor(img_waist);
        setThemeColor(img_centimeter);
        setThemeColor(img_height);
        setThemeColor(img_neck);
        setThemeColor(img_weight);
        setThemeColor(img_inch);


    }

    public void setThemeColor(ImageView imageView) {
        imageView.getDrawable().setColorFilter(primaryColor, PorterDuff.Mode.SRC_IN);
    }

}
