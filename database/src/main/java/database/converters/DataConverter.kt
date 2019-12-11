package database.converters

import androidx.room.TypeConverter
import org.threeten.bp.LocalDate

internal class DataConverter {
    @TypeConverter
    fun fromLocalDateToString(date: LocalDate?) = date.toString()

    @TypeConverter
    fun fromStringToLocalDate(stringDate: String?) = LocalDate.parse(stringDate)
}