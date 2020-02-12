package com.templatevilla.healthcalculator;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityCalculator extends AppCompatActivity {
    boolean add;
    boolean div;
    boolean dot = false;
    Animation fade_out;
    LinearLayout ll0;
    LinearLayout ll1;
    LinearLayout ll2;
    LinearLayout ll3;
    LinearLayout ll4;
    LinearLayout ll5;
    LinearLayout ll6;
    LinearLayout ll7;
    LinearLayout ll8;
    LinearLayout ll9;
    LinearLayout lladd;
    LinearLayout lldiv;
    LinearLayout lldot;

    LinearLayout lleq;
    LinearLayout lliv;
    LinearLayout llmul;
    LinearLayout llsub;
    boolean mul;
    boolean sub;

    TextView textView;
    double val1;
    double val2;

    Vibrator vibrator;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.act_calculator);
        this.vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        this.fade_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        this.ll0 = findViewById(R.id.ll0);
        this.ll1 = findViewById(R.id.ll1);
        this.ll2 = findViewById(R.id.ll2);
        this.ll3 = findViewById(R.id.ll3);
        this.ll4 = findViewById(R.id.ll4);
        this.ll5 = findViewById(R.id.ll5);
        this.ll6 = findViewById(R.id.ll6);
        this.ll7 = findViewById(R.id.ll7);
        this.ll8 = findViewById(R.id.ll8);
        this.ll9 = findViewById(R.id.ll9);
        this.lldot = findViewById(R.id.lldot);
        this.lleq = findViewById(R.id.lleq);
        this.lladd = findViewById(R.id.lladd);
        this.llsub = findViewById(R.id.llsub);
        this.llmul = findViewById(R.id.llmul);
        this.lldiv = findViewById(R.id.lldiv);
        this.textView = findViewById(R.id.tv);
        this.textView.setText("");
        this.lliv = findViewById(R.id.lliv);
        this.ll0.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityCalculator.this.vibrator.vibrate(100);
                TextView textView = ActivityCalculator.this.textView;
                String sb = ActivityCalculator.this.textView.getText() +
                        "0";
                textView.setText(sb);
            }
        });
        this.ll1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityCalculator.this.vibrator.vibrate(100);
                TextView textView = ActivityCalculator.this.textView;
                String sb = ActivityCalculator.this.textView.getText() +
                        "1";
                textView.setText(sb);
            }
        });
        this.ll2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityCalculator.this.vibrator.vibrate(100);
                TextView textView = ActivityCalculator.this.textView;
                String sb = ActivityCalculator.this.textView.getText() +
                        "2";
                textView.setText(sb);
            }
        });
        this.ll3.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityCalculator.this.vibrator.vibrate(100);
                TextView textView = ActivityCalculator.this.textView;
                String sb = ActivityCalculator.this.textView.getText() +
                        "3";
                textView.setText(sb);
            }
        });
        this.ll4.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityCalculator.this.vibrator.vibrate(100);
                TextView textView = ActivityCalculator.this.textView;
                String sb = ActivityCalculator.this.textView.getText() +
                        "4";
                textView.setText(sb);
            }
        });
        this.ll5.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityCalculator.this.vibrator.vibrate(100);
                TextView textView = ActivityCalculator.this.textView;
                String sb = ActivityCalculator.this.textView.getText() +
                        "5";
                textView.setText(sb);
            }
        });
        this.ll6.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityCalculator.this.vibrator.vibrate(100);
                TextView textView = ActivityCalculator.this.textView;
                String sb = ActivityCalculator.this.textView.getText() +
                        "6";
                textView.setText(sb);
            }
        });
        this.ll7.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityCalculator.this.vibrator.vibrate(100);
                TextView textView = ActivityCalculator.this.textView;
                String sb = ActivityCalculator.this.textView.getText() +
                        "7";
                textView.setText(sb);
            }
        });
        this.ll8.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityCalculator.this.vibrator.vibrate(100);
                TextView textView = ActivityCalculator.this.textView;
                String sb = ActivityCalculator.this.textView.getText() +
                        "8";
                textView.setText(sb);
            }
        });
        this.ll9.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ActivityCalculator.this.vibrator.vibrate(100);
                TextView textView = ActivityCalculator.this.textView;
                String sb = ActivityCalculator.this.textView.getText() +
                        "9";
                textView.setText(sb);
            }
        });
        this.lldot.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String charSequence = ActivityCalculator.this.textView.getText().toString();
                ActivityCalculator.this.dot = false;
                if (charSequence.length() < 1) {
                    ActivityCalculator.this.vibrator.vibrate(100);
                    ActivityCalculator.this.textView.setText("0.");
                    return;
                }
                for (int i = 0; i < charSequence.length(); i++) {
                    if (charSequence.charAt(i) == '.') {
                        ActivityCalculator.this.dot = true;
                    }
                }
                if (!ActivityCalculator.this.dot) {
                    ActivityCalculator.this.vibrator.vibrate(100);
                    TextView textView = ActivityCalculator.this.textView;
                    String sb = ActivityCalculator.this.textView.getText() +
                            ".";
                    textView.setText(sb);
                }
            }
        });
        this.lladd.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String charSequence = ActivityCalculator.this.textView.getText().toString();
                if (charSequence.length() >= 1) {
                    ActivityCalculator.this.vibrator.vibrate(100);
                    try {
                        ActivityCalculator activityCalculator = ActivityCalculator.this;
                        String sb = ActivityCalculator.this.textView.getText() +
                                "";
                        activityCalculator.val1 = Double.parseDouble(sb);
                        ActivityCalculator.this.add = true;
                        ActivityCalculator.this.textView.setText(null);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        });
        this.llsub.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String charSequence = ActivityCalculator.this.textView.getText().toString();
                if (charSequence.length() >= 1) {
                    ActivityCalculator.this.vibrator.vibrate(100);
                    try {
                        ActivityCalculator activityCalculator = ActivityCalculator.this;
                        String sb = ActivityCalculator.this.textView.getText() +
                                "";
                        activityCalculator.val1 = Double.parseDouble(sb);
                        ActivityCalculator.this.sub = true;
                        ActivityCalculator.this.textView.setText(null);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        });
        this.llmul.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String charSequence = ActivityCalculator.this.textView.getText().toString();
                if (charSequence.length() >= 1) {
                    ActivityCalculator.this.vibrator.vibrate(100);
                    try {
                        ActivityCalculator activityCalculator = ActivityCalculator.this;
                        String sb = ActivityCalculator.this.textView.getText() +
                                "";
                        activityCalculator.val1 = Double.parseDouble(sb);
                        ActivityCalculator.this.mul = true;
                        ActivityCalculator.this.textView.setText(null);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        });
        this.lldiv.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String charSequence = ActivityCalculator.this.textView.getText().toString();
                if (charSequence.length() >= 1) {
                    ActivityCalculator.this.vibrator.vibrate(100);
                    try {
                        ActivityCalculator activityCalculator = ActivityCalculator.this;
                        String sb = ActivityCalculator.this.textView.getText() +
                                "";
                        activityCalculator.val1 = Double.parseDouble(sb);
                        ActivityCalculator.this.div = true;
                        ActivityCalculator.this.textView.setText(null);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        });
        this.lleq.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "";
                String charSequence = ActivityCalculator.this.textView.getText().toString();
                if (charSequence.length() >= 1) {
                    ActivityCalculator.this.vibrator.vibrate(100);
                    try {
                        ActivityCalculator activityCalculator = ActivityCalculator.this;
                        String sb = ActivityCalculator.this.textView.getText() +
                                str;
                        activityCalculator.val2 = Double.parseDouble(sb);
                    } catch (NumberFormatException ignored) {
                    }
                    String str2 = ".0";
                    if (ActivityCalculator.this.add) {
                        String valueOf = String.valueOf(ActivityCalculator.this.val1 + ActivityCalculator.this.val2);
                        if ((valueOf.length() < 2 ? valueOf : valueOf.substring(valueOf.length() - 2)).contentEquals(str2)) {
                            ActivityCalculator.this.textView.setText(valueOf.substring(0, valueOf.length() - 2));
                        } else {
                            TextView textView = ActivityCalculator.this.textView;
                            String sb2 = (ActivityCalculator.this.val1 + ActivityCalculator.this.val2) +
                                    str;
                            textView.setText(sb2);
                        }
                        ActivityCalculator.this.add = false;
                    }
                    if (ActivityCalculator.this.sub) {
                        String valueOf2 = String.valueOf(ActivityCalculator.this.val1 - ActivityCalculator.this.val2);
                        if ((valueOf2.length() < 2 ? valueOf2 : valueOf2.substring(valueOf2.length() - 2)).contentEquals(str2)) {
                            ActivityCalculator.this.textView.setText(valueOf2.substring(0, valueOf2.length() - 2));
                        } else {
                            TextView textView2 = ActivityCalculator.this.textView;
                            String sb3 = (ActivityCalculator.this.val1 - ActivityCalculator.this.val2) +
                                    str;
                            textView2.setText(sb3);
                        }
                        ActivityCalculator.this.sub = false;
                    }
                    if (ActivityCalculator.this.mul) {
                        String valueOf3 = String.valueOf(ActivityCalculator.this.val1 * ActivityCalculator.this.val2);
                        if ((valueOf3.length() < 2 ? valueOf3 : valueOf3.substring(valueOf3.length() - 2)).contentEquals(str2)) {
                            ActivityCalculator.this.textView.setText(valueOf3.substring(0, valueOf3.length() - 2));
                        } else {
                            TextView textView3 = ActivityCalculator.this.textView;
                            String sb4 = ActivityCalculator.this.val1 * ActivityCalculator.this.val2 +
                                    str;
                            textView3.setText(sb4);
                        }
                        ActivityCalculator.this.mul = false;
                    }
                    if (ActivityCalculator.this.div) {
                        String valueOf4 = String.valueOf(ActivityCalculator.this.val1 / ActivityCalculator.this.val2);
                        if ((valueOf4.length() < 2 ? valueOf4 : valueOf4.substring(valueOf4.length() - 2)).contentEquals(str2)) {
                            ActivityCalculator.this.textView.setText(valueOf4.substring(0, valueOf4.length() - 2));
                        } else {
                            TextView textView4 = ActivityCalculator.this.textView;
                            String sb5 = ActivityCalculator.this.val1 / ActivityCalculator.this.val2 +
                                    str;
                            textView4.setText(sb5);
                        }
                        ActivityCalculator.this.div = false;
                    }
                }
            }
        });
        this.lliv.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String charSequence = ActivityCalculator.this.textView.getText().toString();
                if (charSequence.length() >= 1) {
                    ActivityCalculator.this.vibrator.vibrate(100);
                    String charSequence2 = ActivityCalculator.this.textView.getText().toString();
                    if (charSequence2.length() != 0) {
                        ActivityCalculator.this.textView.setText(charSequence2.substring(0, charSequence2.length() - 1));
                    }
                }
            }
        });
    }
}
