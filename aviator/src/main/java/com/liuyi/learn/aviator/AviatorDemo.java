package com.liuyi.learn.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

/**
 * AviatorDemo
 *
 * @author xc_liuyi
 * Create at: 2023/4/27
 */
public class AviatorDemo {
    public static void main(String[] args) {
        var time1 = System.currentTimeMillis();

        String script = "println(\"hello, AviatorScript!\");";
        Expression expression = AviatorEvaluator.getInstance().compile(script);
        expression.execute();

        var time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);

        AviatorEvaluator.getInstance().compile(script).execute();

        System.out.println(System.currentTimeMillis() - time2);
    }
}
