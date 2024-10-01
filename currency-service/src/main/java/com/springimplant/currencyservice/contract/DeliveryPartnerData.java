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
public class DeliveryPartnerData {
	private int orderId;
	private String firstName;
	private String lastName;
	private double xCoordinte;
	private double yCoordinte;
	private float distance;
	private float estimatedTime;
}
