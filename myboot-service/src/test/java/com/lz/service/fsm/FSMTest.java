package com.lz.service.fsm;

import com.lz.myboot.MyBootApplication;
import com.lz.myboot.fsm.*;
import com.lz.myboot.fsm.audit.AuditContext;
import com.lz.myboot.fsm.audit.AuditEvent;
import com.lz.myboot.fsm.audit.AuditMachine;
import com.lz.myboot.fsm.audit.AuditState;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.squirrelframework.foundation.fsm.StateMachineBuilder;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyBootApplication.class})
public class FSMTest {

    @Autowired
    private AuditMachine auditMachine;

    @Test
    public void test1(){
        StateMachineBuilder<MyStateMachine, MyState, MyEvent, MyContext> builder =
                StateMachineBuilderFactory.create(MyStateMachine.class, MyState.class, MyEvent.class, MyContext.class);

        /**
         * 条件为：content.getNum 为20的时候转换，并执行fun1()方法
         */
        builder.externalTransition().from(MyState.A).to(MyState.B).on(MyEvent.ToB)
                .whenMvel("myCondition:::(context!=null && context.getNum() == 20)").callMethod("fun1");

        MyStateMachine machine = builder.newStateMachine(MyState.A);
        machine.start();
        System.out.println("currentState is " + machine.getCurrentState());
        MyContext context = new MyContext();
        context.setNum(20);
        machine.fire(MyEvent.ToB, context);
        System.out.println("currentState is " + machine.getCurrentState());
    }

    @Test
    public void testDeclarativeMachine(){
        UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(DeclarativeMachine.class);
        UntypedStateMachine fsm = builder.newAnyStateMachine(MyState.A);
        fsm.start();
        fsm.fire(MyEvent.ATOB);
        fsm.fire(MyEvent.BTOC);
        fsm.fire(MyEvent.CTOD);
    }

    @Test
    public void testAuditMachine(){
        AuditContext context = new AuditContext();
        context.setOperatType(1);

//        StateMachineBuilder<AuditMachine, AuditState, AuditEvent, AuditContext> builder =
//                StateMachineBuilderFactory.create(AuditMachine.class,AuditState.class,AuditEvent.class,AuditContext.class);
//        builder.externalTransition().from(AuditState.NOT_SUBMIT).to(AuditState.ONLINE_AUDITING).on(AuditEvent.SUBMIT_AUDITING).callMethod("submitAudit");
//        builder.externalTransition().from(AuditState.ONLINE_AUDITING).to(AuditState.PASSED).on(AuditEvent.PASS_AUDITING).callMethod("passedAudit");
//        builder.externalTransition().from(AuditState.ONLINE_AUDITING).to(AuditState.NOT_SUBMIT).on(AuditEvent.REPEAL_AUDITING).callMethod("repealAudit");
//        builder.externalTransition().from(AuditState.ONLINE_AUDITING).to(AuditState.REJECTED).on(AuditEvent.REJECT_AUDITING).callMethod("rejectAudit");
//        builder.externalTransition().from(AuditState.PASSED).to(AuditState.OFFLINE_AUDITING).on(AuditEvent.APPLY_OFFLINE).callMethod("applyOffline");
//        builder.externalTransition().from(AuditState.OFFLINE_AUDITING).to(AuditState.PASSED).on(AuditEvent.PASS_AUDITING).callMethod("passedAudit");
//        builder.externalTransition().from(AuditState.OFFLINE_AUDITING).to(AuditState.PASSED).on(AuditEvent.REPEAL_AUDITING).callMethod("repealAudit");
//        builder.externalTransition().from(AuditState.OFFLINE_AUDITING).to(AuditState.REJECTED).on(AuditEvent.REJECT_AUDITING).callMethod("rejectAudit");
//        AuditMachine machine = builder.newStateMachine(AuditState.NOT_SUBMIT);

        auditMachine.fire(AuditEvent.SUBMIT_AUDITING,context);
        log.info("【当前状态为】： " + auditMachine.getCurrentState());
        auditMachine.fire(AuditEvent.PASS_AUDITING,context);
        log.info("【当前状态为】： " + auditMachine.getCurrentState());
    }

}
