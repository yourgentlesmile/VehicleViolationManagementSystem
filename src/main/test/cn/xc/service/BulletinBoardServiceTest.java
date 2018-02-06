package cn.xc.service;

import cn.xc.MainApplication;
import cn.xc.constant.BulletinBoardConstant;
import cn.xc.entity.DO.BaseDO;
import cn.xc.entity.DO.BulletinBoardDO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 *  BulletinBoard服务测试类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/23 21:01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BulletinBoardServiceTest {
    @Autowired
    private IBulletinBoardService bulletinBoardService;
    public BulletinBoardDO single;
    public BulletinBoardDO multiData_A;
    public BulletinBoardDO multiData_B;
    public BulletinBoardDO multiData_C;
    public BulletinBoardDO multiData_D;
    @Before
    public void AprepareTestData(){
        //单一数据增删查改准备
        single = new BulletinBoardDO(1L,"single",0,null,null,0);
        //多重增删查改数据准备
        multiData_A = new BulletinBoardDO(2L,"multiData_A",0,null,null,0);
        multiData_B = new BulletinBoardDO(3L,"multiData_B",0,null,null,0);
        multiData_C = new BulletinBoardDO(4L,"multiData_C",0,null,null,0);
        multiData_D = new BulletinBoardDO(5L,"multiData_D",0,null,null,0);
    }
    @Test
    public void BaddBulletinTest(){
        try{
            bulletinBoardService.addBulletin(single);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void ClistDataByConditionTest(){
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2018,0,23,0,0,0);
//        List<Date> param = new ArrayList<>();
//        param.add(calendar.getTime());
//        calendar.set(2018,0,24,0,0,0);
//        param.add(calendar.getTime());
//        List<BulletinBoardDO> value = null;
//        try{
//            value = bulletinBoardService.listDataByCondition(BulletinBoardConstant.QUERY_BY_GMT_CREATE,param);
//            Assert.assertEquals(single.getContext(),value.get(0).getContext());
//            value = bulletinBoardService.listDataByCondition(BulletinBoardConstant.QUERY_BY_GMT_MODIFIED,param);
//            Assert.assertEquals(single.getContext(),value.get(0).getContext());
//            value = bulletinBoardService.listDataByCondition(BulletinBoardConstant.QUERY_BY_TYPE,0);
//            Assert.assertEquals(single.getContext(),value.get(0).getContext());
//            value = bulletinBoardService.listDataByCondition(BulletinBoardConstant.QUERY_BY_PUBLISHER_ID,1L);
//            Assert.assertEquals(single.getContext(),value.get(0).getContext());
//            value = bulletinBoardService.listDataByCondition(BulletinBoardConstant.FETCH_ALL,null);
//            Assert.assertEquals(single.getContext(),value.get(0).getContext());
//        }catch (Exception e){
//
//        }
    }
    @Test
    public void DupdateBulletin(){
        List<BulletinBoardDO> value = null;
        BulletinBoardDO singleBulletin = null;
        BulletinBoardDO temp = null;
        try {
            value = bulletinBoardService.listDataByCondition(BulletinBoardConstant.FETCH_ALL,null);
            singleBulletin = value.get(0);
            singleBulletin.setContext("update test");
            bulletinBoardService.updateBulletin(BulletinBoardConstant.UPDATE_COLUMN_ALL,singleBulletin);
            temp = bulletinBoardService.listDataByCondition(BulletinBoardConstant.FETCH_ALL,null).get(0);
            Assert.assertEquals("update test",temp.getContext());

            temp.setContext(null);
            bulletinBoardService.updateBulletin(BulletinBoardConstant.UPDATE_COLUMN_SELECTIVE,singleBulletin);
            temp = bulletinBoardService.listDataByCondition(BulletinBoardConstant.FETCH_ALL,null).get(0);
            Assert.assertEquals("update test",temp.getContext());

            bulletinBoardService.addBulletin(multiData_A);
            List<BaseDO> param = new ArrayList<>();
            value = bulletinBoardService.listDataByCondition(BulletinBoardConstant.FETCH_ALL,null);
            for (BulletinBoardDO bulletinBoardDO : value) {
                bulletinBoardDO.setContext("list update test");
                param.add(bulletinBoardDO);
            }
            bulletinBoardService.updateBulletin(BulletinBoardConstant.UPDATE_COLUMN_ALL_BY_LIST,param);
            value = bulletinBoardService.listDataByCondition(BulletinBoardConstant.FETCH_ALL,null);
            for (BulletinBoardDO bulletinBoardDO : value) {
                Assert.assertEquals("in loop","list update test",bulletinBoardDO.getContext());
            }

            value = bulletinBoardService.listDataByCondition(BulletinBoardConstant.FETCH_ALL,null);
            for (BulletinBoardDO bulletinBoardDO : value) {
                bulletinBoardDO.setContext(null);
                param.add(bulletinBoardDO);
            }
            bulletinBoardService.updateBulletin(BulletinBoardConstant.UPDATE_COLUMN_SELECTIVE_BY_LIST,param);
            value = bulletinBoardService.listDataByCondition(BulletinBoardConstant.FETCH_ALL,null);
            for (BulletinBoardDO bulletinBoardDO : value) {
                Assert.assertEquals("in loop","list update test",bulletinBoardDO.getContext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void EdeleteBulletinTest(){
        List<BulletinBoardDO> value = null;
        try {
            bulletinBoardService.addBulletin(multiData_B);
            value = bulletinBoardService.listDataByCondition(BulletinBoardConstant.FETCH_ALL,null);
            bulletinBoardService.deleteBulletin(value.get(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void FdeleteBulletinByListTest(){
        List<BulletinBoardDO> value = null;
        try {
            value = bulletinBoardService.listDataByCondition(BulletinBoardConstant.FETCH_ALL,null);
            bulletinBoardService.deleteBulletinByList(value);
            value = bulletinBoardService.listDataByCondition(BulletinBoardConstant.FETCH_ALL,null);
            Assert.assertEquals(0,value.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
