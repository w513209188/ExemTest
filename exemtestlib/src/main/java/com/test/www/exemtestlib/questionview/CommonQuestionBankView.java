package com.test.www.exemtestlib.questionview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.test.www.exemtestlib.R;
import com.test.www.exemtestlib.adapter.CommonQuestionAdapter;
import com.test.www.exemtestlib.bean.QuestionBankBean;
import com.test.www.exemtestlib.call.ViewPageCall;

import java.util.List;

public class CommonQuestionBankView extends LinearLayout{
    private com.wb.baselib.view.MyViewPager mViewPager;
    private CommonQuestionAdapter mAdapter;
    public CommonQuestionBankView(Context context) {
        this(context,null);
    }

    public CommonQuestionBankView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CommonQuestionBankView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }
    private void initView(Context context,AttributeSet attributeSet){
        View mView= LayoutInflater.from(context).inflate(R.layout.layout_question,this);
        mViewPager=mView.findViewById(R.id.question_vp);
    }
    public void initData(List<QuestionBankBean> questionBankBean, FragmentManager fragmentManager){
        mAdapter=new CommonQuestionAdapter(fragmentManager,questionBankBean);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(questionBankBean.size());
    }

    public void cutCurrentQuestion(){
        Log.e("你猜啊","-------"+mViewPager.getCurrentItem());
        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
    }
}
