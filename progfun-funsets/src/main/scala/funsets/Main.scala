package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))

  def boundedSet(m: Int, n: Int): Set = x => x >= m && x <= n

  val s = boundedSet(1, 3)
  printSet(s) // prints {1,2,3}

  def arbitrarySet(i: Int*): Set = x => i.contains(x)

  val t = arbitrarySet(2, 4, 8)
  printSet(t) // prints {2,4,8}
  
  val set1 = (x: Int) =>  x < 12 && x > 0
  val set2 = (x: Int) =>  x > 10 && x < 30
  
  printSet(union(set1, set2))
  
  printSet(intersect(set1, set2))

  printSet(diff(set1, set2))
  
  printSet(filter(set1, set2))
  
  println(forall(set1, set2))
  println(exists(set1, set2))
  
  val mul2 = (x: Int) => x * 2
  printSet(map(set1, mul2))
}
