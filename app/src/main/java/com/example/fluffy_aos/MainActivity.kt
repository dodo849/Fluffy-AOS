package com.example.fluffy_aos

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.fluffy_aos.ai.ModelManager
import com.example.fluffy_aos.data.repository.BcsRepository
import com.example.fluffy_aos.data.db.DbManager
import com.example.fluffy_aos.data.db.PreferencesManager
import com.example.fluffy_aos.data.repository.OnboardingRepository
import com.example.fluffy_aos.data.repository.PetRepository
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.home.sub_page.bcs_survey.BcsSurveyView
import com.example.fluffy_aos.ui.home.sub_page.bcs_survey.view_model.BcsSurveyViewModel
import com.example.fluffy_aos.ui.bottom_navigation.BottomNavigationBar
import com.example.fluffy_aos.ui.home.HomeView
import com.example.fluffy_aos.ui.home.view_model.HomeViewModel
import com.example.fluffy_aos.ui.onboarding_survey.OnboardingSurveyView
import com.example.fluffy_aos.ui.onboarding_survey.view_model.OnboardingSurveyViewModel
import com.example.fluffy_aos.ui.post.PostView
import com.example.fluffy_aos.ui.post.view_model.PostViewModel
import com.example.fluffy_aos.ui.record.RecordView
import com.example.fluffy_aos.ui.record.view_model.RecordViewModel
import com.example.fluffy_aos.ui.setting.SettingView
import com.example.fluffy_aos.ui.setting.sub_page.PhotoTestSurvey
import com.example.fluffy_aos.ui.setting.sub_page.my_pets.MyPetsView
import com.example.fluffy_aos.ui.setting.sub_page.my_pets.view_model.MyPetsViewModel
import com.example.fluffy_aos.ui.theme.main_orange
import com.example.fluffy_aos.util.JsonReader


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setDatabase()
        setPreferences()
        setJsonManager()
        setPython()

        setContent {
            val navController = rememberNavController()
            CompositionLocalProvider(LocalNavController provides navController) {
                MaterialTheme(
                    colorScheme = MaterialTheme.colorScheme.copy(
                        primary = main_orange,
                        background = Color.White,
                        surface = Color.White
                    )
                ) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar()
                        }
                    ) { paddingValues ->
                        AppNavigation(navController, paddingValues)
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        // 앱이 종료될 때 DbManager에서 데이터베이스를 삭제하고 닫음
        DbManager.closeDatabase()
        deleteDatabase("fluffy_database") // 데이터베이스 삭제
        super.onDestroy()
    }

    private fun setDatabase() {

        DbManager.init(this)

//        PetDummy(PetRepository(DbManager)).insertDummy()

//        PetRepository().readAllPets().forEach {
//            println("pet" + it.toString())
//        }
    }

    private fun setPreferences() {
        PreferencesManager.init(this)

        // 선택된 반려동물이 없으면 마지막 반려동물을 선택
//        val petId = PreferencesManager.getValue("pet_id", "0").toLong()
//        if (petId == 0L) {
//            val pets = PetRepository().readAllPets()
//            if (pets.isNotEmpty()) {
//                val lastPet = pets.last()
//                PreferencesManager.saveValue("pet_id", lastPet.id.toString())
//            }
//        }
    }

    private fun setJsonManager() {
        JsonReader.init(this)
    }

    private fun setPython() {
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this));
        }

        // TODO: 모델 로드
//        ModelManager().execute()
    }

    @Composable
    fun AppNavigation(navController: NavHostController, paddingValues: PaddingValues) {
        NavHost(
            navController = navController,
            startDestination = "home",
        ) {
            composable("home") { HomeView(HomeViewModel(PetRepository())) }
            composable("record") { RecordView(RecordViewModel(PetRepository(), BcsRepository())) }
            composable("post") { PostView(PostViewModel()) }
            composable("setting") { SettingView() }
            composable("photo_test") { PhotoTestSurvey() } // FIXME: 테스트 후 삭제

            composable("bcs_survey") {
                BcsSurveyView(
                    BcsSurveyViewModel(BcsRepository())
                )
            }
            composable("onboarding_survey") {
                OnboardingSurveyView(
                    OnboardingSurveyViewModel(OnboardingRepository(), PetRepository())
                )
            }
            composable("my_pets") {
                MyPetsView(MyPetsViewModel(PetRepository()))
            }
        }
    }
}