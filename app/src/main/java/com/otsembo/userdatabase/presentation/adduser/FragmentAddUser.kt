package com.otsembo.userdatabase.presentation.adduser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.otsembo.userdatabase.databinding.FragmentAddUserBinding

class FragmentAddUser : Fragment() {

    private lateinit var binding: FragmentAddUserBinding
    private val addUserVM : AddUserVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddUserBinding.inflate(inflater, container, false)
        return binding.root
    }

}
