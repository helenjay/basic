package com.basic.core.model;

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
import org.hibernate.annotations.GenericGenerator;

/**
 * JstTradeRemark entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jst_trade_remark")
public class JstTradeRemark implements java.io.Serializable {

	// Fields

	private Integer jstTradeRemarkSysId;
	private String tid;
	private String invoiceTitle;
	private String receiveName;
	private String mobile;
	private String phone;
	private String receiveAddress;
	private String receiveZip;
	private Integer quantity;
	private String ticketName;
	private String ticketCode;
	private String ticketAddress;
	private String ticketAccount;
	private Set<JstTradeRemarkPresent> jstTradeRemarkPresents = new HashSet<JstTradeRemarkPresent>(
			0);

	// Constructors

	/** default constructor */
	public JstTradeRemark() {
	}

	/** minimal constructor */
	public JstTradeRemark(String tid) {
		this.tid = tid;
	}

	/** full constructor */
	public JstTradeRemark(String tid, String invoiceTitle, String receiveName,
			String mobile, String phone, String receiveAddress,
			String receiveZip, Integer quantity, String ticketName,
			String ticketCode, String ticketAddress, String ticketAccount,
			Set<JstTradeRemarkPresent> jstTradeRemarkPresents) {
		this.tid = tid;
		this.invoiceTitle = invoiceTitle;
		this.receiveName = receiveName;
		this.mobile = mobile;
		this.phone = phone;
		this.receiveAddress = receiveAddress;
		this.receiveZip = receiveZip;
		this.quantity = quantity;
		this.ticketName = ticketName;
		this.ticketCode = ticketCode;
		this.ticketAddress = ticketAddress;
		this.ticketAccount = ticketAccount;
		this.jstTradeRemarkPresents = jstTradeRemarkPresents;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "JST_TRADE_REMARK_SYS_ID", unique = true, nullable = false)
	public Integer getJstTradeRemarkSysId() {
		return this.jstTradeRemarkSysId;
	}

	public void setJstTradeRemarkSysId(Integer jstTradeRemarkSysId) {
		this.jstTradeRemarkSysId = jstTradeRemarkSysId;
	}

	@Column(name = "TID", nullable = false, length = 200)
	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	@Column(name = "INVOICE_TITLE", length = 500)
	public String getInvoiceTitle() {
		return this.invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	@Column(name = "RECEIVE_NAME", length = 100)
	public String getReceiveName() {
		return this.receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	@Column(name = "MOBILE", length = 100)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "PHONE", length = 100)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "RECEIVE_ADDRESS", length = 500)
	public String getReceiveAddress() {
		return this.receiveAddress;
	}

	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}

	@Column(name = "RECEIVE_ZIP", length = 100)
	public String getReceiveZip() {
		return this.receiveZip;
	}

	public void setReceiveZip(String receiveZip) {
		this.receiveZip = receiveZip;
	}

	@Column(name = "QUANTITY")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "TICKET_NAME", length = 500)
	public String getTicketName() {
		return this.ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	@Column(name = "TICKET_CODE", length = 500)
	public String getTicketCode() {
		return this.ticketCode;
	}

	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}

	@Column(name = "TICKET_ADDRESS", length = 500)
	public String getTicketAddress() {
		return this.ticketAddress;
	}

	public void setTicketAddress(String ticketAddress) {
		this.ticketAddress = ticketAddress;
	}

	@Column(name = "TICKET_ACCOUNT", length = 500)
	public String getTicketAccount() {
		return this.ticketAccount;
	}

	public void setTicketAccount(String ticketAccount) {
		this.ticketAccount = ticketAccount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jstTradeRemark")
	public Set<JstTradeRemarkPresent> getJstTradeRemarkPresents() {
		return this.jstTradeRemarkPresents;
	}

	public void setJstTradeRemarkPresents(
			Set<JstTradeRemarkPresent> jstTradeRemarkPresents) {
		this.jstTradeRemarkPresents = jstTradeRemarkPresents;
	}

}