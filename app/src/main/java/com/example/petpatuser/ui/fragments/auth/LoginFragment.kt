package com.example.petpatuser.ui.fragments.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.petpatuser.R
import com.example.petpatuser.databinding.FragmentLoginBinding
import com.example.petpatuser.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLogIn.setOnClickListener {
            userLogin()
        }
    }

    private fun userLogin() {
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val password = binding.etPassword.text.toString()
        viewModel.login(phoneNumber, password)

        /*viewModel.login(phoneNumber, password)
            .observe(this, { result ->
                when (result) {
                    is LoginResult.Success -> {
                        // Handle successful login response
                        val loginResponse = result.data
                    }

                    is LoginResult.Error -> {
                        // Handle login error
                        val errorMessage = result.message
                    }
                }
            })*/
    }

    private fun observeLoginResult() {

    }
}