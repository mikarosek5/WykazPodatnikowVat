package database.converters

import androidx.room.TypeConverter
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime

internal class DataConverter {
    @TypeConverter
    fun fromLocalDateToString(date: LocalDate?):String? = date.toString()

    @TypeConverter
    fun fromStringToLocalDate(stringDate: String?):LocalDate? = LocalDate.parse(stringDate)

    @TypeConverter
    fun fromLocalDateTimeToString(date: LocalDateTime?):String? = date.toString()

    @TypeConverter
    fun fromStringToLocalDateTime(stringDate: String?):LocalDateTime? = LocalDateTime.parse(stringDate)
}