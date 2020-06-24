package com.slavetny.therapists.presentation.screen.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.slavetny.cryptocurrencyrate.presentation.base.BaseFragment
import com.slavetny.therapists.R
import com.slavetny.therapists.TherapistsApp
import com.slavetny.therapists.domain.extension.isEmail
import com.slavetny.therapists.domain.extension.isPassword
import com.slavetny.therapists.presentation.navigation.Navigator
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<LoginViewModel>(R.layout.fragment_login) {

    override val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (TherapistsApp.getToken(requireContext()) != "empty") {
            Navigator.toTherapists(this)
        }

        frg_continue_btn.setOnClickListener {
            if (frg_email_field.text.toString().isEmail() && frg_password_field.text.toString().isPassword()) {
                viewModel.onAuthorize(requireContext(), frg_email_field.text.toString(), frg_password_field.text.toString())

                if (TherapistsApp.getToken(requireContext()) != "empty") {
                    Navigator.toTherapists(this)
                }
            } else {
                Toast.makeText(requireContext(), "Sorry, login data incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }
}