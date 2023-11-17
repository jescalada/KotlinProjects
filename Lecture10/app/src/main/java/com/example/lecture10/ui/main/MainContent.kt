package com.example.lecture10.ui.main

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.lecture10.data.LocalUser

@Composable
fun MainContent(usersState: UsersState) {
    val signupState = remember { SignupState() }

    val backgroundColor: Color = if (signupState.validEmail) {
        Color.Green
    } else {
        Color.Red
    }

    Column(modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())) {
        MyTextField(signupState.name, signupState.onNameChange)
        MyTextField(signupState.email, signupState.onEmailChange)
        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            usersState.addUser(LocalUser(name=signupState.name, email=signupState.email))
        }) {
            Text(text = "Add User", fontSize = 24.sp)
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            usersState.refresh()
        }) {
            Text(text = "Refresh", fontSize = 24.sp)
        }

        usersState.users.forEach { user ->
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = user.name, fontSize = 24.sp)
                Text(text = user.email, fontSize = 24.sp)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(value: String, onValueChanged: (String) -> Unit) {
    // value and onValueChange allow hoisting of state
    TextField(value = value, onValueChange ={
        onValueChanged(it)
    }, modifier = Modifier.fillMaxWidth())
}