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

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;


import java.text.NumberFormat;

import static com.templatevilla.healthcalculator.util.Constant.getShapeDrawble;

public class ActivityBodyFatFem extends AppCompatActivity {

    double bf;
    boolean check = false;
    public boolean cms = true;
    public boolean cms2 = true;
    public boolean cms3 = true;
    public boolean cms4 = true;
    public boolean cms5 = true;
    public boolean cms6 = true;
    EditText edForearm;
    int primaryColor;
    EditText edHeight;
    EditText edHeight2;
    LinearLayout tvInputHeight2;
    EditText edHip;
    EditText edNeck;
    EditText edWaist;
    EditText edWeight;
    EditText edWrist;
    double forearm;
    Spinner forearmSp;
    int[] forearm_img = {R.drawable.height, R.drawable.height};
    double height;
    double height2;
    Spinner heightSp;
    int[] height_img = {R.drawable.height, R.drawable.height};
    double hip;
    Spinner hipSp;
    int[] hip_img = {R.drawable.height, R.drawable.height};

    /* renamed from: kg */
    public boolean isKG = true;
    double neck;
    Spinner neckSp;
    int[] neck_img = {R.drawable.height, R.drawable.height};

    /* renamed from: nf */
    NumberFormat numberFormat;
    double result3;
    String str_assess;
    String str_bf;
    TextView tvForearm;
    TextView tvHeight;
    TextView tvHip;
    TextView tvNeck;
    TextView tvWaist;
    TextView tvWeight;
    TextView tvWrist;
    TextView tvcm;
    //    TextView tvcm2;
//    TextView tvcm3;
//    TextView tvcm4;
//    TextView tvcm5;
//    TextView tvcm6;
    TextView tvin;
    double waist;
    Spinner waistSp;
    int[] waist_img = {R.drawable.height, R.drawable.height};
    double weight;
    Spinner weightSp;
    int[] weight_img = {R.drawable.weight, R.drawable.weight};
    double wrist;
    Spinner wristSp;
    int[] wrist_img = {R.drawable.height, R.drawable.height};
    Toolbar toolbar;


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
            String[] strArr = {ActivityBodyFatFem.this.getResources().getString(R.string.centimeters), ActivityBodyFatFem.this.getResources().getString(R.string.feets)};
            View inflate = ActivityBodyFatFem.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyFatFem.this.height_img[i]);
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
            String[] strArr = {ActivityBodyFatFem.this.getResources().getString(R.string.kilograms), ActivityBodyFatFem.this.getResources().getString(R.string.pounds)};
            View inflate = ActivityBodyFatFem.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyFatFem.this.weight_img[i]);
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
            String[] strArr = {ActivityBodyFatFem.this.getResources().getString(R.string.centimeters), ActivityBodyFatFem.this.getResources().getString(R.string.feets)};
            View inflate = ActivityBodyFatFem.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyFatFem.this.waist_img[i]);
            return inflate;
        }
    }

    public class MyAdapter5 extends ArrayAdapter<String> {
        MyAdapter5(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBodyFatFem.this.getResources().getString(R.string.centimeters), ActivityBodyFatFem.this.getResources().getString(R.string.feets)};
            View inflate = ActivityBodyFatFem.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyFatFem.this.neck_img[i]);
            return inflate;
        }
    }

    public class MyAdapter6 extends ArrayAdapter<String> {
        MyAdapter6(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBodyFatFem.this.getResources().getString(R.string.centimeters), ActivityBodyFatFem.this.getResources().getString(R.string.feets)};
            View inflate = ActivityBodyFatFem.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyFatFem.this.forearm_img[i]);
            return inflate;
        }
    }

    public class MyAdapter7 extends ArrayAdapter<String> {
        MyAdapter7(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBodyFatFem.this.getResources().getString(R.string.centimeters), ActivityBodyFatFem.this.getResources().getString(R.string.feets)};
            View inflate = ActivityBodyFatFem.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyFatFem.this.wrist_img[i]);
            return inflate;
        }
    }

    public class MyAdapter8 extends ArrayAdapter<String> {
        MyAdapter8(Context context, int i, String[] strArr) {
            super(context, i, strArr);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getCustomView(i, viewGroup);
        }

        public View getCustomView(int i, ViewGroup viewGroup) {
            String[] strArr = {ActivityBodyFatFem.this.getResources().getString(R.string.centimeters), ActivityBodyFatFem.this.getResources().getString(R.string.feets)};
            View inflate = ActivityBodyFatFem.this.getLayoutInflater().inflate(R.layout.act_spinner_down_blue, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.currency)).setText(strArr[i]);
            ((ImageView) inflate.findViewById(R.id.image)).setImageResource(ActivityBodyFatFem.this.hip_img[i]);
            return inflate;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.BlueTheme);
        setContentView(R.layout.act_body_fat_fem);
        String[] strArr = {getResources().getString(R.string.centimeters), getResources().getString(R.string.feets)};
        String[] strArr2 = {getResources().getString(R.string.kilograms), getResources().getString(R.string.pounds)};
        String[] strArr3 = {getResources().getString(R.string.centimeters), getResources().getString(R.string.in)};
        String[] strArr4 = {getResources().getString(R.string.centimeters), getResources().getString(R.string.in)};
        String[] strArr5 = {getResources().getString(R.string.centimeters), getResources().getString(R.string.in)};
        String[] strArr6 = {getResources().getString(R.string.centimeters), getResources().getString(R.string.in)};
        String[] strArr7 = {getResources().getString(R.string.centimeters), getResources().getString(R.string.in)};
//
        init();
        Button button = findViewById(R.id.calc);
        Button button2 = findViewById(R.id.reset);
        numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);

        button.setBackground(getShapeDrawble(false, primaryColor));
        button2.setBackground(getShapeDrawble(true, primaryColor));
        heightSp.setAdapter(new MyAdapter2(this, R.layout.act_spinner_down_blue, strArr));
        weightSp.setAdapter(new MyAdapter3(this, R.layout.act_spinner_down_blue, strArr2));
        waistSp.setAdapter(new MyAdapter4(this, R.layout.act_spinner_down_blue, strArr4));
        neckSp.setAdapter(new MyAdapter5(this, R.layout.act_spinner_down_blue, strArr5));
        forearmSp.setAdapter(new MyAdapter6(this, R.layout.act_spinner_down_blue, strArr6));
        wristSp.setAdapter(new MyAdapter7(this, R.layout.act_spinner_down_blue, strArr3));
        hipSp.setAdapter(new MyAdapter8(this, R.layout.act_spinner_down_blue, strArr7));


        heightSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (ActivityBodyFatFem.this.heightSp.getSelectedItem().toString().equals(ActivityBodyFatFem.this.getResources().getString(R.string.centimeters))) {
                    ActivityBodyFatFem activityBodyFatFem = ActivityBodyFatFem.this;
                    activityBodyFatFem.cms = true;
                    activityBodyFatFem.edHeight.setEnabled(true);
                    ActivityBodyFatFem.this.edHeight2.setEnabled(false);
                    ActivityBodyFatFem.this.tvInputHeight2.setVisibility(View.GONE);
                    ActivityBodyFatFem.this.tvcm.setText(ActivityBodyFatFem.this.getResources().getString(R.string.cm));
                    ActivityBodyFatFem.this.tvin.setText("");
                    return;
                }
                ActivityBodyFatFem activityBodyFatFem2 = ActivityBodyFatFem.this;
                activityBodyFatFem2.cms = false;
                activityBodyFatFem2.edHeight.setEnabled(true);
                ActivityBodyFatFem.this.edHeight2.setEnabled(true);
                ActivityBodyFatFem.this.tvcm.setText(ActivityBodyFatFem.this.getResources().getString(R.string.ft));
                ActivityBodyFatFem.this.tvin.setText(ActivityBodyFatFem.this.getResources().getString(R.string.in));
                ActivityBodyFatFem.this.tvInputHeight2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        waistSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (ActivityBodyFatFem.this.waistSp.getSelectedItem().toString().equals(ActivityBodyFatFem.this.getResources().getString(R.string.centimeters))) {
                    ActivityBodyFatFem activityBodyFatFem = ActivityBodyFatFem.this;
                    activityBodyFatFem.cms2 = true;
                    return;
                }
                ActivityBodyFatFem activityBodyFatFem2 = ActivityBodyFatFem.this;
                activityBodyFatFem2.cms2 = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        neckSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (ActivityBodyFatFem.this.neckSp.getSelectedItem().toString().equals(ActivityBodyFatFem.this.getResources().getString(R.string.centimeters))) {
                    ActivityBodyFatFem activityBodyFatFem = ActivityBodyFatFem.this;
                    activityBodyFatFem.cms3 = true;
                    return;
                }
                ActivityBodyFatFem activityBodyFatFem2 = ActivityBodyFatFem.this;
                activityBodyFatFem2.cms3 = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        forearmSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (ActivityBodyFatFem.this.forearmSp.getSelectedItem().toString().equals(ActivityBodyFatFem.this.getResources().getString(R.string.centimeters))) {
                    ActivityBodyFatFem activityBodyFatFem = ActivityBodyFatFem.this;
                    activityBodyFatFem.cms4 = true;
                    return;
                }
                ActivityBodyFatFem activityBodyFatFem2 = ActivityBodyFatFem.this;
                activityBodyFatFem2.cms4 = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        wristSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (ActivityBodyFatFem.this.wristSp.getSelectedItem().toString().equals(ActivityBodyFatFem.this.getResources().getString(R.string.centimeters))) {
                    ActivityBodyFatFem activityBodyFatFem = ActivityBodyFatFem.this;
                    activityBodyFatFem.cms5 = true;
                    return;
                }
                ActivityBodyFatFem activityBodyFatFem2 = ActivityBodyFatFem.this;
                activityBodyFatFem2.cms5 = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        hipSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (ActivityBodyFatFem.this.hipSp.getSelectedItem().toString().equals(ActivityBodyFatFem.this.getResources().getString(R.string.centimeters))) {
                    ActivityBodyFatFem activityBodyFatFem = ActivityBodyFatFem.this;
                    activityBodyFatFem.cms6 = true;
                    return;
                }
                ActivityBodyFatFem activityBodyFatFem2 = ActivityBodyFatFem.this;
                activityBodyFatFem2.cms6 = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        weightSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityBodyFatFem.this.isKG = ActivityBodyFatFem.this.weightSp.getSelectedItem().toString().equals(ActivityBodyFatFem.this.getResources().getString(R.string.kilograms));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "";
                ActivityBodyFatFem.this.edHeight.setText(str);
                ActivityBodyFatFem.this.edHeight2.setText(str);
                ActivityBodyFatFem.this.edWeight.setText(str);
                ActivityBodyFatFem.this.edWaist.setText(str);
                ActivityBodyFatFem.this.edNeck.setText(str);
                ActivityBodyFatFem.this.edForearm.setText(str);
                ActivityBodyFatFem.this.edHip.setText(str);
                ActivityBodyFatFem.this.edWrist.setText(str);
                ActivityBodyFatFem.this.edHeight.requestFocus();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                try {
                    ActivityBodyFatFem.this.height = Double.parseDouble(ActivityBodyFatFem.this.edHeight.getText().toString());
                } catch (NumberFormatException unused) {
                    ActivityBodyFatFem.this.check = true;
                }
                try {
                    ActivityBodyFatFem.this.height2 = Double.parseDouble(ActivityBodyFatFem.this.edHeight2.getText().toString());
                } catch (NumberFormatException unused2) {
                    ActivityBodyFatFem.this.height2 = 0.0d;
                }
                try {
                    ActivityBodyFatFem.this.weight = Double.parseDouble(ActivityBodyFatFem.this.edWeight.getText().toString());
                } catch (NumberFormatException unused3) {
                    ActivityBodyFatFem.this.check = true;
                }
                try {
                    ActivityBodyFatFem.this.waist = Double.parseDouble(ActivityBodyFatFem.this.edWaist.getText().toString());
                } catch (NumberFormatException unused4) {
                    ActivityBodyFatFem.this.check = true;
                }
                try {
                    ActivityBodyFatFem.this.neck = Double.parseDouble(ActivityBodyFatFem.this.edNeck.getText().toString());
                } catch (NumberFormatException unused5) {
                    ActivityBodyFatFem.this.check = true;
                }
                try {
                    ActivityBodyFatFem.this.forearm = Double.parseDouble(ActivityBodyFatFem.this.edForearm.getText().toString());
                } catch (NumberFormatException unused6) {
                    ActivityBodyFatFem.this.check = true;
                }
                try {
                    ActivityBodyFatFem.this.wrist = Double.parseDouble(ActivityBodyFatFem.this.edWrist.getText().toString());
                } catch (NumberFormatException unused7) {
                    ActivityBodyFatFem.this.check = true;
                }
                try {
                    ActivityBodyFatFem.this.hip = Double.parseDouble(ActivityBodyFatFem.this.edHip.getText().toString());
                } catch (NumberFormatException unused8) {
                    ActivityBodyFatFem.this.check = true;
                }
                if (ActivityBodyFatFem.this.check) {
                    Toast.makeText(ActivityBodyFatFem.this.getApplicationContext(), ActivityBodyFatFem.this.getResources().getString(R.string.valid), Toast.LENGTH_SHORT).show();
                    ActivityBodyFatFem.this.check = false;
                    return;
                }
                if (ActivityBodyFatFem.this.isKG) {
                    ActivityBodyFatFem.this.weight *= 2.20462d;
                }
                if (ActivityBodyFatFem.this.cms) {
                    ActivityBodyFatFem.this.height *= 0.393701d;
                } else {
                    ActivityBodyFatFem.this.height *= 12.0d;
                    ActivityBodyFatFem.this.height += ActivityBodyFatFem.this.height2;
                }
                if (ActivityBodyFatFem.this.cms2) {
                    ActivityBodyFatFem.this.waist *= 0.393701d;
                }
                if (ActivityBodyFatFem.this.cms3) {
                    ActivityBodyFatFem.this.neck *= 0.393701d;
                }
                if (ActivityBodyFatFem.this.cms4) {
                    ActivityBodyFatFem.this.forearm *= 0.393701d;
                }
                if (ActivityBodyFatFem.this.cms5) {
                    ActivityBodyFatFem.this.wrist *= 0.393701d;
                }
                if (ActivityBodyFatFem.this.cms6) {
                    ActivityBodyFatFem.this.hip *= 0.393701d;
                }
                ActivityBodyFatFem activityBodyFatFem7 = ActivityBodyFatFem.this;
                activityBodyFatFem7.result3 = (((((activityBodyFatFem7.weight * 0.0732d) + 8.987d) + (ActivityBodyFatFem.this.wrist / 3.14d)) - (ActivityBodyFatFem.this.waist * 0.157d)) - (ActivityBodyFatFem.this.hip * 0.249d)) + (ActivityBodyFatFem.this.forearm * 0.434d);
                ActivityBodyFatFem activityBodyFatFem8 = ActivityBodyFatFem.this;
                activityBodyFatFem8.bf = ((activityBodyFatFem8.weight - ActivityBodyFatFem.this.result3) * 100.0d) / ActivityBodyFatFem.this.weight;
                if (ActivityBodyFatFem.this.bf >= 10.0d && ActivityBodyFatFem.this.bf <= 13.0d) {
                    ActivityBodyFatFem activityBodyFatFem9 = ActivityBodyFatFem.this;
                    activityBodyFatFem9.str_assess = activityBodyFatFem9.getResources().getString(R.string.essential);
                } else if (ActivityBodyFatFem.this.bf >= 14.0d && ActivityBodyFatFem.this.bf <= 20.0d) {
                    ActivityBodyFatFem activityBodyFatFem10 = ActivityBodyFatFem.this;
                    activityBodyFatFem10.str_assess = activityBodyFatFem10.getResources().getString(R.string.typicalathlete);
                } else if (ActivityBodyFatFem.this.bf >= 21.0d && ActivityBodyFatFem.this.bf <= 24.0d) {
                    ActivityBodyFatFem activityBodyFatFem11 = ActivityBodyFatFem.this;
                    activityBodyFatFem11.str_assess = activityBodyFatFem11.getResources().getString(R.string.physicallyfit);
                } else if (ActivityBodyFatFem.this.bf < 25.0d || ActivityBodyFatFem.this.bf > 31.0d) {
                    ActivityBodyFatFem activityBodyFatFem12 = ActivityBodyFatFem.this;
                    activityBodyFatFem12.str_assess = activityBodyFatFem12.getResources().getString(R.string.obese);
                } else {
                    ActivityBodyFatFem activityBodyFatFem13 = ActivityBodyFatFem.this;
                    activityBodyFatFem13.str_assess = activityBodyFatFem13.getResources().getString(R.string.acceptable);
                }
                ActivityBodyFatFem activityBodyFatFem14 = ActivityBodyFatFem.this;
                activityBodyFatFem14.str_bf = activityBodyFatFem14.numberFormat.format(ActivityBodyFatFem.this.bf);
                Intent intent = new Intent(ActivityBodyFatFem.this, ActivityBodyFatResult.class);
//                intent.putExtra(ConditionalUserProperty.VALUE, ActivityBodyFatFem.this.str_bf);
                intent.putExtra("value2", ActivityBodyFatFem.this.str_assess);
                ActivityBodyFatFem.this.startActivity(intent);
            }
        });
    }

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
        tvInputHeight2 = findViewById(R.id.tvInputHeight2);
        edHeight2 = findViewById(R.id.edHeight2);
        edWaist = findViewById(R.id.edWaist);
        edWrist = findViewById(R.id.edWrist);
        edNeck = findViewById(R.id.edNeck);
        edForearm = findViewById(R.id.edForearm);
        edHip = findViewById(R.id.edHip);
        tvHeight = findViewById(R.id.tvHeight);
        tvWeight = findViewById(R.id.tvWeight);
        tvWaist = findViewById(R.id.tvWaist);
        tvWrist = findViewById(R.id.tvWrist);
        tvNeck = findViewById(R.id.tvNeck);
        tvForearm = findViewById(R.id.tvForearm);
        tvHip = findViewById(R.id.tvHip);
        tvcm = findViewById(R.id.tvcm);
        tvin = findViewById(R.id.tvin);
        weightSp = findViewById(R.id.weightSp);
        heightSp = findViewById(R.id.heightSp);
        waistSp = findViewById(R.id.waistSp);
        neckSp = findViewById(R.id.neckSp);
        wristSp = findViewById(R.id.wristSp);
        ActivityBodyFatFem.this.tvInputHeight2.setVisibility(View.GONE);
        forearmSp = findViewById(R.id.forearmSp);
        hipSp = findViewById(R.id.hipSp);

        primaryColor = ContextCompat.getColor(getApplicationContext(), R.color.bluecolorPrimary);

        ImageView img_waist = findViewById(R.id.img_waist);
        ImageView img_height = findViewById(R.id.img_height);
        ImageView img_centimeter = findViewById(R.id.img_centimeter);
        ImageView img_weight = findViewById(R.id.img_weight);
        ImageView img_forearm = findViewById(R.id.img_forearm);
        ImageView img_inch = findViewById(R.id.img_inch);
        ImageView img_hip = findViewById(R.id.img_hip);
        ImageView img_neck = findViewById(R.id.img_neck);
        ImageView img_wrist = findViewById(R.id.img_wrist);
        setThemeColor(img_waist);
        setThemeColor(img_height);
        setThemeColor(img_centimeter);
        setThemeColor(img_neck);
        setThemeColor(img_forearm);
        setThemeColor(img_hip);
        setThemeColor(img_inch);
        setThemeColor(img_weight);
        setThemeColor(img_wrist);


    }

    public void setThemeColor(ImageView imageView) {
        imageView.getDrawable().setColorFilter(primaryColor, PorterDuff.Mode.SRC_IN);
    }

}
