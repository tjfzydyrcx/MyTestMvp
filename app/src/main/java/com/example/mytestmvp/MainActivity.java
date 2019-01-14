package com.example.mytestmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mymvp.Utils.DateUtil;
import com.example.mymvp.base.BaseMvpActivity;
import com.example.mymvp.base.MvpListener;

import java.util.Date;
import java.util.List;

public class MainActivity extends BaseMvpActivity<DailyPresenterImpl, DailyModelImpl> implements DailyContract.DailyView {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        adapter = new DailyAdapter(this);
        RecyclerView rcv = (RecyclerView) findViewById(R.id.ac_main_rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setHasFixedSize(true);
        rcv.setAdapter(adapter);
    }

    private DailyAdapter adapter;

    @Override
    protected void loadData() {
        mPresenter.loadData(Api.DAILY_HISTORY + DateUtil.format(new Date(), "yyyyMMdd") + "");

    }


    @Override
    public void setData(List<DailyBean.StoriesBean> beanList) {
        adapter.setBeanList(beanList);

    }
}
