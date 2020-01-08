package ng.com.techdepo.remote.dto

import ng.com.techdepo.dto.Article

data class ApiResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)