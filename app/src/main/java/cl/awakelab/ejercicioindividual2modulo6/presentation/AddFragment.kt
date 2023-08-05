package cl.awakelab.ejercicioindividual2modulo6.presentation

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import cl.awakelab.ejercicioindividual2modulo6.R
import cl.awakelab.ejercicioindividual2modulo6.data.Repositorio
import cl.awakelab.ejercicioindividual2modulo6.databinding.FragmentAddBinding
import cl.awakelab.ejercicioindividual2modulo6.data.local.Item
import cl.awakelab.ejercicioindividual2modulo6.data.local.ItemDao
import cl.awakelab.ejercicioindividual2modulo6.data.local.ItemDatabase

class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding
    private val itemViewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        initAll()
        return binding.root
    }

    private fun initListeners() {
        binding.buttonAdd.setOnClickListener {
            var name = binding.editTextName.text.toString()
            var price = binding.editTextPrice.text.toString().toInt()
            var quantity = binding.editTextQuantity.text.toString().toInt()
            itemViewModel.insertItem(name, price, quantity)
            Toast.makeText(requireContext(), "Item agregado", Toast.LENGTH_SHORT).show()
        }
        binding.floatingActionButtonList.setOnClickListener {
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
    }

    fun initAll() {
        initListeners()
        totalPrice()
    }

    fun totalPrice() {
        itemViewModel.getAllItems().observe(viewLifecycleOwner) {
            var items = mutableListOf<Item>()
            var total = 0
            items = it.toMutableList()
            if(items.size > 0) {
                for(item in items) {
                    total = total + (item.precio * item.cantidad)
                    println("Total inside " + total)
                }
            }
            binding.textViewTotalPrice.text = "Precio total: " + total
        }

    }

}

