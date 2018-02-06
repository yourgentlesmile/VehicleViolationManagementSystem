package cn.xc.constant;

/**
 * 公告板功能模块共享常量类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/24 10:42.
 */
public final class BulletinBoardConstant {
    /**
     * 按发布者ID查询<br>
     * 则param 需传入 java.lang.Long
     */
    public static final int QUERY_BY_PUBLISHER_ID = 0;
    /**
     * 按公告类型查询<br>
     * 则param 需传入 java.lang.Integer
     */
    public static final int QUERY_BY_TYPE = 1;
    /**
     * 按创建时间查询(区间)<br>
     * 则param 需传入 java.lang.String ,时间以逗号分隔
     *     List中index = 0的数据为查询日期开始时间<br>
     *     List中index = 1的数据为查询日期结束时间<br>
     */
    public static final int QUERY_BY_GMT_CREATE = 2;
    /**
     * 按修改时间查询(区间)<br>
     * 则param 需传入 java.lang.String ,时间以逗号分隔
     *     List中index = 0的数据为查询日期开始时间<br>
     *     List中index = 1的数据为查询日期结束时间<br>
     */
    public static final int QUERY_BY_GMT_MODIFIED = 3;
    /**
     * 获取所有公告<br>
     * 则param 为null
     */
    public static final int FETCH_ALL = 4;

    /**
     * 更新全部字段<br>
     * 则param需传入cn.xc.entity.DO.BulletinBoardDO
     */
    public static final int UPDATE_COLUMN_ALL = 0;
    /**
     * 批量更新全部字段<br>
     * 则param需传入java.util.List&lt;BaseDO&gt;
     */
    public static final int UPDATE_COLUMN_ALL_BY_LIST = 1;
    /**
     * 部分更新字段(非null)<br>
     * 则param需传入cn.xc.entity.DO.BulletinBoardDO
     */
    public static final int UPDATE_COLUMN_SELECTIVE = 2;
    /**
     * 批量部分更新字段(非null)<br>
     * 则param需传入java.util.List&lt;BaseDO&gt;
     */
    public static final int UPDATE_COLUMN_SELECTIVE_BY_LIST = 3;

}
