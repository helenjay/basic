package com.basic.core.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * JstTrade entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jst_trade")
public class JstTrade implements java.io.Serializable {

	// Fields

	private Integer jstTradeSysId;
	private Double adjustFee;
	private String alipayId;
	private String alipayNo;
	private Integer alipayPoint;
	private Double availableConfirmFee;
	private String buyerAlipayNo;
	private String buyerArea;
	private Double buyerCodFee;
	private String buyerEmail;
	private String buyerNick;
	private Integer buyerObtainPointFee;
	private String buyerRate;
	private Double codFee;
	private String codStatus;
	private Double commissionFee;
	private Date consignTime;
	private Date created;
	private Double creditCardFee;
	private Double discountFee;
	private Date endTime;
	private String hasPostFee;
	private String invoiceName;
	private String is3d;
	private String isBrandSale;
	private String isDaixiao;
	private String isForceWlb;
	private String isLgtype;
	private String isPartConsign;
	private String isWt;
	private Date modified;
	private Integer num;
	private String numIid;
	private Date payTime;
	private Double payment;
	private Integer pccAf;
	private String picPath;
	private Integer pointFee;
	private Double postFee;
	private Double price;
	private Integer realPointFee;
	private Double receivedPayment;
	private String receiverAddress;
	private String receiverCity;
	private String receiverDistrict;
	private String receiverMobile;
	private String receiverName;
	private String receiverState;
	private String receiverZip;
	private String sellerAlipayNo;
	private String sellerCanRate;
	private Double sellerCodFee;
	private String sellerEmail;
	private String sellerFlag;
	private String sellerMemo;
	private String sellerMobile;
	private String sellerName;
	private String sellerNick;
	private String sellerPhone;
	private String sellerRate;
	private String shippingType;
	private String snapshotUrl;
	private String status;
	private Double stepPaidFee;
	private String stepTradeStatus;
	private String tid;
	private String title;
	private Double totalFee;
	private String tradeFrom;
	private String type;
	private String storeId;
	private String receiverPhone;
	private Date estConTime;
	private String invoiceKind;
	private String receiverCountry;
	private String receiverTown;
	private Double orderTaxFee;
	private String buyerMessage;
	private String buyerMemo;
	private Integer buyerFlag;
	private String invoiceType;
	private String markDesc;
	private String shopCode;
	private Date timeoutActionTime;
	private String promotion;
	private Date etSerTime;
	private String etShopName;
	private String etVerifiedShopName;
	private String etPlateNumber;
	private Double paidCouponFee;
	private String sid;
	private String buyerIp;
	private String hasYfx;
	private Double yfxFee;
	private String yfxId;
	private String yfxType;
	private String eticketExt;
	private Date sendTime;
	private Double expressAgencyFee;
	private String canRate;
	private String acookieId;
	private String tradeMemo;
	private String tradeSource;
	private Integer arriveInterval;
	private String arriveCutTime;
	private Integer consignInterval;
	private String o2o;
	private String o2oGuideId;
	private String o2oShopId;
	private String o2oGuideName;
	private String o2oShopName;
	private String o2oDelivery;
	private String zeroPurchase;
	private String o2oOutTradeId;
	private String hkEnName;
	private String hkFlightNo;
	private String hkChinaName;
	private String hkCardCode;
	private String hkCardType;
	private String hkFlightDate;
	private String hkGender;
	private String hkBirthday;
	private String hkPickup;
	private String hkPickupId;
	private String eticketServiceAddr;
	private String isShShip;
	private String o2oSnatchStatus;
	private String market;
	private String etType;
	private String etShopId;
	private String obs;
	private Set<JstPromotionDetail> jstPromotionDetails = new HashSet<JstPromotionDetail>(
			0);
	private Set<JstOrder> jstOrders = new HashSet<JstOrder>(0);

	// Constructors

	/** default constructor */
	public JstTrade() {
	}

	/** full constructor */
	public JstTrade(Double adjustFee, String alipayId, String alipayNo,
			Integer alipayPoint, Double availableConfirmFee,
			String buyerAlipayNo, String buyerArea, Double buyerCodFee,
			String buyerEmail, String buyerNick, Integer buyerObtainPointFee,
			String buyerRate, Double codFee, String codStatus,
			Double commissionFee, Date consignTime, Date created,
			Double creditCardFee, Double discountFee, Date endTime,
			String hasPostFee, String invoiceName, String is3d,
			String isBrandSale, String isDaixiao, String isForceWlb,
			String isLgtype, String isPartConsign, String isWt, Date modified,
			Integer num, String numIid, Date payTime, Double payment,
			Integer pccAf, String picPath, Integer pointFee, Double postFee,
			Double price, Integer realPointFee, Double receivedPayment,
			String receiverAddress, String receiverCity,
			String receiverDistrict, String receiverMobile,
			String receiverName, String receiverState, String receiverZip,
			String sellerAlipayNo, String sellerCanRate, Double sellerCodFee,
			String sellerEmail, String sellerFlag, String sellerMemo,
			String sellerMobile, String sellerName, String sellerNick,
			String sellerPhone, String sellerRate, String shippingType,
			String snapshotUrl, String status, Double stepPaidFee,
			String stepTradeStatus, String tid, String title, Double totalFee,
			String tradeFrom, String type, String storeId,
			String receiverPhone, Date estConTime, String invoiceKind,
			String receiverCountry, String receiverTown, Double orderTaxFee,
			String buyerMessage, String buyerMemo, Integer buyerFlag,
			String invoiceType, String markDesc, String shopCode,
			Date timeoutActionTime, String promotion, Date etSerTime,
			String etShopName, String etVerifiedShopName, String etPlateNumber,
			Double paidCouponFee, String sid, String buyerIp, String hasYfx,
			Double yfxFee, String yfxId, String yfxType, String eticketExt,
			Date sendTime, Double expressAgencyFee, String canRate,
			String acookieId, String tradeMemo, String tradeSource,
			Integer arriveInterval, String arriveCutTime,
			Integer consignInterval, String o2o, String o2oGuideId,
			String o2oShopId, String o2oGuideName, String o2oShopName,
			String o2oDelivery, String zeroPurchase, String o2oOutTradeId,
			String hkEnName, String hkFlightNo, String hkChinaName,
			String hkCardCode, String hkCardType, String hkFlightDate,
			String hkGender, String hkBirthday, String hkPickup,
			String hkPickupId, String eticketServiceAddr, String isShShip,
			String o2oSnatchStatus, String market, String etType,
			String etShopId, String obs,
			Set<JstPromotionDetail> jstPromotionDetails, Set<JstOrder> jstOrders) {
		this.adjustFee = adjustFee;
		this.alipayId = alipayId;
		this.alipayNo = alipayNo;
		this.alipayPoint = alipayPoint;
		this.availableConfirmFee = availableConfirmFee;
		this.buyerAlipayNo = buyerAlipayNo;
		this.buyerArea = buyerArea;
		this.buyerCodFee = buyerCodFee;
		this.buyerEmail = buyerEmail;
		this.buyerNick = buyerNick;
		this.buyerObtainPointFee = buyerObtainPointFee;
		this.buyerRate = buyerRate;
		this.codFee = codFee;
		this.codStatus = codStatus;
		this.commissionFee = commissionFee;
		this.consignTime = consignTime;
		this.created = created;
		this.creditCardFee = creditCardFee;
		this.discountFee = discountFee;
		this.endTime = endTime;
		this.hasPostFee = hasPostFee;
		this.invoiceName = invoiceName;
		this.is3d = is3d;
		this.isBrandSale = isBrandSale;
		this.isDaixiao = isDaixiao;
		this.isForceWlb = isForceWlb;
		this.isLgtype = isLgtype;
		this.isPartConsign = isPartConsign;
		this.isWt = isWt;
		this.modified = modified;
		this.num = num;
		this.numIid = numIid;
		this.payTime = payTime;
		this.payment = payment;
		this.pccAf = pccAf;
		this.picPath = picPath;
		this.pointFee = pointFee;
		this.postFee = postFee;
		this.price = price;
		this.realPointFee = realPointFee;
		this.receivedPayment = receivedPayment;
		this.receiverAddress = receiverAddress;
		this.receiverCity = receiverCity;
		this.receiverDistrict = receiverDistrict;
		this.receiverMobile = receiverMobile;
		this.receiverName = receiverName;
		this.receiverState = receiverState;
		this.receiverZip = receiverZip;
		this.sellerAlipayNo = sellerAlipayNo;
		this.sellerCanRate = sellerCanRate;
		this.sellerCodFee = sellerCodFee;
		this.sellerEmail = sellerEmail;
		this.sellerFlag = sellerFlag;
		this.sellerMemo = sellerMemo;
		this.sellerMobile = sellerMobile;
		this.sellerName = sellerName;
		this.sellerNick = sellerNick;
		this.sellerPhone = sellerPhone;
		this.sellerRate = sellerRate;
		this.shippingType = shippingType;
		this.snapshotUrl = snapshotUrl;
		this.status = status;
		this.stepPaidFee = stepPaidFee;
		this.stepTradeStatus = stepTradeStatus;
		this.tid = tid;
		this.title = title;
		this.totalFee = totalFee;
		this.tradeFrom = tradeFrom;
		this.type = type;
		this.storeId = storeId;
		this.receiverPhone = receiverPhone;
		this.estConTime = estConTime;
		this.invoiceKind = invoiceKind;
		this.receiverCountry = receiverCountry;
		this.receiverTown = receiverTown;
		this.orderTaxFee = orderTaxFee;
		this.buyerMessage = buyerMessage;
		this.buyerMemo = buyerMemo;
		this.buyerFlag = buyerFlag;
		this.invoiceType = invoiceType;
		this.markDesc = markDesc;
		this.shopCode = shopCode;
		this.timeoutActionTime = timeoutActionTime;
		this.promotion = promotion;
		this.etSerTime = etSerTime;
		this.etShopName = etShopName;
		this.etVerifiedShopName = etVerifiedShopName;
		this.etPlateNumber = etPlateNumber;
		this.paidCouponFee = paidCouponFee;
		this.sid = sid;
		this.buyerIp = buyerIp;
		this.hasYfx = hasYfx;
		this.yfxFee = yfxFee;
		this.yfxId = yfxId;
		this.yfxType = yfxType;
		this.eticketExt = eticketExt;
		this.sendTime = sendTime;
		this.expressAgencyFee = expressAgencyFee;
		this.canRate = canRate;
		this.acookieId = acookieId;
		this.tradeMemo = tradeMemo;
		this.tradeSource = tradeSource;
		this.arriveInterval = arriveInterval;
		this.arriveCutTime = arriveCutTime;
		this.consignInterval = consignInterval;
		this.o2o = o2o;
		this.o2oGuideId = o2oGuideId;
		this.o2oShopId = o2oShopId;
		this.o2oGuideName = o2oGuideName;
		this.o2oShopName = o2oShopName;
		this.o2oDelivery = o2oDelivery;
		this.zeroPurchase = zeroPurchase;
		this.o2oOutTradeId = o2oOutTradeId;
		this.hkEnName = hkEnName;
		this.hkFlightNo = hkFlightNo;
		this.hkChinaName = hkChinaName;
		this.hkCardCode = hkCardCode;
		this.hkCardType = hkCardType;
		this.hkFlightDate = hkFlightDate;
		this.hkGender = hkGender;
		this.hkBirthday = hkBirthday;
		this.hkPickup = hkPickup;
		this.hkPickupId = hkPickupId;
		this.eticketServiceAddr = eticketServiceAddr;
		this.isShShip = isShShip;
		this.o2oSnatchStatus = o2oSnatchStatus;
		this.market = market;
		this.etType = etType;
		this.etShopId = etShopId;
		this.obs = obs;
		this.jstPromotionDetails = jstPromotionDetails;
		this.jstOrders = jstOrders;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "JST_TRADE_SYS_ID", unique = true, nullable = false)
	public Integer getJstTradeSysId() {
		return this.jstTradeSysId;
	}

	public void setJstTradeSysId(Integer jstTradeSysId) {
		this.jstTradeSysId = jstTradeSysId;
	}

	@Column(name = "ADJUST_FEE", precision = 10)
	public Double getAdjustFee() {
		return this.adjustFee;
	}

	public void setAdjustFee(Double adjustFee) {
		this.adjustFee = adjustFee;
	}

	@Column(name = "ALIPAY_ID", length = 200)
	public String getAlipayId() {
		return this.alipayId;
	}

	public void setAlipayId(String alipayId) {
		this.alipayId = alipayId;
	}

	@Column(name = "ALIPAY_NO", length = 200)
	public String getAlipayNo() {
		return this.alipayNo;
	}

	public void setAlipayNo(String alipayNo) {
		this.alipayNo = alipayNo;
	}

	@Column(name = "ALIPAY_POINT")
	public Integer getAlipayPoint() {
		return this.alipayPoint;
	}

	public void setAlipayPoint(Integer alipayPoint) {
		this.alipayPoint = alipayPoint;
	}

	@Column(name = "AVAILABLE_CONFIRM_FEE", precision = 10)
	public Double getAvailableConfirmFee() {
		return this.availableConfirmFee;
	}

	public void setAvailableConfirmFee(Double availableConfirmFee) {
		this.availableConfirmFee = availableConfirmFee;
	}

	@Column(name = "BUYER_ALIPAY_NO", length = 200)
	public String getBuyerAlipayNo() {
		return this.buyerAlipayNo;
	}

	public void setBuyerAlipayNo(String buyerAlipayNo) {
		this.buyerAlipayNo = buyerAlipayNo;
	}

	@Column(name = "BUYER_AREA", length = 200)
	public String getBuyerArea() {
		return this.buyerArea;
	}

	public void setBuyerArea(String buyerArea) {
		this.buyerArea = buyerArea;
	}

	@Column(name = "BUYER_COD_FEE", precision = 10)
	public Double getBuyerCodFee() {
		return this.buyerCodFee;
	}

	public void setBuyerCodFee(Double buyerCodFee) {
		this.buyerCodFee = buyerCodFee;
	}

	@Column(name = "BUYER_EMAIL", length = 200)
	public String getBuyerEmail() {
		return this.buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	@Column(name = "BUYER_NICK", length = 200)
	public String getBuyerNick() {
		return this.buyerNick;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	@Column(name = "BUYER_OBTAIN_POINT_FEE")
	public Integer getBuyerObtainPointFee() {
		return this.buyerObtainPointFee;
	}

	public void setBuyerObtainPointFee(Integer buyerObtainPointFee) {
		this.buyerObtainPointFee = buyerObtainPointFee;
	}

	@Column(name = "BUYER_RATE", length = 10)
	public String getBuyerRate() {
		return this.buyerRate;
	}

	public void setBuyerRate(String buyerRate) {
		this.buyerRate = buyerRate;
	}

	@Column(name = "COD_FEE", precision = 10)
	public Double getCodFee() {
		return this.codFee;
	}

	public void setCodFee(Double codFee) {
		this.codFee = codFee;
	}

	@Column(name = "COD_STATUS", length = 200)
	public String getCodStatus() {
		return this.codStatus;
	}

	public void setCodStatus(String codStatus) {
		this.codStatus = codStatus;
	}

	@Column(name = "COMMISSION_FEE", precision = 10)
	public Double getCommissionFee() {
		return this.commissionFee;
	}

	public void setCommissionFee(Double commissionFee) {
		this.commissionFee = commissionFee;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONSIGN_TIME", length = 19)
	public Date getConsignTime() {
		return this.consignTime;
	}

	public void setConsignTime(Date consignTime) {
		this.consignTime = consignTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED", length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "CREDIT_CARD_FEE", precision = 10)
	public Double getCreditCardFee() {
		return this.creditCardFee;
	}

	public void setCreditCardFee(Double creditCardFee) {
		this.creditCardFee = creditCardFee;
	}

	@Column(name = "DISCOUNT_FEE", precision = 10)
	public Double getDiscountFee() {
		return this.discountFee;
	}

	public void setDiscountFee(Double discountFee) {
		this.discountFee = discountFee;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "END_TIME", length = 19)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "HAS_POST_FEE", length = 10)
	public String getHasPostFee() {
		return this.hasPostFee;
	}

	public void setHasPostFee(String hasPostFee) {
		this.hasPostFee = hasPostFee;
	}

	@Column(name = "INVOICE_NAME", length = 200)
	public String getInvoiceName() {
		return this.invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	@Column(name = "IS_3D", length = 10)
	public String getIs3d() {
		return this.is3d;
	}

	public void setIs3d(String is3d) {
		this.is3d = is3d;
	}

	@Column(name = "IS_BRAND_SALE", length = 10)
	public String getIsBrandSale() {
		return this.isBrandSale;
	}

	public void setIsBrandSale(String isBrandSale) {
		this.isBrandSale = isBrandSale;
	}

	@Column(name = "IS_DAIXIAO", length = 10)
	public String getIsDaixiao() {
		return this.isDaixiao;
	}

	public void setIsDaixiao(String isDaixiao) {
		this.isDaixiao = isDaixiao;
	}

	@Column(name = "IS_FORCE_WLB", length = 10)
	public String getIsForceWlb() {
		return this.isForceWlb;
	}

	public void setIsForceWlb(String isForceWlb) {
		this.isForceWlb = isForceWlb;
	}

	@Column(name = "IS_LGTYPE", length = 10)
	public String getIsLgtype() {
		return this.isLgtype;
	}

	public void setIsLgtype(String isLgtype) {
		this.isLgtype = isLgtype;
	}

	@Column(name = "IS_PART_CONSIGN", length = 10)
	public String getIsPartConsign() {
		return this.isPartConsign;
	}

	public void setIsPartConsign(String isPartConsign) {
		this.isPartConsign = isPartConsign;
	}

	@Column(name = "IS_WT", length = 10)
	public String getIsWt() {
		return this.isWt;
	}

	public void setIsWt(String isWt) {
		this.isWt = isWt;
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

	@Column(name = "NUM_IID", length = 200)
	public String getNumIid() {
		return this.numIid;
	}

	public void setNumIid(String numIid) {
		this.numIid = numIid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PAY_TIME", length = 19)
	public Date getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	@Column(name = "PAYMENT", precision = 10)
	public Double getPayment() {
		return this.payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	@Column(name = "PCC_AF")
	public Integer getPccAf() {
		return this.pccAf;
	}

	public void setPccAf(Integer pccAf) {
		this.pccAf = pccAf;
	}

	@Column(name = "PIC_PATH", length = 200)
	public String getPicPath() {
		return this.picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	@Column(name = "POINT_FEE", precision = 10)
	public Integer getPointFee() {
		return this.pointFee;
	}

	public void setPointFee(Integer pointFee) {
		this.pointFee = pointFee;
	}

	@Column(name = "POST_FEE", precision = 10)
	public Double getPostFee() {
		return this.postFee;
	}

	public void setPostFee(Double postFee) {
		this.postFee = postFee;
	}

	@Column(name = "PRICE", precision = 10)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "REAL_POINT_FEE")
	public Integer getRealPointFee() {
		return this.realPointFee;
	}

	public void setRealPointFee(Integer realPointFee) {
		this.realPointFee = realPointFee;
	}

	@Column(name = "RECEIVED_PAYMENT", precision = 10)
	public Double getReceivedPayment() {
		return this.receivedPayment;
	}

	public void setReceivedPayment(Double receivedPayment) {
		this.receivedPayment = receivedPayment;
	}

	@Column(name = "RECEIVER_ADDRESS", length = 200)
	public String getReceiverAddress() {
		return this.receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	@Column(name = "RECEIVER_CITY", length = 200)
	public String getReceiverCity() {
		return this.receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	@Column(name = "RECEIVER_DISTRICT", length = 200)
	public String getReceiverDistrict() {
		return this.receiverDistrict;
	}

	public void setReceiverDistrict(String receiverDistrict) {
		this.receiverDistrict = receiverDistrict;
	}

	@Column(name = "RECEIVER_MOBILE", length = 200)
	public String getReceiverMobile() {
		return this.receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	@Column(name = "RECEIVER_NAME", length = 200)
	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	@Column(name = "RECEIVER_STATE", length = 200)
	public String getReceiverState() {
		return this.receiverState;
	}

	public void setReceiverState(String receiverState) {
		this.receiverState = receiverState;
	}

	@Column(name = "RECEIVER_ZIP", length = 200)
	public String getReceiverZip() {
		return this.receiverZip;
	}

	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}

	@Column(name = "SELLER_ALIPAY_NO", length = 200)
	public String getSellerAlipayNo() {
		return this.sellerAlipayNo;
	}

	public void setSellerAlipayNo(String sellerAlipayNo) {
		this.sellerAlipayNo = sellerAlipayNo;
	}

	@Column(name = "SELLER_CAN_RATE", length = 10)
	public String getSellerCanRate() {
		return this.sellerCanRate;
	}

	public void setSellerCanRate(String sellerCanRate) {
		this.sellerCanRate = sellerCanRate;
	}

	@Column(name = "SELLER_COD_FEE", precision = 10)
	public Double getSellerCodFee() {
		return this.sellerCodFee;
	}

	public void setSellerCodFee(Double sellerCodFee) {
		this.sellerCodFee = sellerCodFee;
	}

	@Column(name = "SELLER_EMAIL", length = 200)
	public String getSellerEmail() {
		return this.sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	@Column(name = "SELLER_FLAG", length = 200)
	public String getSellerFlag() {
		return this.sellerFlag;
	}

	public void setSellerFlag(String sellerFlag) {
		this.sellerFlag = sellerFlag;
	}

	@Column(name = "SELLER_MEMO", length = 1000)
	public String getSellerMemo() {
		return this.sellerMemo;
	}

	public void setSellerMemo(String sellerMemo) {
		this.sellerMemo = sellerMemo;
	}

	@Column(name = "SELLER_MOBILE", length = 200)
	public String getSellerMobile() {
		return this.sellerMobile;
	}

	public void setSellerMobile(String sellerMobile) {
		this.sellerMobile = sellerMobile;
	}

	@Column(name = "SELLER_NAME", length = 200)
	public String getSellerName() {
		return this.sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	@Column(name = "SELLER_NICK", length = 200)
	public String getSellerNick() {
		return this.sellerNick;
	}

	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}

	@Column(name = "SELLER_PHONE", length = 200)
	public String getSellerPhone() {
		return this.sellerPhone;
	}

	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	@Column(name = "SELLER_RATE", length = 200)
	public String getSellerRate() {
		return this.sellerRate;
	}

	public void setSellerRate(String sellerRate) {
		this.sellerRate = sellerRate;
	}

	@Column(name = "SHIPPING_TYPE", length = 200)
	public String getShippingType() {
		return this.shippingType;
	}

	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	@Column(name = "SNAPSHOT_URL", length = 200)
	public String getSnapshotUrl() {
		return this.snapshotUrl;
	}

	public void setSnapshotUrl(String snapshotUrl) {
		this.snapshotUrl = snapshotUrl;
	}

	@Column(name = "STATUS", length = 200)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STEP_PAID_FEE", precision = 10)
	public Double getStepPaidFee() {
		return this.stepPaidFee;
	}

	public void setStepPaidFee(Double stepPaidFee) {
		this.stepPaidFee = stepPaidFee;
	}

	@Column(name = "STEP_TRADE_STATUS", length = 200)
	public String getStepTradeStatus() {
		return this.stepTradeStatus;
	}

	public void setStepTradeStatus(String stepTradeStatus) {
		this.stepTradeStatus = stepTradeStatus;
	}

	@Column(name = "TID", length = 200)
	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	@Column(name = "TITLE", length = 200)
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

	@Column(name = "TRADE_FROM", length = 200)
	public String getTradeFrom() {
		return this.tradeFrom;
	}

	public void setTradeFrom(String tradeFrom) {
		this.tradeFrom = tradeFrom;
	}

	@Column(name = "TYPE", length = 200)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "STORE_ID", length = 100)
	public String getStoreId() {
		return this.storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	@Column(name = "RECEIVER_PHONE", length = 200)
	public String getReceiverPhone() {
		return this.receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EST_CON_TIME", length = 19)
	public Date getEstConTime() {
		return this.estConTime;
	}

	public void setEstConTime(Date estConTime) {
		this.estConTime = estConTime;
	}

	@Column(name = "INVOICE_KIND", length = 10)
	public String getInvoiceKind() {
		return this.invoiceKind;
	}

	public void setInvoiceKind(String invoiceKind) {
		this.invoiceKind = invoiceKind;
	}

	@Column(name = "RECEIVER_COUNTRY", length = 200)
	public String getReceiverCountry() {
		return this.receiverCountry;
	}

	public void setReceiverCountry(String receiverCountry) {
		this.receiverCountry = receiverCountry;
	}

	@Column(name = "RECEIVER_TOWN", length = 200)
	public String getReceiverTown() {
		return this.receiverTown;
	}

	public void setReceiverTown(String receiverTown) {
		this.receiverTown = receiverTown;
	}

	@Column(name = "ORDER_TAX_FEE", precision = 10)
	public Double getOrderTaxFee() {
		return this.orderTaxFee;
	}

	public void setOrderTaxFee(Double orderTaxFee) {
		this.orderTaxFee = orderTaxFee;
	}

	@Column(name = "BUYER_MESSAGE", length = 500)
	public String getBuyerMessage() {
		return this.buyerMessage;
	}

	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage;
	}

	@Column(name = "BUYER_MEMO", length = 500)
	public String getBuyerMemo() {
		return this.buyerMemo;
	}

	public void setBuyerMemo(String buyerMemo) {
		this.buyerMemo = buyerMemo;
	}

	@Column(name = "BUYER_FLAG")
	public Integer getBuyerFlag() {
		return this.buyerFlag;
	}

	public void setBuyerFlag(Integer buyerFlag) {
		this.buyerFlag = buyerFlag;
	}

	@Column(name = "INVOICE_TYPE", length = 200)
	public String getInvoiceType() {
		return this.invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	@Column(name = "MARK_DESC", length = 200)
	public String getMarkDesc() {
		return this.markDesc;
	}

	public void setMarkDesc(String markDesc) {
		this.markDesc = markDesc;
	}

	@Column(name = "SHOP_CODE", length = 200)
	public String getShopCode() {
		return this.shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TIMEOUT_ACTION_TIME", length = 19)
	public Date getTimeoutActionTime() {
		return this.timeoutActionTime;
	}

	public void setTimeoutActionTime(Date timeoutActionTime) {
		this.timeoutActionTime = timeoutActionTime;
	}

	@Column(name = "PROMOTION", length = 200)
	public String getPromotion() {
		return this.promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ET_SER_TIME", length = 19)
	public Date getEtSerTime() {
		return this.etSerTime;
	}

	public void setEtSerTime(Date etSerTime) {
		this.etSerTime = etSerTime;
	}

	@Column(name = "ET_SHOP_NAME", length = 200)
	public String getEtShopName() {
		return this.etShopName;
	}

	public void setEtShopName(String etShopName) {
		this.etShopName = etShopName;
	}

	@Column(name = "ET_VERIFIED_SHOP_NAME", length = 200)
	public String getEtVerifiedShopName() {
		return this.etVerifiedShopName;
	}

	public void setEtVerifiedShopName(String etVerifiedShopName) {
		this.etVerifiedShopName = etVerifiedShopName;
	}

	@Column(name = "ET_PLATE_NUMBER", length = 200)
	public String getEtPlateNumber() {
		return this.etPlateNumber;
	}

	public void setEtPlateNumber(String etPlateNumber) {
		this.etPlateNumber = etPlateNumber;
	}

	@Column(name = "PAID_COUPON_FEE", precision = 10)
	public Double getPaidCouponFee() {
		return this.paidCouponFee;
	}

	public void setPaidCouponFee(Double paidCouponFee) {
		this.paidCouponFee = paidCouponFee;
	}

	@Column(name = "SID", length = 200)
	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Column(name = "BUYER_IP", length = 200)
	public String getBuyerIp() {
		return this.buyerIp;
	}

	public void setBuyerIp(String buyerIp) {
		this.buyerIp = buyerIp;
	}

	@Column(name = "HAS_YFX", length = 200)
	public String getHasYfx() {
		return this.hasYfx;
	}

	public void setHasYfx(String hasYfx) {
		this.hasYfx = hasYfx;
	}

	@Column(name = "YFX_FEE", precision = 10)
	public Double getYfxFee() {
		return this.yfxFee;
	}

	public void setYfxFee(Double yfxFee) {
		this.yfxFee = yfxFee;
	}

	@Column(name = "YFX_ID", length = 200)
	public String getYfxId() {
		return this.yfxId;
	}

	public void setYfxId(String yfxId) {
		this.yfxId = yfxId;
	}

	@Column(name = "YFX_TYPE", length = 200)
	public String getYfxType() {
		return this.yfxType;
	}

	public void setYfxType(String yfxType) {
		this.yfxType = yfxType;
	}

	@Column(name = "ETICKET_EXT", length = 200)
	public String getEticketExt() {
		return this.eticketExt;
	}

	public void setEticketExt(String eticketExt) {
		this.eticketExt = eticketExt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SEND_TIME", length = 19)
	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "EXPRESS_AGENCY_FEE", precision = 10)
	public Double getExpressAgencyFee() {
		return this.expressAgencyFee;
	}

	public void setExpressAgencyFee(Double expressAgencyFee) {
		this.expressAgencyFee = expressAgencyFee;
	}

	@Column(name = "CAN_RATE", length = 10)
	public String getCanRate() {
		return this.canRate;
	}

	public void setCanRate(String canRate) {
		this.canRate = canRate;
	}

	@Column(name = "ACOOKIE_ID", length = 200)
	public String getAcookieId() {
		return this.acookieId;
	}

	public void setAcookieId(String acookieId) {
		this.acookieId = acookieId;
	}

	@Column(name = "TRADE_MEMO", length = 200)
	public String getTradeMemo() {
		return this.tradeMemo;
	}

	public void setTradeMemo(String tradeMemo) {
		this.tradeMemo = tradeMemo;
	}

	@Column(name = "TRADE_SOURCE", length = 200)
	public String getTradeSource() {
		return this.tradeSource;
	}

	public void setTradeSource(String tradeSource) {
		this.tradeSource = tradeSource;
	}

	@Column(name = "ARRIVE_INTERVAL")
	public Integer getArriveInterval() {
		return this.arriveInterval;
	}

	public void setArriveInterval(Integer arriveInterval) {
		this.arriveInterval = arriveInterval;
	}

	@Column(name = "ARRIVE_CUT_TIME", length = 200)
	public String getArriveCutTime() {
		return this.arriveCutTime;
	}

	public void setArriveCutTime(String arriveCutTime) {
		this.arriveCutTime = arriveCutTime;
	}

	@Column(name = "CONSIGN_INTERVAL")
	public Integer getConsignInterval() {
		return this.consignInterval;
	}

	public void setConsignInterval(Integer consignInterval) {
		this.consignInterval = consignInterval;
	}

	@Column(name = "O2O", length = 200)
	public String getO2o() {
		return this.o2o;
	}

	public void setO2o(String o2o) {
		this.o2o = o2o;
	}

	@Column(name = "O2O_GUIDE_ID", length = 200)
	public String getO2oGuideId() {
		return this.o2oGuideId;
	}

	public void setO2oGuideId(String o2oGuideId) {
		this.o2oGuideId = o2oGuideId;
	}

	@Column(name = "O2O_SHOP_ID", length = 200)
	public String getO2oShopId() {
		return this.o2oShopId;
	}

	public void setO2oShopId(String o2oShopId) {
		this.o2oShopId = o2oShopId;
	}

	@Column(name = "O2O_GUIDE_NAME", length = 200)
	public String getO2oGuideName() {
		return this.o2oGuideName;
	}

	public void setO2oGuideName(String o2oGuideName) {
		this.o2oGuideName = o2oGuideName;
	}

	@Column(name = "O2O_SHOP_NAME", length = 200)
	public String getO2oShopName() {
		return this.o2oShopName;
	}

	public void setO2oShopName(String o2oShopName) {
		this.o2oShopName = o2oShopName;
	}

	@Column(name = "O2O_DELIVERY", length = 200)
	public String getO2oDelivery() {
		return this.o2oDelivery;
	}

	public void setO2oDelivery(String o2oDelivery) {
		this.o2oDelivery = o2oDelivery;
	}

	@Column(name = "ZERO_PURCHASE", length = 10)
	public String getZeroPurchase() {
		return this.zeroPurchase;
	}

	public void setZeroPurchase(String zeroPurchase) {
		this.zeroPurchase = zeroPurchase;
	}

	@Column(name = "O2O_OUT_TRADE_ID", length = 200)
	public String getO2oOutTradeId() {
		return this.o2oOutTradeId;
	}

	public void setO2oOutTradeId(String o2oOutTradeId) {
		this.o2oOutTradeId = o2oOutTradeId;
	}

	@Column(name = "HK_EN_NAME", length = 200)
	public String getHkEnName() {
		return this.hkEnName;
	}

	public void setHkEnName(String hkEnName) {
		this.hkEnName = hkEnName;
	}

	@Column(name = "HK_FLIGHT_NO", length = 200)
	public String getHkFlightNo() {
		return this.hkFlightNo;
	}

	public void setHkFlightNo(String hkFlightNo) {
		this.hkFlightNo = hkFlightNo;
	}

	@Column(name = "HK_CHINA_NAME", length = 200)
	public String getHkChinaName() {
		return this.hkChinaName;
	}

	public void setHkChinaName(String hkChinaName) {
		this.hkChinaName = hkChinaName;
	}

	@Column(name = "HK_CARD_CODE", length = 200)
	public String getHkCardCode() {
		return this.hkCardCode;
	}

	public void setHkCardCode(String hkCardCode) {
		this.hkCardCode = hkCardCode;
	}

	@Column(name = "HK_CARD_TYPE", length = 200)
	public String getHkCardType() {
		return this.hkCardType;
	}

	public void setHkCardType(String hkCardType) {
		this.hkCardType = hkCardType;
	}

	@Column(name = "HK_FLIGHT_DATE", length = 200)
	public String getHkFlightDate() {
		return this.hkFlightDate;
	}

	public void setHkFlightDate(String hkFlightDate) {
		this.hkFlightDate = hkFlightDate;
	}

	@Column(name = "HK_GENDER", length = 200)
	public String getHkGender() {
		return this.hkGender;
	}

	public void setHkGender(String hkGender) {
		this.hkGender = hkGender;
	}

	@Column(name = "HK_BIRTHDAY", length = 200)
	public String getHkBirthday() {
		return this.hkBirthday;
	}

	public void setHkBirthday(String hkBirthday) {
		this.hkBirthday = hkBirthday;
	}

	@Column(name = "HK_PICKUP", length = 200)
	public String getHkPickup() {
		return this.hkPickup;
	}

	public void setHkPickup(String hkPickup) {
		this.hkPickup = hkPickup;
	}

	@Column(name = "HK_PICKUP_ID", length = 200)
	public String getHkPickupId() {
		return this.hkPickupId;
	}

	public void setHkPickupId(String hkPickupId) {
		this.hkPickupId = hkPickupId;
	}

	@Column(name = "ETICKET_SERVICE_ADDR", length = 200)
	public String getEticketServiceAddr() {
		return this.eticketServiceAddr;
	}

	public void setEticketServiceAddr(String eticketServiceAddr) {
		this.eticketServiceAddr = eticketServiceAddr;
	}

	@Column(name = "IS_SH_SHIP", length = 10)
	public String getIsShShip() {
		return this.isShShip;
	}

	public void setIsShShip(String isShShip) {
		this.isShShip = isShShip;
	}

	@Column(name = "O2O_SNATCH_STATUS", length = 10)
	public String getO2oSnatchStatus() {
		return this.o2oSnatchStatus;
	}

	public void setO2oSnatchStatus(String o2oSnatchStatus) {
		this.o2oSnatchStatus = o2oSnatchStatus;
	}

	@Column(name = "MARKET", length = 200)
	public String getMarket() {
		return this.market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	@Column(name = "ET_TYPE", length = 200)
	public String getEtType() {
		return this.etType;
	}

	public void setEtType(String etType) {
		this.etType = etType;
	}

	@Column(name = "ET_SHOP_ID", length = 200)
	public String getEtShopId() {
		return this.etShopId;
	}

	public void setEtShopId(String etShopId) {
		this.etShopId = etShopId;
	}

	@Column(name = "OBS", length = 200)
	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jstTrade")
	public Set<JstPromotionDetail> getJstPromotionDetails() {
		return this.jstPromotionDetails;
	}

	public void setJstPromotionDetails(
			Set<JstPromotionDetail> jstPromotionDetails) {
		this.jstPromotionDetails = jstPromotionDetails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jstTrade")
	public Set<JstOrder> getJstOrders() {
		return this.jstOrders;
	}

	public void setJstOrders(Set<JstOrder> jstOrders) {
		this.jstOrders = jstOrders;
	}

}