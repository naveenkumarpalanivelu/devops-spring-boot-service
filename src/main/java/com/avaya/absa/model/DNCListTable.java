package com.avaya.absa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DNC_LIST_TBL")
public class DNCListTable {
	
	private long dncListId;
    private String dncListName="";
    
    public DNCListTable() {}
    
    public DNCListTable(long dncListId, String dncListName) {
		super();
		this.dncListId = dncListId;
		this.dncListName = dncListName;
	}

	@Id
    @Column(name = "DNC_LIST_ID", nullable = false)
    public long getDncListId() {
        return this.dncListId;
    }
    
    public void setDncListId(long dncListId) {
        this.dncListId = dncListId;
    }
    
    @Column(name = "DNC_LIST_NAME", nullable = false)
    public String getDncListName() {
        return this.dncListName;
    }
    
    public void setDncListName(String dncListName) {
        this.dncListName = dncListName;
    }

	@Override
	public String toString() {
		return "DNCListTable [dncListId=" + dncListId + ", dncListName=" + dncListName + "]";
	}
    
    

}
