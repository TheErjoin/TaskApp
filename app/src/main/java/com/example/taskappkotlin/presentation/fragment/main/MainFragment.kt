package com.example.taskappkotlin.presentation.fragment.main

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core_ui.base.BaseFragment
import com.example.taskappkotlin.R
import com.example.taskappkotlin.databinding.FragmentMainBinding
import com.example.taskappkotlin.presentation.fragment.main.viewModel.MainViewModel
import com.example.taskappkotlin.presentation.fragment.main.viewModel.MainViewModelFactory
import com.example.taskappkotlin.shopComponent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding>(
    FragmentMainBinding::inflate
) {

    private val adapter: MainAdapter by lazy {
        MainAdapter()
    }
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity(), vmFactory)
            .get(MainViewModel::class.java)
    }

    @Inject
    lateinit var vmFactory: MainViewModelFactory

    override fun onAttach(context: Context) {
        context.shopComponent.inject(this)
        super.onAttach(context)
    }

    override fun initialize() {
        initRecycler()
    }

    private fun initRecycler() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@MainFragment.adapter
        }
        setupSwipeListeners(binding.recycler)
    }

    private fun setupSwipeListeners(rv: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = adapter.currentList[viewHolder.absoluteAdapterPosition]
                viewModel.deleteShopItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rv)
    }

    override fun setupObservers() {
        lifecycleScope.launch {
            viewModel.getShopList.collectLatest {
                adapter.submitList(it)
            }
        }
    }

    override fun setupListeners() {
        adapter.onShopItemLongClickListener = {
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
        }
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addFragment)
        }
    }
}