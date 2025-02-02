package com.clone.twitter.project_service.dto.donation.filter;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DonationFilterDto {
    private String donationTime;
    private String currency;
    private BigDecimal maxAmount;
    private BigDecimal minAmount;
}