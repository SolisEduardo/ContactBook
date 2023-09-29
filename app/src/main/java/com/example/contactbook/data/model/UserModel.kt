package com.example.contactbook.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(

	@field:SerializedName("UserModel")
	val userModel: List<UserModelItem?>? = null
)

data class UserModelItem(

	@field:SerializedName("address")
	val address: Address? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("date_of_birth")
	val dateOfBirth: String? = null,

	@field:SerializedName("last_name")
	val lastName: String? = null,

	@field:SerializedName("avatar")
	val avatar: String? = null,

	@field:SerializedName("employment")
	val employment: Employment? = null,

	@field:SerializedName("subscription")
	val subscription: Subscription? = null,

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("credit_card")
	val creditCard: CreditCard? = null,

	@field:SerializedName("social_insurance_number")
	val socialInsuranceNumber: String? = null,

	@field:SerializedName("phone_number")
	val phoneNumber: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)

data class Subscription(

	@field:SerializedName("term")
	val term: String? = null,

	@field:SerializedName("plan")
	val plan: String? = null,

	@field:SerializedName("payment_method")
	val paymentMethod: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)


data class Coordinates(

	@field:SerializedName("lng")
	val lng: Any? = null,

	@field:SerializedName("lat")
	val lat: Any? = null
)

data class Address(

	@field:SerializedName("street_address")
	val streetAddress: String? = null,

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("coordinates")
	val coordinates: Coordinates? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("street_name")
	val streetName: String? = null,

	@field:SerializedName("zip_code")
	val zipCode: String? = null
)

data class Employment(

	@field:SerializedName("key_skill")
	val keySkill: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class CreditCard(

	@field:SerializedName("cc_number")
	val ccNumber: String? = null
)
