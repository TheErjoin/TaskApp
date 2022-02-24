package com.example.taskappkotlin.presentation.add

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.taskappkotlin.R
import com.example.taskappkotlin.databinding.ActivityAddBinding
import com.example.taskappkotlin.domain.ShopItem
import com.example.taskappkotlin.presentation.main.MainViewModel

class AddActivity : AppCompatActivity() {

    private val binding: ActivityAddBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        binding.btnAdd.setOnClickListener {
            initListeners()
        }
    }

    private fun initListeners() {
        if (binding.etCount.text.isNotEmpty() &&
            binding.etName.text.isNotEmpty()
        ) {
            viewModel.addShopItem(
                ShopItem(
                    binding.etName.text.toString(),
                    Integer.parseInt(binding.etCount.text.toString()),
                    false, 1
                )
            )
            finish()
        } else {
            Toast.makeText(this, "Заполните поля:", Toast.LENGTH_SHORT).show()
        }
    }
}