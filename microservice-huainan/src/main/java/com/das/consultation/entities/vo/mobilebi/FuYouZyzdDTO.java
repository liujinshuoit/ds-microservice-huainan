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
public class FuYouZyzdDTO {

    /**
     * 授权信息
     */
    private FuYouZyzdAuthinfoBO authinfo;

    /**
     * 数据信息
     */
    private FuYouZyzdVO datainfo;

    public FuYouZyzdAuthinfoBO getAuthinfo() {
        return authinfo;
    }

    public void setAuthinfo(FuYouZyzdAuthinfoBO authinfo) {
        this.authinfo = authinfo;
    }

    public FuYouZyzdVO getDatainfo() {
        return datainfo;
    }

    public void setDatainfo(FuYouZyzdVO datainfo) {
        this.datainfo = datainfo;
    }
}
