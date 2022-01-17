package lab5

fun main() {
    val author1 = Author("artur" , "melnik")
    val list1 = mutableListOf<Author>(author1)
    val book1 = Book("harry potter" , list1 , Genre.FANTASY , 1997)
    val user1 = User("petter" , "parker")

    val author2 = Author("MR" , "BOB")
    val list2 = mutableListOf<Author>(author2)
    val book2 = Book("History of MR. BOB" , list2 , Genre.HISTORY , 0)
    val user2 = User("Pavel" , "2")

    val booksToConstructor = mapOf<Book , Status>(book1 to Status.Available , book2 to Status.Available)
    val usersToConstructor = listOf<User>(user1 , user2)
    val library1 = Library(booksToConstructor , usersToConstructor)
    val findBooks = library1.findBooks(0)
    println("1. year = $findBooks")

    val author3 = Author("Artem" , "Bodrov")
    val list3 = mutableListOf<Author>(author3)
    val book3 = Book("Bro" , list3 , Genre.HISTORY , 1997)
    library1.addBook(book3 , Status.UsedBy(user1))
    val findBooks2 = library1.findBooks(Genre.HISTORY)
    println("2. History genre = $findBooks2")

    println("3. All books = ${library1.getAllBookStatuses()}")

}