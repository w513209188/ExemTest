package com.test.www.exemtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.test.www.exemtestlib.bean.QuestionBankBean;
import com.test.www.exemtestlib.call.ViewPageCall;
import com.test.www.exemtestlib.config.QuestionTypeConfig;
import com.test.www.exemtestlib.questionview.CommonQuestionBankView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPageCall{
    private CommonQuestionBankView cqbv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cqbv=this.findViewById(R.id.cqbv);
        cqbv.initData(getData(),getSupportFragmentManager());
    }
    private List<QuestionBankBean> getData(){
        List<QuestionBankBean> questionBankBeans=new ArrayList<>();
        QuestionBankBean questionBankBean1=new QuestionBankBean();
        questionBankBean1.setQuestionType(2);
        questionBankBean1.setIsCollect(1);
        QuestionBankBean questionBankBean2=new QuestionBankBean();
        questionBankBean2.setQuestionType(1);
        questionBankBean2.setIsCollect(2);

        QuestionBankBean questionBankBean3=new QuestionBankBean();
        questionBankBean3.setQuestionType(3);

        QuestionBankBean questionBankBean4=new QuestionBankBean();
        questionBankBean4.setQuestionType(4);


        questionBankBeans.add(questionBankBean1);
        questionBankBeans.add(questionBankBean2);
        questionBankBeans.add(questionBankBean3);
        questionBankBeans.add(questionBankBean4);
        return questionBankBeans;
    }

    @Override
    public void CutCurrentViewPage(String userSelectOption) {
        Log.e("切换",userSelectOption);
        cqbv.cutCurrentQuestion();
    }
}
