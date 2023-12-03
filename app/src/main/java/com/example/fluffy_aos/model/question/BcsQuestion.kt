package com.example.fluffy_aos.model.question

class BcsQuestion(
    val fieldName: String,
    val type: BcsQuestionType,
    val description: String,
    var response: Any? = null, // 초기화된 상태로 유지
    val selections: List<SelectionItem>? = null // 초기화된 상태로 유지
)

