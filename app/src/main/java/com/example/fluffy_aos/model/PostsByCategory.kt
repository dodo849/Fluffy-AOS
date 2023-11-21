package com.example.fluffy_aos.model

data class PostsByCategory(
    val title: String,
    val posts: List<Post>,
)


// 더미
val dogPostDummy = listOf(
    PostsByCategory(
        "다이어트 정보",
        listOf(
            Post(
                "강아지 다이어트 어떻게 해야할까?",
                "건강하게 오래오래 함께 하는 법",
                "https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_640.jpg"
            ),
            Post(
                "운동? 식단? 강아지 성향에 따라 정해요",
                "건강한 강아지를 위한 운동 및 식단 정보를 공유합니다",
                "https://www.shutterstock.com/image-photo/woman-running-dog-workout-during-600nw-2225043417.jpg"
            ),
            Post(
                "식단 조절의 중요성\"",
                "올바른 식단 조절로 강아지의 건강을 지켜봐요.",
                "https://images.unsplash.com/photo-1599406580992-46ab5d96f296?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8ZG9nJTIwd2Fsa3xlbnwwfHwwfHx8MA%3D%3D"
            )
        )
    ),
    PostsByCategory(
        "운동 정보",
        listOf(
            Post(
                "강아지와 함께하는 즐거운 운동",
                "강아지와 함께할 수 있는 즐거운 운동 아이디어를 제공합니다.",
                "https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_640.jpg"
            ),
            Post(
                "건강한 운동 습관",
                "강아지의 건강을 위한 운동 습관을 만들어봐요.",
                "https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_640.jpg"
            ),
            Post(
                "강아지와의 실내 운동",
                "실내에서 할 수 있는 강아지와의 실용적인 운동을 소개합니다.",
                "https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_640.jpg"
            )
        )
    ), PostsByCategory(
        "영양 정보",
        listOf(
            Post(
                "강아지 영양 꿀팁",
                "강아지에게 필요한 영양소 및 영양 공급 방법을 알려드려요.",
                "https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_640.jpg"
            ),
            Post(
                "강아지 다이어트 어떻게 해야할까?",
                "건강하게 오래오래 함께 하는 법",
                "https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_640.jpg",
            ),
            Post(
                "영양소 선별 가이드",
                "건강한 강아지를 위한 필수 영양소를 선별하는 방법에 대해 알려드립니다.",
                "https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_640.jpg"
            )
        )
    )
)