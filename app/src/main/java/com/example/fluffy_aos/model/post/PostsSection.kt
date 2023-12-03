package com.example.fluffy_aos.model.post

data class PostsSection(
    val category: String,
    val title: String,
    val posts: List<Post>,
)


// 더미
val postDummy = listOf(
    PostsSection(
        "반려견",
        "다이어트 시작하기",
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
    PostsSection(
        "고양이",
        "영양과 식이 조절",
        listOf(
            Post(
                "식이 섭취 조절법",
                "반려동물의 건강을 위해 올바른 식이 섭취와 조절 방법을 알아봅니다.",
                "https://st3.depositphotos.com/1177973/14607/i/450/depositphotos_146078475-stock-photo-cute-funny-cat.jpg"
            ),
            Post(
                "영양소 풍부한 간식",
                "고양이를 위한 영양소 풍부한 간식을 선택하는 방법과 추천 간식을 소개합니다.",
                "https://www.shutterstock.com/image-photo/adorable-domestic-cat-brown-white-600nw-2269901429.jpg"
            ),
            Post(
                "다양한 먹이 종류",
                "고양이에게 제공할 수 있는 다양한 먹이 종류와 그에 따른 장단점을 알려드립니다.",
                "https://cats.com/wp-content/uploads/2022/03/cat-eating-cat-food-compressed.jpg"
            )
        )
    ),
    PostsSection(
        "반려견",
        "운동 가이드",
        listOf(
            Post(
                "강아지와 함께하는 즐거운 운동",
                "강아지와 함께할 수 있는 즐거운 운동 아이디어를 제공합니다.",
                "https://www.shutterstock.com/image-photo/doga-yoga-practice-exercise-dogs-600nw-1888562752.jpg"
            ),
            Post(
                "건강한 운동 습관",
                "강아지의 건강을 위한 운동 습관을 만들어봐요.",
                "https://img.freepik.com/free-photo/isolated-happy-smiling-dog-white-background-portrait-2_1562-691.jpg"
            ),
            Post(
                "강아지와의 실내 운동",
                "실내에서 할 수 있는 강아지와의 실용적인 운동을 소개합니다.",
                "https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_640.jpg"
            )
        )
    ), PostsSection(
        "반려견",
        "반려견 영양 가이드",
        listOf(
            Post(
                "강아지 영양 꿀팁",
                "강아지에게 필요한 영양소 및 영양 공급 방법을 알려드려요.",
                "https://img.freepik.com/free-photo/healthy-fresh-pet-food-ingredients-dark-surface_1150-42077.jpg"
            ),
            Post(
                "간식 고르는 법",
                "살찌지 않는 간식",
                "https://www.shutterstock.com/image-photo/cute-labrador-dog-getting-heart-600nw-1859652601.jpg"
            ),
            Post(
                "영양소 선별 가이드",
                "건강한 강아지를 위한 필수 영양소를 선별하는 방법에 대해 알려드립니다.",
                "https://thumbs.dreamstime.com/b/dog-treat-background-top-view-image-several-bone-shaped-treats-87325983.jpg"
            )
        )
    ),
    PostsSection(
        "반려견",
        "반려견 운동 가이드",
        listOf(
            Post(
                "강아지와 함께하는 즐거운 운동",
                "강아지와 함께할 수 있는 즐거운 운동 아이디어를 제공합니다.",
                "https://www.shutterstock.com/image-photo/doga-yoga-practice-exercise-dogs-600nw-1888562752.jpg"
            ),
            Post(
                "건강한 운동 습관",
                "강아지의 건강을 위한 운동 습관을 만들어봐요.",
                "https://img.freepik.com/free-photo/isolated-happy-smiling-dog-white-background-portrait-2_1562-691.jpg"
            ),
            Post(
                "강아지와의 실내 운동",
                "실내에서 할 수 있는 강아지와의 실용적인 운동을 소개합니다.",
                "https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_640.jpg"
            )
        )
    ),
    PostsSection(
        "반려묘",
        "반려묘 영양 가이드",
        listOf(
            Post(
                "영양가득한 캣푸드 추천",
                "반려묘를 위한 영양가득한 캣푸드를 소개합니다.",
                "https://www.shutterstock.com/image-photo/smoky-cat-running-on-exercise-600nw-2145188439.jpg"
            ),
            Post(
                "새로운 간식 아이디어",
                "반려묘를 위한 다양한 새로운 간식 아이디어를 알려드립니다.",
                "https://img.freepik.com/free-photo/portrait-fluffy-white-kitty-cat-with-blue-gray-eyes_1098-18643.jpg"
            ),
            Post(
                "스트레스 해소하는 놀이법",
                "스트레스를 해소하고 활동적인 반려묘를 위한 놀이법을 소개합니다.",
                "https://cdn.pixabay.com/photo/2017/11/14/13/06/kitty-2948404_640.jpg"
            )
        )
    ),
)