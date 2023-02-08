package com.example.apicalls.test

data class TestResponse(
    val batchNr: Int,
    val doz: Doz,
    val tuts: List<Tut>,
    val participants: List<Participants>
)

data class Doz(
    val name: String,
    val field: String
)

data class Tut(
    val name: String,
    val funFactor: Int
)

data class Participants(
    val name: String,
    val funFactor: Int,
    val progress: Int
)
