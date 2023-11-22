package com.example.lab9juanescalada.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab9juanescalada.data.LocalUser

@Composable
fun MainContent(usersState: UsersState) {
    val signupState = remember { SignupState() }

    val backgroundColor: Color = if (signupState.validEmail) {
        Color.Green
    } else {
        Color.Red
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        MyTextField("UID", signupState.uid, signupState.onUIDChange)
        MyTextField("Name", signupState.name, signupState.onNameChange)
        MyTextField("Email", signupState.email, signupState.onEmailChange)

        Row(modifier = Modifier.fillMaxWidth().padding(vertical=12.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                usersState.addUser(LocalUser(name=signupState.name, email=signupState.email))
            }) {
                Text(text = "Add", fontSize = 24.sp)
            }

            Button(onClick = {
                usersState.refresh()
            }) {
                Text(text = "Refresh", fontSize = 24.sp)
            }
        }

        Column(modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())) {
            usersState.users.forEach { user ->
                UserCard(user, usersState::deleteUser)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(title: String, value: String, onValueChanged: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)) {
        Text(text = title, fontSize = 16.sp)
        // value and onValueChange allow hoisting of state
        TextField(value = value, onValueChange = {
            onValueChanged(it)
        }, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun UserCard(user: LocalUser, deleteUserCallback: (Int) -> Unit = {}) {
    Card(shape = RoundedCornerShape(16.dp), modifier = Modifier.padding(4.dp).fillMaxWidth().padding(4.dp)) {
        Row(modifier = Modifier.padding(4.dp).fillMaxWidth().background(Color(0xFFE7D2EE)).padding(4.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            // Add rounded corners to the card

            Text(text = user.name, fontSize = 20.sp, modifier = Modifier.padding(top = 8.dp))
            Text(text = user.email, fontSize = 20.sp, modifier = Modifier.padding(top = 8.dp))
            IconButton(
                onClick = { deleteUserCallback(user.uid!!) }
            ) {
                Icon(
                    Icons.Rounded.Close,
                    contentDescription = "Close",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}