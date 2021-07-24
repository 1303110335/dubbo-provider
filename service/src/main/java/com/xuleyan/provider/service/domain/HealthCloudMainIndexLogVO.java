package com.xuleyan.provider.service.domain;



import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 主索引日志
 * @author chenli
 * es 索引创建
 * {
 *     "settings": {
 *         "index": {
 *             "number_of_shards": 4,
 *             "number_of_replicas": 0
 *         }
 *     },
 *     "mappings": {
 *         "properties": {
 *             "orgGroup": {
 *                 "type": "keyword"
 *             },
 *             "creator": {
 *                 "type": "keyword"
 *             },
 *             "orgCode": {
 *                 "type": "keyword"
 *             },
 *             "gmtCreate": {
 *                 "format": "yyyy-MM-dd HH:mm:ss",
 *                 "type": "date"
 *             },
 *             "type": {
 *                 "type": "keyword"
 *             }
 *         }
 *     }
 * }
 *
 */
public class HealthCloudMainIndexLogVO {

    private String orgGroup;

    private String creator;

    private String orgCode;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    private Integer type;

	private String id;

    public String getOrgGroup() {
        return orgGroup;
    }

    public void setOrgGroup(String orgGroup) {
        this.orgGroup = orgGroup;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HealthCloudMainIndexLogVO{" +
                "orgGroup='" + orgGroup + '\'' +
                ", creator='" + creator + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", type=" + type +
                ", id='" + id + '\'' +
                '}';
    }
}
