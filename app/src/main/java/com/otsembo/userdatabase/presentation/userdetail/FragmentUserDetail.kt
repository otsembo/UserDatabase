package com.otsembo.userdatabase.presentation.userdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.otsembo.userdatabase.databinding.FragmentUserDetailBinding

class FragmentUserDetail : Fragment() {

    private lateinit var binding: FragmentUserDetailBinding
    private val userDetailVM : UserDetailVM by viewModels()
    // TODO: COMPLETE THE USERDETAILS PAGE

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

}