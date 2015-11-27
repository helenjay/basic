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
 * JdpTbRefund entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jdp_tb_refund")
public class JdpTbRefund implements java.io.Serializable {

	// Fields

	private Integer id;
	private String refundId;
	private String oid;
	private String tid;
	private String status;
	private String sellerNick;
	private String buyerNick;
	private Date created;
	private Date modified;
	private Date jdpCreated;
	private Date jdpModified;
	private String jdpHashcode;
	private String jdpResponse;
	private Integer batchNo;

	// Constructors

	/** default constructor */
	public JdpTbRefund() {
	}

	/** minimal constructor */
	public JdpTbRefund(String refundId, String oid, String tid, String status) {
		this.refundId = refundId;
		this.oid = oid;
		this.tid = tid;
		this.status = status;
	}

	/** full constructor */
	public JdpTbRefund(String refundId, String oid, String tid, String status,
			String sellerNick, String buyerNick, Date created, Date modified,
			Date jdpCreated, Date jdpModified, String jdpHashcode,
			String jdpResponse, Integer batchNo) {
		this.refundId = refundId;
		this.oid = oid;
		this.tid = tid;
		this.status = status;
		this.sellerNick = sellerNick;
		this.buyerNick = buyerNick;
		this.created = created;
		this.modified = modified;
		this.jdpCreated = jdpCreated;
		this.jdpModified = jdpModified;
		this.jdpHashcode = jdpHashcode;
		this.jdpResponse = jdpResponse;
		this.batchNo = batchNo;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "REFUND_ID", nullable = false, length = 100)
	public String getRefundId() {
		return this.refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	@Column(name = "OID", nullable = false, length = 100)
	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	@Column(name = "TID", nullable = false, length = 100)
	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	@Column(name = "STATUS", nullable = false, length = 100)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "SELLER_NICK", length = 100)
	public String getSellerNick() {
		return this.sellerNick;
	}

	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIED", length = 19)
	public Date getModified() {
		return this.modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "JDP_CREATED", length = 19)
	public Date getJdpCreated() {
		return this.jdpCreated;
	}

	public void setJdpCreated(Date jdpCreated) {
		this.jdpCreated = jdpCreated;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "JDP_MODIFIED", length = 19)
	public Date getJdpModified() {
		return this.jdpModified;
	}

	public void setJdpModified(Date jdpModified) {
		this.jdpModified = jdpModified;
	}

	@Column(name = "JDP_HASHCODE", length = 300)
	public String getJdpHashcode() {
		return this.jdpHashcode;
	}

	public void setJdpHashcode(String jdpHashcode) {
		this.jdpHashcode = jdpHashcode;
	}

	@Column(name = "JDP_RESPONSE", length = 65535)
	public String getJdpResponse() {
		return this.jdpResponse;
	}

	public void setJdpResponse(String jdpResponse) {
		this.jdpResponse = jdpResponse;
	}

	@Column(name = "BATCH_NO")
	public Integer getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(Integer batchNo) {
		this.batchNo = batchNo;
	}

}