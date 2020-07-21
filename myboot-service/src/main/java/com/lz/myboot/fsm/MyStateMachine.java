package com.lz.myboot.fsm;

import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;

/**
 * 定义我的状态机：需继承AbstractStateMachine
 */
public class MyStateMachine extends AbstractStateMachine<MyStateMachine, MyState, MyEvent, MyContext> {

    public void fun1(MyState from, MyState to, MyEvent event, MyContext context) {

        System.out.println("fun1() 方法执行了。。。 from：" + from + ", to:" + to +", event:" +event +", context:" + context.num );
    }

}