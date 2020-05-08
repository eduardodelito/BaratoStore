package com.enaz.baratostore.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.enaz.baratostore.R
import com.enaz.baratostore.common.listener.CallbackListener
import com.enaz.baratostore.common.manager.FirebaseAuthenticationManager
import kotlinx.android.synthetic.main.login_dialog_layout.*

/**
 * Created by eduardo.delito on 5/7/20.
 */
class LoginOrRegisterDialog(
    private val firebaseAuthenticationManager: FirebaseAuthenticationManager,
    private val listener: CallbackListener
) :
    DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        isCancelable = false
        if (firebaseAuthenticationManager.isUserLogged()) dismiss()
        return inflater.inflate(R.layout.login_dialog_layout, container, false)
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login_btn.setOnClickListener {
            //send back data to PARENT fragment using callback
            // Now dismiss the fragment
            setViewVisibility(true)
            val userName = email_field.text.toString()
            val password = password_field.text.toString()
            firebaseAuthenticationManager.login(userName, password, ::onResult)
        }

        register_btn.setOnClickListener {
            //send back data to PARENT fragment using callback
            // Now dismiss the fragment
            setViewVisibility(true)
            val userName = email_field.text.toString()
            val password = password_field.text.toString()
            firebaseAuthenticationManager.register(userName, password, userName, ::onResult)
        }

        skip_btn.setOnClickListener { dismiss() }
    }

    private fun setViewVisibility(isLoadingVisible: Boolean) {
        if (isLoadingVisible) {
            loading_view.visibility = View.VISIBLE
            fields_card_view.visibility = View.GONE
            error_text_view.visibility = View.GONE
        } else {
            loading_view.visibility = View.GONE
            fields_card_view.visibility = View.VISIBLE
        }
    }

    private fun onResult(result: Boolean) {
        if (result) {
            dismiss()
            listener.updateAddMenu()
        } else {
            setViewVisibility(false)
            error_text_view.visibility = View.VISIBLE
        }
    }
}