package euler

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec

class Problem37Test extends FlatSpec with ShouldMatchers {

  it should "show that 3797 is a right-truncatable prime" in {
    Problem37.isRightTruncatable(3797L) should be (true)
  }

  it should "show that 3797 is a left-truncatable prime" in {
    Problem37.isRightTruncatable(3797L) should be (true)
  }

  it should "correctly find the sum of the 11 left- and right-truncatable prime numbers" in {
    Problem37.solution() should be (748317)
  }
}
