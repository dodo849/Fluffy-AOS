package com.example.fluffy_aos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fluffy_aos.db.BcsRepository
import com.example.fluffy_aos.db.DbManager
import com.example.fluffy_aos.db.OnboardingRepository
import com.example.fluffy_aos.db.PetRepository
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.bcs_survey.BcsSurveyView
import com.example.fluffy_aos.ui.bcs_survey.view_model.BcsSurveyViewModel
import com.example.fluffy_aos.ui.bottom_navigation.BottomNavigationBar
import com.example.fluffy_aos.ui.home.HomeView
import com.example.fluffy_aos.ui.onboarding_survey.OnboardingSurveyView
import com.example.fluffy_aos.ui.onboarding_survey.view_model.OnboardingSurveyViewModel
import com.example.fluffy_aos.ui.post.PostView
import com.example.fluffy_aos.ui.post.view_model.PostViewModel
import com.example.fluffy_aos.ui.record.RecordView
import com.example.fluffy_aos.ui.setting.SettingView
import com.example.fluffy_aos.util.JsonParser
import com.example.fluffy_aos.util.JsonReader


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setDatabase()
        setJsonManager()

        setContent {
            val navController = rememberNavController()
            CompositionLocalProvider(LocalNavController provides navController) {
                MaterialTheme {
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

        PetRepository(DbManager).readAllPets().forEach {
            println("pet" + it.toString())
        }
    }

    private fun setJsonManager() {
        JsonReader.init(this)
    }

    @Composable
    fun AppNavigation(navController: NavHostController, paddingValues: PaddingValues) {
        NavHost(
            navController = navController,
            startDestination = "home",
        ) {
            composable("home") { HomeView() }
            composable("record") { RecordView() }
            composable("post") { PostView(PostViewModel()) }
            composable("setting") { SettingView() }

            composable("bcs_survey") {
                BcsSurveyView(
                    BcsSurveyViewModel(BcsRepository())
                )
            }
            composable("onboarding_survey") {
                OnboardingSurveyView(
                    OnboardingSurveyViewModel(OnboardingRepository())
                )
            }
        }
    }
}