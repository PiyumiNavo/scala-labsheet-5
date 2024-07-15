@main def main() = {
    val library:Set[BookRecord] = Set(
        BookRecord("Harry Potter","JK Rowling","1235"),
        BookRecord("Percy Jackson","Rick Riordan","5647"),
        BookRecord("Sherlock Holmes", "Arthur Conan Doyle","12389")
    )

    val book1 = BookRecord("abc","cvb","123")

    var newLib = addBook(library,book1)
    println(newLib)
    var newLib2 = removeBook(library,"1235")
    println(newLib2)
    findBook(newLib2,"1235")
    var lib = displayLibrary(library)
}

case class BookRecord(title:String,author:String,isbn:String)

def addBook(library:Set[BookRecord], book:BookRecord): Set[BookRecord] = {
    val updatedLibrary = library + book
    println("Added book successfully")
    updatedLibrary
}

def removeBook(library:Set[BookRecord],isbn:String): Set[BookRecord] = {
    if (library.size == 0){
        println("Book does not exist")
        library
    }else if(library.head.isbn == isbn){
        val updatedLibrary = library - library.head
        println("Removed book successfully")
        updatedLibrary
    } else {
        removeBook(library.tail,isbn)
    }
    
}


def findBook(library:Set[BookRecord],isbn:String):Unit = {
    if(library.size == 0){
        println("Book does not exist")
    }
    else if(library.head.isbn == isbn){
        println("Book exists")
    } else {
        findBook(library.tail,isbn)
    }
}


def displayLibrary(library:Set[BookRecord]): Unit = 
    library match {
        case a if a.isEmpty =>
        case _ =>{
            printf("%s | %s | %s\n",library.head.title,library.head.author, library.head.isbn)
            displayLibrary(library.tail)
            }
    }

def searchBook(library:Set[BookRecord],title:String): Unit =
    library match {
        case a if a.isEmpty => println("Not found")
        case a if a.head.title == title => printf("%s | %s | %s\n",library.head.title,library.head.author, library.head.isbn)
        case _ => searchBook(library.tail, title)
    }

def authorBooks(library:Set[BookRecord],author:String): Unit = 
    library match {
        case a if a.isEmpty =>
        case a if a.head.author == author => {
            printf("%s | %s | %s\n",library.head.title,library.head.author, library.head.isbn)
            authorBooks(library.tail, author)
        }
        case _ => authorBooks(library.tail, author)
    }