package com.test.www.exemtestlib.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.test.www.exemtestlib.R;
import com.test.www.exemtestlib.call.OptionCall;
import com.test.www.exemtestlib.config.QuestionTypeConfig;
import com.test.www.exemtestlib.utils.StrUtils;
import com.test.www.exemtestlib.view.HtmlTextView;

import java.util.List;

public class CommonQuestionOptionAdapter extends BaseAdapter {
    private List<String> stringList;
    private Context mContext;
    private OptionCall mCall;
    private int selectOption=-1;
    private int questionType;
    public void setSelectOption(int selectOption) {
        this.selectOption = selectOption;
    }

    public void setmCall(OptionCall mCall) {
        this.mCall = mCall;
    }
    public CommonQuestionOptionAdapter(List<String> stringList, Context mContext,int type) {
        this.stringList = stringList;
        this.mContext = mContext;
        this.questionType=type;
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        CommonQuestionOptionHolder holder=null;
        final String s= (String) getItem(position);

        if(convertView==null){
            holder=new CommonQuestionOptionHolder();
            convertView=questionType==QuestionTypeConfig.RADIO_CHOICE||questionType==QuestionTypeConfig.MATERIAL_RADIO_CHOICE? LayoutInflater.from(mContext).inflate(R.layout.layout_option,null):LayoutInflater.from(mContext).inflate(R.layout.layout_duooption,null);
            holder.html_htv=convertView.findViewById(R.id.html_htv);
            holder.main_ll=convertView.findViewById(R.id.main_ll);
            holder.html_htv.setOption(true);
            convertView.setTag(holder);
        }else {
            holder= (CommonQuestionOptionHolder) convertView.getTag();
        }
        holder.html_htv.setAuotOption(position+1);
        holder.html_htv.showTxt(s+position);
        if(selectOption==position){
            holder.html_htv.showRightOption();
        }else {
            holder.html_htv.showNoDoOption();
        }

        final CommonQuestionOptionHolder finalHolder = holder;
        holder.html_htv.onClickOption(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionType==QuestionTypeConfig.RADIO_CHOICE||questionType==QuestionTypeConfig.MATERIAL_RADIO_CHOICE){
                    //单选
                    setSelectOption(position);
                    notifyDataSetChanged();
                }else {
                    //多选
                    if(finalHolder.html_htv.getTag()==null||!(Boolean) finalHolder.html_htv.getTag()){
                        finalHolder.html_htv.showRightOption();
                        finalHolder.html_htv.setTag(true);
                    }else {
                        finalHolder.html_htv.showNoDoOption();
                        finalHolder.html_htv.setTag(false);
                    }
                }
                mCall.getUserSelectOption(StrUtils.Instance().numberToLetter(position+1),questionType);
            }
        });
        return convertView;
    }
    class CommonQuestionOptionHolder{
        HtmlTextView html_htv;
        LinearLayout main_ll;
    }
}
