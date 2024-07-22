package com.springimplant.currencyservice.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAnalyticsData {
	private int orderId;
	private float totalDistanceCovered;
	private float totalTimeTaken;
	private boolean deliveryOnTime;
	private String trafficSituation;
}
