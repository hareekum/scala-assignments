package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {
  import Main.balance

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!balance(":-)".toList))
  }

  test("balance: counting is not enough") {
    assert(!balance("())(".toList))
  }

  `test`("empty string is balanced") {
    assert(balance("".toList))
  }

  `test`("basic `case`") {
    assert(balance("()".toList))
  }

  `test`("nested") {
    assert(balance("(())".toList))
  }

  `test`("nested twice") {
    assert(balance("((()))".toList))
  }

  `test`("nested thrice") {
    assert(balance("(((())))".toList))
  }

  `test`("extra content") {
    assert(balance(" a ( bc ( def ( ghij ( klmno ) pqrs ) tuv ) wx ) y (and z)".toList))
  }

  `test`("siblings") {
    assert(balance("()()".toList))
  }

  `test`("too many closing parens") {
    assert(!balance("())".toList))
  }

  `test`("inverted") {
    assert(!balance(")(".toList))
  }

  `test`("opener only") {
    assert(!balance("(".toList))
  }

  `test`("closer only") {
    assert(!balance(")".toList))
  }

}
