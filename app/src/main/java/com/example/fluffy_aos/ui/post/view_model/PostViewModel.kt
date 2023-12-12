package com.example.fluffy_aos.ui.post.view_model

import androidx.lifecycle.ViewModel
import com.example.fluffy_aos.model.post.Post
import com.example.fluffy_aos.model.post.PostsSection
import com.example.fluffy_aos.model.post.postDummy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PostViewModel : ViewModel() {
    private val _posts = MutableStateFlow(PostViewState())
    val post: StateFlow<PostViewState> = _posts.asStateFlow()

    private val _selectedPost = MutableStateFlow<Post>(postDummy[0].posts[0])
    val selectedPost: StateFlow<Post> = _selectedPost.asStateFlow()

    init {
        _posts.update { currentState ->
            currentState.copy(posts = postDummy)
        }
    }

    fun updateSelectedPost(post: Post) {
        _selectedPost.update { currentState ->
            post
        }
    }

    fun selectCategory(category: String) {
        _posts.update { currentState ->
            val filteredPosts = if (category == "전체") {
                postDummy
            } else {
                postDummy.filter { it.category == category }
            }
            currentState.copy(selectedCategory = category, posts = filteredPosts)
        }
    }
}

data class PostViewState(
    var selectedCategory: String = "전체",
    var posts: List<PostsSection> = emptyList(),
)
