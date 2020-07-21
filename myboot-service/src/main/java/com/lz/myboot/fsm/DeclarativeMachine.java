package com.lz.myboot.fsm;

import org.squirrelframework.foundation.fsm.annotation.*;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

@States({
        @State(name = "A", entryCallMethod = "entryA", exitCallMethod = "exitA", initialState = true),
        @State(name = "B", entryCallMethod = "entryB", exitCallMethod = "exitB"),
        @State(name = "C", entryCallMethod = "entryC", exitCallMethod = "exitC"),
        @State(name = "D", entryCallMethod = "entryD", exitCallMethod = "exitD")
})
@Transitions({
        @Transit(from = "A", to = "B", on = "ATOB", callMethod = "toB"),
        @Transit(from = "B", to = "C", on = "BTOC", callMethod = "toC"),
        @Transit(from = "C", to = "D", on = "CTOD", callMethod = "toD")
})
@StateMachineParameters(stateType = MyState.class, eventType = MyEvent.class, contextType = MyContext.class)
public class DeclarativeMachine extends AbstractUntypedStateMachine {

    public void entryA(MyState from, MyState to, MyEvent on, MyContext context){

        System.out.println("---entryA");
    }
    public void exitA(MyState from, MyState to, MyEvent on, MyContext context){
        System.out.println("---exitA");
    }
    public void entryB(MyState from, MyState to, MyEvent on, MyContext context){
        System.out.println("---entryB");
    }
    public void exitB(MyState from, MyState to, MyEvent on, MyContext context){
        System.out.println("---exitB");
    }
    public void entryC(MyState from, MyState to, MyEvent on, MyContext context){
        System.out.println("---entryC");
    }
    public void exitC(MyState from, MyState to, MyEvent on, MyContext context){
        System.out.println("---exitC");
    }
    public void entryD(MyState from, MyState to, MyEvent on, MyContext context){
        System.out.println("---entryD");
    }
    public void exitD(MyState from, MyState to, MyEvent on, MyContext context){
        System.out.println("---exitD");
    }
    public void toB(MyState from, MyState to, MyEvent on, MyContext context){
        System.out.println("---toB");
    }
    public void toC(MyState from, MyState to, MyEvent on, MyContext context){
        System.out.println("---toC");
    }
    public void toD(MyState from, MyState to, MyEvent on, MyContext context){
        System.out.println("---toD");
    }
    
}

