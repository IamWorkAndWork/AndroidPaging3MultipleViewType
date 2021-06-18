package app.practice.androidpaging3multipleviewtype.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import app.practice.androidpaging3multipleviewtype.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

@FlowPreview
@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    private val homeAdapter by lazy {
        HomeAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        initWidget()
        initListener()
    }

    private fun initListener() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            homeAdapter.refresh()
        }

        homeAdapter.addLoadStateListener {
            binding.swipeRefreshLayout.isRefreshing = it.refresh is LoadState.Loading
        }
    }

    private fun initWidget() {

        binding.shelfRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = homeAdapter
        }

    }

    private fun observeViewModel() = with(homeViewModel) {

        lifecycleScope.launchWhenCreated {
            showLoading.collect { isVisible ->
                binding.progressBar.isVisible = isVisible
            }
        }

        lifecycleScope.launchWhenCreated {
            loadDataEachShelf().collectLatest { itemResponsePagingData ->
                homeAdapter.submitData(pagingData = itemResponsePagingData)
            }
        }

    }

}