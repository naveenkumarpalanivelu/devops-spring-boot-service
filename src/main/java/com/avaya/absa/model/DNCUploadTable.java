package com.avaya.absa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DNC_UPLOAD_TBL")
public class DNCUploadTable
{
    private long id;
    private String firstName= "";
    private String lastName= "";
    private String accountNo= "";
    private String clientIdNumber= "";
    private String customDncList= "";
    private String startTimeDate= "";
    private String endTimeDate= "";
    private String reason= "";
    private String phone1= "";
    private String phone2= "";
    private String phone3= "";
    private String phone4= "";
    private String phone5= "";
    private String phone6= "";
    private String phone7= "";
    private String phone8= "";
    private String email1= "";
    private String email2= "";
    private String email3= "";
    private String email4= "";
    private String email5= "";
    private String dncStartTimeDate= "";
    private String dncEndTimeDate= "";
    private String createdDate= "";
    private String updatedDate= "";
    private String startProcessFlag= "N";
    private String endProcessFlag= "N";
    private long dncListId;
    
    public DNCUploadTable() {}
    
    
    
    public DNCUploadTable(long id, String firstName, String lastName, String accountNo, String clientIdNumber,
			String customDncList, String startTimeDate, String endTimeDate, String reason, String phone1, String phone2,
			String phone3, String phone4, String phone5, String phone6, String phone7, String phone8, String email1,
			String email2, String email3, String email4, String email5, String dncStartTimeDate, String dncEndTimeDate,
			String createdDate, String updatedDate, String startProcessFlag, String endProcessFlag, long dncListId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNo = accountNo;
		this.clientIdNumber = clientIdNumber;
		this.customDncList = customDncList;
		this.startTimeDate = startTimeDate;
		this.endTimeDate = endTimeDate;
		this.reason = reason;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.phone4 = phone4;
		this.phone5 = phone5;
		this.phone6 = phone6;
		this.phone7 = phone7;
		this.phone8 = phone8;
		this.email1 = email1;
		this.email2 = email2;
		this.email3 = email3;
		this.email4 = email4;
		this.email5 = email5;
		this.dncStartTimeDate = dncStartTimeDate;
		this.dncEndTimeDate = dncEndTimeDate;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.startProcessFlag = startProcessFlag;
		this.endProcessFlag = endProcessFlag;
		this.dncListId = dncListId;
	}



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "FIRST_NAME", nullable = true)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name = "LAST_NAME", nullable = true)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Column(name = "ACCOUNT_NO", nullable = true)
    public String getAccountNo() {
        return this.accountNo;
    }
    
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    
    @Column(name = "CLIENT_ID_NUMBER", nullable = true)
    public String getClientIdNumber() {
        return this.clientIdNumber;
    }
    
    public void setClientIdNumber(String clientIdNumber) {
        this.clientIdNumber = clientIdNumber;
    }
    
    @Column(name = "CUSTOM_DNC_LIST", nullable = true)
    public String getCustomDncList() {
        return this.customDncList;
    }
    
    public void setCustomDncList(String customDncList) {
        this.customDncList = customDncList;
    }
    
    @Column(name = "START_TIME_DATE", nullable = true)
    public String getStartTimeDate() {
        return this.startTimeDate;
    }
    
    public void setStartTimeDate(String startTimeDate) {
        this.startTimeDate = startTimeDate;
    }
    
    @Column(name = "END_TIME_DATE", nullable = true)
    public String getEndTimeDate() {
        return this.endTimeDate;
    }
    
    public void setEndTimeDate(String endTimeDate) {
        this.endTimeDate = endTimeDate;
    }
    
    @Column(name = "REASON", nullable = true)
    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    @Column(name = "PHONE1", nullable = true)
    public String getPhone1() {
        return this.phone1;
    }
    
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }
    
    @Column(name = "PHONE2", nullable = true)
    public String getPhone2() {
        return this.phone2;
    }
    
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
    
    @Column(name = "PHONE3", nullable = true)
    public String getPhone3() {
        return this.phone3;
    }
    
    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }
    
    @Column(name = "PHONE4", nullable = true)
    public String getPhone4() {
        return this.phone4;
    }
    
    public void setPhone4(String phone4) {
        this.phone4 = phone4;
    }
    
    @Column(name = "PHONE5", nullable = true)
    public String getPhone5() {
        return this.phone5;
    }
    
    public void setPhone5(String phone5) {
        this.phone5 = phone5;
    }
    
    @Column(name = "PHONE6", nullable = true)
    public String getPhone6() {
        return this.phone6;
    }
    
    public void setPhone6(String phone6) {
        this.phone6 = phone6;
    }
    
    @Column(name = "PHONE7", nullable = true)
    public String getPhone7() {
        return this.phone7;
    }
    
    public void setPhone7(String phone7) {
        this.phone7 = phone7;
    }
    
    @Column(name = "PHONE8", nullable = true)
    public String getPhone8() {
        return this.phone8;
    }
    
    public void setPhone8(String phone8) {
        this.phone8 = phone8;
    }
    
    @Column(name = "EMAIL1", nullable = true)
    public String getEmail1() {
        return this.email1;
    }
    
    public void setEmail1(String email1) {
        this.email1 = email1;
    }
    
    @Column(name = "EMAIL2", nullable = true)
    public String getEmail2() {
        return this.email2;
    }
    
    public void setEmail2(String email2) {
        this.email2 = email2;
    }
    
    @Column(name = "EMAIL3", nullable = true)
    public String getEmail3() {
        return this.email3;
    }
    
    public void setEmail3(String email3) {
        this.email3 = email3;
    }
    
    @Column(name = "EMAIL4", nullable = true)
    public String getEmail4() {
        return this.email4;
    }
    
    public void setEmail4(String email4) {
        this.email4 = email4;
    }
    
    @Column(name = "EMAIL5", nullable = true)
    public String getEmail5() {
        return this.email5;
    }
    
    public void setEmail5(String email5) {
        this.email5 = email5;
    }
    
    @Column(name = "DNC_START_TIME_DATE", nullable = true)
    public String getDncStartTimeDate() {
        return this.dncStartTimeDate;
    }
    
    public void setDncStartTimeDate(String dncStartTimeDate) {
        this.dncStartTimeDate = dncStartTimeDate;
    }
    
    @Column(name = "DNC_END_TIME_DATE", nullable = true)
    public String getDncEndTimeDate() {
        return this.dncEndTimeDate;
    }
    
    public void setDncEndTimeDate(String dncEndTimeDate) {
        this.dncEndTimeDate = dncEndTimeDate;
    }
    
    @Column(name = "CREATED_DATE", nullable = true)
    public String getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    
    @Column(name = "UPDATED_DATE", nullable = true)
    public String getUpdatedDate() {
        return this.updatedDate;
    }
    
    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    @Column(name = "START_PROCESS_FLAG", nullable = true)
    public String getStartProcessFlag() {
        return this.startProcessFlag;
    }
    
    public void setStartProcessFlag(String startProcessFlag) {
        this.startProcessFlag = startProcessFlag;
    }
    
    @Column(name = "END_PROCESS_FLAG", nullable = true)
    public String getEndProcessFlag() {
        return this.endProcessFlag;
    }
    
    public void setEndProcessFlag(String endProcessFlag) {
        this.endProcessFlag = endProcessFlag;
    }
    
    @Column(name = "DNC_LIST_ID", nullable = true)
    public long getDncListId() {
        return this.dncListId;
    }
    
    public void setDncListId(long dncListId) {
        this.dncListId = dncListId;
    }

	@Override
	public String toString() {
		return "DNCUploadTable [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", accountNo="
				+ accountNo + ", clientIdNumber=" + clientIdNumber + ", customDncList=" + customDncList
				+ ", startTimeDate=" + startTimeDate + ", endTimeDate=" + endTimeDate + ", reason=" + reason
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3=" + phone3 + ", phone4=" + phone4
				+ ", phone5=" + phone5 + ", phone6=" + phone6 + ", phone7=" + phone7 + ", phone8=" + phone8
				+ ", email1=" + email1 + ", email2=" + email2 + ", email3=" + email3 + ", email4=" + email4
				+ ", email5=" + email5 + ", dncStartTimeDate=" + dncStartTimeDate + ", dncEndTimeDate=" + dncEndTimeDate
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", startProcessFlag="
				+ startProcessFlag + ", endProcessFlag=" + endProcessFlag + ", dncListId=" + dncListId + "]";
	}
    
    
}
