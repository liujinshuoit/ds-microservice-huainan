package com.das.consultation.schedule;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.das.consultation.config.ParamConfig;
import com.das.consultation.entities.vo.mobilebi.FuYouZyzdAuthinfoBO;
import com.das.consultation.entities.vo.mobilebi.FuYouZyzdDTO;
import com.das.consultation.entities.vo.mobilebi.FuYouZyzdVO;
import com.das.consultation.service.mobilebi.FuYouService;
import com.das.consultation.util.DESUtils;
import com.das.consultation.util.OkHttpUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by LJS on 2021/3/14.
 */
@Configuration
@EnableScheduling
public class DataPushSchedule {

    private Logger logger = LoggerFactory.getLogger(DataPushSchedule.class);

    @Resource
    private FuYouService fuYouService;

    @Autowired
    private ParamConfig paramConfig;

    /**
     * 线程池（解决多个函数同时都使用@Scheduled时，彼此之间为串行问题）
     * @return
     */
    @Bean
    public ScheduledThreadPoolExecutor scheduledExecutorService() {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
        return executor;
    }

    /**
     * 育龄妇女早孕诊断信息推送
     */
    @Scheduled(cron = "${schedule.data.push.fertileWomanCorn}")
    public void fertileWomanDataPush() {
        /* 日志记录 */
        logger.info("==========fertile woman diagnosis of early pregnancy message push start...");

        /* 局部变量 */
        // 妇幼系统地址，后续改为配置
        String url = paramConfig.getFuYouUrl();
        // 认证token，后续改为配置
        String authtoken = paramConfig.getFuYouAuthToken();
        // 密钥，后续改为配置
        String ysKey = paramConfig.getFuYouKey();
        String key;
        try {
            key = Base64.encodeBase64String(ysKey.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            logger.error(">>>>>>key error: {}", e);
            return;
        }

        // 查询条数
        long queryCount = 0;
        // 推送成功条数
        long pushSuccessCount = 0;
        // 推送失败条数
        long pushFailCount = 0;

        /* 总时间记录 */
        long totalStart = System.currentTimeMillis();

        /* 数据查询 */
        long dataQueryStart = System.currentTimeMillis();
        List<FuYouZyzdVO> fuYouZyzdVOList = fuYouService.queryZyzdList();
        long dataQueryEnd = System.currentTimeMillis();
        if (null == fuYouZyzdVOList || fuYouZyzdVOList.isEmpty()) {
            logger.info(">>>>>>query data is empty");
            return;
        }
        queryCount = fuYouZyzdVOList.size();

        /* 数据加密并推送 */
        for (int i=0; i<fuYouZyzdVOList.size(); i++) {
            long dataPushStart = System.currentTimeMillis();
            String sfzh = fuYouZyzdVOList.get(i).getYfsfz();
            // 数据组装
            FuYouZyzdDTO fuYouZyzdDTO = new FuYouZyzdDTO();
            FuYouZyzdAuthinfoBO fuYouZyzdAuthinfoBO = new FuYouZyzdAuthinfoBO();
            fuYouZyzdAuthinfoBO.setServiceID("100001");
            fuYouZyzdDTO.setAuthinfo(fuYouZyzdAuthinfoBO);
            fuYouZyzdDTO.setDatainfo(fuYouZyzdVOList.get(i));
            String fuYouZyzdStr = JSONObject.toJSONString(fuYouZyzdDTO, SerializerFeature.WriteMapNullValue);
            String fuYouZyzdEncryptStr;
            try {
                // 数据加密
                long dataEncryptStart = System.currentTimeMillis();
                fuYouZyzdEncryptStr = DESUtils.encrypt(fuYouZyzdStr, key, key);
                long dataEncryptEnd = System.currentTimeMillis();
                logger.info("The {} data sfzh: {}, encrypt execute time: {}ms", i+1, sfzh, dataEncryptEnd - dataEncryptStart);
                // 数据推送
                StringBuffer requestUrlStr = new StringBuffer();
                requestUrlStr.append(url);
                requestUrlStr.append("?authtoken=");
                requestUrlStr.append(authtoken);
                requestUrlStr.append("&data=");
                requestUrlStr.append(fuYouZyzdEncryptStr);
                logger.info("The {} data request: {}", i+1, requestUrlStr);
                String encryptResult = OkHttpUtils.postParam(requestUrlStr.toString());
                logger.info("The {} data response: {}", i+1, encryptResult);
                // 推送结果解析
                if (StringUtils.isBlank(encryptResult)) {
                    logger.error("The {} data response null, sfzh: {}", i+1, sfzh);
                    continue;
                }
                String decryptResult = DESUtils.decrypt(encryptResult, key, key);
                JSONObject resultObj = JSONObject.parseObject(decryptResult);
                if (null == resultObj) {
                    logger.error("The {} data decrypt parse fail, sfzh: {}", i+1, sfzh);
                    pushFailCount++;
                    continue;
                }
                Object returnCodeObj = resultObj.get("returncode");
                if (null == returnCodeObj) {
                    logger.error("The {} data returncode decrypt parse fail, sfzh: {}", i+1, sfzh);
                    pushFailCount++;
                    continue;
                }
                Object returnMessageObj = resultObj.get("returnmessage");
                if (null == returnMessageObj) {
                    logger.error("The {} data returnmessage decrypt parse fail, sfzh: {}", i+1, sfzh);
                    pushFailCount++;
                    continue;
                }
                String returncode = returnCodeObj.toString();
                String returnmessage = returnMessageObj.toString();
                if ("000".equals(returncode)) {
                    logger.info("The {} data success, sfzh: {}", i+1, sfzh);
                    pushSuccessCount++;
                } else {
                    logger.info("The {} data fail, sfzh: {}, returncode: {}, returnmessage: {}", i+1, sfzh, returncode, returnmessage);
                    pushFailCount++;
                }
            } catch (Exception e) {
                logger.error("The {} data decrypt fail, sfzh: {}", i+1, sfzh);
                pushFailCount++;
                e.printStackTrace();
                continue;
            }
            long dataPushEnd = System.currentTimeMillis();
            logger.info("The {} data sfzh: {}, push execute time: {}ms", i+1, sfzh, dataPushEnd - dataPushStart);
        }

        /* 总时间记录 */
        long totalEnd = System.currentTimeMillis();
        logger.info(">>>>>>QueryCount: {}, Query execute time: {}ms;  PushSuccess: {}, PushFail: {}; Total execute time: {}ms", queryCount, (dataQueryEnd - dataQueryStart), pushSuccessCount, pushFailCount, (totalEnd - totalStart));
        /* 总结果记录 */
        logger.info("==========fertile woman diagnosis of early pregnancy message push end!!!");
    }

}