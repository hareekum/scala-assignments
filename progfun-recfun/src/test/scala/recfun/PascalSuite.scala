package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
  test("pascal: col=0,row=2") {
    assert(pascal(0,2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1,2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1,3) === 3)
  }
  
  test("pascal: col=-1, row=0 - should raise/intercept NoSuchElementException") {
    intercept[NoSuchElementException] {
    	pascal(-1,0)
    }
  }
  
  test("triangle") {
  val triangle = List(
      List(    1        ),
      List(   1, 1      ),
      List(  1, 2, 1    ),
      List( 1, 3, 3, 1  ),
      List(1, 4, 6, 4, 1)
  )

  for ((row, i) <- triangle.view.zipWithIndex) {
    for ((col, j) <- row.view.zipWithIndex) {
      assert(pascal(j, i) === col)
    }
  }
}
  
}
