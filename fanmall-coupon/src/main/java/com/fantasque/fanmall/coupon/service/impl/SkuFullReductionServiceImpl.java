package com.fantasque.fanmall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fantasque.common.to.MemberPrice;
import com.fantasque.common.to.SkuReductionTo;
import com.fantasque.common.utils.PageUtils;
import com.fantasque.common.utils.Query;
import com.fantasque.fanmall.coupon.dao.SkuFullReductionDao;
import com.fantasque.fanmall.coupon.entity.MemberPriceEntity;
import com.fantasque.fanmall.coupon.entity.SkuFullReductionEntity;
import com.fantasque.fanmall.coupon.entity.SkuLadderEntity;
import com.fantasque.fanmall.coupon.service.MemberPriceService;
import com.fantasque.fanmall.coupon.service.SkuFullReductionService;
import com.fantasque.fanmall.coupon.service.SkuLadderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {

    @Autowired
    private SkuLadderService skuLadderService;
    @Autowired
    private MemberPriceService memberPriceService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuFullReductionEntity> page = this.page(
                new Query<SkuFullReductionEntity>().getPage(params),
                new QueryWrapper<SkuFullReductionEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveSkuReduction(SkuReductionTo reductionTo) {
        //1、// //5.4）、sku的优惠、满减等信息；fanmall_sms->sms_sku_ladder\sms_sku_full_reduction\sms_member_price
        //sms_sku_ladder 保存sku
        SkuLadderEntity skuLadderEntity = new SkuLadderEntity();
//        skuLadderEntity.setSkuId(reductionTo.getSkuId());
//        skuLadderEntity.setFullCount(reductionTo.getFullCount());
//        skuLadderEntity.setDiscount(reductionTo.getDiscount());
//        skuLadderEntity.setAddOther(reductionTo.getCountStatus());
        BeanUtils.copyProperties(reductionTo, skuLadderEntity);
        if (reductionTo.getFullCount() > 0) {
            skuLadderService.save(skuLadderEntity);
        }

        //2、sms_sku_full_reduction 保存满减
        SkuFullReductionEntity reductionEntity = new SkuFullReductionEntity();
        BeanUtils.copyProperties(reductionTo, reductionEntity);
        if (reductionEntity.getFullPrice().compareTo(new BigDecimal("0")) == 1) {
            this.save(reductionEntity);
        }

        //3、sms_member_price 保存会员价
        List<MemberPrice> memberPrice = reductionTo.getMemberPrice();
        if (CollectionUtils.isEmpty(memberPrice)) {
            List<MemberPriceEntity> collect = memberPrice.stream().map(item -> {
                MemberPriceEntity priceEntity = new MemberPriceEntity();
                priceEntity.setSkuId(reductionTo.getSkuId());
                priceEntity.setMemberLevelId(item.getId());
                priceEntity.setMemberLevelName(item.getName());
                priceEntity.setMemberPrice(item.getPrice());
                priceEntity.setAddOther(1);
                return priceEntity;
            }).filter(item -> {
                return item.getMemberPrice().compareTo(new BigDecimal("0")) == 1;
            }).collect(Collectors.toList());
            memberPriceService.saveBatch(collect);
        }

    }

}