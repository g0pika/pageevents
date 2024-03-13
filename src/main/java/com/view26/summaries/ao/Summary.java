package com.view26.summaries.ao;

import java.util.Date;
import net.java.ao.Entity;
import net.java.ao.Preload;
import net.java.ao.schema.NotNull;
import net.java.ao.schema.StringLength;


@Preload
public interface Summary extends Entity {
    
    @PrimaryKey
    String getBoardID();
    void setBoardID(String boardID);
    
    Date getDate();
    void setDate(Date date);

    String getCommentID();
    void setCommentID(String commentID);

    @StringLength(StringLength.UNLIMITED)
    String getSummary();
    @StringLength(StringLength.UNLIMITED)
    void setSummary(String dailyCard);
    
}
