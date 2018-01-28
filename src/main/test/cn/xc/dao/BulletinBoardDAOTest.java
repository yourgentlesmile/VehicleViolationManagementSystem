package cn.xc.dao;

import cn.xc.MainApplication;
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
import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Description: 公告板DAO接口测试类
 * @Author XiongCheng
 * @Date 2018/1/22 11:47.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BulletinBoardDAOTest {
    @Autowired
    private IBulletinBoardDAO dao;

    public BulletinBoardDO single;
    public BulletinBoardDO multiData_A;
    public BulletinBoardDO multiData_B;
    public BulletinBoardDO multiData_C;
    public BulletinBoardDO multiData_D;
    @Before
    public void AprepareTestData(){
        Date currentTime = new Date();
        //单一数据增删查改准备
        single = new BulletinBoardDO(1L,"single",0,currentTime,currentTime,0);
        //多重增删查改数据准备
        multiData_A = new BulletinBoardDO(1L,"multiData_A",0,currentTime,currentTime,0);
        multiData_B = new BulletinBoardDO(1L,"multiData_B",0,currentTime,currentTime,0);
        multiData_C = new BulletinBoardDO(1L,"multiData_C",0,currentTime,currentTime,0);
        multiData_D = new BulletinBoardDO(1L,"multiData_D",0,currentTime,currentTime,0);
    }
    @Test
    public void BinsertDataTest(){
        dao.insertData(single);
    }
    @Test
    public void CfindAllTest(){
        List<BaseDO> result = dao.findAll();
        BulletinBoardDO re = (BulletinBoardDO) result.get(0);
        Assert.assertSame(1,result.size());
        Assert.assertEquals(re.getContext(),single.getContext());
    }
    @Test
    public void DinsertDataByListTest(){
        List<BaseDO> list = new ArrayList<>();
        list.add(multiData_A);
        list.add(multiData_B);
        list.add(multiData_C);
        list.add(multiData_D);
        dao.insertDataByList(list);
    }
    @Test
    public void EupdateDataTest(){
        List<BaseDO> result = dao.findAll();
        BulletinBoardDO re = (BulletinBoardDO) result.get(0);
        re.setContext("auto Test");
        dao.updateData(re);
    }
    @Test
    public void FupdateDataByListTest(){
        List<BaseDO> result = dao.findAll();
        for (BaseDO baseDO : result) {
            BulletinBoardDO re = (BulletinBoardDO) baseDO;
            re.setContext("update list test");
        }
        dao.updateDataByList(result);
    }
    @Test
    public void GupdateDataSelectiveTest(){
        List<BaseDO> result = dao.findAll();
        BulletinBoardDO re = (BulletinBoardDO) result.get(0);
        re.setContext(null);
        dao.updateDataSelective(re);
    }
    @Test
    public void HupdateDataByListSelectiveTest(){
        List<BaseDO> result = dao.findAll();
        for (BaseDO baseDO : result) {
            BulletinBoardDO re = (BulletinBoardDO) baseDO;
            re.setType(null);
        }
        dao.updateDataByListSelective(result);
    }
    @Test
    public void IdeleteDataByPrimaryKeyTest(){
        List<BaseDO> result = dao.findAll();
        BulletinBoardDO re = (BulletinBoardDO) result.get(0);
        dao.deleteDataByPrimaryKey(re.getId());
    }
    @Test
    public void JdeleteDataByListTest(){
        List<BaseDO> result = dao.findAll();
        List<Long> idCollection = new ArrayList<>();
        for (BaseDO baseDO : result) {
            BulletinBoardDO re = (BulletinBoardDO) baseDO;
            idCollection.add(re.getId());
        }
        dao.deleteDataByList(idCollection);
    }
}
