package com.lz.myboot.config;

import com.lz.myboot.fsm.audit.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.squirrelframework.foundation.fsm.StateMachineBuilder;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;

@Configuration
public class StateMachineConfig {

    @Bean
    public AuditMachine initAuditMachine(){
        StateMachineBuilder<AuditMachine, AuditState, AuditEvent, AuditContext> builder =
                StateMachineBuilderFactory.create(AuditMachine.class,AuditState.class,AuditEvent.class,AuditContext.class);
        builder.externalTransition().from(AuditState.NOT_SUBMIT).to(AuditState.ONLINE_AUDITING).on(AuditEvent.SUBMIT_AUDITING).callMethod("submitAudit");
        builder.externalTransition().from(AuditState.ONLINE_AUDITING).to(AuditState.PASSED).on(AuditEvent.PASS_AUDITING).callMethod("passedAudit");
        builder.externalTransition().from(AuditState.ONLINE_AUDITING).to(AuditState.NOT_SUBMIT).on(AuditEvent.REPEAL_AUDITING).callMethod("repealAudit");
        builder.externalTransition().from(AuditState.ONLINE_AUDITING).to(AuditState.REJECTED).on(AuditEvent.REJECT_AUDITING).callMethod("rejectAudit");
        builder.externalTransition().from(AuditState.REJECTED).to(AuditState.ONLINE_AUDITING).on(AuditEvent.SUBMIT_AUDITING).callMethod("submitAuditReject2OnlineAuditing");
        builder.externalTransition().from(AuditState.REJECTED).to(AuditState.OFFLINE_AUDITING).on(AuditEvent.SUBMIT_AUDITING).callMethod("submitAuditReject2OfflineAuditing");
        builder.externalTransition().from(AuditState.PASSED).to(AuditState.OFFLINE_AUDITING).on(AuditEvent.APPLY_OFFLINE).callMethod("applyOffline");
        builder.externalTransition().from(AuditState.OFFLINE_AUDITING).to(AuditState.PASSED).on(AuditEvent.PASS_AUDITING).callMethod("passedAudit");
        builder.externalTransition().from(AuditState.OFFLINE_AUDITING).to(AuditState.PASSED).on(AuditEvent.REPEAL_AUDITING).callMethod("repealAudit");
        builder.externalTransition().from(AuditState.OFFLINE_AUDITING).to(AuditState.REJECTED).on(AuditEvent.REJECT_AUDITING).callMethod("rejectAudit");
        AuditMachine machine = builder.newStateMachine(AuditState.NOT_SUBMIT);
        return machine;
    }

    @Bean
    public AuditTypeMachine initAuditTypeMachine(){
        StateMachineBuilder<AuditTypeMachine, AuditType, AuditEvent, AuditContext> builder =
                StateMachineBuilderFactory.create(AuditTypeMachine.class,AuditType.class,AuditEvent.class,AuditContext.class);
        //首次创建申请上线
        builder.externalTransition().from(AuditType.START_STATE).to(AuditType.FIRST_APPLY_ONLINE).on(AuditEvent.SUBMIT_AUDITING).callMethod("firstApplyOnline");
        //已上线申请下线(无修改)
        builder.externalTransition().from(AuditType.FIRST_APPLY_ONLINE).to(AuditType.ONLINE_APPLY_OFFLINE).on(AuditEvent.SUBMIT_AUDITING).callMethod("applyOfflineSubmit");
        //修改后申请上线
        builder.externalTransition().from(AuditType.START_STATE).to(AuditType.UPDATED_APPLY_ONLINE).on(AuditEvent.SUBMIT_AUDITING).callMethod("updatedApplyOnline");
        //已上线申请下线(修改后)
        builder.externalTransition().from(AuditType.UPDATED_APPLY_ONLINE).to(AuditType.ONLINE_APPLY_OFFLINE).on(AuditEvent.SUBMIT_AUDITING).callMethod("applyOfflineSubmit");
        //已下线申请上线
        builder.externalTransition().from(AuditType.ONLINE_APPLY_OFFLINE).to(AuditType.OFFLINE_APPLY_ONLINE).on(AuditEvent.SUBMIT_AUDITING).callMethod("applyOfflineSubmit");
        //已上线申请下线(下线重新上线后)
        builder.externalTransition().from(AuditType.OFFLINE_APPLY_ONLINE).to(AuditType.ONLINE_APPLY_OFFLINE).on(AuditEvent.SUBMIT_AUDITING).callMethod("applyOfflineSubmit");
        AuditTypeMachine machine = builder.newStateMachine(AuditType.START_STATE);
        return machine;
    }
}

