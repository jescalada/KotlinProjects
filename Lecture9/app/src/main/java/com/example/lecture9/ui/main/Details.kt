package com.example.lecture9.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lecture9.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetails() {
    Details("Yoda", R.drawable.yoda)
}

@Composable
fun Details(name: String?, imageId: Int?) {
    Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        Text(
            text = "$name",
            fontSize = 30.sp,
            modifier = androidx.compose.ui.Modifier
                .align(alignment = androidx.compose.ui.Alignment.CenterHorizontally)
        )
        Image(
            painter = painterResource(id = imageId!!),
            contentDescription = "Yoda",
            modifier = androidx.compose.ui.Modifier
                .height(300.dp)
                .width(300.dp)
                .align(alignment = androidx.compose.ui.Alignment.CenterHorizontally)
        )
    }
}