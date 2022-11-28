package io.github.landrynorris.serpapi

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Account(@SerialName("account_id") val id: String,
                   @SerialName("account_email") val email: String,
                   @SerialName("plan_id") val planId: String,
                   @SerialName("plan_name") val planName: String,
                   @SerialName("searches_per_month") val searchesPerMonth: Int,
                   @SerialName("plan_searches_left") val planSearchesLeft: Int,
                   @SerialName("extra_credits") val extraCredits: Int,
                   @SerialName("total_searches_left") val totalSearchesLeft: Int,
                   @SerialName("this_month_usage") val thisMonthUsage: Int,
                   @SerialName("last_hour_searches") val lastHourSearches: Int,
                   @SerialName("account_rate_limit_per_hour") val accountRateLimitPerHour: Int
)
