package com.example.fluffy_aos.ui.post.view_model

import androidx.lifecycle.ViewModel
import com.example.fluffy_aos.model.PostsSection
import com.example.fluffy_aos.model.postDummy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PostViewModel : ViewModel() {
    private val _state = MutableStateFlow(PostViewState())
    val state: StateFlow<PostViewState> = _state.asStateFlow()

    init {
        _state.update { currentState ->
            currentState.copy(posts = postDummy)
        }
    }

    fun selectCategory(category: String) {
        _state.update { currentState ->
            val filteredPosts = if (category == "전체") {
                postDummy
            } else {
                postDummy.filter { it.category == category }
            }
            println(filteredPosts)
            currentState.copy(selectedCategory = category, posts = filteredPosts)
        }
    }
}

data class PostViewState(
    var selectedCategory: String = "전체",
    var posts: List<PostsSection> = emptyList(),
)
