package com.example.praktikum7.ui.view.screen

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum7.R
import com.example.praktikum7.model.Mahasiswa
import com.example.praktikum7.model.RencanaStudy

@Composable
fun TampilView(
    mahasiswa: Mahasiswa,
    krs: RencanaStudy,
    onBackButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Data Mahasiswa",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White
            )
        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(15.dp)
            )
            .padding(16.dp)){
            
            Column {
                Text(text = "Informasi Mahasiswa", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "NIM: "+ mahasiswa.nim)
                Text(text = "Nama: "+ mahasiswa.nama)
                Text(text = "Email: "+ mahasiswa.email)
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(text = "Rencana Studi", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Matkul: " + krs.mataKuliah)
                Text(text = "Kelas: " + krs.kelas)
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(onClick = { onBackButtonClicked() }) {
                Text(text = "Kembali")
                
            }
            Button(onClick = { onNextButtonClicked() }) {
                Text(text = "Lanjut")
                
            }
            
        }

    }
}