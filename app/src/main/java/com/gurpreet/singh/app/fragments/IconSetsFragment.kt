package com.gurpreet.singh.app.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gurpreet.singh.app.R
import com.gurpreet.singh.app.adapter.IconSetAdapter
import com.gurpreet.singh.app.data.ServerResponse
import com.gurpreet.singh.app.databinding.FragmentIconSetsBinding
import com.gurpreet.singh.app.network.IconsApi
import com.gurpreet.singh.app.viewmodel.IconSetsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class IconSetsFragment : Fragment() {
    private lateinit var viewModel: IconSetsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val adapter = IconSetAdapter(IconSetAdapter.IconSetClickListener { iconSet ->

            Toast.makeText(context, "${iconSet}", Toast.LENGTH_SHORT).show()
            findNavController().navigate(IconSetsFragmentDirections
                .actionIconSetsFragmentToIconSetDetailsFragment(iconSet))
        })


        val binding: FragmentIconSetsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_icon_sets, container, false)

        binding.iconSetsRecyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(IconSetsViewModel::class.java)

        viewModel.iconSetList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
            viewModel.isLoading = false
            binding.progressBar.visibility = View.GONE
        })

        binding.iconSetsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    var visibleItemCount = recyclerView.getLayoutManager()?.getChildCount()
                    var totalItemCount = recyclerView.getLayoutManager()?.getItemCount() ?: 0
                    var pastVisiblesItems =
                        (recyclerView.getLayoutManager() as LinearLayoutManager).findFirstVisibleItemPosition()

                    if (visibleItemCount != null) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount && !viewModel.isLoading) {
                            viewModel.isLoading = true
                            binding.progressBar.visibility = View.VISIBLE

                            viewModel.getIconsData(viewModel.itemPerPage, viewModel.lastId)
                        }
                    }
                }
            }
        })

        return binding.root
    }


}