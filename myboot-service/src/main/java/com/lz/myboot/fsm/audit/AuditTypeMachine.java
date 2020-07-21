package com.lz.myboot.fsm.audit;

import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;

public class AuditTypeMachine extends AbstractStateMachine<AuditTypeMachine, AuditType, AuditEvent, AuditContext> {

    public void firstApplyOnline(AuditType from, AuditType to, AuditEvent event, AuditContext context) {
        System.out.println("【首次申请上线】 from：" + from + ", to:" + to +", event:" +event +", context:" + context.getOperatType() );
    }

    public void updatedApplyOnline(AuditType from, AuditType to, AuditEvent event, AuditContext context) {
        System.out.println("【修改后申请上线】 from：" + from + ", to:" + to +", event:" +event +", context:" + context.getOperatType() );
    }

    public void onlineApplyOffline(AuditType from, AuditType to, AuditEvent event, AuditContext context) {
        System.out.println("【已在线申请下线】 from：" + from + ", to:" + to +", event:" +event +", context:" + context.getOperatType() );
    }

    public void offlineApplyOnline(AuditType from, AuditType to, AuditEvent event, AuditContext context) {
        System.out.println("【已下线申请上线】 from：" + from + ", to:" + to +", event:" +event +", context:" + context.getOperatType() );
    }

}
