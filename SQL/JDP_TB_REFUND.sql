/*交易退款备份表*/
DROP TABLE IF EXISTS `JDP_TB_REFUND`;
CREATE TABLE `JDP_TB_REFUND` (
`ID` INT NOT NULL COMMENT 'ID' AUTO_INCREMENT,
`REFUND_ID` VARCHAR(100) NOT NULL COMMENT '交易退款单ID' ,
`OID` VARCHAR(100) NOT NULL COMMENT '交易订单子ID' ,
`TID` VARCHAR(100) NOT NULL COMMENT '交易订单ID' ,
`STATUS` VARCHAR(100) NOT NULL COMMENT '交易状态',
`SELLER_NICK` VARCHAR(100) NULL COMMENT '卖家昵称',
`BUYER_NICK` VARCHAR(100) NULL COMMENT '买家昵称',
`CREATED` TIMESTAMP NULL COMMENT '交易创建时间',
`MODIFIED` TIMESTAMP NULL COMMENT '交易修改时间',
`JDP_CREATED` TIMESTAMP NULL COMMENT '数据推送的创建时间',
`JDP_MODIFIED` TIMESTAMP NULL COMMENT '数据推送的修改时间',
`JDP_HASHCODE` VARCHAR(300) NULL COMMENT 'JDP用来做数据校验的字段',
`JDP_RESPONSE` TEXT NULL COMMENT 'API返回的整个JSON字符串',
`BATCH_NO` INT NULL COMMENT '更新批次',
  PRIMARY KEY (`ID`)
)
ENGINE = INNODB AUTO_INCREMENT=100001
DEFAULT CHARACTER SET = UTF8;