package com.example.praktikum7.ui.viewmodel

import com.example.praktikum7.model.RencanaStudy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RencanaStudyViewModel {
    private val _krsState = MutableStateFlow(RencanaStudy())
    val krsStateUi: StateFlow<RencanaStudy> = _krsState.asStateFlow()

    fun setMataKuliah(mkPilihan: String){
        _krsState.update { stateMK -> stateMK.copy(mataKuliah = mkPilihan) }
    }

    fun setKelas(kelasPilihan: String){
        _krsState.update { stateKelas -> stateKelas.copy(kelas = kelasPilihan) }
    }
}