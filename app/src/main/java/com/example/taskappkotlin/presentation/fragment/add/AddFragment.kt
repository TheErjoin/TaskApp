package com.example.taskappkotlin.presentation.fragment.add

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BaseFragment
import com.example.domain.ShopItem
import com.example.taskappkotlin.databinding.FragmentAddBinding

class AddFragment : BaseFragment<FragmentAddBinding>(
    FragmentAddBinding::inflate
) {

    override fun setupListeners() {
        binding.btnAdd.setOnClickListener {
            addData()
        }
    }

    private fun addData() {
        if (binding.etCount.text.isNotEmpty() &&
            binding.etName.text.isNotEmpty() &&
            binding.etId.text.isNotEmpty()
        ) {
            findNavController().navigate(
                AddFragmentDirections.actionAddFragmentToMainFragment(
                    ShopItem(
                        binding.etName.text.toString(),
                        binding.etCount.text.toString().toInt(), false,
                        binding.etId.text.toString().toInt()
                    )
                )
            )
        } else {
            Toast.makeText(requireContext(), "Заполните поля:", Toast.LENGTH_SHORT).show()
        }
    }

}