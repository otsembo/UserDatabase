package com.otsembo.userdatabase.presentation.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.otsembo.userdatabase.databinding.FragmentUserListBinding

class FragmentUserList : Fragment() {

    private lateinit var binding: FragmentUserListBinding

    // TODO 2: Create the ViewModel object

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }
}
