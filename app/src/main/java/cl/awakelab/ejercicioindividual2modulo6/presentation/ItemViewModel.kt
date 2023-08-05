package cl.awakelab.ejercicioindividual2modulo6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.awakelab.ejercicioindividual2modulo6.data.Repositorio
import cl.awakelab.ejercicioindividual2modulo6.data.local.Item
import cl.awakelab.ejercicioindividual2modulo6.data.local.ItemDatabase
import data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ItemViewModel(application: Application): AndroidViewModel(application){

    private val repository: Repositorio

    init {
        val dao = ItemDatabase.getDatabase(application).getItemsDao()
        repository = Repositorio(dao)
    }

    fun getAllItems(): LiveData<List<Item>> = repository.getItems()

    fun insertItem(name: String, price: Int, quantity: Int) = viewModelScope.launch {
        val item = Item(name, price, quantity)
        repository.addItem(item)
    }

    suspend fun deleteAllItems() {
        repository.deleteAllItems()
    }

}

