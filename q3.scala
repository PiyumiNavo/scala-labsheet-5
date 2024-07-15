@main def main() = print(fibonacci(10))

def fibonacci(n:Int):List[Int] =
    n match{
        case 1 => List(0)
        case 2 => List(0, 1)
        case n if n > 2 => {
            val seq = fibonacci(n-1)
            seq :+ (seq.reverse.head + seq.reverse.tail.head)
        }
        case _ => List(0)
    }