package com.slavetny.therapists.presentation.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.slavetny.therapists.R

object Navigator {

    fun toTherapists(component: Fragment) {
        navigateTo(component, R.id.action_loginFragment_to_therapistsFragment)
    }

    private fun navigateTo(component: Fragment, action: Int, bundle: Bundle? = null) {
        val controller = NavHostFragment.findNavController(component)
        controller.navigate(action, bundle)
    }
}