package com.lz.myboot.fsm.audit;

public enum AuditType {
    FIRST_APPLY_ONLINE(1),
    UPDATED_APPLY_ONLINE(2),
    ONLINE_APPLY_OFFLINE(3),
    OFFLINE_APPLY_ONLINE(4);

    private Integer auditType;    //1首次创建申请上线，2修改后申请上线，3已上线申请下线, 4已下线申请上线
    private AuditType(Integer auditType){
        this.auditType = auditType;
    }

    public Integer getAuditType() {
        return auditType;
    }
}
