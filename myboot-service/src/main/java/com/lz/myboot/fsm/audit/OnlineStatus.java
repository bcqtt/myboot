package com.lz.myboot.fsm.audit;

public enum OnlineStatus {

    ONT_ONLINE(1),
    ONLINE(2),
    OFFLINE(3);

    private Integer onlineStatus; //1:未上线，2已上线，3已下线

    private OnlineStatus(Integer onlineStatus){
        this.onlineStatus = onlineStatus;
    }

    public Integer getOnlineStatus() {
        return onlineStatus;
    }
}
