package com.test.www.exemtestlib.config;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 这个是题库  题型的配置
 */
@IntDef({
        QuestionTypeConfig.RADIO_CHOICE,
        QuestionTypeConfig.MULITSELECT_CHOICE,
        QuestionTypeConfig.MATERIAL_RADIO_CHOICE,
        QuestionTypeConfig.MATERIAL_MULITSELECT_CHOICE,
        QuestionTypeConfig.ESSAY_QUESTION,
})
@Retention(RetentionPolicy.SOURCE)
public @interface  QuestionTypeConfig {
    //普通单选标识
    int RADIO_CHOICE=1;
    //普通多选标识
    int MULITSELECT_CHOICE=2;
    //材料单选标识
    int MATERIAL_RADIO_CHOICE=3;
    //材料多选标识
    int MATERIAL_MULITSELECT_CHOICE=4;
    //问答标识
    int ESSAY_QUESTION=5;
}
