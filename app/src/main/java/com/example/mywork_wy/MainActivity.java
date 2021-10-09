package com.example.mywork_wy;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout mTabweixin;
    private LinearLayout mTabfrd;
    private LinearLayout mTabcontact;
    private LinearLayout mTabsetting;

    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgcontact;
    private ImageButton mImgSettings;

    private Fragment mTab05;
    private Fragment mTab01 = new weixinFragment();
    private Fragment mTab02 = new frdFragment();
    private Fragment mTab03 = new contactFragment();
    private Fragment mTab04 = new settingsFragment();

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        initFragment();
        selectfragment(0);
    }

    private void initFragment(){
        //fragment的切换
        fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content,mTab01);
        transaction.add(R.id.id_content,mTab02);
        transaction.add(R.id.id_content,mTab03);
        transaction.add(R.id.id_content,mTab04);
        transaction.commit();
    }

    private void initEvent(){
        mTabweixin.setOnClickListener(this);
        mTabfrd.setOnClickListener(this);
        mTabcontact.setOnClickListener(this);
        mTabsetting.setOnClickListener(this);
    }

    private void initView() {
        //改变图标的颜色
        mTabweixin = (LinearLayout)findViewById(R.id.id_tab_weixin);
        mTabfrd = (LinearLayout)findViewById(R.id.id_tab_frd);
        mTabcontact = (LinearLayout)findViewById(R.id.id_tab_contact);
        mTabsetting = (LinearLayout)findViewById(R.id.id_tab_settings);

        mImgWeixin = (ImageButton)findViewById(R.id.id_tab_weixin_img);
        mImgFrd = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mImgcontact = (ImageButton)findViewById(R.id.id_tab_contact_img);
        mImgSettings = (ImageButton)findViewById(R.id.id_tab_settings_img);
    }

    private void selectfragment(int i){
        //显示选中界面的内容，选中界面图标为绿色
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                Log.d("setSelect","1");
                transaction.show(mTab01);
                mImgWeixin.setImageResource(R.drawable.p5);
                break;
            case 1:
                transaction.show(mTab02);
                mImgFrd.setImageResource(R.drawable.p6);
                break;
            case 2:
                transaction.show(mTab03);
                mImgcontact.setImageResource(R.drawable.p7);
                break;
            case 3:
                transaction.show(mTab04);
                mImgSettings.setImageResource(R.drawable.p8);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        //把没有使用的界面的内容隐藏
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);
    }

    @Override
    public void onClick(View view) {
        //监听函数，监听到底是哪一个图标被击中从而显示哪一个界面的内容
        resetimg();
        switch (view.getId()){
            case R.id.id_tab_weixin:
                selectfragment(0);
                break;
            case R.id.id_tab_frd:
                selectfragment(1);
                break;
            case R.id.id_tab_contact:
                selectfragment(2);
                break;
            case R.id.id_tab_settings:
                selectfragment(3);
                break;
        }
    }

    public void resetimg(){
        //没有使用的界面的图标为灰色
        mImgWeixin.setImageResource(R.drawable.p5);
        mImgFrd.setImageResource(R.drawable.p6);
        mImgcontact.setImageResource(R.drawable.p7);
        mImgSettings.setImageResource(R.drawable.p8);
    }
}
