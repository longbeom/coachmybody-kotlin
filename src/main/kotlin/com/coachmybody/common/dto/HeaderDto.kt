package com.coachmybody.common.dto

import org.springframework.http.HttpHeaders

data class HeaderDto(
        var token: String,
        var os: String,
        var appVersion: String,
        var deviceToken: String
) {
    companion object {
        fun of(httpHeaders: HttpHeaders): HeaderDto {
            val token = httpHeaders.toSingleValueMap()["authorization"]
            val os = httpHeaders.toSingleValueMap()["OS"]
            val appVersion = httpHeaders.toSingleValueMap()["App-Version"]
            val deviceToken = httpHeaders.toSingleValueMap()["Device-Token"]

            return HeaderDto(
                    token = token?.substring(7) ?: "NONE",
                    os = os ?: "NONE",
                    appVersion = appVersion ?: "NONE",
                    deviceToken = deviceToken ?: "NONE"
            )
        }
    }
}