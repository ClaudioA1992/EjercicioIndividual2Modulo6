package cl.awakelab.ejercicioindividual2modulo6.data

import androidx.lifecycle.LiveData
import cl.awakelab.ejercicioindividual2modulo6.data.local.Item
import cl.awakelab.ejercicioindividual2modulo6.data.local.ItemDao

class Repositorio(private val itemDao: ItemDao) {

    fun getItems(): LiveData<List<Item>> = itemDao.getAllItems()
    suspend fun addItem(item: Item) = itemDao.insertItem(item)

    suspend fun deleteAllItems() = itemDao.deleteAllItems()

}

