package cn.edu.upc.yb.integrate.material.model;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2017/2/10.
 */
@Entity
@Table(name = "BorrowMaterial")
public class BorrowMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String borrowerName;//借用人名字
    private String borrowerNumber;//借用人电话
    private int borrowNumber;//借用数目
    private String reason;//借用原因
    private long startTime;//开始时间
    private long endTime;//结束时间


    private long creatTime;//创建时间
    private int materialId;//物资id
    private String materialName;
    private String materialOrganization;
    private int borrowerYibanId;//借用人易班id

    private int isAgree;//同意情况
    private boolean isReturn;//是否归还
    private String returnStatus;//归还情况



    public BorrowMaterial() {
    }

    public BorrowMaterial(String borrowerName, String borrowerNumber, int borrowerYibanId, String reason, long startTime, long endTime, long creatTime, int materialId, int borrowNumber) {
        this.borrowerName = borrowerName;
        this.borrowerNumber = borrowerNumber;
        this.borrowerYibanId = borrowerYibanId;
        this.reason = reason;
        this.startTime = startTime;
        this.endTime = endTime;
        this.creatTime = creatTime;
        this.materialId = materialId;
        this.borrowNumber = borrowNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getBorrowerNumber() {
        return borrowerNumber;
    }

    public void setBorrowerNumber(String borrowerNumber) {
        this.borrowerNumber = borrowerNumber;
    }

    public int getBorrowerYibanId() {
        return borrowerYibanId;
    }

    public void setBorrowerYibanId(int borrowerYibanId) {
        this.borrowerYibanId = borrowerYibanId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(long creatTime) {
        this.creatTime = creatTime;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getBorrowNumber() {
        return borrowNumber;
    }

    public void setBorrowNumber(int borrowNumber) {
        this.borrowNumber = borrowNumber;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public int getIsAgree() {
        return isAgree;
    }

    public void setAgree(int agree) {
        isAgree = agree;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public void setReturn(boolean aReturn) {
        isReturn = aReturn;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialOrganization() {
        return materialOrganization;
    }

    public void setMaterialOrganization(String materialOrganization) {
        this.materialOrganization = materialOrganization;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }
}
