package com.basic.core.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * JstRefund entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jst_refund")
public class JstRefund implements java.io.Serializable {

	// Fields

	private Integer jstRefundSysId;
	private String advanceStatus;
	private String alipayNo;
	private String attribute;
	private String buyerNick;
	private Date created;
	private String csStatus;
	private String desc;
	private String goodStatus;
	private String hasGoodReturn;
	private Date modified;
	private Integer num;
	private String numIid;
	private String oid;
	private String operationContraint;
	private String orderStatus;
	private String outerId;
	private Double payment;
	private Double price;
	private String reason;
	private Double refundFee;
	private String refundId;
	private String refundPhase;
	private String refundVersion;
	private String sellerNick;
	private String sku;
	private String status;
	private String tid;
	private String title;
	private Double totalFee;
	private String shippingType;
	private Double splitTaobaoFee;
	private Double splitSellerFee;
	private Date goodReturnTime;
	private String companyName;
	private String sid;
	private String address;
	private String storeId;
	private Date recordCreate;

	// Constructors

	/** default constructor */
	public JstRefund() {
	}

	/** full constructor */
	public JstRefund(String advanceStatus, String alipayNo, String attribute,
			String buyerNick, Date created, String csStatus, String desc,
			String goodStatus, String hasGoodReturn, Date modified,
			Integer num, String numIid, String oid, String operationContraint,
			String orderStatus, String outerId, Double payment, Double price,
			String reason, Double refundFee, String refundId,
			String refundPhase, String refundVersion, String sellerNick,
			String sku, String status, String tid, String title,
			Double totalFee, String shippingType, Double splitTaobaoFee,
			Double splitSellerFee, Date goodReturnTime, String companyName,
			String sid, String address, String storeId, Date recordCreate) {
		this.advanceStatus = advanceStatus;
		this.alipayNo = alipayNo;
		this.attribute = attribute;
		this.buyerNick = buyerNick;
		this.created = created;
		this.csStatus = csStatus;
		this.desc = desc;
		this.goodStatus = goodStatus;
		this.hasGoodReturn = hasGoodReturn;
		this.modified = modified;
		this.num = num;
		this.numIid = numIid;
		this.oid = oid;
		this.operationContraint = operationContraint;
		this.orderStatus = orderStatus;
		this.outerId = outerId;
		this.payment = payment;
		this.price = price;
		this.reason = reason;
		this.refundFee = refundFee;
		this.refundId = refundId;
		this.refundPhase = refundPhase;
		this.refundVersion = refundVersion;
		this.sellerNick = sellerNick;
		this.sku = sku;
		this.status = status;
		this.tid = tid;
		this.title = title;
		this.totalFee = totalFee;
		this.shippingType = shippingType;
		this.splitTaobaoFee = splitTaobaoFee;
		this.splitSellerFee = splitSellerFee;
		this.goodReturnTime = goodReturnTime;
		this.companyName = companyName;
		this.sid = sid;
		this.address = address;
		this.storeId = storeId;
		this.recordCreate = recordCreate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "JST_REFUND_SYS_ID", unique = true, nullable = false)
	public Integer getJstRefundSysId() {
		return this.jstRefundSysId;
	}

	public void setJstRefundSysId(Integer jstRefundSysId) {
		this.jstRefundSysId = jstRefundSysId;
	}

	@Column(name = "ADVANCE_STATUS", length = 10)
	public String getAdvanceStatus() {
		return this.advanceStatus;
	}

	public void setAdvanceStatus(String advanceStatus) {
		this.advanceStatus = advanceStatus;
	}

	@Column(name = "ALIPAY_NO", length = 100)
	public String getAlipayNo() {
		return this.alipayNo;
	}

	public void setAlipayNo(String alipayNo) {
		this.alipayNo = alipayNo;
	}

	@Column(name = "ATTRIBUTE", length = 1000)
	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	@Column(name = "BUYER_NICK", length = 100)
	public String getBuyerNick() {
		return this.buyerNick;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED", length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "CS_STATUS", length = 10)
	public String getCsStatus() {
		return this.csStatus;
	}

	public void setCsStatus(String csStatus) {
		this.csStatus = csStatus;
	}

	@Column(name = "DESC", length = 10)
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "GOOD_STATUS", length = 100)
	public String getGoodStatus() {
		return this.goodStatus;
	}

	public void setGoodStatus(String goodStatus) {
		this.goodStatus = goodStatus;
	}

	@Column(name = "HAS_GOOD_RETURN", length = 10)
	public String getHasGoodReturn() {
		return this.hasGoodReturn;
	}

	public void setHasGoodReturn(String hasGoodReturn) {
		this.hasGoodReturn = hasGoodReturn;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIED", length = 19)
	public Date getModified() {
		return this.modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
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

	@Column(name = "OPERATION_CONTRAINT", length = 100)
	public String getOperationContraint() {
		return this.operationContraint;
	}

	public void setOperationContraint(String operationContraint) {
		this.operationContraint = operationContraint;
	}

	@Column(name = "ORDER_STATUS", length = 100)
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "OUTER_ID", length = 100)
	public String getOuterId() {
		return this.outerId;
	}

	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

	@Column(name = "PAYMENT", precision = 10)
	public Double getPayment() {
		return this.payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	@Column(name = "PRICE", precision = 10)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "REASON", length = 200)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "REFUND_FEE", precision = 10)
	public Double getRefundFee() {
		return this.refundFee;
	}

	public void setRefundFee(Double refundFee) {
		this.refundFee = refundFee;
	}

	@Column(name = "REFUND_ID", length = 100)
	public String getRefundId() {
		return this.refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	@Column(name = "REFUND_PHASE", length = 10)
	public String getRefundPhase() {
		return this.refundPhase;
	}

	public void setRefundPhase(String refundPhase) {
		this.refundPhase = refundPhase;
	}

	@Column(name = "REFUND_VERSION", length = 100)
	public String getRefundVersion() {
		return this.refundVersion;
	}

	public void setRefundVersion(String refundVersion) {
		this.refundVersion = refundVersion;
	}

	@Column(name = "SELLER_NICK", length = 100)
	public String getSellerNick() {
		return this.sellerNick;
	}

	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}

	@Column(name = "SKU", length = 100)
	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Column(name = "STATUS", length = 100)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "TID", length = 100)
	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
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

	@Column(name = "SHIPPING_TYPE", length = 100)
	public String getShippingType() {
		return this.shippingType;
	}

	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	@Column(name = "SPLIT_TAOBAO_FEE", precision = 10)
	public Double getSplitTaobaoFee() {
		return this.splitTaobaoFee;
	}

	public void setSplitTaobaoFee(Double splitTaobaoFee) {
		this.splitTaobaoFee = splitTaobaoFee;
	}

	@Column(name = "SPLIT_SELLER_FEE", precision = 10)
	public Double getSplitSellerFee() {
		return this.splitSellerFee;
	}

	public void setSplitSellerFee(Double splitSellerFee) {
		this.splitSellerFee = splitSellerFee;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "GOOD_RETURN_TIME", length = 19)
	public Date getGoodReturnTime() {
		return this.goodReturnTime;
	}

	public void setGoodReturnTime(Date goodReturnTime) {
		this.goodReturnTime = goodReturnTime;
	}

	@Column(name = "COMPANY_NAME", length = 100)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "SID", length = 100)
	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Column(name = "ADDRESS", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "STORE_ID", length = 100)
	public String getStoreId() {
		return this.storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RECORD_CREATE", length = 19)
	public Date getRecordCreate() {
		return this.recordCreate;
	}

	public void setRecordCreate(Date recordCreate) {
		this.recordCreate = recordCreate;
	}

}