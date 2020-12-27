package com.example.xiangmu.view;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragment.FiveFragment;
import com.example.fragment.FourFragment;
import com.example.fragment.OneFragment;
import com.example.fragment.ThreeFragment;
import com.example.fragment.TwoFragment;
import com.example.xiangmu.R;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private android.widget.RadioGroup mRgMain;
    private android.widget.RadioButton mRb1;
    private android.widget.RadioButton mRb2;
    private android.widget.RadioButton mRb3;
    private android.widget.RadioButton mRb4;
    private android.widget.RadioButton mRb5;
    private android.widget.FrameLayout mFlFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mFlFragment = (FrameLayout) findViewById(R.id.fl_fragment);
        mRgMain = (RadioGroup) findViewById(R.id.rg_main);
        mRb1 = (RadioButton) findViewById(R.id.rb1);
        mRb2 = (RadioButton) findViewById(R.id.rb2);
        mRb3 = (RadioButton) findViewById(R.id.rb3);
        mRb4 = (RadioButton) findViewById(R.id.rb4);
        mRb5 = (RadioButton) findViewById(R.id.rb5);
        mRb1.setChecked(true);
        mRgMain.setOnCheckedChangeListener(this);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction begin = manager.beginTransaction();
        begin.replace(R.id.fl_fragment, new OneFragment())
                .commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb1:
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_fragment,new OneFragment())
                        .commit();
                break;
            case R.id.rb2:
                FragmentManager supportFragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = supportFragmentManager1.beginTransaction();
                fragmentTransaction1.replace(R.id.fl_fragment,new TwoFragment())
                        .commit();
                break;
            case R.id.rb3:
                FragmentManager supportFragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = supportFragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.fl_fragment,new ThreeFragment())
                        .commit();
                break;
            case R.id.rb4:
                FragmentManager supportFragmentManager3 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = supportFragmentManager3.beginTransaction();
                fragmentTransaction3.replace(R.id.fl_fragment,new FourFragment())
                        .commit();
                break;
            case R.id.rb5:
                FragmentManager supportFragmentManager4 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction4 = supportFragmentManager4.beginTransaction();
                fragmentTransaction4.replace(R.id.fl_fragment,new FiveFragment())
                        .commit();
                break;
        }
    }
}