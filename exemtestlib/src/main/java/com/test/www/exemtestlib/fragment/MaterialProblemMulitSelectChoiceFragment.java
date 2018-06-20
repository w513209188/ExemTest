package com.test.www.exemtestlib.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.ArraySet;
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
import com.test.www.exemtestlib.view.HtmlTextView;

import java.util.HashSet;
import java.util.Set;

/**
 * 多选业务
 */
public class MaterialProblemMulitSelectChoiceFragment extends LazyFragment {
    private HtmlTextView mt_tv;
    private ListView bottom_lv;
    private QuestionBankBean questionBankBean;
    private RadioChoiceAdapter mAdapter;
    private ViewPageCall mCall;
    private Set<String> stringSet;
    public static MaterialProblemMulitSelectChoiceFragment newInstance(QuestionBankBean questionBankBean){
        MaterialProblemMulitSelectChoiceFragment mulitselectChoiceFragment=new MaterialProblemMulitSelectChoiceFragment();
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
        setContentView(R.layout.layout_main);
        stringSet=new HashSet<>();
        questionBankBean=getArguments().getParcelable("questionBankBean");
        mt_tv=getViewById(R.id.mt_tv);
        mt_tv.setOption(false);
        mt_tv.showTxt("fnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsbfnsfsgfsdjgkjdsjgfdjgjdjgjsgjsbjhvbjdfbvjbsjbvjdsbvjbdsjbvjdsbjvbsjbvjdsbjvbsdbjvsdbjgvbsdjbgsdbgjbsgbdsbgjbsdjbgsb");
        bottom_lv=getViewById(R.id.bottom_lv);
        mAdapter=new RadioChoiceAdapter(questionBankBean,getActivity());
        bottom_lv.setAdapter(mAdapter);
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
