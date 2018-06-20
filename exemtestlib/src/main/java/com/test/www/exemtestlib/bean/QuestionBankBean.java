package com.test.www.exemtestlib.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 这个是题型的公共模块，用于配置题相关的信息
 */
public class QuestionBankBean implements Parcelable {
    //题的类型
    private  int questionType;
    //题号
    private long questionNum;
    //题模块
    private int questionModel;
    //问题
    private String questionIssue;
    //题干
    private String questionStem;
    //选项
    private List<String> option;
    //用户定义的选项
    private List<UserOptionBean> userOption;
    //是否收藏
    private int isCollect;

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public long getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(long questionNum) {
        this.questionNum = questionNum;
    }

    public int getQuestionModel() {
        return questionModel;
    }

    public void setQuestionModel(int questionModel) {
        this.questionModel = questionModel;
    }

    public String getQuestionIssue() {
        return questionIssue;
    }

    public void setQuestionIssue(String questionIssue) {
        this.questionIssue = questionIssue;
    }

    public String getQuestionStem() {
        return questionStem;
    }

    public void setQuestionStem(String questionStem) {
        this.questionStem = questionStem;
    }

    public List<String> getOption() {
        return option;
    }

    public void setOption(List<String> option) {
        this.option = option;
    }

    public List<UserOptionBean> getUserOption() {
        return userOption;
    }

    public void setUserOption(List<UserOptionBean> userOption) {
        this.userOption = userOption;
    }

    public int getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(int isCollect) {
        this.isCollect = isCollect;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.questionType);
        dest.writeLong(this.questionNum);
        dest.writeInt(this.questionModel);
        dest.writeString(this.questionIssue);
        dest.writeString(this.questionStem);
        dest.writeStringList(this.option);
        dest.writeTypedList(this.userOption);
        dest.writeInt(this.isCollect);
    }

    public QuestionBankBean() {
    }

    protected QuestionBankBean(Parcel in) {
        this.questionType = in.readInt();
        this.questionNum = in.readLong();
        this.questionModel = in.readInt();
        this.questionIssue = in.readString();
        this.questionStem = in.readString();
        this.option = in.createStringArrayList();
        this.userOption = in.createTypedArrayList(UserOptionBean.CREATOR);
        this.isCollect = in.readInt();
    }

    public static final Parcelable.Creator<QuestionBankBean> CREATOR = new Parcelable.Creator<QuestionBankBean>() {
        @Override
        public QuestionBankBean createFromParcel(Parcel source) {
            return new QuestionBankBean(source);
        }

        @Override
        public QuestionBankBean[] newArray(int size) {
            return new QuestionBankBean[size];
        }
    };
}
