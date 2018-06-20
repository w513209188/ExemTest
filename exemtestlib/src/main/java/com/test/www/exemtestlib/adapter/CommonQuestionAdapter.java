package com.test.www.exemtestlib.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.test.www.exemtestlib.bean.QuestionBankBean;
import com.test.www.exemtestlib.config.QuestionTypeConfig;
import com.test.www.exemtestlib.fragment.EssayQuestionFragment;
import com.test.www.exemtestlib.fragment.MaterialProblemMulitSelectChoiceFragment;
import com.test.www.exemtestlib.fragment.MaterialProblemRadioChoiceFragment;
import com.test.www.exemtestlib.fragment.MulitselectChoiceFragment;
import com.test.www.exemtestlib.fragment.RadioChoiceFragment;

import java.util.List;

/**
 * Created by desin on 2017/2/9.
 */

public class CommonQuestionAdapter extends FragmentStatePagerAdapter {
    private List<QuestionBankBean> mLists;
    public CommonQuestionAdapter(FragmentManager fm, List<QuestionBankBean> questionBankBeanList) {
        super(fm);
        this.mLists=questionBankBeanList;
    }
    @Override
    public Fragment getItem(int position) {
        if(position<mLists.size()){
            if(mLists.get(position).getQuestionType()== QuestionTypeConfig.RADIO_CHOICE){
                //单选
                return RadioChoiceFragment.newInstance(mLists.get(position));
            }else if(mLists.get(position).getQuestionType()== QuestionTypeConfig.MULITSELECT_CHOICE){
                //多选
                return MulitselectChoiceFragment.newInstance(mLists.get(position));
            }else if(mLists.get(position).getQuestionType()== QuestionTypeConfig.ESSAY_QUESTION){
                //问答
                return EssayQuestionFragment.newInstance(mLists.get(position));
            }else if(mLists.get(position).getQuestionType()== QuestionTypeConfig.MATERIAL_RADIO_CHOICE){
                //材料
                return MaterialProblemRadioChoiceFragment.newInstance(mLists.get(position));
            }else if(mLists.get(position).getQuestionType()== QuestionTypeConfig.MATERIAL_MULITSELECT_CHOICE){
                //材料
                return MaterialProblemMulitSelectChoiceFragment.newInstance(mLists.get(position));
            }
        }else {
          //加一页 作为答题卡
        }
        return null;
    }

    @Override
    public int getCount() {
        return mLists.size();
    }
}
