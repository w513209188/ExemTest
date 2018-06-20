package com.test.www.exemtestlib.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.test.www.exemtestlib.R;
import com.test.www.exemtestlib.bean.QuestionBankBean;
import com.test.www.exemtestlib.call.OptionCall;
import com.test.www.exemtestlib.view.HtmlTextView;
import com.test.www.exemtestlib.view.MyListView;

import java.util.ArrayList;
import java.util.List;

public class RadioChoiceAdapter extends BaseAdapter {
    private QuestionBankBean questionBankBean;
    private Context mContext;
    List<String> strings=new ArrayList<>();
    private OptionCall mCall;

    public void setmCall(OptionCall mCall) {
        this.mCall = mCall;
    }

    public RadioChoiceAdapter(QuestionBankBean questionBankBean, Context context) {
        this.questionBankBean = questionBankBean;
        this.mContext = context;
        strings.add("你猜"+questionBankBean.getIsCollect());
        strings.add("你猜"+questionBankBean.getIsCollect());
        strings.add("你猜"+questionBankBean.getIsCollect());
        strings.add("你猜"+questionBankBean.getIsCollect());
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(getItemViewType(position)==0){
            return getOneView(position,convertView);
        }else if(getItemViewType(position)==1){
            return getTwoView(position,convertView);
        }
        return null;
    }
    private View getOneView(int option,View convertView){
        RadioChoiceOneHolder holder=null;
        if(convertView==null){
            holder=new RadioChoiceOneHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.layout_option,null);
            holder.html_htv=convertView.findViewById(R.id.html_htv);
            holder.html_htv.setOption(false);
            convertView.setTag(holder);
        }else {
            holder= (RadioChoiceOneHolder) convertView.getTag();
        }
        holder.html_htv.showTxt("问题提");
        return convertView;
    }
    private View getTwoView(int option,View convertView){
        RadioChoiceTwoHolder holder=null;
        CommonQuestionOptionAdapter mAdapter=null;
        if(convertView==null){
            holder=new RadioChoiceTwoHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.layout_mylistview,null);
            holder.myListView=convertView.findViewById(R.id.mylistview);
            convertView.setTag(holder);
            mAdapter=new CommonQuestionOptionAdapter(strings,mContext,questionBankBean.getQuestionType());
            mAdapter.setmCall(new OptionCall() {
                @Override
                public void getUserSelectOption(String option,int type) {
                    if(mCall==null)
                        return;
                    mCall.getUserSelectOption(option,type);
                }
            });
            holder.myListView.setAdapter(mAdapter);
        }else {
            holder= (RadioChoiceTwoHolder) convertView.getTag();
        }
        return convertView;
    }

    class RadioChoiceOneHolder{
        HtmlTextView html_htv;
    }
    class RadioChoiceTwoHolder{
       MyListView myListView;
    }
}
