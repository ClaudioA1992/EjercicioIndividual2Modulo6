package data

import androidx.lifecycle.LiveData
import cl.awakelab.ejercicioindividual2modulo6.data.local.Item
import cl.awakelab.ejercicioindividual2modulo6.data.local.ItemDao

class Repository(private val itemDao: ItemDao) {

    suspend fun insertItem(item: Item) {
        itemDao.insertItem(item)
    }

    fun getAllItems(): LiveData<List<Item>> {
        return itemDao.getAllItems()
    }

}