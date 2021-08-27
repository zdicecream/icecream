package com.zdinit.icecream;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
@Slf4j
@SpringBootTest
class PoolTests {
    @Data
    private class Asset{
        String name;
        BigDecimal amount;
        Date date;
    }
    @Data
    private class Liability{
        String name;
        BigDecimal amount;
        Date date;
    }

    public static void main(String[] args) throws SQLException {
        new PoolTests().contextLoads();

    }

    @Test
    void contextLoads() throws SQLException {
        List<Asset> assetList = new ArrayList<>();
        Asset asset1 = new Asset();
        asset1.setAmount(new BigDecimal(70));
        asset1.setName("资产1");
        Calendar c1 = Calendar.getInstance();
        c1.set(2021,1,2);
        asset1.setDate(c1.getTime());

        Asset asset2 = new Asset();
        asset2.setAmount(new BigDecimal(10));
        asset2.setName("资产2");
        Calendar c2 = Calendar.getInstance();
        c2.set(2021,1,3);
        asset2.setDate(c2.getTime());

        Asset asset3 = new Asset();
        asset3.setAmount(new BigDecimal(80));
        asset3.setName("资产3");
        Calendar c3 = Calendar.getInstance();
        c3.set(2021,1,5);
        asset3.setDate(c3.getTime());

        Asset asset4 = new Asset();
        asset4.setAmount(new BigDecimal(120));
        asset4.setName("资产4");
        Calendar c4 = Calendar.getInstance();
        c4.set(2021,1,6);
        asset4.setDate(c4.getTime());

        Asset asset5 = new Asset();
        asset5.setAmount(new BigDecimal(33));
        asset5.setName("无限期资产5");
        assetList.add(asset5);
        assetList.add(asset4);
        assetList.add(asset3);
        assetList.add(asset2);
        assetList.add(asset1);

        List<Liability> liabilityList = new ArrayList<>();

        Liability liability1 = new Liability();
        liability1.setAmount(new BigDecimal(85));
        liability1.setName("负债1");
        Calendar cc1 = Calendar.getInstance();
        cc1.set(2021,1,4);
        liability1.setDate(cc1.getTime());

        Liability liability2 = new Liability();
        liability2.setAmount(new BigDecimal(60));
        liability2.setName("负债2");
        Calendar cc2 = Calendar.getInstance();
        cc2.set(2021,1,6);
        liability2.setDate(cc2.getTime());

        Liability liability3 = new Liability();
        liability3.setAmount(new BigDecimal(100));
        liability3.setName("负债3");
        Calendar cc3 = Calendar.getInstance();
        cc3.set(2021,1,9);
        liability3.setDate(cc3.getTime());

        liabilityList.add(liability1);
        liabilityList.add(liability2);
        liabilityList.add(liability3);

        this.run(assetList,liabilityList);
    }

    private Boolean run(List<Asset> assetList, List<Liability> liabilityList) {
        List<Asset> assetListNoTime = assetList.stream().filter(asset -> asset.getDate()==null).collect(Collectors.toList());
        List<Asset> assetListTime = assetList.stream().filter(asset -> asset.getDate()!=null).collect(Collectors.toList());

        //有期限资产占用
        this.adjust(assetListTime,liabilityList);
        //无期限资产占用
        this.adjust(assetListNoTime,liabilityList);
        //负债实体列表为空是占用成功
        log.info("判断结果为："+liabilityList.isEmpty());
        return liabilityList.isEmpty();
    }

    /**
     * 资产占用判断
     * @param assetList
     * @param liabilityList
     */
    private void adjust(List<Asset> assetList, List<Liability> liabilityList){
        Iterator<Liability> liabilityIterator = liabilityList.iterator();
        Iterator<Asset> assetIterator = assetList.iterator();
        Liability l = null;
        Asset a = null;
        while (liabilityIterator.hasNext()) {
            l = liabilityIterator.next();
            assetIterator = assetList.iterator();
            while (assetIterator.hasNext()) {
                a = assetIterator.next();
                //资负为有期限资产 并且 负债实体期限早于资产实体，跳过
                //资负为无期限资产 直接对比金额
                if (a.getDate()!=null && l.getDate().before(a.getDate()) ){
                    log.info("负债_"+l.getName()+",早于资产_"+a.getName()+":跳过");
                    continue;
                }
                //负债实体金额大于资产实体，负债实体占有此资产，并计算剩余负债金额，资产实体金额清零
                //负债实体金额等于资产实体，负债实体占有此资产，资产实体金额清零，负债实体金额清零
                //负债实体金额小于资产实体，负债实体占有部分资产，并计算剩余资产金额，负债实体金额清零
                if (l.getAmount().compareTo(a.getAmount())>0){
                    log.info("负债_"+l.getName()+",占用资产_"+a.getName()+":"+a.getAmount());
                    l.setAmount(l.getAmount().subtract(a.getAmount()));
                    assetIterator.remove();
                }else if(l.getAmount().compareTo(a.getAmount())==0){
                    log.info("负债_"+l.getName()+",占用资产_"+a.getName()+":"+a.getAmount());
                    assetIterator.remove();
                    liabilityIterator.remove();
                    break;
                }else{
                    log.info("负债_"+l.getName()+",占用资产_"+a.getName()+":"+l.getAmount());
                    a.setAmount(a.getAmount().subtract(l.getAmount()));
                    liabilityIterator.remove();
                    break;
                }
            }
        }
    }

}
