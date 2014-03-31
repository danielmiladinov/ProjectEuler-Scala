package euler

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec

class Problem37Test extends FlatSpec with ShouldMatchers {

  it should "show that 3797 is a right-truncatable prime" in {
    Problem37.isRightTruncatablePrime(3797L) should be (true)
  }

  it should "show that 3797 is a left-truncatable prime" in {
    Problem37.isRightTruncatablePrime(3797L) should be (true)
  }
}
