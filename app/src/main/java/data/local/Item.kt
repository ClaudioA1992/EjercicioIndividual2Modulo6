package data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_item")
class Item(val nombre:String, val precio:Int, val cantidad:Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

}