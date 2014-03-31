package euler

object Problem37 {
  import euler.tools.ImplicitConversions._

  // The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from
  // left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left:
  // 3797, 379, 37, and 3.

  // Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
  // NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

  def isRightTruncatablePrime (n: Long): Boolean = {
    propertyHolds(n, _.isPrime, truncateRight)
  }

  def isLeftTruncatablePrime (n: Long): Boolean = {
    propertyHolds(n, _.isPrime, truncateLeft)
  }

  def truncateRight (n: Long): Option[Long] = {
    val truncated = n.toString.init
    truncated match {
      case "" => None
      case _ => Some(truncated.toLong)
    }
  }

  def truncateLeft (n: Long): Option[Long] = {
    val truncated = n.toString.substring(1)
    truncated match {
      case "" => None
      case _ => Some(truncated.toLong)
    }
  }

  def propertyHolds (n: Long, property: Long => Boolean, reduceFn: Long => Option[Long]): Boolean = {
    property(n) && (reduceFn(n) match {
      case Some(reduced) => propertyHolds(reduced, property, reduceFn)
      case None => true
    })
  }
}
