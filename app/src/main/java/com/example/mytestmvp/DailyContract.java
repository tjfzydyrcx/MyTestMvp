package com.example.mytestmvp;

import com.example.mymvp.base.BaseModel;
import com.example.mymvp.base.BasePresenter;
import com.example.mymvp.base.BaseView;
import com.example.mymvp.base.MvpListener;

import java.util.List;

/**
 * Created by Administrator on 2019-01-06 0006.
 */

public interface DailyContract {

    interface DailyModel extends BaseModel {
        void loadDaily(String url, MvpListener<List<DailyBean.StoriesBean>> listener);
    }

    interface DailyView extends BaseView {
        void setData(List<DailyBean.StoriesBean> beanList);

    }

    abstract class DailyPresenter extends BasePresenter<DailyModel, DailyView> {

        protected abstract void loadData(String url);
    }
}
