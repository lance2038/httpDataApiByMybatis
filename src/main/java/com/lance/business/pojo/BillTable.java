package com.lance.business.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author lance
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BillTable
{
    private String billCode;
    private String userCode;
    private String address;
    private String transactionId;
    private BigDecimal amount;

}
