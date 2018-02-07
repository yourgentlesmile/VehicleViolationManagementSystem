package cn.xc.constant;

/**
 * 咨询单模块共享常量类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/6 10:25.
 */
public class ConsultationListConstant {
    /**
     * 按ID查询<br>
     * 则param 需传入 java.lang.Long
     */
    public static final int QUERY_BY_ID = 0;
    /**
     * 按咨询单种类查询<br>
     * 则param 需传入 java.lang.Integer
     */
    public static final int QUERY_BY_TYPE = 1;
    /**
     * 按创建者编号<br>
     * 则param 需传入 java.lang.String
     */
    public static final int QUERY_BY_IDENTIFIER = 2;
    /**
     * 按创建者ID<br>
     * 则param 需传入 java.lang.Long
     */
    public static final int QUERY_BY_CREATERID = 3;
    /**
     * 按回应者ID<br>
     * 则param 需传入 java.lang.Long
     */
    public static final int QUERY_BY_PROCESSORID = 4;
    /**
     * 按工单状态<br>
     * 则param 需传入 java.lang.Integer
     */
    public static final int QUERY_BY_STATUS = 5;
    /**
     * 按回应时间查询(区间)<br>
     * 则param 需传入 java.util.List&lt;java.sql.Timestamp&gt;<br>
     *     List中index = 0的数据为查询日期开始时间<br>
     *     List中index = 1的数据为查询日期结束时间<br>
     */
    public static final int QUERY_BETWEEN_RESPONSETIME = 6;
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
