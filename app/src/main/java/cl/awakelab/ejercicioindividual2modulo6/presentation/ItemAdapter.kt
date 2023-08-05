package cl.awakelab.ejercicioindividual2modulo6.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.ejercicioindividual2modulo6.databinding.ItemBinding
import cl.awakelab.ejercicioindividual2modulo6.data.local.Item

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    lateinit var binding: ItemBinding
    private val listItem = mutableListOf<Item>()

    class ItemViewHolder(val view: ItemBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: Item) {
            view.tvName.text = item.nombre
            view.tvPrecio.text = "Precio: " + item.precio.toString()
            view.tvCantidad.text = "Cantidad: " + item.cantidad.toString()
            view.tvTotal.text = "Total: " + (item.precio * item.cantidad).toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listItem[position]
        holder.bind(item)
    }

    fun setData(itemList: List<Item>) {
        this.listItem.clear()
        this.listItem.addAll(itemList)
        notifyDataSetChanged()
    }

}

