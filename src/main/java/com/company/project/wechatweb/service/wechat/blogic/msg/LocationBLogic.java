package com.company.project.wechatweb.service.wechat.blogic.msg;

import com.company.project.wechatweb.service.wechat.blogic.BaseBLogic;
import com.company.project.wechatweb.service.wechat.msg.LocationMsg;
import org.springframework.stereotype.Component;

/**
 * 地理位置时间
 *
 * @author wangzhj
 */
@Component
public class LocationBLogic extends BaseBLogic<LocationMsg> {

    @Override
    public void processBusiness(String openId, LocationMsg msg) {
        LOGGER.info("1111111");
    }
}
