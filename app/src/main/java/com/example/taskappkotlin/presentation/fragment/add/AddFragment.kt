package com.example.taskappkotlin.presentation.fragment.add

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BaseFragment
import com.example.domain.ShopItem
import com.example.taskappkotlin.databinding.FragmentAddBinding
import com.example.taskappkotlin.presentation.fragment.add.viewModel.AddViewModel
import com.example.taskappkotlin.presentation.fragment.add.viewModel.AddViewModelFactory
import com.example.taskappkotlin.shopComponent
import javax.inject.Inject

class AddFragment : BaseFragment<FragmentAddBinding>(
    FragmentAddBinding::inflate
) {

    private val viewModel: AddViewModel by lazy {
        ViewModelProvider(requireActivity(), vmFactory)
            .get(AddViewModel::class.java)
    }

    @Inject
    lateinit var vmFactory: AddViewModelFactory

    override fun onAttach(context: Context) {
        context.shopComponent.inject(this)
        super.onAttach(context)
    }

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
            viewModel.addShopItem(
                ShopItem(
                    binding.etName.text.toString(),
                    binding.etCount.text.toString().toInt(), false,
                    binding.etId.text.toString().toInt()
                )
            )
            findNavController().navigateUp()
        } else {
            Toast.makeText(requireContext(), "Заполните поля:", Toast.LENGTH_SHORT).show()
        }
    }

}