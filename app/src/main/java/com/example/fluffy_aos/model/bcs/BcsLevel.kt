package com.example.fluffy_aos.model.bcs

enum class BcsLevel {
    LEVEL_1,
    LEVEL_2,
    LEVEL_3,
    LEVEL_4,
    LEVEL_5,
    LEVEL_6,
    LEVEL_7,
    LEVEL_8,
    LEVEL_9;

    fun bcsLevel(): Int {
        return when (this) {
            LEVEL_1 -> 1
            LEVEL_2 -> 2
            LEVEL_3 -> 3
            LEVEL_4 -> 4
            LEVEL_5 -> 5
            LEVEL_6 -> 6
            LEVEL_7 -> 7
            LEVEL_8 -> 8
            LEVEL_9 -> 9
        }
    }

    fun getKr(): String {
        return when (this) {
            LEVEL_1 -> "마른 상태"
            LEVEL_2 -> "마른 상태"
            LEVEL_3 -> "약간 마른 상태"
            LEVEL_4 -> "적정 상태"
            LEVEL_5 -> "적정 상태"
            LEVEL_6 -> "과체중"
            LEVEL_7 -> "비만"
            LEVEL_8 -> "비만"
            LEVEL_9 -> "비만"
        }
    }

    fun getDescription(): String {
        return when (this) {
            LEVEL_1 -> "극심한 근육 손실이 있고, 뼈가 눈에 띄게 돌출되어 있을 것으로 예상됩니다. 건강 문제가 우려되므로 빠른 시일 내에 의료기관에 방문하는 것을 권장드립니다."
            LEVEL_2 -> "근육량이 적고, 뼈가 쉽게 만져지는 상태일 것으로 예상됩니다. 수의사와 상담하여 체중 증가를 위한 적절한 식단 계획이 필요합니다."
            LEVEL_3 -> "약간 마른 상태로 건강에 극심한 문제는 없을 것으로 예상되나, 현재보다 체중을 증량하는 것이 반려동물의 건강에 도움이 될 것으로 보입니다."
            LEVEL_4 -> "이상적인 상태입니다. 앞으로도 건강한 식습관과 적절한 운동을 통해 현재 체중을 유지하는 것이 좋습니다."
            LEVEL_5 -> "이상적인 상태입니다. 앞으로도 건강한 식습관과 적절한 운동을 통해 현재 체중을 유지하는 것이 좋습니다."
            LEVEL_6 -> "약간의 과체중입니다. 당장 극심한 건강 문제는 없을 것으로 예상되나, 장기적으로 약간의 체중 감량이 필요합니다."
            LEVEL_7 -> "지방으로 인한 건강 문제가 우려됩니다. 수의사와의 상담을 통해 적절한 식단과 운동 계획을 세우는 것을 권장드립니다."
            LEVEL_8 -> "지방으로 인한 건강 문제가 우려됩니다. 수의사와의 상담을 통해 적절한 식단과 운동 계획을 세우는 것을 권장드립니다."
            LEVEL_9 -> "심각한 체지방 축적으로 인해 갈비뼈나 척추를 만져보기 어려울 것으로 예상됩니다. 수의사와의 상담을 통해 체중 감량 프로그램을 진행하시는 것이 좋습니다."
        }
    }

    fun getImoji(): String {
        return when (this) {
            LEVEL_1 -> "‼️"
            LEVEL_2 -> "❗️"
            LEVEL_3 -> "⚠️"
            LEVEL_4 -> "✅"
            LEVEL_5 -> "✅"
            LEVEL_6 -> "⚠️"
            LEVEL_7 -> "❗"
            LEVEL_8 -> "❗"
            LEVEL_9 -> "‼️"
        }
    }
}