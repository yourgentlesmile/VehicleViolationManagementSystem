package cn.xc.constant;

/**
 * 违章信息常量类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/1 13:09.
 */
public final class ViolatingInformationConstant {
    /**
     * 按ID查询<br>
     * 则param 需传入 java.lang.Long
     */
    public static final int QUERY_BY_ID = 0;
    /**
     * 按违章人员编号查询<br>
     * 则param 需传入 java.lang.String
     */
    public static final int QUERY_BY_IDENTIFIER = 1;
    /**
     * 按违章类型查询<br>
     * 则param 需传入 java.lang.Integer
     */
    public static final int QUERY_BY_VIOLATIONTYPE = 2;
    /**
     * 按车牌号查询<br>
     * 则param 需传入 java.lang.String
     */
    public static final int QUERY_BY_CARNUMBER = 3;
    /**
     * 按违章时间查询，需要传入查询起止时间<br>
     * 则param 需传入 java.util.List&lt;java.sql.Timestamp&gt;
     */
    public static final int QUERY_BETWEEN_VIOLATIONTIME = 4;
    /**
     * 按扣分查询，需要传入扣分起止区间<br>
     * 则param 需传入 java.util.List&lt;java.lang.Integer&gt;
     */
    public static final int QUERY_BETWEEN_PENALTYPOINT = 5;
    /**
     * 按罚款金额查询，需要传入罚款数额起止区间<br>
     * 则param 需传入 java.util.List&lt;java.math.BigDecimal&gt;
     */
    public static final int QUERY_BETWEEN_PENALTYMONEY = 6;
    /**
     * 按创建时间查询(区间)<br>
     * 则param 需传入 java.util.List&lt;java.sql.Timestamp&gt;<br>
     *     List中index = 0的数据为查询日期开始时间<br>
     *     List中index = 1的数据为查询日期结束时间<br>
     */
    public static final int QUERY_BETWEEN_GMTCREATE = 7;
    /**
     * 按修改时间查询(区间)<br>
     * 则param 需传入 java.util.List&lt;java.sql.Timestamp&gt;<br>
     *     List中index = 0的数据为查询日期开始时间<br>
     *     List中index = 1的数据为查询日期结束时间<br>
     */
    public static final int QUERY_BETWEEN_GMTMODIFIED = 8;

}
