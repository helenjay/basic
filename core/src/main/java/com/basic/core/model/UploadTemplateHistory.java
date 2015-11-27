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
 * UploadTemplateHistory entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "upload_template_history")
public class UploadTemplateHistory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String templateName;
	private String templateColumn;
	private Integer templateColumnIndex;
	private Date createTime;
	private String createOp;
	private Integer mustExists;
	private Integer ignoreColumnIndex;

	// Constructors

	/** default constructor */
	public UploadTemplateHistory() {
	}

	/** minimal constructor */
	public UploadTemplateHistory(String templateName, String templateColumn,
			Date createTime, String createOp) {
		this.templateName = templateName;
		this.templateColumn = templateColumn;
		this.createTime = createTime;
		this.createOp = createOp;
	}

	/** full constructor */
	public UploadTemplateHistory(String templateName, String templateColumn,
			Integer templateColumnIndex, Date createTime, String createOp,
			Integer mustExists, Integer ignoreColumnIndex) {
		this.templateName = templateName;
		this.templateColumn = templateColumn;
		this.templateColumnIndex = templateColumnIndex;
		this.createTime = createTime;
		this.createOp = createOp;
		this.mustExists = mustExists;
		this.ignoreColumnIndex = ignoreColumnIndex;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "template_name", nullable = false, length = 100)
	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	@Column(name = "template_column", nullable = false, length = 45)
	public String getTemplateColumn() {
		return this.templateColumn;
	}

	public void setTemplateColumn(String templateColumn) {
		this.templateColumn = templateColumn;
	}

	@Column(name = "template_column_index")
	public Integer getTemplateColumnIndex() {
		return this.templateColumnIndex;
	}

	public void setTemplateColumnIndex(Integer templateColumnIndex) {
		this.templateColumnIndex = templateColumnIndex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_op", nullable = false, length = 45)
	public String getCreateOp() {
		return this.createOp;
	}

	public void setCreateOp(String createOp) {
		this.createOp = createOp;
	}

	@Column(name = "must_exists")
	public Integer getMustExists() {
		return this.mustExists;
	}

	public void setMustExists(Integer mustExists) {
		this.mustExists = mustExists;
	}

	@Column(name = "ignore_column_index")
	public Integer getIgnoreColumnIndex() {
		return this.ignoreColumnIndex;
	}

	public void setIgnoreColumnIndex(Integer ignoreColumnIndex) {
		this.ignoreColumnIndex = ignoreColumnIndex;
	}

}