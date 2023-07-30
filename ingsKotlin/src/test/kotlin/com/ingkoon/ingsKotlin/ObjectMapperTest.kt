package com.ingkoon.ingsKotlin

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.ingkoon.ingsKotlin.domain.enums.Grade
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForObject
import java.math.BigInteger

data class SampleRequest(
    val id: Long,
    val name: String,
    val password: String,
    val grade: Grade
)

@Autowired
lateinit var restTemplate : RestTemplate
val mapper = ObjectMapper().registerKotlinModule()

fun main(){

    val header = HttpHeaders()
    header.contentType = MediaType.APPLICATION_JSON

    val bodyJsonObject = JSONObject().apply {
        put("id", String)
        put("password", String)
    }

    val request = HttpEntity(bodyJsonObject.toString(), header)
    val response: String = restTemplate.postForObject<String>("https://www", request, String::class)

    val getSampleRequest = mapper.readValue(response, SampleRequest::class.java)

    print(getSampleRequest.toString())
}