package com.das.consultation.entities.vo.mobilebi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJS
 * @Date: 2022/1/26 15:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuYouZyzdAuthinfoBO {

    /**
     * 服务标识
     */
    private String ServiceID;

    /**
     * 用户名（平台分配）
     */
    private String UserName;

    /**
     * 密码（平台分配）
     */
    private String UserPass;

    /**
     * 运行地区编码
     */
    private String RunRegionCode;

    /**
     * 医院ID
     */
    private String HospId;

    public String getServiceID() {
        return ServiceID;
    }

    public void setServiceID(String serviceID) {
        ServiceID = serviceID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPass() {
        return UserPass;
    }

    public void setUserPass(String userPass) {
        UserPass = userPass;
    }

    public String getRunRegionCode() {
        return RunRegionCode;
    }

    public void setRunRegionCode(String runRegionCode) {
        RunRegionCode = runRegionCode;
    }

    public String getHospId() {
        return HospId;
    }

    public void setHospId(String hospId) {
        HospId = hospId;
    }
}
