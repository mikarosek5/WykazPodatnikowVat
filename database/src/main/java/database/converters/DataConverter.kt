package database.converters

import androidx.room.TypeConverter
import org.threeten.bp.LocalDate

internal class DataConverter {
    @TypeConverter
    fun fromLocalDateToString(date: LocalDate?):String? = date.toString()

    @TypeConverter
    fun fromStringToLocalDate(stringDate: String?):LocalDate? = LocalDate.parse(stringDate)
}