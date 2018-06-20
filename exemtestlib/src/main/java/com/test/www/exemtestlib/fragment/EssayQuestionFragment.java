package com.test.www.exemtestlib.fragment;

import android.os.Bundle;

import com.test.www.exemtestlib.base.LazyFragment;
import com.test.www.exemtestlib.bean.QuestionBankBean;

/**
 * 问答业务
 */
public class EssayQuestionFragment extends LazyFragment{
    public static EssayQuestionFragment newInstance(QuestionBankBean questionBankBean){
        EssayQuestionFragment essayQuestionFragment=new EssayQuestionFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable("questionBankBean",questionBankBean);
        essayQuestionFragment.setArguments(bundle);
        return essayQuestionFragment;
    }
    @Override
    public boolean isLazyFragment() {
        return false;
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);

    }
}
