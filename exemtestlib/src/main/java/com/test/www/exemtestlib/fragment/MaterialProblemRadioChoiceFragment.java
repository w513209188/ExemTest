package com.test.www.exemtestlib.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.test.www.exemtestlib.R;
import com.test.www.exemtestlib.adapter.RadioChoiceAdapter;
import com.test.www.exemtestlib.base.LazyFragment;
import com.test.www.exemtestlib.bean.QuestionBankBean;
import com.test.www.exemtestlib.call.OptionCall;
import com.test.www.exemtestlib.call.ViewPageCall;
import com.test.www.exemtestlib.view.HtmlTextView;

/**
 * 材料业务
 */
public class MaterialProblemRadioChoiceFragment extends LazyFragment{
    private HtmlTextView mt_tv;
    private ListView bottom_lv;
    private QuestionBankBean questionBankBean;
    private ViewPageCall mCall;
    private RadioChoiceAdapter mAdapter;
    public static MaterialProblemRadioChoiceFragment newInstance(QuestionBankBean questionBankBean){
        MaterialProblemRadioChoiceFragment materialProblemFragment=new MaterialProblemRadioChoiceFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable("questionBankBean",questionBankBean);
        materialProblemFragment.setArguments(bundle);
        return materialProblemFragment;
    }
    @Override
    public boolean isLazyFragment() {
        return false;
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.layout_main);
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
