package com.example.praktikum7.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum7.ui.view.screen.MahasiswaFormView
import com.example.praktikum7.ui.view.screen.RencanaStudyView
import com.example.praktikum7.ui.view.screen.SplashView
import com.example.praktikum7.ui.view.screen.TampilView
import com.example.praktikum7.ui.view.viewmodel.MahasiswaViewModel
import com.example.praktikum7.ui.view.viewmodel.RencanaStudyViewModel

enum class Halaman{
    Splahs,
    Mahasiswa,
    MataKuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    rencanaStudyViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()

    ){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    NavHost(navController = navController, startDestination = Halaman.Splahs.name,
        modifier = Modifier.padding()

    ) {
        composable(route = Halaman.Splahs.name){
            SplashView(onMulaiButton = {navController.navigate(Halaman.Mahasiswa.name)})
        }

        composable(route = Halaman.Mahasiswa.name){
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.MataKuliah.name)
                },
                onBackButtonClicked = { navController.popBackStack()}

            )
        }
        composable(route = Halaman.MataKuliah.name){
            RencanaStudyView(mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = {rencanaStudyViewModel.saveDataKRS(it)},
                onBackButtonClicked = {navController.popBackStack()},
                navController = navController
                )
        }
        composable(route = Halaman.Tampil.name) {
            TampilView(
                mahasiswa = mahasiswaUiState,
                krs = rencanaStudyViewModel.krsStateUi.collectAsState().value,
                onBackButtonClicked = { navController.popBackStack() },
                onNextButtonClicked = { navController.navigate(Halaman.Splahs.name) })
        }
    }
}