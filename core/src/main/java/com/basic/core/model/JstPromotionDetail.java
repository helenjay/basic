package com.basic.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * JstPromotionDetail entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jst_promotion_detail")
public class JstPromotionDetail implements java.io.Serializable {

	// Fields

	private Integer jstPromotionDetailSysId;
	private JstTrade jstTrade;
	private String id;
	private String promotionName;
	private Double discountFee;
	private String promotionDesc;
	private String promotionId;
	private String promotionType;

	// Constructors

	/** default constructor */
	public JstPromotionDetail() {
	}

	/** minimal constructor */
	public JstPromotionDetail(JstTrade jstTrade) {
		this.jstTrade = jstTrade;
	}

	/** full constructor */
	public JstPromotionDetail(JstTrade jstTrade, String id,
			String promotionName, Double discountFee, String promotionDesc,
			String promotionId, String promotionType) {
		this.jstTrade = jstTrade;
		this.id = id;
		this.promotionName = promotionName;
		this.discountFee = discountFee;
		this.promotionDesc = promotionDesc;
		this.promotionId = promotionId;
		this.promotionType = promotionType;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "JST_PROMOTION_DETAIL_SYS_ID", unique = true, nullable = false)
	public Integer getJstPromotionDetailSysId() {
		return this.jstPromotionDetailSysId;
	}

	public void setJstPromotionDetailSysId(Integer jstPromotionDetailSysId) {
		this.jstPromotionDetailSysId = jstPromotionDetailSysId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JST_TRADE_SYS_ID", nullable = false)
	public JstTrade getJstTrade() {
		return this.jstTrade;
	}

	public void setJstTrade(JstTrade jstTrade) {
		this.jstTrade = jstTrade;
	}

	@Column(name = "ID", length = 100)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "PROMOTION_NAME", length = 100)
	public String getPromotionName() {
		return this.promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	@Column(name = "DISCOUNT_FEE", precision = 10)
	public Double getDiscountFee() {
		return this.discountFee;
	}

	public void setDiscountFee(Double discountFee) {
		this.discountFee = discountFee;
	}

	@Column(name = "PROMOTION_DESC", length = 100)
	public String getPromotionDesc() {
		return this.promotionDesc;
	}

	public void setPromotionDesc(String promotionDesc) {
		this.promotionDesc = promotionDesc;
	}

	@Column(name = "PROMOTION_ID", length = 100)
	public String getPromotionId() {
		return this.promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	@Column(name = "PROMOTION_TYPE", length = 100)
	public String getPromotionType() {
		return this.promotionType;
	}

	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

}