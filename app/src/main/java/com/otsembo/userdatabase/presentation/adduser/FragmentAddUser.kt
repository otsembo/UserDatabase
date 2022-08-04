package com.otsembo.userdatabase.presentation.adduser

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
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

        binding.btnStorage.setOnClickListener {
            // TODO: STORAGE PERMISSION
        }

        binding.btnSms.setOnClickListener {
            grantSMSPermission()
        }
    }

    private val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            isGranted: Boolean ->
        if (isGranted) {
            Snackbar.make(binding.root, "Permission already granted", Snackbar.LENGTH_LONG).show()
        } else {
            Snackbar.make(binding.root, "Permission was denied", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun grantSMSPermission() {
        when {
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED -> Unit

            shouldShowRequestPermissionRationale(Manifest.permission.READ_SMS) -> {
                Snackbar.make(binding.root, "We need to read your SMS's", Snackbar.LENGTH_LONG).show()
                permissionLauncher.launch(Manifest.permission.READ_SMS)
            }

            else -> {
                permissionLauncher.launch(Manifest.permission.READ_SMS)
            }
        }
    }

    companion object {
        const val SMS_PERMISSION = 3266
    }
}
