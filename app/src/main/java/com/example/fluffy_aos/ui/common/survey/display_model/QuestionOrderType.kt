package com.example.fluffy_aos.ui.common.survey.display_model

enum class QuestionOrderType {
    FIRST, LAST, NOTHING;

    companion object {
        fun from(order: Int, size: Int): QuestionOrderType {
            return when {
                size == 1 -> FIRST
                size == order -> LAST
                else -> NOTHING
            }
        }
    }
}
