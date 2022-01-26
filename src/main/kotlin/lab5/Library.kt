package lab5

data class Book(val title: String, val authors: List<Author>, val genre: Genre, val year: Int)
data class Author(val name: String, val Surname: String)
data class User(val name: String, val Surname: String)

enum class Genre {
    HISTORY, FANTASY,
}

sealed class Status {
    object Available : Status()
    data class UsedBy(val user: User) : Status()
    object ComingSoon : Status()
    object Restoration : Status()
}

interface LibraryService {
    fun findBooks(substring: String): List<Book>
    fun findBooks(author: Author): List<Book>
    fun findBooks(year: Int): List<Book>
    fun findBooks(genre: Genre): List<Book>
    fun findBooks(substring: String?, author: Author?, year: Int?, genre: Genre?): List<Book>

    fun getAllBooks(): List<Book>
    fun getAllAvailableBooks(): List<Book>

    fun getBookStatus(book: Book): Status?
    fun getAllBookStatuses(): Map<Book, Status>

    fun setBookStatus(book: Book, status: Status)

    fun addBook(book: Book, status: Status = Status.Available)

    fun registerUser(user: User)
    fun unregisterUser(user: User)

    fun takeBook(user: User, book: Book)
    fun returnBook(book: Book)

    fun sendToRestoration(book: Book)
    fun comingSoon(book: Book)
}

const val maxNumOfBooks = 3

class Library : LibraryService {
    private var libraryBooks = mutableMapOf<Book, Status>()
    private var libraryUsers = mutableListOf<User>()


    override fun findBooks(substring: String): List<Book> {
        return libraryBooks.keys.filter { book -> book.title.contains(substring) }.toList()
    }

    override fun findBooks(author: Author): List<Book> {
        return libraryBooks.keys.filter { book -> book.authors.contains(author) }.toList()
    }

    override fun findBooks(genre: Genre): List<Book> {
        return libraryBooks.keys.filter { book -> book.genre == genre }.toList()
    }

    override fun findBooks(year: Int): List<Book> {
        return libraryBooks.keys.filter { book -> book.year == year }.toList()
    }

    override fun findBooks(substring: String?, author: Author?, year: Int?, genre: Genre?): List<Book> {
        return libraryBooks.keys.filter { book ->
            (substring == null || book.title.contains(substring) &&
                    (author == null || book.authors.contains(author)) &&
                    (year == null || book.year == year) &&
                    (genre == null || book.genre == genre)
                    )
        }.toList()
    }

    override fun getAllBooks(): List<Book> {
        return libraryBooks.keys.toList()
    }

    override fun getAllAvailableBooks(): List<Book> {
        return libraryBooks.filter { book -> book.value == Status.Available }.keys.toList()
    }

    override fun getBookStatus(book: Book): Status? {
        return libraryBooks[book]
    }

    override fun getAllBookStatuses(): Map<Book, Status> {
        return libraryBooks.toMap()
    }

    override fun setBookStatus(book: Book, status: Status) {
        if (!libraryBooks.contains(book))
            throw IllegalArgumentException("there is no such book")
        libraryBooks[book] = status
    }

    override fun addBook(book: Book, status: Status) {
        libraryBooks[book] = status
    }

    override fun registerUser(user: User) {
        if (libraryUsers.contains(user))
            throw IllegalArgumentException("this user is already exists")
        libraryUsers.plusAssign(user)
    }

    override fun returnBook(book: Book) {
        libraryBooks[book] = Status.Available
    }

    override fun takeBook(user: User, book: Book) {
        if (libraryBooks.keys.contains(book) && libraryUsers.contains(user)) {
            if (libraryBooks.filter { book -> book.value == Status.UsedBy(user) }.size < maxNumOfBooks && libraryBooks[book] == Status.Available) {
                libraryBooks[book] = Status.UsedBy(user)
            } else
                throw IllegalArgumentException("user has on his hands 3 or more books or book isn't available")
        } else
            throw IllegalArgumentException("there is no book or user")

    }

    override fun unregisterUser(user: User) {
        if (!libraryUsers.contains(user))
            throw IllegalArgumentException("there is no such user")
        for (el in libraryBooks)
            if (el.value == Status.UsedBy(user))
                libraryBooks[el.key] = Status.Available
        libraryUsers.remove(user)

    }

    override fun sendToRestoration(book: Book) {
        if (libraryBooks.keys.contains(book)) {
            if (libraryBooks[book] == Status.Available)
                libraryBooks[book] = Status.Restoration
            else
                throw IllegalArgumentException("book isn't available")
        } else
            throw IllegalArgumentException("there is no book")
    }

    override fun comingSoon(book: Book) {
        libraryBooks[book] = Status.ComingSoon
    }
}