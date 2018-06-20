package com.test.www.exemtestlib.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.test.www.exemtestlib.R;
import com.test.www.exemtestlib.adapter.RadioChoiceAdapter;
import com.test.www.exemtestlib.base.LazyFragment;
import com.test.www.exemtestlib.bean.QuestionBankBean;
import com.test.www.exemtestlib.call.OptionCall;
import com.test.www.exemtestlib.call.ViewPageCall;
import com.test.www.exemtestlib.config.QuestionTypeConfig;
import com.test.www.exemtestlib.utils.StrUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 多选业务
 */
public class MulitselectChoiceFragment extends LazyFragment {
    private ListView mListView;
    private RadioChoiceAdapter mAdapter;
    private QuestionBankBean questionBankBean;
    private ViewPageCall mCall;
    private Set<String> stringSet;
    public static MulitselectChoiceFragment newInstance(QuestionBankBean questionBankBean){
        MulitselectChoiceFragment mulitselectChoiceFragment=new MulitselectChoiceFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable("questionBankBean",questionBankBean);
        mulitselectChoiceFragment.setArguments(bundle);
        return mulitselectChoiceFragment;
    }
    @Override
    public boolean isLazyFragment() {
        return false;
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.layout_listview);
        stringSet=new HashSet<>();
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
                    if(stringSet.contains(option)){
                        stringSet.remove(option);
                    }else {
                        stringSet.add(option);
                    }
                    if(stringSet.size()==0)
                        return;
                    mCall.CutCurrentViewPage(StrUtils.Instance().SetToString(stringSet));

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCall= (ViewPageCall) context;
    }
}
