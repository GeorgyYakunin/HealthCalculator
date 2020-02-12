package com.templatevilla.healthcalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.templatevilla.healthcalculator.adapters.LazyAdapter;
import com.templatevilla.healthcalculator.models.RowItem;



import java.util.ArrayList;
import java.util.List;


public class ActivityMain extends AppCompatActivity implements LazyAdapter.clickInterface {

    private static Integer[] images = {R.drawable.idealweight, R.drawable.bmi, R.drawable.heartrate, R.drawable.bloodvol, R.drawable.blood_donate, R.drawable.calorie,
            R.drawable.waterintake, R.drawable.body_fat, R.drawable.bloodalcohol,
            R.drawable.pregnancy_new, R.drawable.ovulation};


    private static Integer[] themes = {R.style.OrangeTheme, R.style.BlueTheme, R.style.YellowTheme, R.style.CyanTheme, R.style.PinkTheme, R.style.GrayTheme, R.style.OrangeTheme,
            R.style.BlueTheme, R.style.GrayTheme, R.style.PinkTheme, R.style.YellowTheme};


    private static Integer[] arrows = {R.drawable.arrow_orange, R.drawable.arrow_blue, R.drawable.arrow_yellow, R.drawable.arrow_cyan, R.drawable.arrow_pink,
            R.drawable.arrow_gray, R.drawable.arrow_orange
            , R.drawable.arrow_blue, R.drawable.arrow_gray, R.drawable.arrow_pink, R.drawable.arrow_yellow};

    private static Integer[] colors = {R.color.orangecolorPrimary, R.color.bluecolorPrimary, R.color.yellowcolorPrimary, R.color.cyancolorPrimary, R.color.pinkcolorPrimary, R.color.graycolorPrimary, R.color.orangecolorPrimary
            , R.color.bluecolorPrimary, R.color.graycolorPrimary, R.color.pinkcolorPrimary, R.color.yellowcolorPrimary};


    private static final String ratings_fileName = "ratingAgain";
    SharedPreferences ratePrefs;
    List<RowItem> rowItems;
    LazyAdapter lazyAdapter;
    RecyclerView listView;
    Toolbar toolbar;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.act_main);

        init();
        ratePrefs = getSharedPreferences(ratings_fileName, 0);

        listView = findViewById(R.id.myList);
        rowItems = new ArrayList<>();
        String[] strArr = {getResources().getString(R.string.idealweight), getResources().getString(R.string.bmi_title), getResources().getString(R.string.heartrate), getResources().getString(R.string.bloodvol), getResources().getString(R.string.blood_donate), getResources().getString(R.string.calories), getResources().getString(R.string.waterintake),
                getResources().getString(R.string.bodyfat), getResources().getString(R.string.bloodalcohol), getResources().getString(R.string.pregnancy), getResources().getString(R.string.ovulation)};

        String[] strArr2 = {getResources().getString(R.string.idealweight_desc), getResources().getString(R.string.bmi_desc), getResources().getString(R.string.heart_desc), getResources().getString(R.string.bloodvol_desc), getResources().getString(R.string.blood_don_desc), getResources().getString(R.string.calorie_desc), getResources().getString(R.string.waterintake_desc),
                getResources().getString(R.string.bodyfat_desc), getResources().getString(R.string.bloodalcohol_desc),
                getResources().getString(R.string.pregnancy_desc), getResources().getString(R.string.ovulation_desc)};
        for (int i = 0; i < strArr.length; i++) {
            this.rowItems.add(new RowItem(images[i], strArr[i], strArr2[i], themes[i], arrows[i], colors[i]));
        }
        lazyAdapter = new LazyAdapter(this.rowItems, this);
        listView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        listView.setAdapter(lazyAdapter);
        lazyAdapter.setListeners(this);
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getResources().getString(R.string.app_name));
    }




//    private void sendFeedBack() {
//        Intent localIntent = new Intent(Intent.ACTION_SEND);
//        localIntent.putExtra(Intent.EXTRA_EMAIL, R.string.mail_feedback_email);
//        localIntent.putExtra(Intent.EXTRA_CC, "");
//        String str;
//        try {
//            str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
//            localIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.feedback_msg));
//            localIntent.putExtra(Intent.EXTRA_TEXT, "\n\n----------------------------------\n" + getResources().getString(R.string.device_os) +
//                    Build.VERSION.RELEASE + "\n" + getResources().getString(R.string.app_version) + str + "\n Device Brand: " + Build.BRAND +
//                    "\n" + getResources().getString(R.string.device_model) + Build.MODEL + "\n" + getResources().getString(R.string.manufacturer) + Build.MANUFACTURER);
//            localIntent.setType("message/rfc822");
//            startActivity(Intent.createChooser(localIntent, getResources().getString(R.string.email_client)));
//        } catch (Exception ignored) {
//        }
//    }

    public void onBackPressed() {
        finishAffinity();
    }


    @Override
    public void onRecItemClick(View view, int i) {
        switch (i) {
            case 0:
                passIntent(ActivityIdealWeightCalc.class);
                return;
            case 1:
                passIntent(ActivityBodyMassIndex.class);
                return;
            case 2:
                passIntent(ActivityHeartRateCalculator.class);
                return;
            case 3:
                passIntent(ActivityBloodVolCalc.class);
                return;
            case 4:
                passIntent(ActivityBloodDonat.class);
                return;
            case 5:
                passIntent(ActivityCalorieCalculator.class);
                return;
            case 6:
                passIntent(ActivityWaterIntakeCalc.class);
                return;
            case 7:
                passIntent(ActivityBodyFatHome.class);
                return;
            case 8:
                passIntent(ActivityBloodAlcoContent.class);
                return;
            case 9:
                passIntent(ActivityPregnancyCalc.class);
                return;
            case 10:
                passIntent(ActivityOvulationCalc.class);
                return;
            default:
        }
    }

    public void passIntent(Class aClass) {
        startActivity(new Intent(this, aClass));
    }
}
