package com.springimplant.userapi.contracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	private String ratingId;
	private long userId;
	private String orderId;
	private int rating;
	private String feedback;
}
