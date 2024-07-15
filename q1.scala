import scala.io.StdIn.readLine

@main def main() = {
    val list = getProductList(List())
    printProductList(list)
    println(s"Total No. of Products : ${getTotalProducts(list)} ")
}

def getProductList(list: List[String]): List[String] = {
    print("Enter a product (or 'done' to finish): ")
    val userInput = readLine()
    userInput.toLowerCase() match {
        case "done" => list
        case _ => getProductList(userInput :: list)
    }
}


def printProductList(list:List[String],n:Int = 0):Unit = {
    list match{
        case Nil => println("List is empty")
        case x if (x.length == 1) => println(s"${n+1} - ${x(0)}")
        case head::tail => println(s"${n+1} - ${head}"); printProductList(tail,n+1)
    }
}

def getTotalProducts(list:List[String]):Int = {
    list match{
        case Nil => 0
        case x if(x.length == 1) => 1
        case head::tail => 1 + getTotalProducts(tail)
    }
}