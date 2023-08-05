package cl.awakelab.ejercicioindividual2modulo6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import cl.awakelab.ejercicioindividual2modulo6.databinding.FragmentListBinding
import cl.awakelab.ejercicioindividual2modulo6.presentation.ItemAdapter
import cl.awakelab.ejercicioindividual2modulo6.presentation.ItemViewModel
import kotlinx.coroutines.launch

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    private val itemViewModel: ItemViewModel by activityViewModels()
    private var adapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        initList()
        initListeners()
        return binding.root
    }

    private fun initList() {
        adapter = ItemAdapter()
        itemViewModel.getAllItems().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
        binding.recyclerView.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstancesState: Bundle?) {
        super.onViewCreated(view, savedInstancesState)
    }

    private fun initListeners() {
        binding.floatingActionButtonDelete.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {itemViewModel.deleteAllItems()}
        }
        binding.floatingActionButtonBack.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }

}

