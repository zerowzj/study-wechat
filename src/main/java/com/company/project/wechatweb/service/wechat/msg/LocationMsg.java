package com.company.project.wechatweb.service.wechat.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 地理位置事件消息
 *
 * @author wangzhj
 */
@XStreamAlias("xml")
public class LocationMsg extends Msg {

    //事件类型，LOCATION
    private String Event;
    //地理位置纬度
    private Float Latitude;
    //地理位置经度
    private Float Longitude;
    //地理位置精度
    private Float Precision;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public Float getLatitude() {
        return Latitude;
    }

    public void setLatitude(Float latitude) {
        Latitude = latitude;
    }

    public Float getLongitude() {
        return Longitude;
    }

    public void setLongitude(Float longitude) {
        Longitude = longitude;
    }

    public Float getPrecision() {
        return Precision;
    }

    public void setPrecision(Float precision) {
        Precision = precision;
    }
}
