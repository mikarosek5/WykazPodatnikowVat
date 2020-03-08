package database

import database.entity.*
import org.threeten.bp.LocalDateTime

val taxPayer = TaxPayer("1", LocalDateTime.now())
val taxPayer2 = TaxPayer("2", LocalDateTime.now().plusSeconds(10))
val subject = Subject(
    "55555",
    "111",
    "222",
    "999",
    "321",
    "123:321",
    "aaaaaa",
    "bbbbbbb",
    "ccccc",
    "asdasd",
    "sdgfdfsgfd",
    "sdfsdfsdf",
    "sdfsdf",
    "sdfsdf",
    false,
    "1"
)
val subject2 = Subject(
    "1234321",
    "111",
    "222",
    "999",
    "321",
    "123:321",
    "aaaaaa",
    "bbbbbbb",
    "ccccc",
    "asdasd",
    "sdgfdfsgfd",
    "sdfsdfsdf",
    "sdfsdf",
    "sdfsdf",
    false,
    "1"
)
val partner = Partner("111", "adamowo", "abc", "gggg", null, "55555")
val partner2 = Partner("222", "michalowo", "abasdc", "gffgg", "12334", "1234321")

val representative = Representative("1234", "iksde", "bekol", null, "111111", "1234321")
val representative2 =
    Representative("4321", "policja", null, null, "0000000", "1234321")
val representative3 =
    Representative("1111", "kurnik", "kogut", "kurzy", "44444", "1234321")

val authorizedClerk = AuthorizedClerk("1234", "", "", "", "", "1234321")
val authorizedClerk2 = AuthorizedClerk("4321", "", "", "", "", "1234321")
val authorizedClerk3 = AuthorizedClerk("5555", "", "", "", "", "1234321")

val bankAccountNumber = BankAccountNumber("1234", "55555")
val bankAccountNumber2 = BankAccountNumber("4321", "1234321")
val bankAccountNumber3 = BankAccountNumber("2222", "1234321")
val bankAccountNumber4 = BankAccountNumber("1111", "1234321")