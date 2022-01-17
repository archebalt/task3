package lab5

import kotlin.collections.Map as Mapof

data class Book(val title : String , val authors : List<Author> , val genre : Genre , val year : Int)
data class Author(val name : String , val Surname : String)
data class User(val name : String , val Surname : String)

enum class Genre {
    HISTORY , FANTASY ,
}

sealed class Status {
    object Available : Status()
    data class UsedBy(val user : User) : Status()
    object ComingSoon : Status()
    object Restoration : Status()
}

interface LibraryService {
    fun findBooks(substring : String) : List<Book>
    fun findBooks(author : Author) : List<Book>
    fun findBooks(year : Int) : List<Book>
    fun findBooks(genre : Genre) : List<Book>

    fun getAllBooks() : List<Book>
    fun getAllAvailableBooks() : List<Book>

    fun getBookStatus(book : Book) : Status
    fun getAllBookStatuses() : Mapof<Book , Status>

    fun setBookStatus(book : Book , status : Status)

    fun addBook(book : Book , status : Status = Status.Available)

    fun registerUser(user : User)
    fun returnBook(book : Book)
}



class Library(books : Mapof<Book , Status> , users : List<User>) : LibraryService {
    private var libraryBooks = mutableMapOf<Book , Status>()
    private var libraryUsers = mutableListOf<User>()

    init {
        libraryBooks.plusAssign(books)
        libraryUsers.plusAssign(users)
    }

    override fun findBooks(substring : String) : List<Book> {
        return libraryBooks.keys.filter { book -> book.title.contains(substring) }.toList()
    }

    override fun findBooks(author : Author) : List<Book> {
        return libraryBooks.keys.filter { book -> book.authors.contains(author) }.toList()
    }

    override fun findBooks(genre : Genre) : List<Book> {
        return libraryBooks.keys.filter { book -> book.genre == genre }.toList()
    }

    override fun findBooks(year : Int) : List<Book> {
        return libraryBooks.keys.filter { book -> book.year == year }.toList()
    }

    override fun getAllBooks() : List<Book> {
        return libraryBooks.keys.toList()
    }

    override fun getAllAvailableBooks() : List<Book> {
        return libraryBooks.filter { book -> book.value == Status.Available }.keys.toList()
    }

    override fun getBookStatus(book : Book) : Status {
        return libraryBooks.getValue(book)
    }

    override fun getAllBookStatuses() : Mapof<Book , Status> {
        return libraryBooks
    }

    override fun setBookStatus(book : Book , status : Status) {
        if (!libraryBooks.contains(book))
            throw Exception("there is no such book")
        libraryBooks[book] = status
    }

    override fun addBook(book : Book , status : Status) {
        libraryBooks[book] = status
    }

    override fun registerUser(user : User) {
        if (libraryUsers.contains(user))
            throw Exception("this user is already exists")
        libraryUsers.plusAssign(user)
    }

    override fun returnBook(book : Book) {
        libraryBooks[book] = Status.Available
    }
}