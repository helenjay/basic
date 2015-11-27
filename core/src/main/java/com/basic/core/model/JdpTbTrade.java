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
 * JdpTbTrade entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jdp_tb_trade")
public class JdpTbTrade implements java.io.Serializable {

	// Fields

	private Integer id;
	private String tid;
	private String status;
	private String type;
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
	public JdpTbTrade() {
	}

	/** minimal constructor */
	public JdpTbTrade(String tid, String status) {
		this.tid = tid;
		this.status = status;
	}

	/** full constructor */
	public JdpTbTrade(String tid, String status, String type,
			String sellerNick, String buyerNick, Date created, Date modified,
			Date jdpCreated, Date jdpModified, String jdpHashcode,
			String jdpResponse, Integer batchNo) {
		this.tid = tid;
		this.status = status;
		this.type = type;
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

	@Column(name = "TYPE", length = 100)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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