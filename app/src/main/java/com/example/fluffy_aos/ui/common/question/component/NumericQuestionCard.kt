package com.example.fluffy_aos.ui.common.question.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.fluffy_aos.ui.common.question.resuable.NumericField
import com.example.fluffy_aos.ui.common.question.resuable.QuestionCard

@Composable
fun NumericQuestionCard(
    question: String,
    suffix: String = "",
    initialText: String,
    onClickPreviousButton: (Any) -> Unit,
    onClickNextButton: (Any) -> Unit
) {
    // ✅ remember()안에 변수를 넣어주면 해당 변수가 변화하는 시점에 mutableState를 새로 만들어준다
    // 원래라면 상위 컴포넌트가 리컴포즈 되어도 text는 이전 상태를 유지하는데 초기화 시점을 정해주면 text 상태도 같이 초기화 된다
    // 즉, initialText 값이 변경될 때마다 remember는 text 상태 값을 새로운 initialText 값으로 재생성한다.
    // SwiftUI의 @Binding과 비슷한 기능 (단 바인딩은 부모-><-자식 양방향, 이건 부모->자식 만)
    var text by remember(initialText) { mutableStateOf(initialText) }

    QuestionCard(
        question = question,
        onClickPreviousButton = {
            onClickPreviousButton(text)
        },
        onClickNextButton = {
            onClickNextButton(text)
        },
    ) {
        NumericField(suffix = suffix, text = text, onValueChange = { text = it })
    }
}
