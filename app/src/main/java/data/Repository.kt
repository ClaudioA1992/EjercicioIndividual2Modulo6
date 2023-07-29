package data

import androidx.lifecycle.LiveData
import data.local.Item
import data.local.ItemDao

class Repository(private val itemDao: ItemDao) {

    suspend fun insertItem(item: Item) {
        itemDao.insertItem(item)
    }

    fun getAllItems(): LiveData<List<Item>> {
        return itemDao.getAllItems()
    }

}