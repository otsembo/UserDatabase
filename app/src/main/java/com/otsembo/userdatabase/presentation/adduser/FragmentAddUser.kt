package com.otsembo.userdatabase.presentation.adduser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.otsembo.userdatabase.databinding.FragmentAddUserBinding
import com.otsembo.userdatabase.db.AppDatabase

class FragmentAddUser : Fragment() {

    private lateinit var binding: FragmentAddUserBinding
    private lateinit var addUserVM: AddUserVM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddUserBinding.inflate(inflater, container, false)
//        val db = AppDatabase.getDb(requireActivity())
//        addUserVM = AddUserVM(db)
//        binding.viewmodel = addUserVM
//        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}
