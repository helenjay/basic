package com.basic.core.util;

import com.basic.core.model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: caol005
 * Date: 15-8-12
 * Time: 上午9:11
 * To change this template use File | Settings | File Templates.
 */
public class TaobaoJsonUtil {
    private static final Log log = LogFactory.getLog(TaobaoJsonUtil.class);

    /**
     * 去除json中的特殊字符
     * @param response
     * @return
     */
    private static String formatJsonString(String response) {
        //去除换行
        String str = response.replaceAll("\\r", "");
        str = str.replaceAll("\\n","|||");
        str = str.replaceAll("\\t","");
        return str;
    }

    /**
     * 将value中的引号改为中文的引号
     * @param s
     * @return
     */
    private static String jsonString(String s){
        char[] temp = s.toCharArray();
        int n = temp.length;
        for(int i =0;i<n;i++){
            if(temp[i]==':'&&temp[i+1]=='"'){
                for(int j =i+2;j<n;j++){
                    if(temp[j]=='"'){
                        if(temp[j+1]!=',' &&  temp[j+1]!='}'){
                            temp[j]='”';
                        }else if(temp[j+1]==',' ||  temp[j+1]=='}'){
                            break ;
                        }
                    }
                }
            }
        }
        return new String(temp);
    }

    /**
     * 解析response数据到订单表
     * @param response
     * @return
     */
    public static JstTrade generateJstTrade(String response){
        JstTrade jstTrade = new JstTrade();
        JSONObject jsonObject = null;
        try {
            jsonObject = JSONObject.fromObject(formatJsonString(response)).getJSONObject("trade_fullinfo_get_response").getJSONObject("trade");
        }catch (Exception ex){
            jsonObject = JSONObject.fromObject(jsonString(formatJsonString(response))).getJSONObject("trade_fullinfo_get_response").getJSONObject("trade");
        }
        jstTrade.setAdjustFee(jsonObjectToDouble(jsonObject.get("adjust_fee")));//卖家手工调整金额
        jstTrade.setAlipayId(jsonObjectToString(jsonObject.get("alipay_id")));//买家的支付宝ID号
        jstTrade.setAlipayNo(jsonObjectToString(jsonObject.get("alipay_no")));//支付宝交易号
        jstTrade.setAlipayPoint(jsonObjectToInteger(jsonObject.get("alipay_point")));//付款时使用的支付宝积分的额度
        jstTrade.setAvailableConfirmFee(jsonObjectToDouble(jsonObject.get("available_confirm_fee")));//交易中剩余的确认收货金额
        jstTrade.setBuyerAlipayNo(jsonObjectToString(jsonObject.get("buyer_alipay_no")));//买家支付宝账号
        jstTrade.setBuyerArea(jsonObjectToString(jsonObject.get("buyer_area")));//买家下单的地区
        jstTrade.setBuyerCodFee(jsonObjectToDouble(jsonObject.get("buyer_cod_fee")));//买家货到付款服务费
        jstTrade.setBuyerEmail(jsonObjectToString(jsonObject.get("buyer_email")));//买家邮件地址
        jstTrade.setBuyerNick(jsonObjectToString(jsonObject.get("buyer_nick")));//买家昵称
        jstTrade.setBuyerObtainPointFee(jsonObjectToInteger(jsonObject.get("buyer_obtain_point_fee")));//买家获得积分
        jstTrade.setBuyerRate(jsonObjectToString(jsonObject.get("buyer_rate")));//买家是否已评价可选值
        jstTrade.setCodFee(jsonObjectToDouble(jsonObject.get("cod_fee")));//货到付款服务费
        jstTrade.setCodStatus(jsonObjectToString(jsonObject.get("cod_status")));//货到付款物流状态
        jstTrade.setCommissionFee(jsonObjectToDouble(jsonObject.get("commission_fee")));//交易佣金
        jstTrade.setConsignTime(jsonObjectToTimestamp(jsonObject.get("consign_time"), "yyyy-MM-dd hh:mm:ss"));//卖家发货时间
        jstTrade.setCreated(jsonObjectToTimestamp(jsonObject.get("created"), "yyyy-MM-dd hh:mm:ss"));//交易创建时间
        jstTrade.setCreditCardFee(jsonObjectToDouble(jsonObject.get("credit_card_fee")));//使用信用卡支付金额数
        jstTrade.setDiscountFee(jsonObjectToDouble(jsonObject.get("discount_fee")));//系统优惠金额
        jstTrade.setEndTime(jsonObjectToTimestamp(jsonObject.get("end_time"), "yyyy-MM-dd hh:mm:ss"));//交易结束时间
        jstTrade.setHasPostFee(jsonObjectToString(jsonObject.get("has_post_fee")));//是否包含邮费
        jstTrade.setInvoiceName(jsonObjectToString(jsonObject.get("invoice_name")));//发票抬头
        jstTrade.setIs3d(jsonObjectToString(jsonObject.get("is_3D")));//是否3D交易
        jstTrade.setIsBrandSale(jsonObjectToString(jsonObject.get("is_brand_sale")));//表示是否是品牌特卖
        jstTrade.setIsDaixiao(jsonObjectToString(jsonObject.get("is_daixiao")));//表示订单交易是否含有对应的代销采购单BOOLEAN
        jstTrade.setIsForceWlb(jsonObjectToString(jsonObject.get("is_force_wlb")));//订单是否强制使用物流宝发货
        jstTrade.setIsLgtype(jsonObjectToString(jsonObject.get("is_lgtype")));//是否保障速递
        jstTrade.setIsPartConsign(jsonObjectToString(jsonObject.get("is_part_consign")));//是否是多次发货的订单如果卖家对订单进行多次发货BOOLEAN
        jstTrade.setIsWt(jsonObjectToString(jsonObject.get("is_wt")));//表示订单交易是否网厅订单BOOLEAN
        jstTrade.setModified(jsonObjectToTimestamp(jsonObject.get("modified"), "yyyy-MM-dd hh:mm:ss"));//交易修改时间
        jstTrade.setNum(jsonObjectToInteger(jsonObject.get("num")));//商品购买数量
        jstTrade.setNumIid(jsonObjectToString(jsonObject.get("num_iid")));//商品数字编号
        jstTrade.setPayTime(jsonObjectToTimestamp(jsonObject.get("pay_time"), "yyyy-MM-dd hh:mm:ss"));//付款时间
        jstTrade.setPayment(jsonObjectToDouble(jsonObject.get("payment")));//实付金额
        jstTrade.setPccAf(jsonObjectToInteger(jsonObject.get("pcc_af")));//天猫点券卡实付款金额
        jstTrade.setPicPath(jsonObjectToString(jsonObject.get("pic_path")));//商品图片绝对路径
        jstTrade.setPointFee(jsonObjectToInteger(jsonObject.get("point_fee")));//买家使用积分
        jstTrade.setPostFee(jsonObjectToDouble(jsonObject.get("post_fee")));//邮费
        jstTrade.setPrice(jsonObjectToDouble(jsonObject.get("price")));//商品价格
        jstTrade.setRealPointFee(jsonObjectToInteger(jsonObject.get("real_point_fee")));//买家实际使用积分
        jstTrade.setReceivedPayment(jsonObjectToDouble(jsonObject.get("received_payment")));//卖家实际收到的支付宝打款金额
        jstTrade.setReceiverAddress(jsonObjectToString(jsonObject.get("receiver_address")));//收货人的详细地址
        jstTrade.setReceiverCity(jsonObjectToString(jsonObject.get("receiver_city")));//收货人的所在城市
        jstTrade.setReceiverDistrict(jsonObjectToString(jsonObject.get("receiver_district")));//收货人的所在地区
        jstTrade.setReceiverMobile(jsonObjectToString(jsonObject.get("receiver_mobile")));//收货人的手机号码
        jstTrade.setReceiverName(jsonObjectToString(jsonObject.get("receiver_name")));//收货人的姓名
        jstTrade.setReceiverState(jsonObjectToString(jsonObject.get("receiver_state")));//收货人的所在省份
        jstTrade.setReceiverZip(jsonObjectToString(jsonObject.get("receiver_zip")));//收货人的邮编
        jstTrade.setSellerAlipayNo(jsonObjectToString(jsonObject.get("seller_alipay_no")));//卖家支付宝账号
        jstTrade.setSellerCanRate(jsonObjectToString(jsonObject.get("seller_can_rate")));//卖家是否可以对订单进行评价BOOLEAN
        jstTrade.setSellerCodFee(jsonObjectToDouble(jsonObject.get("seller_cod_fee")));//卖家货到付款服务费
        jstTrade.setSellerEmail(jsonObjectToString(jsonObject.get("seller_email")));//卖家邮件地址
        jstTrade.setSellerFlag(jsonObjectToString(jsonObject.get("seller_flag")));//卖家备注旗帜
        jstTrade.setSellerMemo(jsonObjectToString(jsonObject.get("seller_memo")));//卖家备注
        jstTrade.setSellerMobile(jsonObjectToString(jsonObject.get("seller_mobile")));//卖家手机
        jstTrade.setSellerName(jsonObjectToString(jsonObject.get("seller_name")));//卖家姓名
        jstTrade.setSellerNick(jsonObjectToString(jsonObject.get("seller_nick")));//卖家昵称
        jstTrade.setSellerPhone(jsonObjectToString(jsonObject.get("seller_phone")));//卖家电话
        jstTrade.setSellerRate(jsonObjectToString(jsonObject.get("seller_rate")));//卖家是否已评价
        jstTrade.setShippingType(jsonObjectToString(jsonObject.get("shipping_type")));//创建交易时的物流方式
        jstTrade.setSnapshotUrl(jsonObjectToString(jsonObject.get("snapshot_url")));//交易快照地址
        jstTrade.setStatus(jsonObjectToString(jsonObject.get("status")));//交易状态
        jstTrade.setStepPaidFee(jsonObjectToDouble(jsonObject.get("step_paid_fee")));//分阶段付款的已付金额（万人团订单已付金额）
        jstTrade.setStepTradeStatus(jsonObjectToString(jsonObject.get("step_trade_status")));//分阶段付款的订单状态（例如万人团订单等）
        jstTrade.setTid(jsonObjectToString(jsonObject.get("tid")));//交易编号
        jstTrade.setTitle(jsonObjectToString(jsonObject.get("title")));//交易标题
        jstTrade.setTotalFee(jsonObjectToDouble(jsonObject.get("total_fee")));//商品金额
        jstTrade.setTradeFrom(jsonObjectToString(jsonObject.get("trade_from")));//交易内部来源
        jstTrade.setType(jsonObjectToString(jsonObject.get("type")));//交易类型列表
//        jstTrade.setStoreId();
        jstTrade.setReceiverPhone(jsonObjectToString(jsonObject.get("receiver_phone")));//收货人的电话号码
        jstTrade.setEstConTime(jsonObjectToTimestamp(jsonObject.get("est_con_time"), "yyyy-MM-dd HH:mm:ss"));//商家的预计发货时间
        jstTrade.setInvoiceKind(jsonObjectToString(jsonObject.get("invoice_kind")));//发票类型
        jstTrade.setReceiverCountry(jsonObjectToString(jsonObject.get("receiver_country")));//收货人国籍
        jstTrade.setReceiverTown(jsonObjectToString(jsonObject.get("receiver_town")));//收货人街道地址
        jstTrade.setOrderTaxFee(jsonObjectToDouble(jsonObject.get("order_tax_fee")));//天猫国际官网直供主订单关税税费
        jstTrade.setBuyerMessage(jsonObjectToString(jsonObject.get("buyer_message")));//买家留言
        jstTrade.setBuyerMemo(jsonObjectToString(jsonObject.get("buyer_memo")));//买家备注
        jstTrade.setBuyerFlag(jsonObjectToInteger(jsonObject.get("buyer_flag")));//买家备注旗帜
        jstTrade.setInvoiceType(jsonObjectToString(jsonObject.get("invoice_type")));//发票类型
        jstTrade.setMarkDesc(jsonObjectToString(jsonObject.get("mark_desc")));//订单出现异常问题的时候,给予用户的描述
        jstTrade.setShopCode(jsonObjectToString(jsonObject.get("shop_code")));//线下自提门店编码
        jstTrade.setTimeoutActionTime(jsonObjectToTimestamp(jsonObject.get("timeout_actoin_time"), "yyyy-MM-dd HH:mm:ss"));//TIMEOUT_ACTION_TIME
        jstTrade.setPromotion(jsonObjectToString(jsonObject.get("promotion")));//交易促销详细信息
        jstTrade.setEtSerTime(jsonObjectToTimestamp(jsonObject.get("et_ser_time"), "yyyy-MM-dd HH:mm:ss"));//天猫汽车服务预约时间
        jstTrade.setEtShopName(jsonObjectToString(jsonObject.get("et_shop_name")));//电子凭证预约门店地址
        jstTrade.setEtVerifiedShopName(jsonObjectToString(jsonObject.get("et_verified_shop_name")));//电子凭证核销门店地址
        jstTrade.setEtPlateNumber(jsonObjectToString(jsonObject.get("et_plate_number")));//车牌号码
        jstTrade.setPaidCouponFee(jsonObjectToDouble(jsonObject.get("paid_coupon_fee")));//满返红包的金额
        jstTrade.setSid(jsonObjectToString(jsonObject.get("sid")));//物流运单号
        jstTrade.setBuyerIp(jsonObjectToString(jsonObject.get("buyer_ip")));//买家下单的IP信息
        jstTrade.setHasYfx(jsonObjectToString(jsonObject.get("has_yfx")));//订单中是否包含运费险订单
        jstTrade.setYfxFee(jsonObjectToDouble(jsonObject.get("yfx_fee")));//订单的运费险
        jstTrade.setYfxId(jsonObjectToString(jsonObject.get("yfx_id")));//运费险支付号
        jstTrade.setYfxType(jsonObjectToString(jsonObject.get("yfx_type")));//运费险类型
        jstTrade.setEticketExt(jsonObjectToString(jsonObject.get("eticket_ext")));//电子凭证的垂直信息
        jstTrade.setSendTime(jsonObjectToTimestamp(jsonObject.get("send_time"), "yyyy-MM-dd HH:mm:ss"));//订单将在此时间前发出
        jstTrade.setExpressAgencyFee(jsonObjectToDouble(jsonObject.get("express_agency_fee")));//快递代收款
        jstTrade.setCanRate(jsonObjectToString(jsonObject.get("can_rate")));//买家可以通过此字段查询是否当前交易可以评论
        jstTrade.setAcookieId(jsonObjectToString(jsonObject.get("acookie_id")));//ACOOKIE订单唯一ID
        jstTrade.setTradeMemo(jsonObjectToString(jsonObject.get("trade_memo")));//交易备注
        jstTrade.setTradeSource(jsonObjectToString(jsonObject.get("trade_source")));//交易外部来源
        jstTrade.setArriveInterval(jsonObjectToInteger(jsonObject.get("arrive_interval")));//物流到货时效
        jstTrade.setArriveCutTime(jsonObjectToString(jsonObject.get("arrive_cut_time")));//物流到货时效截单时间
        jstTrade.setConsignInterval(jsonObjectToInteger(jsonObject.get("consign_interval")));//物流发货时效
        jstTrade.setO2o(jsonObjectToString(jsonObject.get("o2o")));//导购宝=CRM
        jstTrade.setO2oGuideId(jsonObjectToString(jsonObject.get("o2o_guide_id")));//导购员ID
        jstTrade.setO2oShopId(jsonObjectToString(jsonObject.get("o2o_shop_id")));//导购员门店ID
        jstTrade.setO2oGuideName(jsonObjectToString(jsonObject.get("o2o_guide_name")));//导购员名称
        jstTrade.setO2oShopName(jsonObjectToString(jsonObject.get("o2o_shop_name")));//导购门店名称
        jstTrade.setO2oDelivery(jsonObjectToString(jsonObject.get("o2o_delivery")));//导购宝提货方式
        jstTrade.setZeroPurchase(jsonObjectToString(jsonObject.get("zero_purchase")));//在返回的TRADE对象上专门增加一个字段ZERO_PURCHASE来区分
        jstTrade.setO2oOutTradeId(jsonObjectToString(jsonObject.get("o2o_out_trade_id")));//外部订单号
        jstTrade.setHkEnName(jsonObjectToString(jsonObject.get("hk_en_name")));//拼音名
        jstTrade.setHkFlightNo(jsonObjectToString(jsonObject.get("hk_flight_no")));//航班号
        jstTrade.setHkChinaName(jsonObjectToString(jsonObject.get("hk_china_name")));//中文名
        jstTrade.setHkCardCode(jsonObjectToString(jsonObject.get("hk_card_code")));//证件号码
        jstTrade.setHkCardType(jsonObjectToString(jsonObject.get("hk_card_type")));//证件类型001代表港澳通行证类型
        jstTrade.setHkFlightDate(jsonObjectToString(jsonObject.get("hk_flight_date")));//航班飞行时间
        jstTrade.setHkGender(jsonObjectToString(jsonObject.get("hk_gender")));//性别
        jstTrade.setHkBirthday(jsonObjectToString(jsonObject.get("hk_birthday")));//出生日期
        jstTrade.setHkPickup(jsonObjectToString(jsonObject.get("hk_pickup")));//提货地点
        jstTrade.setHkPickupId(jsonObjectToString(jsonObject.get("hk_pickup_id")));//提货地点ID
        jstTrade.setEticketServiceAddr(jsonObjectToString(jsonObject.get("eticket_service_addr")));//天猫电子凭证家装
        jstTrade.setIsShShip(jsonObjectToString(jsonObject.get("is_sh_ship")));//是否屏蔽发货BOOLEAN
        jstTrade.setO2oSnatchStatus(jsonObjectToString(jsonObject.get("o2o_snatch_status")));//抢单状态
        jstTrade.setMarket(jsonObjectToString(jsonObject.get("market")));//垂直市场
        jstTrade.setEtType(jsonObjectToString(jsonObject.get("et_type")));//电子凭证扫码购
        jstTrade.setEtShopId(jsonObjectToString(jsonObject.get("et_shop_id")));//扫码购关联门店
        jstTrade.setObs(jsonObjectToString(jsonObject.get("obs")));//门店预约自提订单标

        Set<JstPromotionDetail> jstPromotionDetailSet = new HashSet<JstPromotionDetail>();
        JSONObject promotionJson = jsonObject.getJSONObject("promotion_details");
        if(promotionJson.size() > 0) {
            JSONArray promotionDetails = promotionJson.getJSONArray("promotion_detail");
            for(int i = 0;i<promotionDetails.size();i++){
                JSONObject promotionDetail = (JSONObject) promotionDetails.get(i);
                JstPromotionDetail jstPromotionDetail = new JstPromotionDetail();
                jstPromotionDetail.setJstTrade(jstTrade);
                jstPromotionDetail.setId(jsonObjectToString(promotionDetail.get("id")));
                jstPromotionDetail.setPromotionName(jsonObjectToString(promotionDetail.get("promotion_name")));
                jstPromotionDetail.setDiscountFee(jsonObjectToDouble(promotionDetail.get("discount_fee")));
                jstPromotionDetail.setPromotionDesc(jsonObjectToString(promotionDetail.get("promotion_desc")));
                jstPromotionDetail.setPromotionId(jsonObjectToString(promotionDetail.get("promotion_id")));
                jstPromotionDetailSet.add(jstPromotionDetail);
            }
        }
        jstTrade.setJstPromotionDetails(jstPromotionDetailSet);

        Set<JstOrder> jstOrderSet = new HashSet<JstOrder>();
        JSONObject orderJson = jsonObject.getJSONObject("orders");
        if(orderJson.size() > 0){
            JSONArray orders = orderJson.getJSONArray("order");
            for(int i = 0; i < orders.size(); i++){
                JSONObject order = (JSONObject) orders.get(i);
                JstOrder jstOrder = new JstOrder();
                jstOrder.setJstTrade(jstTrade);
                jstOrder.setItemMealName(jsonObjectToString(order.get("item_meal_name")));
                jstOrder.setPicPath(jsonObjectToString(order.get("pic_path")));
                jstOrder.setRefundStatus(jsonObjectToString(order.get("refund_status")));
                jstOrder.setOuterIid(jsonObjectToString(order.get("outer_iid")));
                jstOrder.setSnapshotUrl(jsonObjectToString(order.get("snapshot_url")));
                jstOrder.setTimeoutActionTime(jsonObjectToTimestamp(order.get("timeout_action_time"),"yyyy-MM-dd hh:mm:ss"));
                jstOrder.setBuyerRate(jsonObjectToString(order.get("buyer_rate")));
                jstOrder.setSellerRate(jsonObjectToString(order.get("seller_rate")));
//                tempOrder.setSellerType(jsonObjectToString(order.get("seller_type")));//卖家类型，可选值为：B（商城商家），C（普通卖家）


                jstOrder.setCid(jsonObjectToString(order.get("cid")));
                jstOrder.setSubOrderTaxFee(jsonObjectToString(order.get("sub_order_tax_fee")));
                jstOrder.setSubOrderTaxRate(jsonObjectToString(order.get("sub_order_tax_rate")));
                jstOrder.setOid(jsonObjectToString(order.get("oid")));
                jstOrder.setStatus(jsonObjectToString(order.get("status")));
                jstOrder.setTitle(jsonObjectToString(order.get("title")));
                jstOrder.setPrice(jsonObjectToDouble(order.get("price")));
                jstOrder.setNumIid(jsonObjectToString(order.get("num_iid")));
                jstOrder.setItemMealId(jsonObjectToString(order.get("item_meal_id")));
                jstOrder.setSkuId(jsonObjectToString(order.get("sku_id")));
                jstOrder.setNum(jsonObjectToInteger(order.get("num")));
                jstOrder.setOuterSkuId(jsonObjectToString(order.get("outer_sku_id")));
                jstOrder.setOrderFrom(jsonObjectToString(order.get("order_from")));
                jstOrder.setTotalFee(jsonObjectToDouble(order.get("total_fee")));
                jstOrder.setPayment(jsonObjectToDouble(order.get("payment")));
                jstOrder.setDiscountFee(jsonObjectToDouble(order.get("discount_fee")));
                jstOrder.setAdjustFee(jsonObjectToDouble(order.get("adjust_fee")));
                jstOrder.setSkuPropertiesName(jsonObjectToString(order.get("sku_properties_name")));
                jstOrder.setRefundId(jsonObjectToString(order.get("refund_id")));
                jstOrder.setIsOversold(jsonObjectToString(order.get("is_oversold")));
                jstOrder.setIsServiceOrder(jsonObjectToString(order.get("is_service_order")));
                jstOrder.setEndTime(jsonObjectToTimestamp(order.get("end_time"),"yyyy-MM-dd hh:mm:ss"));
                jstOrder.setConsignTime(jsonObjectToTimestamp(order.get("consign_time"),"yyyy-MM-dd hh:mm:ss"));
                jstOrder.setShippingType(jsonObjectToString(order.get("shipping_type")));
                jstOrder.setBindOid(jsonObjectToString(order.get("bind_oid")));
                jstOrder.setLogisticsCompany(jsonObjectToString(order.get("logistics_company")));
                jstOrder.setInvoiceNo(jsonObjectToString(order.get("invoice_no")));
                jstOrder.setIsDaixiao(jsonObjectToString(order.get("is_daixiao")));
                jstOrder.setDivideOrderFee(jsonObjectToDouble(order.get("divide_order_fee")));
                jstOrder.setPartMjzDiscount(jsonObjectToDouble(order.get("part_mjz_discount")));
                jstOrder.setTicketOuterId(jsonObjectToString(order.get("ticket_outer_id")));
                jstOrder.setTicketExpdateKey(jsonObjectToString(order.get("ticket_expdate_key")));
                jstOrder.setStoreCode(jsonObjectToString(order.get("store_code")));
                jstOrder.setIsWww(jsonObjectToString(order.get("is_www")));
                jstOrder.setTmserSpuCode(jsonObjectToString(order.get("tmser_spu_code")));
                jstOrder.setMatnr(jsonObjectToString(order.get("outer_iid")));
                jstOrderSet.add(jstOrder);
            }
        }
        jstTrade.setJstOrders(jstOrderSet);

        return jstTrade;
    }

    /**
     *解析response数据到退款表
     * @param response
     * @return
     */
    public static JstRefund generateJstRefund(String response){
        JstRefund jstRefund = new JstRefund();
        JSONObject jsonObject = null;
        try {
            jsonObject = JSONObject.fromObject(formatJsonString(response)).getJSONObject("refund_get_response").getJSONObject("refund");
        }catch (Exception ex){
            jsonObject = JSONObject.fromObject(jsonString(formatJsonString(response))).getJSONObject("refund_get_response").getJSONObject("refund");
        }
        jstRefund.setShippingType(jsonObjectToString(jsonObject.get("shipping_type")));//物流方式
        jstRefund.setCsStatus(jsonObjectToString(jsonObject.get("cs_status")));
        jstRefund.setAdvanceStatus(jsonObjectToString(jsonObject.get("advance_status")));
        jstRefund.setSplitSellerFee(jsonObjectToDouble(jsonObject.get("split_taobao_fee")));
        jstRefund.setSplitSellerFee(jsonObjectToDouble(jsonObject.get("split_seller_fee")));
        jstRefund.setRefundId(jsonObjectToString(jsonObject.get("refund_id")));
        jstRefund.setTid(jsonObjectToString(jsonObject.get("tid")));
        jstRefund.setOid(jsonObjectToString(jsonObject.get("oid")));
        jstRefund.setAlipayNo(jsonObjectToString(jsonObject.get("alipay_no")));
        jstRefund.setTotalFee(jsonObjectToDouble(jsonObject.get("total_fee")));
        jstRefund.setSellerNick(jsonObjectToString(jsonObject.get("seller_nick"))); //卖家昵称
        jstRefund.setCreated(jsonObjectToTimestamp(jsonObject.get("created"),"yyyy-MM-dd hh:mm:ss"));//退款申请时间
        jstRefund.setModified(jsonObjectToTimestamp(jsonObject.get("modified"),"yyyy-MM-dd hh:mm:ss"));//更新时间
        jstRefund.setOrderStatus(jsonObjectToString(jsonObject.get("order_status")));//退款对应的订单交易状态
        jstRefund.setStatus(jsonObjectToString(jsonObject.get("status")));//退款状态
        jstRefund.setGoodStatus(jsonObjectToString(jsonObject.get("good_status"))); //货物状态
        jstRefund.setHasGoodReturn(jsonObjectToString(jsonObject.get("has_good_return")));//买家是否需要退货
        jstRefund.setRefundFee(jsonObjectToDouble(jsonObject.get("refund_fee")));//退还给买家的金额
        jstRefund.setPayment(jsonObjectToDouble(jsonObject.get("payment")));//支付给卖家的金额
        jstRefund.setReason(jsonObjectToString(jsonObject.get("reason")));//退款原因
        jstRefund.setDesc(jsonObjectToString(jsonObject.get("description"))); //退款说明
        jstRefund.setTitle(jsonObjectToString(jsonObject.get("title")));//商品标题
        jstRefund.setPrice(jsonObjectToDouble(jsonObject.get("price")));//商品价格
        jstRefund.setNum(jsonObjectToInteger(jsonObject.get("num")));//商品购买数量
        jstRefund.setGoodReturnTime(jsonObjectToTimestamp(jsonObject.get("good_return_time"),"yyyy-MM-dd hh:mm:ss"));//退货时间
        jstRefund.setCompanyName(jsonObjectToString(jsonObject.get("company_name")));//物流公司名称
        jstRefund.setSid(jsonObjectToString(jsonObject.get("sid")));//退货运单号
        jstRefund.setAddress(jsonObjectToString(jsonObject.get("address")));//卖家收货地址
        jstRefund.setNumIid(jsonObjectToString(jsonObject.get("num_iid")));//申请退款的商品数字编号
        jstRefund.setRefundPhase(jsonObjectToString(jsonObject.get("refund_phase")));//退款阶段
        jstRefund.setRefundVersion(jsonObjectToString(jsonObject.get("refund_version")));//退款版本号
        jstRefund.setSku(jsonObjectToString(jsonObject.get("sku")));//商品SKU信息
        jstRefund.setAttribute(jsonObjectToString(jsonObject.get("attribute")));//退款扩展属性
        jstRefund.setOuterId(jsonObjectToString(jsonObject.get("outer_id")));//商品外部商家编码
        jstRefund.setOperationContraint(jsonObjectToString(jsonObject.get("operation_contraint")));//退款约束
        return jstRefund;
    }

    /**
     *根据促销详细判断coupon类型
     * @param promotionId
     * @return
     */
    public static String getCouponTypeByDesc(String promotionId) {
        if(Validate.isNullOrEmpty(promotionId)){
            return "";
        }
        String[] promotionArray = promotionId.split("-");
        if(Validate.isNullOrEmpty(promotionArray)){
            return "";
        }
        String type = promotionArray[0];
        if(Constants.CouponType.ITEM.getValue().equals(type)){
            return Constants.CouponType.ITEM.toString();
        }else if(Constants.CouponType.SHOP.getValue().equals(type)){
            return Constants.CouponType.SHOP.toString();
        }else {
            return "";
        }
    }

    /**
     *generate remark by seller memo
     * @param sellerMemo
     * @return
     */
    public static JstTradeRemark generateJstTradeRemarkBySellerMemo(String sellerMemo) {
        if (Validate.isNullOrEmpty(sellerMemo)) {
            return null;
        }
        JstTradeRemark jstTradeRemark = new JstTradeRemark();
        try {
            //Format conversion
            sellerMemo = formatJsonString(sellerMemo).replace("；", ";").replace("：", ":").replace("，", ",").replace("、", "");
            //analyze sellerMemo
            String[] array_str = sellerMemo.split(";");
            if (array_str.length != 5) {
                return null;
            }
            try{
                jstTradeRemark.setInvoiceTitle(getInfo(CommonHelper.getTrimString(array_str[0].trim())));
            }catch(Exception ex) {
                log.error(" remark invoice title has error:"+array_str[0]);
            }
            try{
                String invoiceAddress = getInfo(CommonHelper.getTrimString(array_str[1]));
                String[] array_address = invoiceAddress.split(",");
                if (array_address.length == 3) {
                    jstTradeRemark.setReceiveName(CommonHelper.getTrimString(array_address[0]));
                    jstTradeRemark.setMobile(CommonHelper.getTrimString(array_address[1]));
                    jstTradeRemark.setReceiveAddress(CommonHelper.getTrimString(array_address[2]));
                }
            }catch(Exception ex){
                log.error(" remark invoice address has error:"+array_str[1]);
            }
            try{
                String giftInfo = getInfo(CommonHelper.getTrimString(array_str[2]));
                if (!(Validate.isNullOrEmpty(giftInfo) || Validate.isNullOrEmpty(giftInfo.trim()))) {
                    String[] array_gift = giftInfo.split(",");
                    Set<JstTradeRemarkPresent> jstTradeRemarkPresentSet = new HashSet<JstTradeRemarkPresent>();
                    JstTradeRemarkPresent jstTradeRemarkPresent = null;
                    String reason = "";
                    for (int i = 0; i < array_gift.length; i++) {
                        String[] gift = array_gift[i].split(":");
                        if (gift.length == 1) {
                            jstTradeRemarkPresent = new JstTradeRemarkPresent();
                            jstTradeRemarkPresent.setJstTradeRemark(jstTradeRemark);
                            jstTradeRemarkPresent.setPresentName(CommonHelper.getTrimString(gift[0].substring(0, gift[0].length() - 1)));
                            jstTradeRemarkPresent.setPresentQuantity(CommonHelper.IntegerParse(gift[0].substring(gift[0].length() - 1, gift[0].length())));
                            jstTradeRemarkPresent.setPresentReason(CommonHelper.getTrimString(reason));
                            jstTradeRemarkPresentSet.add(jstTradeRemarkPresent);
                        } else if (gift.length == 2) {
                            jstTradeRemarkPresent = new JstTradeRemarkPresent();
                            jstTradeRemarkPresent.setJstTradeRemark(jstTradeRemark);
                            jstTradeRemarkPresent.setPresentName(CommonHelper.getTrimString(gift[1].substring(0, gift[1].length() - 1)));
                            jstTradeRemarkPresent.setPresentQuantity(CommonHelper.IntegerParse(gift[1].substring(gift[1].length() - 1, gift[1].length())));
                            jstTradeRemarkPresent.setPresentReason(CommonHelper.getTrimString(gift[0].substring(0, gift[0].length())));
                            reason = CommonHelper.getTrimString(gift[0].substring(0, gift[0].length()));
                            jstTradeRemarkPresentSet.add(jstTradeRemarkPresent);
                        }
                    }
                    jstTradeRemark.setJstTradeRemarkPresents(jstTradeRemarkPresentSet);
                }
            }catch (Exception ex) {
                log.error("remark gift has error:"+array_str[2]);
            }
            try{
                jstTradeRemark.setQuantity(CommonHelper.IntegerParse(getInfo(array_str[3].trim())));
            }catch (Exception ex){
                log.error("quantity has error:"+array_str[3]);
            }
            try{
                String ticketInfo = getInfo(CommonHelper.getTrimString(array_str[4]));
                if (ticketInfo.indexOf("税号") > 0) {
                    String[] array_ticket = ticketInfo.split("\\|\\|\\|");
                    if(array_ticket.length > 0) {
                        for(int a = 0; a < array_ticket.length ;a ++) {
                            jstTradeRemark.setTicketName(CommonHelper.getTrimString(jstTradeRemark.getTicketName()) + array_ticket[a]);
                        }
                    }
    //                jstTradeRemark.setTicketName(CommonHelper.getTrimString(array_ticket[0]));
    //                jstTradeRemark.setTicketCode(CommonHelper.getTrimString(array_ticket[1]));
    //                jstTradeRemark.setTicketAddress(CommonHelper.getTrimString(array_ticket[2]));
    //                jstTradeRemark.setTicketAccount(CommonHelper.getTrimString(array_ticket[3]));
                }
            } catch (Exception ex) {
                log.error("ticket has error:"+array_str[4]);
            }
            return jstTradeRemark;
        }catch (ArrayIndexOutOfBoundsException ax){
            log.error("ArrayIndexOutOfBoundsException:"+ax.getMessage());
        }catch (Exception ex){
            log.error("Exception:" + ex.getMessage(),ex);
        }
        return null;
    }

    private static String getInfo(String message) {
        return message.substring(1, message.length());
    }

    public static String jsonObjectToString(Object object){
        if(Validate.isNullOrEmpty(object)){
            return "";
        }
        return object.toString();
    }

    public static Integer jsonObjectToInteger(Object object){
        if(Validate.isNullOrEmpty(object)){
            return 0;
        }
        return Integer.parseInt(object.toString());
    }

    public static Double jsonObjectToDouble(Object object){
        if(Validate.isNullOrEmpty(object)){
            return 0.00;
        }
        return Double.parseDouble(object.toString());
    }

    public static Timestamp jsonObjectToTimestamp(Object object,String format) {
        if(Validate.isNullOrEmpty(object)){
            return null;
        }
        return CommonHelper.toTime(object.toString(),format);
    }


    /**
     * 根据优先级获取发票抬头
     * @param jstTradeRemark
     * @param invoiceName
     * @param receiveName
     * @return
     */
    public static String getInvoiceTitlePriority(JstTradeRemark jstTradeRemark,String invoiceName,String receiveName){
        if(!Validate.isNullOrEmpty(jstTradeRemark)){
            if(!Validate.isNullOrEmpty(jstTradeRemark.getInvoiceTitle())){
                return jstTradeRemark.getInvoiceTitle();
            }
        }
        if(!Validate.isNullOrEmpty(invoiceName)) {
            return invoiceName;
        }
        if(!Validate.isNullOrEmpty(receiveName)) {
            return receiveName;
        }
        return "";
    }


    /**
     *测试备注中换行的特殊字符
     */
    private static final String json = "{\"trade_fullinfo_get_response\":{\"trade\":{\"adjust_fee\":\"0.00\",\"alipay_id\":2088602101600374,\"alipay_no\":\"2015031321001001370218629394\",\"alipay_point\":0,\"available_confirm_fee\":\"0.00\",\"buyer_alipay_no\":\"15810409809\",\"buyer_area\":\"北京北京联通ADSL\",\"buyer_cod_fee\":\"0.00\",\"buyer_email\":\"249898158@qq.com\",\"buyer_message\":\"咖啡机记得送\",\"buyer_nick\":\"亲爱的小康康\",\"buyer_obtain_point_fee\":899,\"buyer_rate\":false,\"cod_fee\":\"0.00\",\"cod_status\":\"NEW_CREATED\",\"commission_fee\":\"59.98\",\"consign_time\":\"2015-03-14 18:12:09\",\"created\":\"2015-03-13 19:36:51\",\"credit_card_fee\":\"2999.00\",\"discount_fee\":\"0.00\",\"end_time\":\"2015-03-24 18:12:29\",\"has_post_fee\":false,\"is_3D\":false,\"is_brand_sale\":false,\"is_daixiao\":false,\"is_force_wlb\":false,\"is_lgtype\":true,\"is_part_consign\":false,\"is_wt\":false,\"modified\":\"2015-06-04 16:10:10\",\"orders\":{\"order\":[{\"adjust_fee\":\"0.00\",\"buyer_rate\":false,\"cid\":50003881,\"consign_time\":\"2015-03-14 18:12:09\",\"discount_fee\":\"989.00\",\"divide_order_fee\":\"2999.00\",\"end_time\":\"2015-03-24 18:12:29\",\"invoice_no\":\"6091376768\",\"is_oversold\":false,\"is_www\":true,\"logistics_company\":\"日日顺物流\",\"num\":1,\"num_iid\":41406302095,\"oid\":894370630179755,\"order_from\":\"WAP,WAP\",\"payment\":\"2999.00\",\"pic_path\":\"http://img03.taobaocdn.com/bao/uploaded/i3/TB1iS.UGXXXXXXuXpXXxirN9FXX_044608.jpg\",\"price\":\"3988.00\",\"refund_status\":\"NO_REFUND\",\"seller_rate\":false,\"seller_type\":\"B\",\"shipping_type\":\"express\",\"sku_id\":\"70949739475\",\"sku_properties_name\":\"颜色分类:银色\",\"snapshot_url\":\"g:894370630179755_1\",\"status\":\"TRADE_FINISHED\",\"store_code\":\"QDHEWL-0019\",\"title\":\"SIEMENS/西门子 BCD-235(KG24N1166W)组合冷藏冰箱\",\"total_fee\":\"2999.00\"}]},\"pay_time\":\"2015-03-13 19:37:00\",\"payment\":\"2999.00\",\"pcc_af\":0,\"point_fee\":0,\"post_fee\":\"0.00\",\"promotion_details\":{\"promotion_detail\":[{\"discount_fee\":\"989.00\",\"id\":894370630179755,\"promotion_desc\":\"开年大放价:省989.00元,包邮\",\"promotion_id\":\"Tmall$tmallItemPromotion-55200903_401126989\",\"promotion_name\":\"开年大放价\"}]},\"real_point_fee\":0,\"received_payment\":\"2999.00\",\"receiver_address\":\"阳明街道余姚万达豪庭2栋1801\",\"receiver_city\":\"宁波市\",\"receiver_district\":\"余姚市\",\"receiver_mobile\":\"18610345028\",\"receiver_name\":\"肖敏云\",\"receiver_state\":\"浙江省\",\"receiver_zip\":\"100000\",\"seller_alipay_no\":\"wenjuan.gao@bshg.com\",\"seller_can_rate\":false,\"seller_cod_fee\":\"0.00\",\"seller_email\":\"songji.yu@bshg.com\",\"seller_flag\":3,\"seller_memo\":\"1北京中卓鼎科技有限公司，2，3满赠：咖啡壶一，4一，5（芳芳名称：北京中卓鼎科技有限公司\n" +
            " 税号：110108582507564\n" +
            " 地址：北京市海淀区清河小营雄狮机械厂5幢2层021室\n" +
            " 电话：010-52434790\n" +
            " 开户行：中国民生银行北京东单支行\n" +
            " 账号：0124012830002332\",\"seller_mobile\":\"18551843480\",\"seller_name\":\"博西家用电器（中国）有限公司\",\"seller_nick\":\"西门子家电官方旗舰店\",\"seller_phone\":\"400-8251919\",\"seller_rate\":false,\"service_orders\":{\"service_order\":[{\"buyer_nick\":\"亲爱的小康康\",\"item_oid\":894370630149755,\"num\":1,\"oid\":894370630159755,\"payment\":\"0.00\",\"pic_path\":\"http://img.taobaocdn.com/bao/uploaded/http://img03.taobaocdn.com/tps/i3/T1K6KfXrXXXXbmbP6j-60-60.jpg\",\"price\":\"0.00\",\"seller_nick\":\"西门子家电官方旗舰店\",\"service_detail_url\":\"http://fuwu.tmall.com/protocol/get_protocol.htm?service_item_id=1\",\"service_id\":1,\"title\":\"送货入户\",\"total_fee\":\"0.00\"},{\"buyer_nick\":\"亲爱的小康康\",\"item_oid\":894370630149755,\"num\":1,\"oid\":894370630169755,\"payment\":\"0.00\",\"pic_path\":\"http://img.taobaocdn.com/bao/uploaded/http://img03.taobaocdn.com/tps/i3/T1pLuoXvxXXXajiPzi-54-60.jpg\",\"price\":\"0.00\",\"seller_nick\":\"西门子家电官方旗舰店\",\"service_detail_url\":\"http://fuwu.tmall.com/protocol/get_protocol.htm?service_item_id=21785043555\",\"service_id\":21785043555,\"title\":\"全国联保\",\"tmser_spu_code\":\"SIEMENS/西门子全国联保-672\",\"total_fee\":\"0.00\"}]},\"service_tags\":{\"logistics_tag\":[{\"logistic_service_tag_list\":{\"logistic_service_tag\":[{\"service_tag\":\"esTime=3;osTime=3;osFee=0;osDate=2015-03-16;osDateF=3;lgType=5\",\"service_type\":\"WLB\"}]},\"order_id\":\"894370630149755\"},{\"logistic_service_tag_list\":{\"logistic_service_tag\":[{\"service_tag\":\"esTime=3;osTime=3;osFee=0;osDate=2015-03-16;ssid=5000000000001_50;osDateF=3;cutTime=16;lgType=5;storeCode=QDHEWL-0019\",\"service_type\":\"WWW_HOME\"}]},\"order_id\":\"894370630179755\"}]},\"shipping_type\":\"express\",\"snapshot_url\":\"g:894370630149755_1\",\"status\":\"TRADE_FINISHED\",\"tid\":894370630149755,\"title\":\"西门子家电官方旗舰店\",\"total_fee\":\"3988.00\",\"trade_from\":\"WAP,WAP\",\"type\":\"fixed\"}}}";

    private static final String json1 ="{\"trade_fullinfo_get_response\":{\"trade\":{\"adjust_fee\":\"0.00\",\"alipay_id\":2088402519137754,\"alipay_no\":\"2015052921001001750215664192\",\"alipay_point\":0,\"available_confirm_fee\":\"0.00\",\"buyer_alipay_no\":\"961909917@qq.com\",\"buyer_area\":\"上海上海联通\",\"buyer_cod_fee\":\"0.00\",\"buyer_email\":\"961909917@qq.com\",\"buyer_nick\":\"karen19881225\",\"buyer_obtain_point_fee\":379,\"buyer_rate\":false,\"cod_fee\":\"0.00\",\"cod_status\":\"NEW_CREATED\",\"commission_fee\":\"75.80\",\"consign_time\":\"2015-05-29 16:06:14\",\"created\":\"2015-05-29 15:29:46\",\"discount_fee\":\"0.00\",\"end_time\":\"2015-06-08 16:06:33\",\"has_post_fee\":false,\"invoice_name\":\"李彪\",\"is_3D\":false,\"is_brand_sale\":false,\"is_daixiao\":false,\"is_force_wlb\":false,\"is_lgtype\":true,\"is_part_consign\":false,\"is_wt\":false,\"modified\":\"2015-06-08 16:06:33\",\"orders\":{\"order\":[{\"adjust_fee\":\"0.00\",\"buyer_rate\":false,\"cid\":50003881,\"consign_time\":\"2015-05-29 16:06:14\",\"discount_fee\":\"842.00\",\"divide_order_fee\":\"3790.00\",\"end_time\":\"2015-06-08 16:06:33\",\"invoice_no\":\"6095234219\",\"is_oversold\":false,\"is_www\":true,\"logistics_company\":\"日日顺物流\",\"num\":1,\"num_iid\":21556631052,\"oid\":950962717835781,\"order_from\":\"TAOBAO\",\"payment\":\"3790.00\",\"pic_path\":\"http:\\/\\/img01.taobaocdn.com\\/bao\\/uploaded\\/i1\\/859230932\\/TB2JptFbVXXXXXyXXXXXXXXXXXX_!!859230932.jpg\",\"price\":\"4632.00\",\"refund_status\":\"NO_REFUND\",\"seller_rate\":false,\"seller_type\":\"B\",\"shipping_type\":\"express\",\"sku_id\":\"35643551490\",\"sku_properties_name\":\"颜色分类:银色\",\"snapshot_url\":\"h:950962717835781_1\",\"status\":\"TRADE_FINISHED\",\"store_code\":\"QDHEWL-0004\",\"title\":\"SIEMENS\\/西门子 KG23F1861W  零度生物保鲜技术  224升三门电冰箱\",\"total_fee\":\"3790.00\"}]},\"pay_time\":\"2015-05-29 15:30:44\",\"payment\":\"3790.00\",\"pcc_af\":0,\"point_fee\":0,\"post_fee\":\"0.00\",\"promotion_details\":{\"promotion_detail\":[{\"discount_fee\":\"842.00\",\"id\":950962717835781,\"promotion_desc\":\"尚新价:省842.00元,包邮\",\"promotion_id\":\"Tmall$tmallItemPromotion-57751420_464655668\",\"promotion_name\":\"尚新价\"}]},\"real_point_fee\":0,\"received_payment\":\"3790.00\",\"receiver_address\":\"大龙湖街道商聚路中茵龙湖国际，14号楼2单元1601\",\"receiver_city\":\"徐州市\",\"receiver_district\":\"云龙区\",\"receiver_mobile\":\"15052063456\",\"receiver_name\":\"李彪\",\"receiver_state\":\"江苏省\",\"receiver_zip\":\"000000\",\"seller_alipay_no\":\"wenjuan.gao@bshg.com\",\"seller_can_rate\":false,\"seller_cod_fee\":\"0.00\",\"seller_email\":\"songji.yu@bshg.com\",\"seller_flag\":3,\"seller_memo\":\"1， 2江苏省  徐州市  云龙区  大龙湖街道商聚路中茵龙湖国际14号楼2单元1601  000000  李彪  15052063456\\r\\n， 3工具盒一， 4一，5\",\"seller_mobile\":\"18551843480\",\"seller_name\":\"博西家用电器（中国）有限公司\",\"seller_nick\":\"西门子家电官方旗舰店\",\"seller_phone\":\"400-8251919\",\"seller_rate\":false,\"service_orders\":{\"service_order\":[{\"buyer_nick\":\"karen19881225\",\"item_oid\":950962717805781,\"num\":1,\"oid\":950962717815781,\"payment\":\"0.00\",\"pic_path\":\"http:\\/\\/img.taobaocdn.com\\/bao\\/uploaded\\/\\/\\/gtd.alicdn.com\\/tps\\/i3\\/T1K6KfXrXXXXbmbP6j-60-60.jpg\",\"price\":\"0.00\",\"seller_nick\":\"西门子家电官方旗舰店\",\"service_detail_url\":\"http:\\/\\/fuwu.tmall.com\\/protocol\\/get_protocol.htm?service_item_id=1\",\"service_id\":1,\"title\":\"送货入户\",\"total_fee\":\"0.00\"},{\"buyer_nick\":\"karen19881225\",\"item_oid\":950962717805781,\"num\":1,\"oid\":950962717825781,\"payment\":\"0.00\",\"pic_path\":\"http:\\/\\/img.taobaocdn.com\\/bao\\/uploaded\\/http:\\/\\/img03.taobaocdn.com\\/tps\\/i3\\/T1pLuoXvxXXXajiPzi-54-60.jpg\",\"price\":\"0.00\",\"seller_nick\":\"西门子家电官方旗舰店\",\"service_detail_url\":\"http:\\/\\/fuwu.tmall.com\\/protocol\\/get_protocol.htm?service_item_id=21785043555\",\"service_id\":21785043555,\"title\":\"全国联保\",\"tmser_spu_code\":\"SIEMENS\\/西门子全国联保-672\",\"total_fee\":\"0.00\"}]},\"service_tags\":{\"logistics_tag\":[{\"logistic_service_tag_list\":{\"logistic_service_tag\":[{\"service_tag\":\"esTime=2;lgType=5\",\"service_type\":\"WLB\"}]},\"order_id\":\"950962717805781\"},{\"logistic_service_tag_list\":{\"logistic_service_tag\":[{\"service_tag\":\"esTime=2;ssid=5000000000001_50;cutTime=16;lgType=5;storeCode=QDHEWL-0004\",\"service_type\":\"WWW_HOME\"}]},\"order_id\":\"950962717835781\"}]},\"shipping_type\":\"express\",\"snapshot_url\":\"h:950962717805781_1\",\"status\":\"TRADE_FINISHED\",\"tid\":950962717805781,\"title\":\"西门子家电官方旗舰店\",\"total_fee\":\"4632.00\",\"trade_from\":\"TAOBAO\",\"type\":\"fixed\"}}}\n";
//    public static void main(String[] args){
////        String str = json1.replace("\\n","");
////        str = str.replace("\\r","");
////        System.out.println(str);
//
////        StringBuffer stringBuffer = new StringBuffer(json1.replaceAll("\n","").replaceAll("\r",""));
////        System.out.println(stringBuffer.toString());
////        JSONObject jsonObject = JSONObject.fromObject(stringBuffer.toString()).getJSONObject("trade_fullinfo_get_response").getJSONObject("trade");
////        System.out.println(jsonObject.get("seller_memo"));
//
////        String a = "\r1234\n456\r\n134";
////        a = a.replaceAll("\\r","");
////        a = a.replaceAll("\\n","");
////        System.out.println(a);
////        System.out.println(a);
//
//
////        String b = "{\"receiver_address\":\"杨林乡王安村上山组一号（顺丰韵达天天，\"申圆汇中通\"都到）\"}";
//        String b = "{\"trade_fullinfo_get_response\":{\"trade\":{\"adjust_fee\":\"0.00\",\"alipay_id\":2088702544635345,\"alipay_no\":\"2015053121001001340221590318\",\"alipay_point\":0,\"available_confirm_fee\":\"2190.00\",\"buyer_alipay_no\":\"258347158@qq.com\",\"buyer_area\":\"湖南长沙联通\",\"buyer_cod_fee\":\"0.00\",\"buyer_email\":\"258347158@qq.com\",\"buyer_message\":\"务必竖着搬运！横放拒收！冰箱要原装全新正品无瑕疵，拒绝返修机！\",\"buyer_nick\":\"zydx2583\",\"buyer_obtain_point_fee\":0,\"buyer_rate\":false,\"cod_fee\":\"0.00\",\"cod_status\":\"NEW_CREATED\",\"commission_fee\":\"0.00\",\"created\":\"2015-05-31 23:28:23\",\"discount_fee\":\"0.00\",\"end_time\":\"2015-05-31 23:36:00\",\"has_post_fee\":true,\"is_3D\":false,\"is_brand_sale\":false,\"is_daixiao\":false,\"is_force_wlb\":false,\"is_lgtype\":true,\"is_part_consign\":false,\"is_wt\":false,\"modified\":\"2015-06-03 12:09:14\",\"orders\":{\"order\":[{\"adjust_fee\":\"0.00\",\"buyer_rate\":false,\"cid\":50003881,\"discount_fee\":\"534.00\",\"end_time\":\"2015-05-31 23:36:00\",\"is_oversold\":false,\"is_www\":true,\"num\":1,\"num_iid\":43684255274,\"oid\":1072332341171833,\"order_from\":\"WAP,WAP\",\"payment\":\"2190.00\",\"pic_path\":\"http://img06.taobaocdn.com/bao/uploaded/i6/TB1RxJsFVXXXXcHXFXX2x26_FXX_062504.jpg\",\"price\":\"2724.00\",\"refund_status\":\"NO_REFUND\",\"seller_rate\":false,\"seller_type\":\"B\",\"sku_id\":\"77459778476\",\"sku_properties_name\":\"颜色分类:白色\",\"snapshot_url\":\"h:1072332341171833_1\",\"status\":\"TRADE_CLOSED_BY_TAOBAO\",\"store_code\":\"QDHEWL-0010\",\"title\":\"SIEMENS/西门子 BCD-200(KK20V0111W) 双门冰箱\",\"total_fee\":\"2190.00\"}]},\"payment\":\"2190.00\",\"pcc_af\":0,\"point_fee\":0,\"post_fee\":\"0.00\",\"promotion_details\":{\"promotion_detail\":[{\"discount_fee\":\"534.00\",\"id\":1072332341171833,\"promotion_desc\":\"尚新价:省534.00元,包邮\",\"promotion_id\":\"Tmall$tmallItemPromotion-59838150_483346709\",\"promotion_name\":\"尚新价\"}]},\"real_point_fee\":0,\"received_payment\":\"0.00\",\"receiver_address\":\"杨林乡王安村上山组一号（顺丰韵达天天，\"申圆汇中通\"都到）\",\"receiver_city\":\"岳阳市\",\"receiver_district\":\"岳阳县\",\"receiver_mobile\":\"18692117815\",\"receiver_name\":\"叶盈盈\",\"receiver_state\":\"湖南省\",\"receiver_zip\":\"414114\",\"seller_alipay_no\":\"wenjuan.gao@bshg.com\",\"seller_can_rate\":false,\"seller_cod_fee\":\"0.00\",\"seller_email\":\"songji.yu@bshg.com\",\"seller_flag\":0,\"seller_mobile\":\"18551843480\",\"seller_name\":\"博西家用电器（中国）有限公司\",\"seller_nick\":\"西门子家电官方旗舰店\",\"seller_phone\":\"400-8251919\",\"seller_rate\":false,\"service_orders\":{\"service_order\":[{\"buyer_nick\":\"zydx2583\",\"item_oid\":1072332341141833,\"num\":1,\"oid\":1072332341151833,\"payment\":\"0.00\",\"pic_path\":\"http://img.taobaocdn.com/bao/uploaded///gtd.alicdn.com/tps/i3/T1K6KfXrXXXXbmbP6j-60-60.jpg\",\"price\":\"0.00\",\"seller_nick\":\"西门子家电官方旗舰店\",\"service_detail_url\":\"http://fuwu.tmall.com/protocol/get_protocol.htm?service_item_id=1\",\"service_id\":1,\"title\":\"送货入户\",\"total_fee\":\"0.00\"},{\"buyer_nick\":\"zydx2583\",\"item_oid\":1072332341141833,\"num\":1,\"oid\":1072332341161833,\"payment\":\"0.00\",\"pic_path\":\"http://img.taobaocdn.com/bao/uploaded/http://img03.taobaocdn.com/tps/i3/T1pLuoXvxXXXajiPzi-54-60.jpg\",\"price\":\"0.00\",\"seller_nick\":\"西门子家电官方旗舰店\",\"service_detail_url\":\"http://fuwu.tmall.com/protocol/get_protocol.htm?service_item_id=21785043555\",\"service_id\":21785043555,\"title\":\"全国联保\",\"tmser_spu_code\":\"SIEMENS/西门子全国联保-672\",\"total_fee\":\"0.00\"}]},\"service_tags\":{\"logistics_tag\":[{\"logistic_service_tag_list\":{\"logistic_service_tag\":[{\"service_tag\":\"esTime=3;osTime=3;osFee=0;osDate=2015-06-03;osDateF=3;lgType=5\",\"service_type\":\"WLB\"}]},\"order_id\":\"1072332341141833\"},{\"logistic_service_tag_list\":{\"logistic_service_tag\":[{\"service_tag\":\"esTime=3;osTime=3;osFee=0;osDate=2015-06-03;ssid=5000000000001_50;osDateF=3;cutTime=16;lgType=5;storeCode=QDHEWL-0010\",\"service_type\":\"WWW_HOME\"}]},\"order_id\":\"1072332341171833\"}]},\"shipping_type\":\"express\",\"snapshot_url\":\"h:1072332341141833_1\",\"status\":\"TRADE_CLOSED_BY_TAOBAO\",\"tid\":1072332341141833,\"title\":\"西门子家电官方旗舰店\",\"total_fee\":\"2724.00\",\"trade_from\":\"WAP,WAP\",\"type\":\"fixed\"}}}";
////        b = b.replaceAll("^[(\",\")|(\":\")]\"","");
////        System.out.println(b);
//        JSONObject jsonObject = JSONObject.fromObject(jsonString(b));
//        System.out.println(jsonObject.getJSONObject("trade_fullinfo_get_response").toString());
//    }


    public static void main(String[] args){
//        List<String> title = new ArrayList<String>();
//        title.add("a");
//        title.add("13");
//        List<String> content = new ArrayList<String>();
//        content.add("13");
//        content.add("a");
//
//        System.out.println(title.equals(content));



//        String tid = "'123','srt',";
//        tid = tid.substring(0,tid.length()-1);
//        System.out.println(tid);


//        String a = "13";
//        String b = "134567";
//        System.out.println(b.indexOf(a));
//        System.out.println(b.indexOf(a));
//
//        double a = 2345;
//        double b = 3;
////        BigDecimal c=     new BigDecimal(a).remainder(new BigDecimal(b)).setScale(1,BigDecimal.ROUND_HALF_EVEN) ;
////         System.out.println(c.setScale(1,BigDecimal.ROUND_HALF_DOWN).intValue());
//        System.out.println(new BigDecimal(a).remainder(new BigDecimal(b)).intValue());

//        String a = "上海市";
//        String b = "上海";
//        System.out.println(a.indexOf(b)>=0);
//
//        String title = "#账号：[20887011960011000156]";
//        System.out.println(title.substring(5,title.length() -1));

//        String memo = "1、镇江润能电气有限公司；2、曹彬，13961204507，江苏省常州市溧阳市溧城镇盛世华城5幢1单元402室；3；4、1；5、名称：镇江润能电气有限公司" +
//                "税号：321100058657654" +
//                "地址、电话：镇江市润州花园6幢13775359929" +
//                "开户行、帐号：中国工商银行股份有限公司镇江分行1104010309000285807" ;
//
//        TradeRemark tradeRemark = getTradeRemarkBySellerMemo(memo);
//        System.out.println(tradeRemark.getInvoiceTitle());
//        System.out.println(tradeRemark.getTicketAccount());
//        System.out.println(tradeRemark.getTicketAddress());
//        System.out.println(tradeRemark.getTicketCode());
//        System.out.println(tradeRemark.getTicketName());
//        System.out.println(tradeRemark.getMobile());
//        System.out.println(tradeRemark.getPhone());
//        System.out.println(tradeRemark.getQuantity());
//        System.out.println(tradeRemark.getReceiveAddress());
//        System.out.println(tradeRemark.getReceiveName());
//        System.out.println(tradeRemark.getReceiveZip());
//        System.out.println(tradeRemark.getTid());

//        String response = "{\"trade_fullinfo_get_response\":{\"trade\":{\"adjust_fee\":\"0.00\",\"alipay_id\":2088002469832121,\"alipay_no\":\"2015082421001001120274649109\",\"alipay_point\":0,\"available_confirm_fee\":\"5690.00\",\"buyer_alipay_no\":\"liuhongliang21@163.com\",\"buyer_area\":\"上海上海联通\",\"buyer_cod_fee\":\"0.00\",\"buyer_email\":\"liuhongliang21@163.com\",\"buyer_nick\":\"芊芊dora\",\"buyer_obtain_point_fee\":0,\"buyer_rate\":false,\"cod_fee\":\"0.00\",\"cod_status\":\"NEW_CREATED\",\"commission_fee\":\"0.00\",\"consign_time\":\"2015-08-24 19:11:28\",\"created\":\"2015-08-24 11:52:03\",\"credit_card_fee\":\"5690.00\",\"discount_fee\":\"100.00\",\"has_post_fee\":true,\"invoice_name\":\"姜海霞\",\"is_3D\":false,\"is_brand_sale\":false,\"is_daixiao\":false,\"is_force_wlb\":false,\"is_lgtype\":true,\"is_part_consign\":false,\"is_wt\":false,\"modified\":\"2015-08-24 19:13:31\",\"orders\":{\"order\":[{\"adjust_fee\":\"0.00\",\"buyer_rate\":false,\"cid\":350301,\"consign_time\":\"2015-08-24 19:11:28\",\"discount_fee\":\"200.00\",\"divide_order_fee\":\"5690.00\",\"invoice_no\":\"6098569473\",\"is_oversold\":false,\"is_www\":true,\"logistics_company\":\"日日顺物流\",\"num\":1,\"num_iid\":45467912866,\"oid\":1227798428501232,\"order_from\":\"TAOBAO\",\"part_mjz_discount\":\"100.00\",\"payment\":\"5790.00\",\"pic_path\":\"http://img05.taobaocdn.com/bao/uploaded/i5/TB1nREgHFXXXXbkaXXXBVNr9FXX_042812.jpg\",\"price\":\"5990.00\",\"refund_status\":\"NO_REFUND\",\"seller_rate\":false,\"seller_type\":\"B\",\"shipping_type\":\"express\",\"sku_id\":\"91208439529\",\"sku_properties_name\":\"颜色分类:白色\",\"snapshot_url\":\"h:1227798428501232_1\",\"status\":\"WAIT_BUYER_CONFIRM_GOODS\",\"store_code\":\"QDHEWL-0082\",\"timeout_action_time\":\"2015-09-03 19:11:28\",\"title\":\"SIEMENS/西门子 XQG80-WD12G4601W变频洗干一体干衣机8kg洗衣机\",\"total_fee\":\"5790.00\"}]},\"pay_time\":\"2015-08-24 11:52:26\",\"payment\":\"5690.00\",\"pcc_af\":0,\"point_fee\":0,\"post_fee\":\"0.00\",\"promotion_details\":{\"promotion_detail\":[{\"discount_fee\":\"100.00\",\"id\":1227798428461232,\"promotion_desc\":\"100元日销:省100.00元\",\"promotion_id\":\"shopbonus-849776280_5087068323-131212548389\",\"promotion_name\":\"100元日销\"},{\"discount_fee\":\"200.00\",\"id\":1227798428501232,\"promotion_desc\":\"特惠价:省200.00元,包邮\",\"promotion_id\":\"Tmall$tmallItemPromotion-62198129_531730460\",\"promotion_name\":\"特惠价\"}]},\"real_point_fee\":0,\"received_payment\":\"0.00\",\"receiver_address\":\"三林镇环林西路608弄20号501\",\"receiver_city\":\"上海市\",\"receiver_district\":\"浦东新区\",\"receiver_mobile\":\"13524491929\",\"receiver_name\":\"姜海霞\",\"receiver_phone\":\"021-54354553\",\"receiver_state\":\"上海\",\"receiver_zip\":\"200123\",\"seller_alipay_no\":\"wenjuan.gao@bshg.com\",\"seller_can_rate\":false,\"seller_cod_fee\":\"0.00\",\"seller_email\":\"songji.yu@bshg.com\",\"seller_flag\":3,\"seller_memo\":\"1、上海臻鼎会展服务有限公司；2、姜海霞，13524491929，上海上海市浦东新区三林镇环林西路608弄20号501；3、买送：电熨斗1；4、1；5、童童开增值税专用发票\n" +
//                "名称：上海臻鼎会展服务有限公司\n" +
//                "税号：31011558207296X\n" +
//                "地址、电话：上海市浦东新区康桥路787号7号楼223室021-60455909\n" +
//                "开户行、帐号：上海浦东发展银行三林支行97600154740001326\",\"seller_mobile\":\"18551843480\",\"seller_name\":\"博西家用电器（中国）有限公司\",\"seller_nick\":\"西门子家电官方旗舰店\",\"seller_phone\":\"400-8251919\",\"seller_rate\":false,\"service_orders\":{\"service_order\":[{\"buyer_nick\":\"芊芊dora\",\"item_oid\":1227798428461232,\"num\":1,\"oid\":1227798428481232,\"payment\":\"0.00\",\"pic_path\":\"http://img.taobaocdn.com/bao/uploaded///gtd.alicdn.com/tps/i3/T1K6KfXrXXXXbmbP6j-60-60.jpg\",\"price\":\"0.00\",\"seller_nick\":\"西门子家电官方旗舰店\",\"service_detail_url\":\"http://fuwu.tmall.com/protocol/get_protocol.htm?service_item_id=1\",\"service_id\":1,\"title\":\"送货入户\",\"total_fee\":\"0.00\"},{\"buyer_nick\":\"芊芊dora\",\"item_oid\":1227798428461232,\"num\":1,\"oid\":1227798428491232,\"payment\":\"0.00\",\"pic_path\":\"http://img.taobaocdn.com/bao/uploaded///gtd.alicdn.com/tps/i3/T1pLuoXvxXXXajiPzi-54-60.jpg\",\"price\":\"0.00\",\"seller_nick\":\"西门子家电官方旗舰店\",\"service_detail_url\":\"http://fuwu.tmall.com/protocol/get_protocol.htm?service_item_id=26790308269\",\"service_id\":26790308269,\"title\":\"全国联保\",\"tmser_spu_code\":\"SIEMENS/西门子全国联保-673\",\"total_fee\":\"0.00\"}]},\"service_tags\":{\"logistics_tag\":[{\"logistic_service_tag_list\":{\"logistic_service_tag\":[{\"service_tag\":\"esTime=2;lgType=5\",\"service_type\":\"WLB\"}]},\"order_id\":\"1227798428461232\"},{\"logistic_service_tag_list\":{\"logistic_service_tag\":[{\"service_tag\":\"esTime=2;ssid=5000000000001_50;cutTime=16;lgType=5;storeCode=QDHEWL-0082\",\"service_type\":\"WWW_HOME\"}]},\"order_id\":\"1227798428501232\"}]},\"shipping_type\":\"express\",\"snapshot_url\":\"h:1227798428461232_1\",\"status\":\"WAIT_BUYER_CONFIRM_GOODS\",\"tid\":1227798428461232,\"timeout_action_time\":\"2015-09-03 19:11:28\",\"title\":\"西门子家电官方旗舰店\",\"total_fee\":\"5990.00\",\"trade_from\":\"TAOBAO\",\"type\":\"fixed\"}}}\n";
//        TempTrade tempTrade = generateTempTrade(response);
//        System.out.println(tempTrade.getSellerMemo());

//        String str = "名称:江苏康诺医疗器械有限公司|||税号:320581754611596|||地址电话:江苏省常熟市古里镇白茆开发区红枫路38号0512-52350210|||开户行账号:常熟农村商业银行白茆支行0145797611120100105171";
//        TradeRemark tradeRemark = new TradeRemark();
//        String[] array_ticket = str.split("\\|\\|\\|");
//        System.out.println(array_ticket[0]);
//        System.out.println(array_ticket[1]);
//        System.out.println(array_ticket[2]);
//        System.out.println(array_ticket[3]);

//        String str = "买送:工具盒1";
//        String str = "排名礼:工具盒1,双色杯1,买就送:咖啡壶1";
//        String[] array_gift = str.split(",");
//        Set<TradeRemarkPresent> tradeRemarkPresentSet = new HashSet<TradeRemarkPresent>();
//        TradeRemarkPresent tradeRemarkPresent = null;
//        String reason = "";
//        for (int i = 0; i < array_gift.length; i++) {
//            String[] gift = array_gift[i].split(":");
//            if (gift.length == 1) {
//                tradeRemarkPresent = new TradeRemarkPresent();
//                tradeRemarkPresent.setPresentName(gift[0].substring(0, gift[0].length() - 1));
//                tradeRemarkPresent.setPresentQuantity(CommonHelper.IntegerParse(gift[0].substring(gift[0].length() - 1, gift[0].length())));
//                tradeRemarkPresent.setPresentReason(reason);
//                tradeRemarkPresentSet.add(tradeRemarkPresent);
//            } else if (gift.length == 2) {
//                tradeRemarkPresent = new TradeRemarkPresent();
//                System.out.println("NEW***********************************");
//                tradeRemarkPresent.setPresentName(gift[1].substring(0, gift[1].length() - 1));
//                tradeRemarkPresent.setPresentQuantity(CommonHelper.IntegerParse(gift[1].substring(gift[1].length() - 1, gift[1].length())));
//                reason = gift[0].substring(0, gift[0].length());
//                tradeRemarkPresent.setPresentReason(gift[0].substring(0, gift[0].length()));
//                tradeRemarkPresentSet.add(tradeRemarkPresent);
//            }
//        }
//
//        tradeRemarkPresentSet.size();

//        double a = new BigDecimal(567.0).divide(new BigDecimal(2.0)).setScale(2).doubleValue();
//        System.out.println(new BigDecimal(a).divide(new BigDecimal(100.0)).setScale(3).doubleValue());
//        System.out.println(new BigDecimal(567.0).divide(new BigDecimal(2.0)).divide(new BigDecimal(100.0)).setScale(2,BigDecimal.ROUND_HALF_EVEN).doubleValue());
//        System.out.println(new BigDecimal(567.0).divide(new BigDecimal(2.0)).divide(new BigDecimal(100.0)).doubleValue());
//        System.out.println(new BigDecimal(76).divide(new BigDecimal(1)).divide(new BigDecimal(100.0)).doubleValue());
//        System.out.println(new BigDecimal(207.41).divide(new BigDecimal(3)).doubleValue());
//        System.out.println(CommonHelper.getMod(10,3));

//        System.out.println(CommonHelper.getModDouble(207.41,3));
//
//        System.out.println(CommonHelper.getModDouble(57.27d,1.0d));
//
//        System.out.println(CommonHelper.getMod(5727,1));
//
//        System.out.println(CommonHelper.getMod(207.41 * 100,3));


//        String response = "1； 2、 陈早英，15872063849，湖北省咸宁市咸安区永安办事处咸安区咸宝路宝汇宾馆门口；3、好评：双色杯1；4、1；5";
//        TradeRemark tempTrade = getTradeRemarkBySellerMemo(response);
//        System.out.println("");

        String memo = "1、宁波瑞琦塑业科技有限公司；2、18617326262，海南省海口市美兰区国营桂林洋农场开维生态城檀逸29号101；3、排名礼：咖啡壶1；4、1；5、公司名称：宁波瑞琦塑业科技有限公司\n" +
                "税     号：330203316917915\n" +
                "地址、电话：浙江省宁波市海曙区泛亚中心28号（10-15）室 0574-87894806\n" +
                "开户行、账号：中国工商银行股份有限公司宁波启运支行 3901111609000001561\n";


        System.out.println(generateJstTradeRemarkBySellerMemo(memo));


//        CommonHelper.getSub(CommonHelper.getDiv(CommonHelper.getSub(tempOrder.getPayment(),tempOrder.getPartMjzDiscount()),tempOrder.getNum()),pointFee);


        System.out.println(new BigDecimal(6062.59).divide(new BigDecimal(3)).doubleValue());
//        System.out.println(CommonHelper.getSub(CommonHelper.getDiv(6062.59,3),0));
//        System.out.println(CommonHelper.getSub(CommonHelper.getDiv(CommonHelper.getSub(0,207.41),3),0));

    }


}
