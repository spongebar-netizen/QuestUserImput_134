package com.example.pertemuan5
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp

@Composable

fun FormulirScreen(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf("") }
    var inputAlamat by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    var displayedNama by remember { mutableStateOf("") }
    var displayedAlamat by remember { mutableStateOf("") }
    var displayedGender by remember { mutableStateOf("") }

    val genderOptions = listOf("Laki-laki", "Perempuan")

    Column(modifier = modifier.padding(top = 50.dp),
        verticalArrangement =  Arrangement.Top,
        horizontalAlignment =  Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = modifier.width(width = 250.dp),
            label = { Text(text = "nama Lengkap") },
            onValueChange = {
                textNama = it
            }
        )

        )
    }