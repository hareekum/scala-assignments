package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == c) 1
    else if (r < c || r < 0 || c < 0) throw new NoSuchElementException()
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def _balance(chars: List[Char], pCount: Int): Boolean = {
      if (chars.isEmpty)
        pCount == 0
      else {
        val p = chars.head match {
          case '(' => pCount + 1
          case ')' => pCount - 1
          case _ => pCount
        }
        if (p < 0) false
        else _balance(chars.tail, p)
      }

    }

    _balance(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0) 0
    else if (coins.length <= 0 && money >= 1) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
