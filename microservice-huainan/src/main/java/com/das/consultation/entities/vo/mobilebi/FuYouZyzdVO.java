package com.das.consultation.entities.vo.mobilebi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: LJS
 * @Date: 2022/1/26 15:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuYouZyzdVO {
    /**
     * 自增主键
     */
    private int id;

    /**
     * 卡号（门诊记录编号|按照某一特定编码规则赋予门(急)诊就诊对象的顺序号|）
     */
    private String jckh;

    /**
     * 女方姓名（居民姓名|就诊者在公安管理部门正式登记注册的姓氏和名称|）
     */
    private String yfxm;

    /**
     * 女方出生日期（出生日期|本人出生当天的公元纪年日期|）
     */
    private String yfcsrq;

    /**
     * 女方身份证（身份证号|本人身份证证件唯一号码标识|）
     */
    private String yfsfz;

    /**
     * 女方民族（民族名称|本人所属民族在特定编码体系中的名称|CT02.01.025.01）
     */
    private String yfmz;

    /**
     * 女方联系电话（本人电话号码|本人的电话号码。包括国际、国内区号和分机号|）
     */
    private String yflxdh;

    /**
     * 户籍及常住类型：1 户籍常住，2 常住非户籍(流入)，4 户籍非常住(流出)，9 其它（常住地址户籍标志/标识本人的常住地址是否为户籍所在地|L|1户籍2非户籍）
     */
    private String yfhjczlx;

    /**
     * 女子户籍地
     */
    private String yfhjd;

    /**
     * 女方居住地地址
     */
    private String yfxjddz;

    /**
     * 男子姓名
     */
    private String nzxm;

    /**
     * 男子出生日期
     */
    private String nzcsrq;

    /**
     * 男子身份证
     */
    private String nzsfz;

    /**
     * 男子民族
     */
    private String nzmz;

    /**
     * 男子联系电话
     */
    private String nzlxdh;

    /**
     * 男子居住地地址
     */
    private String nzxjddz;

    /**
     * 男子户籍地
     */
    private String nzhjd;

    /**
     * 妊娠次
     */
    private String rsc;

    /**
     * 产次
     */
    private String cc;

    /**
     * 是否怀孕
     */
    private String sfhy;

    /**
     * 怀孕日期（末次月经）（诊断日期|对患者所患疾病做出诊断时的公元纪年日期的完整描述|）
     */
    private String hyrq;

    /**
     * 预产期
     */
    private String ycq;

    /**
     * 建册时间
     */
    private String jcsj;

    /**
     * 孕册本号
     */
    private String ycbh;

    /**
     * 检查方法(代码表7.6)
     */
    private String jcff;

    /**
     * 检查医生
     */
    private String jcys;

    /**
     * 检查日期
     */
    private String jcrq;

    /**
     * 当前年度是否分娩
     */
    private String sffm;

    /**
     * 分娩日期
     */
    private String fmrq;

    /**
     * 分娩医院
     */
    private String fmyy;

    /**
     * 分娩方式
     */
    private String fmfs;

    /**
     * 数据来源 1-WIS 2-达实
     */
    private String DataSource;

    /**
     * 推送时间
     */
    private Date SendTime;

    /**
     * 应答代码
     */
    private String ResponseCode;

    /**
     * 应答说明
     */
    private String ResponseMessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJckh() {
        return jckh;
    }

    public void setJckh(String jckh) {
        this.jckh = jckh;
    }

    public String getYfxm() {
        return yfxm;
    }

    public void setYfxm(String yfxm) {
        this.yfxm = yfxm;
    }

    public String getYfcsrq() {
        return yfcsrq;
    }

    public void setYfcsrq(String yfcsrq) {
        this.yfcsrq = yfcsrq;
    }

    public String getYfsfz() {
        return yfsfz;
    }

    public void setYfsfz(String yfsfz) {
        this.yfsfz = yfsfz;
    }

    public String getYfmz() {
        return yfmz;
    }

    public void setYfmz(String yfmz) {
        this.yfmz = yfmz;
    }

    public String getYflxdh() {
        return yflxdh;
    }

    public void setYflxdh(String yflxdh) {
        this.yflxdh = yflxdh;
    }

    public String getYfhjczlx() {
        return yfhjczlx;
    }

    public void setYfhjczlx(String yfhjczlx) {
        this.yfhjczlx = yfhjczlx;
    }

    public String getYfhjd() {
        return yfhjd;
    }

    public void setYfhjd(String yfhjd) {
        this.yfhjd = yfhjd;
    }

    public String getYfxjddz() {
        return yfxjddz;
    }

    public void setYfxjddz(String yfxjddz) {
        this.yfxjddz = yfxjddz;
    }

    public String getNzxm() {
        return nzxm;
    }

    public void setNzxm(String nzxm) {
        this.nzxm = nzxm;
    }

    public String getNzcsrq() {
        return nzcsrq;
    }

    public void setNzcsrq(String nzcsrq) {
        this.nzcsrq = nzcsrq;
    }

    public String getNzsfz() {
        return nzsfz;
    }

    public void setNzsfz(String nzsfz) {
        this.nzsfz = nzsfz;
    }

    public String getNzmz() {
        return nzmz;
    }

    public void setNzmz(String nzmz) {
        this.nzmz = nzmz;
    }

    public String getNzlxdh() {
        return nzlxdh;
    }

    public void setNzlxdh(String nzlxdh) {
        this.nzlxdh = nzlxdh;
    }

    public String getNzxjddz() {
        return nzxjddz;
    }

    public void setNzxjddz(String nzxjddz) {
        this.nzxjddz = nzxjddz;
    }

    public String getNzhjd() {
        return nzhjd;
    }

    public void setNzhjd(String nzhjd) {
        this.nzhjd = nzhjd;
    }

    public String getRsc() {
        return rsc;
    }

    public void setRsc(String rsc) {
        this.rsc = rsc;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSfhy() {
        return sfhy;
    }

    public void setSfhy(String sfhy) {
        this.sfhy = sfhy;
    }

    public String getHyrq() {
        return hyrq;
    }

    public void setHyrq(String hyrq) {
        this.hyrq = hyrq;
    }

    public String getYcq() {
        return ycq;
    }

    public void setYcq(String ycq) {
        this.ycq = ycq;
    }

    public String getJcsj() {
        return jcsj;
    }

    public void setJcsj(String jcsj) {
        this.jcsj = jcsj;
    }

    public String getYcbh() {
        return ycbh;
    }

    public void setYcbh(String ycbh) {
        this.ycbh = ycbh;
    }

    public String getJcff() {
        return jcff;
    }

    public void setJcff(String jcff) {
        this.jcff = jcff;
    }

    public String getJcys() {
        return jcys;
    }

    public void setJcys(String jcys) {
        this.jcys = jcys;
    }

    public String getJcrq() {
        return jcrq;
    }

    public void setJcrq(String jcrq) {
        this.jcrq = jcrq;
    }

    public String getSffm() {
        return sffm;
    }

    public void setSffm(String sffm) {
        this.sffm = sffm;
    }

    public String getFmrq() {
        return fmrq;
    }

    public void setFmrq(String fmrq) {
        this.fmrq = fmrq;
    }

    public String getFmyy() {
        return fmyy;
    }

    public void setFmyy(String fmyy) {
        this.fmyy = fmyy;
    }

    public String getFmfs() {
        return fmfs;
    }

    public void setFmfs(String fmfs) {
        this.fmfs = fmfs;
    }

    public String getDataSource() {
        return DataSource;
    }

    public void setDataSource(String dataSource) {
        DataSource = dataSource;
    }

    public Date getSendTime() {
        return SendTime;
    }

    public void setSendTime(Date sendTime) {
        SendTime = sendTime;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String responseCode) {
        ResponseCode = responseCode;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        ResponseMessage = responseMessage;
    }
}
