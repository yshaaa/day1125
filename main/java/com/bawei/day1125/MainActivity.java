package com.bawei.day1125;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.day1125.adapter.MyAdapter;
import com.bawei.day1125.base.BaseActivity;
import com.bawei.day1125.base.BasePresenter;
import com.bawei.day1125.bean.ShopBean;
import com.bawei.day1125.presenter.Presenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView recy;

   private String http="http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList?page=1&count=20";

    @Override
    protected void startCoding() {
        mPresenter.start(http);
    }

    @Override
    protected void initView() {

        recy = (RecyclerView) findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected int Layout() {
        return R.layout.activity_main;
    }

    @Override
    public void Success(String json) {
        List<ShopBean.ResultBean> list = new Gson().fromJson(json, ShopBean.class).getResult();
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,list);
        recy.setAdapter(myAdapter);

    }

    @Override
    public void Error(String error) {

    }
}
