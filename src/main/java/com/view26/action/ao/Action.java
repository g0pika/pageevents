package com.view26.settings.ao;

import net.java.ao.Entity;
import net.java.ao.Preload;
import net.java.ao.DBParam;
import net.java.ao.schema.NotNull;
import java.sql.Time;

@Preload
public interface Action extends Entity {

    Time getActionTime();
    void setActionTime(Time actionTime);

    String getActionType();
    void setActionType(String actionType);
    
    int getPageId();
    void setPageId(int pageId); 

    String getUserKey();
    void setUserKey(String userKey);

}
