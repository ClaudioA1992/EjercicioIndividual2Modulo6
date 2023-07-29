package data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {

    @Insert
    suspend fun insertItem(item: Item)

    @Query("select * from table_item")
    fun getAllItems(): LiveData<List<Item>>

}