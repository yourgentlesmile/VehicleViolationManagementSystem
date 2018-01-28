package cn.xc.entity.DO;

import java.util.Date;

/**
 * @version V1.0
 * @Description: 数据表实体类基类，包含id，数据记录创建时间，修改时间，逻辑删除标志位
 * @Author XiongCheng
 * @Date 2018/1/21 22:45.
 */
public class BaseDO {

    protected Long id;

    /**
     * 创建时间
     */
    protected Date gmtCreate;

    /**
     * 最后修改时间
     */
    protected Date gmtModified;

    /**
     * 是否被删除1:已删除 0:未删除
     */
    protected Integer isDeleted;

    public BaseDO() {
    }

    public BaseDO(Long id, Date gmtCreate, Date gmtModified, Integer isDeleted) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDeleted = isDeleted;
    }
}
