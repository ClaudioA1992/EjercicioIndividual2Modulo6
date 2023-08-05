package cl.awakelab.ejercicioindividual2modulo6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {

    @Insert
    suspend fun insertItem(item: Item)

    @Query("select * from table_item order by id")
    fun getAllItems(): LiveData<List<Item>>

    @Query("delete from table_item")
    suspend fun deleteAllItems()

}

