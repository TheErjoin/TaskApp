package com.example.taskappkotlin.presentation.fragment.add

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.ShopItem
import com.example.taskappkotlin.App
import com.example.taskappkotlin.R
import com.example.taskappkotlin.databinding.ActivityAddBinding
import com.example.taskappkotlin.presentation.fragment.add.viewModel.AddViewModel
import com.example.taskappkotlin.presentation.fragment.add.viewModel.AddViewModelFactory
import javax.inject.Inject

class AddActivity : AppCompatActivity() {

    private val binding: ActivityAddBinding by viewBinding()

    //    private val viewModel: MainViewModel by viewModels()
    @Inject
    lateinit var vmFactory: AddViewModelFactory
    private lateinit var viewModel: AddViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        (applicationContext as App).shopComponent.injectAddActivity(this)
        viewModel = ViewModelProvider(this, vmFactory)
            .get(AddViewModel::class.java)
        binding.btnAdd.setOnClickListener {
            initListeners()
        }
    }

    private fun initListeners() {
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
            finish()
        } else {
            Toast.makeText(this, "Заполните поля:", Toast.LENGTH_SHORT).show()
        }
    }
}