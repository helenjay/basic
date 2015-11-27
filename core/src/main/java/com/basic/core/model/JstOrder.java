package com.basic.core.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * JstOrder entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jst_order")
public class JstOrder implements java.io.Serializable {

	// Fields

	private Integer jstOrderSysId;
	private JstTrade jstTrade;
	private Double adjustFee;
	private String buyerRate;
	private String cid;
	private Date consignTime;
	private Double discountFee;
	private Double divideOrderFee;
	private Date endTime;
	private String invoiceNo;
	private String isOversold;
	private String isWww;
	private String logisticsCompany;
	private Integer num;
	private String numIid;
	private String oid;
	private String orderFrom;
	private Double partMjzDiscount;
	private Double payment;
	private String picPath;
	private Double price;
	private String refundId;
	private String refundStatus;
	private String sellerRate;
	private String sellerType;
	private String shippingType;
	private String skuId;
	private String skuPropertiesName;
	private String snapshotUrl;
	private String status;
	private String storeCode;
	private String title;
	private Double totalFee;
	private String itemMealName;
	private String outerIid;
	private Date timeoutActionTime;
	private String subOrderTaxFee;
	private String subOrderTaxRate;
	private String itemMealId;
	private String outerSkuId;
	private String isServiceOrder;
	private String bindOid;
	private String isDaixiao;
	private String ticketOuterId;
	private String ticketExpdateKey;
	private String tmserSpuCode;
	private String matnr;
	private String itemMemo;
	private Date etSerTime;
	private String etShopName;
	private String etVerifiedShopName;
	private String etPlateNumber;
	private String estimateConTime;
	private String bindOids;
	private String zhengjiStatus;

	// Constructors

	/** default constructor */
	public JstOrder() {
	}

	/** minimal constructor */
	public JstOrder(JstTrade jstTrade) {
		this.jstTrade = jstTrade;
	}

	/** full constructor */
	public JstOrder(JstTrade jstTrade, Double adjustFee, String buyerRate,
			String cid, Date consignTime, Double discountFee,
			Double divideOrderFee, Date endTime, String invoiceNo,
			String isOversold, String isWww, String logisticsCompany,
			Integer num, String numIid, String oid, String orderFrom,
			Double partMjzDiscount, Double payment, String picPath,
			Double price, String refundId, String refundStatus,
			String sellerRate, String sellerType, String shippingType,
			String skuId, String skuPropertiesName, String snapshotUrl,
			String status, String storeCode, String title, Double totalFee,
			String itemMealName, String outerIid, Date timeoutActionTime,
			String subOrderTaxFee, String subOrderTaxRate, String itemMealId,
			String outerSkuId, String isServiceOrder, String bindOid,
			String isDaixiao, String ticketOuterId, String ticketExpdateKey,
			String tmserSpuCode, String matnr, String itemMemo, Date etSerTime,
			String etShopName, String etVerifiedShopName, String etPlateNumber,
			String estimateConTime, String bindOids, String zhengjiStatus) {
		this.jstTrade = jstTrade;
		this.adjustFee = adjustFee;
		this.buyerRate = buyerRate;
		this.cid = cid;
		this.consignTime = consignTime;
		this.discountFee = discountFee;
		this.divideOrderFee = divideOrderFee;
		this.endTime = endTime;
		this.invoiceNo = invoiceNo;
		this.isOversold = isOversold;
		this.isWww = isWww;
		this.logisticsCompany = logisticsCompany;
		this.num = num;
		this.numIid = numIid;
		this.oid = oid;
		this.orderFrom = orderFrom;
		this.partMjzDiscount = partMjzDiscount;
		this.payment = payment;
		this.picPath = picPath;
		this.price = price;
		this.refundId = refundId;
		this.refundStatus = refundStatus;
		this.sellerRate = sellerRate;
		this.sellerType = sellerType;
		this.shippingType = shippingType;
		this.skuId = skuId;
		this.skuPropertiesName = skuPropertiesName;
		this.snapshotUrl = snapshotUrl;
		this.status = status;
		this.storeCode = storeCode;
		this.title = title;
		this.totalFee = totalFee;
		this.itemMealName = itemMealName;
		this.outerIid = outerIid;
		this.timeoutActionTime = timeoutActionTime;
		this.subOrderTaxFee = subOrderTaxFee;
		this.subOrderTaxRate = subOrderTaxRate;
		this.itemMealId = itemMealId;
		this.outerSkuId = outerSkuId;
		this.isServiceOrder = isServiceOrder;
		this.bindOid = bindOid;
		this.isDaixiao = isDaixiao;
		this.ticketOuterId = ticketOuterId;
		this.ticketExpdateKey = ticketExpdateKey;
		this.tmserSpuCode = tmserSpuCode;
		this.matnr = matnr;
		this.itemMemo = itemMemo;
		this.etSerTime = etSerTime;
		this.etShopName = etShopName;
		this.etVerifiedShopName = etVerifiedShopName;
		this.etPlateNumber = etPlateNumber;
		this.estimateConTime = estimateConTime;
		this.bindOids = bindOids;
		this.zhengjiStatus = zhengjiStatus;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "JST_ORDER_SYS_ID", unique = true, nullable = false)
	public Integer getJstOrderSysId() {
		return this.jstOrderSysId;
	}

	public void setJstOrderSysId(Integer jstOrderSysId) {
		this.jstOrderSysId = jstOrderSysId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JST_TRADE_SYS_ID", nullable = false)
	public JstTrade getJstTrade() {
		return this.jstTrade;
	}

	public void setJstTrade(JstTrade jstTrade) {
		this.jstTrade = jstTrade;
	}

	@Column(name = "ADJUST_FEE", precision = 22, scale = 0)
	public Double getAdjustFee() {
		return this.adjustFee;
	}

	public void setAdjustFee(Double adjustFee) {
		this.adjustFee = adjustFee;
	}

	@Column(name = "BUYER_RATE", length = 10)
	public String getBuyerRate() {
		return this.buyerRate;
	}

	public void setBuyerRate(String buyerRate) {
		this.buyerRate = buyerRate;
	}

	@Column(name = "CID", length = 100)
	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONSIGN_TIME", length = 19)
	public Date getConsignTime() {
		return this.consignTime;
	}

	public void setConsignTime(Date consignTime) {
		this.consignTime = consignTime;
	}

	@Column(name = "DISCOUNT_FEE", precision = 10)
	public Double getDiscountFee() {
		return this.discountFee;
	}

	public void setDiscountFee(Double discountFee) {
		this.discountFee = discountFee;
	}

	@Column(name = "DIVIDE_ORDER_FEE", precision = 10)
	public Double getDivideOrderFee() {
		return this.divideOrderFee;
	}

	public void setDivideOrderFee(Double divideOrderFee) {
		this.divideOrderFee = divideOrderFee;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "END_TIME", length = 19)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "INVOICE_NO", length = 100)
	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Column(name = "IS_OVERSOLD", length = 10)
	public String getIsOversold() {
		return this.isOversold;
	}

	public void setIsOversold(String isOversold) {
		this.isOversold = isOversold;
	}

	@Column(name = "IS_WWW", length = 10)
	public String getIsWww() {
		return this.isWww;
	}

	public void setIsWww(String isWww) {
		this.isWww = isWww;
	}

	@Column(name = "LOGISTICS_COMPANY", length = 100)
	public String getLogisticsCompany() {
		return this.logisticsCompany;
	}

	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	@Column(name = "NUM")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name = "NUM_IID", length = 100)
	public String getNumIid() {
		return this.numIid;
	}

	public void setNumIid(String numIid) {
		this.numIid = numIid;
	}

	@Column(name = "OID", length = 100)
	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	@Column(name = "ORDER_FROM", length = 100)
	public String getOrderFrom() {
		return this.orderFrom;
	}

	public void setOrderFrom(String orderFrom) {
		this.orderFrom = orderFrom;
	}

	@Column(name = "PART_MJZ_DISCOUNT", precision = 10)
	public Double getPartMjzDiscount() {
		return this.partMjzDiscount;
	}

	public void setPartMjzDiscount(Double partMjzDiscount) {
		this.partMjzDiscount = partMjzDiscount;
	}

	@Column(name = "PAYMENT", precision = 10)
	public Double getPayment() {
		return this.payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	@Column(name = "PIC_PATH", length = 100)
	public String getPicPath() {
		return this.picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	@Column(name = "PRICE", precision = 10)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "REFUND_ID", length = 100)
	public String getRefundId() {
		return this.refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	@Column(name = "REFUND_STATUS", length = 100)
	public String getRefundStatus() {
		return this.refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	@Column(name = "SELLER_RATE", length = 10)
	public String getSellerRate() {
		return this.sellerRate;
	}

	public void setSellerRate(String sellerRate) {
		this.sellerRate = sellerRate;
	}

	@Column(name = "SELLER_TYPE", length = 10)
	public String getSellerType() {
		return this.sellerType;
	}

	public void setSellerType(String sellerType) {
		this.sellerType = sellerType;
	}

	@Column(name = "SHIPPING_TYPE", length = 100)
	public String getShippingType() {
		return this.shippingType;
	}

	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	@Column(name = "SKU_ID", length = 100)
	public String getSkuId() {
		return this.skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	@Column(name = "SKU_PROPERTIES_NAME", length = 100)
	public String getSkuPropertiesName() {
		return this.skuPropertiesName;
	}

	public void setSkuPropertiesName(String skuPropertiesName) {
		this.skuPropertiesName = skuPropertiesName;
	}

	@Column(name = "SNAPSHOT_URL", length = 100)
	public String getSnapshotUrl() {
		return this.snapshotUrl;
	}

	public void setSnapshotUrl(String snapshotUrl) {
		this.snapshotUrl = snapshotUrl;
	}

	@Column(name = "STATUS", length = 100)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STORE_CODE", length = 100)
	public String getStoreCode() {
		return this.storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	@Column(name = "TITLE", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "TOTAL_FEE", precision = 10)
	public Double getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}

	@Column(name = "ITEM_MEAL_NAME", length = 50)
	public String getItemMealName() {
		return this.itemMealName;
	}

	public void setItemMealName(String itemMealName) {
		this.itemMealName = itemMealName;
	}

	@Column(name = "OUTER_IID", length = 100)
	public String getOuterIid() {
		return this.outerIid;
	}

	public void setOuterIid(String outerIid) {
		this.outerIid = outerIid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TIMEOUT_ACTION_TIME", length = 19)
	public Date getTimeoutActionTime() {
		return this.timeoutActionTime;
	}

	public void setTimeoutActionTime(Date timeoutActionTime) {
		this.timeoutActionTime = timeoutActionTime;
	}

	@Column(name = "SUB_ORDER_TAX_FEE", length = 100)
	public String getSubOrderTaxFee() {
		return this.subOrderTaxFee;
	}

	public void setSubOrderTaxFee(String subOrderTaxFee) {
		this.subOrderTaxFee = subOrderTaxFee;
	}

	@Column(name = "SUB_ORDER_TAX_RATE", length = 100)
	public String getSubOrderTaxRate() {
		return this.subOrderTaxRate;
	}

	public void setSubOrderTaxRate(String subOrderTaxRate) {
		this.subOrderTaxRate = subOrderTaxRate;
	}

	@Column(name = "ITEM_MEAL_ID", length = 100)
	public String getItemMealId() {
		return this.itemMealId;
	}

	public void setItemMealId(String itemMealId) {
		this.itemMealId = itemMealId;
	}

	@Column(name = "OUTER_SKU_ID", length = 100)
	public String getOuterSkuId() {
		return this.outerSkuId;
	}

	public void setOuterSkuId(String outerSkuId) {
		this.outerSkuId = outerSkuId;
	}

	@Column(name = "IS_SERVICE_ORDER", length = 10)
	public String getIsServiceOrder() {
		return this.isServiceOrder;
	}

	public void setIsServiceOrder(String isServiceOrder) {
		this.isServiceOrder = isServiceOrder;
	}

	@Column(name = "BIND_OID", length = 100)
	public String getBindOid() {
		return this.bindOid;
	}

	public void setBindOid(String bindOid) {
		this.bindOid = bindOid;
	}

	@Column(name = "IS_DAIXIAO", length = 10)
	public String getIsDaixiao() {
		return this.isDaixiao;
	}

	public void setIsDaixiao(String isDaixiao) {
		this.isDaixiao = isDaixiao;
	}

	@Column(name = "TICKET_OUTER_ID", length = 100)
	public String getTicketOuterId() {
		return this.ticketOuterId;
	}

	public void setTicketOuterId(String ticketOuterId) {
		this.ticketOuterId = ticketOuterId;
	}

	@Column(name = "TICKET_EXPDATE_KEY", length = 100)
	public String getTicketExpdateKey() {
		return this.ticketExpdateKey;
	}

	public void setTicketExpdateKey(String ticketExpdateKey) {
		this.ticketExpdateKey = ticketExpdateKey;
	}

	@Column(name = "TMSER_SPU_CODE", length = 100)
	public String getTmserSpuCode() {
		return this.tmserSpuCode;
	}

	public void setTmserSpuCode(String tmserSpuCode) {
		this.tmserSpuCode = tmserSpuCode;
	}

	@Column(name = "MATNR", length = 100)
	public String getMatnr() {
		return this.matnr;
	}

	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}

	@Column(name = "ITEM_MEMO", length = 100)
	public String getItemMemo() {
		return this.itemMemo;
	}

	public void setItemMemo(String itemMemo) {
		this.itemMemo = itemMemo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ET_SER_TIME", length = 19)
	public Date getEtSerTime() {
		return this.etSerTime;
	}

	public void setEtSerTime(Date etSerTime) {
		this.etSerTime = etSerTime;
	}

	@Column(name = "ET_SHOP_NAME", length = 100)
	public String getEtShopName() {
		return this.etShopName;
	}

	public void setEtShopName(String etShopName) {
		this.etShopName = etShopName;
	}

	@Column(name = "ET_VERIFIED_SHOP_NAME", length = 100)
	public String getEtVerifiedShopName() {
		return this.etVerifiedShopName;
	}

	public void setEtVerifiedShopName(String etVerifiedShopName) {
		this.etVerifiedShopName = etVerifiedShopName;
	}

	@Column(name = "ET_PLATE_NUMBER", length = 100)
	public String getEtPlateNumber() {
		return this.etPlateNumber;
	}

	public void setEtPlateNumber(String etPlateNumber) {
		this.etPlateNumber = etPlateNumber;
	}

	@Column(name = "ESTIMATE_CON_TIME", length = 100)
	public String getEstimateConTime() {
		return this.estimateConTime;
	}

	public void setEstimateConTime(String estimateConTime) {
		this.estimateConTime = estimateConTime;
	}

	@Column(name = "BIND_OIDS", length = 200)
	public String getBindOids() {
		return this.bindOids;
	}

	public void setBindOids(String bindOids) {
		this.bindOids = bindOids;
	}

	@Column(name = "ZHENGJI_STATUS", length = 10)
	public String getZhengjiStatus() {
		return this.zhengjiStatus;
	}

	public void setZhengjiStatus(String zhengjiStatus) {
		this.zhengjiStatus = zhengjiStatus;
	}

}