package euler

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import euler.Problem2._
import tools.NumberUtilities

class Problem2Test extends FlatSpec with ShouldMatchers {
  val ints = new NumberUtilities[Int]

  "A Problem2 Solution" should "have a method to generate the first 11 fibonacci numbers" in {
    ints.fibonacci.take(11).toList should be (List(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89))
  }

  it should "produce the correct sum of even fibonacci numbers less than 4 million" in {
    solution(4000000) should be (4613732)
  }
}

