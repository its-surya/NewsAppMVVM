package com.example.newsappassignment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newsappassignment.adapters.NewsAdapter
import com.example.newsappassignment.api.NewsAPI
import com.example.newsappassignment.api.RetroFitHelper
import com.example.newsappassignment.databinding.FragmentHomeBinding
import com.example.newsappassignment.repository.NewsRepository
import com.example.newsappassignment.viewmodels.MainViewModel
import com.example.newsappassignment.viewmodels.MainViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentHomeBinding

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val newsApi = RetroFitHelper.getInstance().create(NewsAPI::class.java)

        val repository = NewsRepository(newsApi)
        mainViewModel = ViewModelProvider(this , MainViewModelFactory(repository)).get(MainViewModel::class.java)


        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewLifecycleOwner is used to observe the LiveData within the lifespan of the fragment
        mainViewModel.news.observe(viewLifecycleOwner, Observer {
            val newsAdapter = NewsAdapter(it.articles, requireContext())
            binding.recyclerViewNews.adapter = newsAdapter

            // Log.d("Harsh", it.articles.toString())
        })
    }

}