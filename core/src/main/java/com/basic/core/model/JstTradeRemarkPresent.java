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
 * JstTradeRemarkPresent entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jst_trade_remark_present")
public class JstTradeRemarkPresent implements java.io.Serializable {

	// Fields

	private Integer presentSysId;
	private JstTradeRemark jstTradeRemark;
	private String presentReason;
	private String presentName;
	private Integer presentQuantity;

	// Constructors

	/** default constructor */
	public JstTradeRemarkPresent() {
	}

	/** minimal constructor */
	public JstTradeRemarkPresent(JstTradeRemark jstTradeRemark) {
		this.jstTradeRemark = jstTradeRemark;
	}

	/** full constructor */
	public JstTradeRemarkPresent(JstTradeRemark jstTradeRemark,
			String presentReason, String presentName, Integer presentQuantity) {
		this.jstTradeRemark = jstTradeRemark;
		this.presentReason = presentReason;
		this.presentName = presentName;
		this.presentQuantity = presentQuantity;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PRESENT_SYS_ID", unique = true, nullable = false)
	public Integer getPresentSysId() {
		return this.presentSysId;
	}

	public void setPresentSysId(Integer presentSysId) {
		this.presentSysId = presentSysId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JST_TRADE_REMARK_SYS_ID", nullable = false)
	public JstTradeRemark getJstTradeRemark() {
		return this.jstTradeRemark;
	}

	public void setJstTradeRemark(JstTradeRemark jstTradeRemark) {
		this.jstTradeRemark = jstTradeRemark;
	}

	@Column(name = "PRESENT_REASON", length = 200)
	public String getPresentReason() {
		return this.presentReason;
	}

	public void setPresentReason(String presentReason) {
		this.presentReason = presentReason;
	}

	@Column(name = "PRESENT_NAME", length = 100)
	public String getPresentName() {
		return this.presentName;
	}

	public void setPresentName(String presentName) {
		this.presentName = presentName;
	}

	@Column(name = "PRESENT_QUANTITY")
	public Integer getPresentQuantity() {
		return this.presentQuantity;
	}

	public void setPresentQuantity(Integer presentQuantity) {
		this.presentQuantity = presentQuantity;
	}

}