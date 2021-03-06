/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.fanmei.pay4j.weixin.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fanmei.pay4j.util.DateUtil;
import com.fanmei.pay4j.weixin.domain.mch.CouponInfo;
import com.fanmei.pay4j.weixin.type.BankType;
import com.fanmei.pay4j.weixin.type.CurrencyType;
import com.fanmei.pay4j.weixin.type.TradeType;
import com.fanmei.pay4j.xml.ListSuffixResult;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * 订单信息
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WeixinPayResult extends CommonResult {

    private static final long serialVersionUID = 5636828325595317079L;
    /**
     * 用户的openid
     */
    @XmlElement(name = "openid")
    @JSONField(name = "openid")
    private String openId;
    /**
     * 用户是否关注公众账号,Y- 关注,N-未关注,仅在公众 账号类型支付有效
     */
    @XmlElement(name = "is_subscribe")
    @JSONField(name = "is_subscribe")
    private String isSubscribe;
    /**
     * 交易类型
     *
     * @see TradeType
     */
    @XmlElement(name = "trade_type")
    @JSONField(name = "trade_type")
    private String tradeType;
    /**
     * 银行类型
     */
    @XmlElement(name = "bank_type")
    @JSONField(name = "bank_type")
    private String bankType;
    /**
     * 订单总金额,单位为分
     */
    @XmlElement(name = "total_fee")
    @JSONField(name = "total_fee")
    private Integer totalFee;
    /**
     * 应结订单金额,单位为分
     */
    @XmlElement(name = "settlement_total_fee")
    @JSONField(name = "settlement_total_fee")
    private Integer settlementTotalFee;
    /**
     * 现金券支付金额&lt;=订单总金 额,订单总金额-现金券金额 为现金支付金额
     */
    @XmlElement(name = "coupon_fee")
    @JSONField(name = "coupon_fee")
    private Integer couponFee;
    /**
     * 代金券或立减优惠使用数量
     */
    @XmlElement(name = "coupon_count")
    @JSONField(name = "coupon_count")
    private Integer couponCount;
    /**
     * 代金券信息 验证签名有点麻烦
     */
    @ListSuffixResult
    private List<CouponInfo> couponList;
    /**
     * 现金支付金额
     */
    @XmlElement(name = "cash_fee")
    @JSONField(name = "cash_fee")
    private Integer cashFee;
    /**
     * 现金支付货币类型
     */
    @XmlElement(name = "cash_fee_type")
    @JSONField(name = "cash_fee_type")
    private String cashFeeType;
    /**
     * 货币类型,符合 ISO 4217 标准的三位字母代码,默认人民币:CNY
     */
    @XmlElement(name = "fee_type")
    @JSONField(name = "fee_type")
    private String feeType;
    /**
     * 微信支付订单号
     */
    @XmlElement(name = "transaction_id")
    @JSONField(name = "transaction_id")
    private String transactionId;
    /**
     * 商户订单号
     */
    @XmlElement(name = "out_trade_no")
    @JSONField(name = "out_trade_no")
    private String outTradeNo;
    /**
     * 商家数据包
     */
    @XmlElement(name = "attach")
    @JSONField(name = "attach")
    private String attach;
    /**
     * 支付完成时间,格式为 yyyyMMddhhmmss
     */
    @XmlElement(name = "time_end")
    @JSONField(name = "time_end")
    private String timeEnd;

    protected WeixinPayResult() {
        // jaxb required
    }

    public String getOpenId() {
        return openId;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    @JSONField(serialize = false)
    public boolean getFormatIsSubscribe() {
        return isSubscribe != null && isSubscribe.equalsIgnoreCase("y");
    }

    @JSONField(serialize = false)
    public TradeType getFormatTradeType() {
        return tradeType != null ? TradeType.valueOf(tradeType.toUpperCase())
                : null;
    }

    public String getBankType() {
        return bankType;
    }

    @JSONField(serialize = false)
    public BankType getFormatBankType() {
        return bankType != null ? BankType.valueOf(bankType.toUpperCase())
                : null;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    /**
     * <span style="color:red">调用接口获取单位为分,get方法转换为元方便使用</span>
     *
     * @return 元单位
     */
    @JSONField(serialize = false)
    public double getFormatTotalFee() {
        return totalFee != null ? totalFee / 100d : 0d;
    }

    public Integer getCouponFee() {
        return couponFee;
    }

    /**
     * <span style="color:red">调用接口获取单位为分,get方法转换为元方便使用</span>
     *
     * @return 元单位
     */
    @JSONField(serialize = false)
    public double getFormatCouponFee() {
        return couponFee != null ? couponFee / 100d : 0d;
    }

    public Integer getCouponCount() {
        return couponCount;
    }

    public Integer getCashFee() {
        return cashFee;
    }

    /**
     * <span style="color:red">调用接口获取单位为分,get方法转换为元方便使用</span>
     *
     * @return 元单位
     */
    @JSONField(serialize = false)
    public double getFormatCashFee() {
        return cashFee != null ? cashFee / 100d : 0d;
    }

    @JSONField(serialize = false)
    public CurrencyType getFormatFeeType() {
        return feeType != null ? CurrencyType.valueOf(feeType.toUpperCase())
                : null;
    }

    public String getTradeType() {
        return tradeType;
    }

    public String getFeeType() {
        return feeType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public String getAttach() {
        return attach;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    @JSONField(serialize = false)
    public Date getPayTime() {
        return timeEnd != null ? DateUtil.parse2yyyyMMddHHmmss(timeEnd) : null;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee(Integer settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
    }

    public void setCouponFee(Integer couponFee) {
        this.couponFee = couponFee;
    }

    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
    }

    public List<CouponInfo> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<CouponInfo> couponList) {
        this.couponList = couponList;
    }

    public void setCashFee(Integer cashFee) {
        this.cashFee = cashFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
