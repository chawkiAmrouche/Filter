package com.chawki.filter;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import io.codetail.animation.ViewAnimationUtils;

public class MainActivity extends AppCompatActivity {


    protected SekizbitSwitch sekizbitSwitch;
    protected ImageView ImageViewDrawerToggle;
    protected ImageView ImageViewSetting;
    protected ImageView ImageViewSearch;
    private FragmentManager fragmentManager;
    ViewPager todaymenupager;
    Animator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        todaymenupager = (ViewPager) findViewById(R.id.fragment_layout);
        ImageViewSetting = (ImageView) findViewById(R.id.ImageViewSetting);
        initView();
        final LinearLayout myView = (LinearLayout) findViewById(R.id.awesome_card);
        ImageView cancel_action = (ImageView) findViewById(R.id.cancel_action);
        ImageViewSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Android native animator
                animator =
                        ViewAnimationUtils.createCircularReveal(myView, myView.getRight(), 0, myView.getLeft(), myView.getHeight());
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(1500);
                animator.start();
                myView.setVisibility(View.VISIBLE);


            }
        });
        cancel_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator =
                        ViewAnimationUtils.createCircularReveal(myView, myView.getLeft(), 0, myView.getRight(), 0);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(1500);
                animator.start();
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        myView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

            }
        });
        org.adw.library.widgets.discreteseekbar.DiscreteSeekBar pricebar = (DiscreteSeekBar) findViewById(R.id.pricebar);
        final TextView pricetext = (TextView) findViewById(R.id.pricetext);
        pricebar.setProgress(785);
        pricetext.setText("50-" + pricebar.getProgress() + "$");
        pricebar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                pricetext.setText("50-" + value + "$");
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });
        final org.adw.library.widgets.discreteseekbar.DiscreteSeekBar distanceBar = (DiscreteSeekBar) findViewById(R.id.distancebar);
        final TextView distancetext = (TextView) findViewById(R.id.distancetext);
        distanceBar.setProgress(7);
        distanceBar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                distancetext.setText("0-" + value + "km");
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });


    }

    private void initView() {
        sekizbitSwitch = new SekizbitSwitch(findViewById(R.id.sekizbit_switch));
        sekizbitSwitch.setSelected(0);
        TodayMenuPagerAdapter myPagerAdapter = new TodayMenuPagerAdapter(getSupportFragmentManager(), 2, 0);
        todaymenupager.setAdapter(myPagerAdapter);
        todaymenupager.setCurrentItem(0);
        sekizbitSwitch.setOnChangeListener(new SekizbitSwitch.OnSelectedChangeListener() {
            @Override
            public void OnSelectedChange(SekizbitSwitch sender) {
                if (sender.getCheckedIndex() == 0) {
                    TodayMenuPagerAdapter myPagerAdapter = new TodayMenuPagerAdapter(getSupportFragmentManager(), 2, 0);
                    todaymenupager.setAdapter(myPagerAdapter);
                    todaymenupager.setCurrentItem(0);
                } else {
                    TodayMenuPagerAdapter myPagerAdapter = new TodayMenuPagerAdapter(getSupportFragmentManager(), 2, 1);
                    todaymenupager.setAdapter(myPagerAdapter);
                    todaymenupager.setCurrentItem(1);
                }
            }
        });

    }

    private void setupFragment(int pos) {

        if (pos == 0) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_layout, new EventsFragment());
            transaction.commit();
        } else {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_layout, new ClubFragment());
            transaction.commit();
        }

    }


}
