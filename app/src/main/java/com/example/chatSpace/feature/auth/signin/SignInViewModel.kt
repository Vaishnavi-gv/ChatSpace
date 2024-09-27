package com.example.chatSpace.feature.auth.signin

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor():ViewModel() {

    private val _state= MutableStateFlow<SignInState>(SignInState.Nothing) //this is altered only inside class
    val state=_state.asStateFlow()

    fun signIn(email:String,password:String){

        _state.value= SignInState.Loading

        //firebase sign in
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(){
                task->
                if(task.isSuccessful){
                    task.result.user?.let {
                        _state.value=SignInState.Success
                        return@addOnCompleteListener
                    }
                    _state.value=SignInState.Error
                }
                else{
                    _state.value=SignInState.Error
                }
            }
    }
}
//these are different states that are showing on ui
sealed class SignInState{
    object Nothing: SignInState()
    object Loading :SignInState()
    object Success :SignInState()
    object Error:SignInState()
}