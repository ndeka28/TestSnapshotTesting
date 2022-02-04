package com.nila.testshot

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.nila.testshot.databinding.LoginFragmentBinding
import javax.inject.Inject

@OpenForTesting
class LoginFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: LoginViewModel by viewModels { viewModelFactory }

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnLogin.setOnClickListener {
                viewModel.login()
            }

            viewModel.loginState.observe(viewLifecycleOwner) {
                when (it) {
                    true -> {
                        AlertDialog.Builder(requireContext())
                            .setMessage("Login Successful")
                            .setPositiveButton("Ok",
                                DialogInterface.OnClickListener { dialog, which ->
                                    // here you can add functions
                                    dialog.dismiss()
                                }).create().show()

                    }
                    false -> {
                        AlertDialog.Builder(requireContext())
                            .setMessage("Login Failed")
                            .setPositiveButton("Ok",
                                DialogInterface.OnClickListener { dialog, which ->
                                    // here you can add functions
                                    dialog.dismiss()
                                }).create().show()
                    }
                }
            }
        }
    }
}