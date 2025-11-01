package com.example.pertemuan5 // Sesuaikan dengan nama package Anda

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan5.ui.theme.Pertemuan5Theme

@Composable
fun FormulirScreen(modifier: Modifier = Modifier) {
    var namaLengkap by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var displayedNama by remember { mutableStateOf("") }
    var displayedJenisKelamin by remember { mutableStateOf("") }
    var displayedStatus by remember { mutableStateOf("") }
    var displayedAlamat by remember { mutableStateOf("") }
    val listJenisKelamin = listOf("Laki-laki", "Perempuan")
    val listStatusPerkawinan = listOf("Janda", "Lajang", "Duda")
    val headerColor = Color(0xFF6A00EE)
    val backgroundColor = Color(0xFFF0E6FF)

    Surface(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding(),
        color = backgroundColor
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(headerColor)
                    .padding(vertical = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Formulir Pendaftaran",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .verticalScroll(rememberScrollState())
                ) {

                    Text(text = "NAMA LENGKAP", style = MaterialTheme.typography.labelMedium, color = Color.Gray)
                    OutlinedTextField(
                        value = namaLengkap,
                        onValueChange = { namaLengkap = it },
                        label = { Text("Isian nama lengkap") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(24.dp))

                    Text(text = "JENIS KELAMIN", style = MaterialTheme.typography.labelMedium, color = Color.Gray)
                    Column(Modifier.fillMaxWidth()) {
                        listJenisKelamin.forEach { option ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .selectable(
                                        selected = (jenisKelamin == option),
                                        onClick = { jenisKelamin = option }
                                    )
                                    .padding(vertical = 4.dp)
                            ) {
                                RadioButton(
                                    selected = (jenisKelamin == option),
                                    onClick = { jenisKelamin = option }
                                )
                                Text(text = option, modifier = Modifier.padding(start = 8.dp))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))

                    Text(text = "STATUS PERKAWINAN", style = MaterialTheme.typography.labelMedium, color = Color.Gray)
                    Column(Modifier.fillMaxWidth()) {
                        listStatusPerkawinan.forEach { option ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .selectable(
                                        selected = (statusPerkawinan == option),
                                        onClick = { statusPerkawinan = option }
                                    )
                                    .padding(vertical = 4.dp)
                            ) {
                                RadioButton(
                                    selected = (statusPerkawinan == option),
                                    onClick = { statusPerkawinan = option }
                                )
                                Text(text = option, modifier = Modifier.padding(start = 8.dp))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))

                    Text(text = "ALAMAT", style = MaterialTheme.typography.labelMedium, color = Color.Gray)
                    OutlinedTextField(
                        value = alamat,
                        onValueChange = { alamat = it },
                        label = { Text("Alamat") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = {
                            displayedNama = namaLengkap
                            displayedJenisKelamin = jenisKelamin
                            displayedStatus = statusPerkawinan
                            displayedAlamat = alamat
                            // -----------------------------
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = headerColor)
                    ) {
                        Text(text = "Submit")
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Nama : $displayedNama",
                                color = Color.White
                            )
                            Text(
                                text = "Jenis Kelamin : $displayedJenisKelamin",
                                color = Color.White
                            )
                            Text(
                                text = "Status : $displayedStatus",
                                color = Color.White
                            )
                            Text(
                                text = "Alamat : $displayedAlamat",
                                color = Color.White
                            )
                        }
                    }

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FormulirPendaftaranPreview() {
    Pertemuan5Theme {
        FormulirScreen()
    }
}