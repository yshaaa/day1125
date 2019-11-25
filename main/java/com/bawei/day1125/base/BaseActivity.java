package com.bawei.day1125.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.day1125.contract.Contract;

public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements Contract.IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Layout()!=0){
            setContentView(Layout());
            initView();
            mPresenter=initPresenter();
            if (mPresenter != null) {
                mPresenter.Attch(this);
            }
            startCoding();
        }
    }

    protected abstract void startCoding();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int Layout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onEnd();
        }
    }
}
