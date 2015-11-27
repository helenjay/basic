/*聚石塔订单商品原始表*/
DROP TABLE IF EXISTS `JST_ORDER`;
CREATE TABLE `JST_ORDER` (
`JST_ORDER_SYS_ID` INT NOT NULL COMMENT '' AUTO_INCREMENT,
`JST_TRADE_SYS_ID` INT NOT NULL COMMENT '',
`ADJUST_FEE` DOUBLE NULL COMMENT '手工调整金额.格式为:1.01;单位:元;精确到小数点后两位',
`BUYER_RATE` VARCHAR(10) NULL COMMENT '买家是否已评价BOOLEAN',
`CID` VARCHAR(100) NULL COMMENT '交易商品对应的类目ID',
`CONSIGN_TIME` TIMESTAMP NULL COMMENT '子订单发货时间',
`DISCOUNT_FEE` DECIMAL(10,2) NULL COMMENT '子订单级订单优惠金额',
`DIVIDE_ORDER_FEE` DECIMAL(10,2) NULL COMMENT '分摊之后的实付金额',
`END_TIME` TIMESTAMP NULL COMMENT '子订单的交易结束时间',
`INVOICE_NO` VARCHAR(100) NULL COMMENT '子订单所在包裹的运单号',
`IS_OVERSOLD` VARCHAR(10) NULL COMMENT '是否超卖',
`IS_WWW` VARCHAR(10) NULL COMMENT '子订单是否是WWW订单Boolean',
`LOGISTICS_COMPANY` VARCHAR(100) NULL COMMENT '子订单发货的快递公司名称',
`NUM` INT NULL COMMENT '购买数量',
`NUM_IID` VARCHAR(100) NULL COMMENT '商品数字ID',
`OID` VARCHAR(100) NULL COMMENT '子订单编号',
`ORDER_FROM` VARCHAR(100) NULL COMMENT '子订单来源',
`PART_MJZ_DISCOUNT` DECIMAL(10,2) NULL COMMENT '优惠分摊',
`PAYMENT` DECIMAL(10,2) NULL COMMENT '子订单实付金额',
`PIC_PATH` VARCHAR(100) NULL COMMENT '商品图片的绝对路径',
`PRICE` DECIMAL(10,2) NULL COMMENT '商品价格',
`REFUND_ID` VARCHAR(100) NULL COMMENT '最近退款ID',
`REFUND_STATUS` VARCHAR(100) NULL COMMENT '退款状态',
`SELLER_RATE` VARCHAR(10) NULL COMMENT '卖家是否已评价BOOLEAN',
`SELLER_TYPE` VARCHAR(10) NULL COMMENT '卖家类型，可选值为：B（商城商家），C（普通卖家）',
`SHIPPING_TYPE` VARCHAR(100) NULL COMMENT '子订单的运送方式',
`SKU_ID` VARCHAR(100) NULL COMMENT '商品的最小库存单位SKU的ID',
`SKU_PROPERTIES_NAME` VARCHAR(100) NULL COMMENT 'SKU的值,如：机身颜色:黑色;手机套餐:官方标配',
`SNAPSHOT_URL` VARCHAR(100) NULL COMMENT '订单快照URL',
`STATUS` VARCHAR(100) NULL COMMENT '订单状态',
`STORE_CODE` VARCHAR(100) NULL COMMENT '发货的仓库编码',
`TITLE` VARCHAR(100) NULL COMMENT '商品标题',
`TOTAL_FEE` DECIMAL(10,2) NULL COMMENT '应付金额',
/*未使用的字段*/
`ITEM_MEAL_NAME` VARCHAR(50) NULL COMMENT '套餐的值',
`OUTER_IID` VARCHAR(100) NULL COMMENT '商家外部编码',
`TIMEOUT_ACTION_TIME` TIMESTAMP NULL COMMENT '订单超时到期时间',
`SUB_ORDER_TAX_FEE` VARCHAR(100) NULL COMMENT '天猫国际官网直供子订单关税税费',
`SUB_ORDER_TAX_RATE` VARCHAR(100) NULL COMMENT '天猫国际官网直供子订单关税税率',
`ITEM_MEAL_ID` VARCHAR(100) NULL COMMENT '套餐ID',
`OUTER_SKU_ID`  VARCHAR(100) NULL COMMENT '外部网店自己定义的SKU编号',
`IS_SERVICE_ORDER` VARCHAR(10) NULL COMMENT '是否是服务订单Boolean',
`BIND_OID` VARCHAR(100) NULL COMMENT '捆绑的子订单号',
`IS_DAIXIAO` VARCHAR(10) NULL COMMENT '表示订单交易是否含有对应的代销采购单BOOLEAN',
`TICKET_OUTER_ID` VARCHAR(100) NULL COMMENT '对应门票有效期的外部ID',
`TICKET_EXPDATE_KEY` VARCHAR(100) NULL COMMENT '门票有效期的KEY',
`TMSER_SPU_CODE` VARCHAR(100) NULL COMMENT '支持家装类物流的类型',
`MATNR` VARCHAR(100) NULL COMMENT 'SKU CODE',
`ITEM_MEMO` VARCHAR(100) NULL COMMENT '商品备注',
`ET_SER_TIME` TIMESTAMP NULL COMMENT '天猫汽车服务预约时间',
`ET_SHOP_NAME` VARCHAR(100) NULL COMMENT '电子凭证预约门店地址',
`ET_VERIFIED_SHOP_NAME` VARCHAR(100) NULL COMMENT '电子凭证核销门店地址',
`ET_PLATE_NUMBER` VARCHAR(100) NULL COMMENT '车牌号码',
`ESTIMATE_CON_TIME` VARCHAR(100) NULL COMMENT '子订单预计发货时间',
`BIND_OIDS` VARCHAR(200) NULL COMMENT 'BIND_OID字段的升级，支持返回绑定的多个子订单，多个子订单以半角逗号分隔',
`ZHENGJI_STATUS` VARCHAR(10) NULL COMMENT '征集预售订单征集状态：1（征集中），2（征集成功），3（征集失败）',
PRIMARY KEY (`JST_ORDER_SYS_ID`),
FOREIGN KEY (`JST_TRADE_SYS_ID`) REFERENCES JST_TRADE(`JST_TRADE_SYS_ID`) ON DELETE CASCADE
)
ENGINE = INNODB AUTO_INCREMENT=100001
DEFAULT CHARACTER SET = UTF8;