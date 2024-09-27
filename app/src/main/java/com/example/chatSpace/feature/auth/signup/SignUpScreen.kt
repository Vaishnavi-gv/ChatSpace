package com.example.chatSpace.feature.auth.signup

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chatspace.R

@Composable
fun SignUpScreen(navController: NavController){

    val viewModel:SignUpViewModel= hiltViewModel()
    val uiState=viewModel.state.collectAsState()

        var name by remember {
            mutableStateOf("")
        }
        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        var confirmPassword by remember {
            mutableStateOf("")
        }

    val context= LocalContext.current
    LaunchedEffect(key1 = uiState.value){
        when(uiState.value){
            is SignUpState.Success->{
                navController.navigate("home")
            }
            is SignUpState.Error->{
                Toast.makeText(context,"Sign Up Failed!",Toast.LENGTH_LONG).show()
            }
            else->{}
        }
    }

        Scaffold (modifier = Modifier.fillMaxSize()){
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(16.dp)
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Image(
                    painter = painterResource(id = R.drawable.chattag),
                    contentDescription = "chatApp",
                    modifier = Modifier
                        .size(200.dp)
                        .background(Color.White)
                )

                Text("Chatspace", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Text(
                    " M  E  S  S  A  G  I  N  G ",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                )
                OutlinedTextField(value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Name") }
                )

                OutlinedTextField(value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Email") }
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Password") },
                    visualTransformation = PasswordVisualTransformation()
                )

                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "ConfirmPassword") },
                    isError = password.isNotEmpty() && confirmPassword.isNotEmpty() && password != confirmPassword
                )
                Spacer(modifier = Modifier.size(16.dp))

                if (uiState.value == SignUpState.Loading) {
                    CircularProgressIndicator()
                } else {
                    Button(
                        onClick = { viewModel.signUp(name, email, password) },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && password == confirmPassword
                    ) {
                        Text(text = "Sign Up")
                    }

                    TextButton(onClick = { navController.popBackStack() }) {
                        Text(text = "Already have an account? Signin")
                    }
                }
            }

        }
    }

@Preview(showBackground=true)
@Composable
fun PreviewSignUpScreen(){
    SignUpScreen(navController = rememberNavController())
}