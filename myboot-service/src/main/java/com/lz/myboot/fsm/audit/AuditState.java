package com.lz.myboot.fsm.audit;

public enum AuditState {

    NOT_SUBMIT,
    ONLINE_AUDITING,
    PASSED,
    OFFLINE_AUDITING,
    REJECTED;

    //private Integer auditStatus;  //0未提交，1审核中，2已通过，3已驳回
    //private Integer auditType;    //1首次创建申请上线，2修改后申请上线，3已上线申请下线, 4已下线申请上线
    //private Integer operaterType; //1正式，2临时

//    private AuditState(Integer auditStatus){
//        this.auditStatus = auditStatus;
//    }
//
//    public Integer getAuditStatus() {
//        return auditStatus;
//    }

}