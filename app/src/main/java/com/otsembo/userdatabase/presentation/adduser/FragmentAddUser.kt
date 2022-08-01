package com.otsembo.userdatabase.presentation.adduser

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.otsembo.userdatabase.R
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
        addUserVM = AddUserVM(db = AppDatabase.getDb(requireContext()))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = addUserVM
        binding.btnUserList.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_fragmentAddUser_to_fragmentUserList)
        }
    }
}
