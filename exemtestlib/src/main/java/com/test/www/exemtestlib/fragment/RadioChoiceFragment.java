package com.test.www.exemtestlib.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.test.www.exemtestlib.R;
import com.test.www.exemtestlib.adapter.CommonQuestionAdapter;
import com.test.www.exemtestlib.adapter.RadioChoiceAdapter;
import com.test.www.exemtestlib.base.LazyFragment;
import com.test.www.exemtestlib.bean.QuestionBankBean;
import com.test.www.exemtestlib.call.OptionCall;
import com.test.www.exemtestlib.call.ViewPageCall;
import com.test.www.exemtestlib.config.QuestionTypeConfig;
import com.test.www.exemtestlib.utils.StrUtils;
import com.test.www.exemtestlib.view.HtmlTextView;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 单选业务
 */
public class RadioChoiceFragment extends LazyFragment {
    private ListView mListView;
    private RadioChoiceAdapter mAdapter;
    private QuestionBankBean questionBankBean;
    private ViewPageCall mCall;
    public static RadioChoiceFragment newInstance(QuestionBankBean questionBankBean){
        RadioChoiceFragment radioChoiceFragment=new RadioChoiceFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable("questionBankBean",questionBankBean);
        radioChoiceFragment.setArguments(bundle);
        return radioChoiceFragment;
    }
    @Override
    public boolean isLazyFragment() {
        return false;
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.layout_listview);
        questionBankBean=getArguments().getParcelable("questionBankBean");
        mListView=getViewById(R.id.question_lv);
        mAdapter=new RadioChoiceAdapter(questionBankBean,getActivity());
        mListView.setAdapter(mAdapter);
        setListener();
    }

    @Override
    protected void setListener() {
        super.setListener();
        mAdapter.setmCall(new OptionCall() {
            @Override
            public void getUserSelectOption(String option,int type) {
                Log.e("点击了单选","-----");
                    mCall.CutCurrentViewPage(option);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCall= (ViewPageCall) context;
    }

}
