package com.lz.myboot.fsm.audit;

import lombok.extern.slf4j.Slf4j;
import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;

@Slf4j
public class AuditMachine extends AbstractStateMachine<AuditMachine, AuditState, AuditEvent, AuditContext> {

    public void submitAudit(AuditState from, AuditState to, AuditEvent event, AuditContext context) {
        log.info("【提交审核】 from：" + from + ", to:" + to +", event:" +event +", context:" + context.getOperatType() );
    }

    public void passedAudit(AuditState from, AuditState to, AuditEvent event, AuditContext context) {
        log.info("【审核通过】 from：" + from + ", to:" + to +", event:" +event +", context:" + context.getOperatType() );
    }

    public void repealAudit(AuditState from, AuditState to, AuditEvent event, AuditContext context) {
        log.info("【撤销审核】 from：" + from + ", to:" + to +", event:" +event +", context:" + context.getOperatType() );
    }

    public void rejectAudit(AuditState from, AuditState to, AuditEvent event, AuditContext context) {
        log.info("【拒绝审核】 from：" + from + ", to:" + to +", event:" +event +", context:" + context.getOperatType() );
    }

    public void applyOffline(AuditState from, AuditState to, AuditEvent event, AuditContext context) {
        log.info("【申请下线】 from：" + from + ", to:" + to +", event:" +event +", context:" + context.getOperatType() );
    }

    public void submitAuditReject2OnlineAuditing(AuditState from, AuditState to, AuditEvent event, AuditContext context) {
        log.info("【提交审核】 from：" + from + ", to:" + to +", event:" +event +", context:" + context.getOperatType() );
    }

    public void submitAuditReject2OfflineAuditing(AuditState from, AuditState to, AuditEvent event, AuditContext context) {
        log.info("【提交审核】 from：" + from + ", to:" + to +", event:" +event +", context:" + context.getOperatType() );
    }
}
