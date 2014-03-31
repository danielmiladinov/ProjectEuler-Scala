package euler

object Problem37 {
  import euler.tools.ImplicitConversions._

  // The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from
  // left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left:
  // 3797, 379, 37, and 3.

  // Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
  // NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

  def solution (): Long = {
    import euler.tools.NumberUtilities
    val longs = new NumberUtilities[Long]()

    // skip 2, 3, 5, and 7; next prime is 11
    longs.primes(11L)
      .filter(isRightTruncatable)
      .filter(isLeftTruncatable)
      .take(11)
      .sum
  }

  def isRightTruncatable (n: Long): Boolean = {
    propertyHolds(n, _.isPrime, truncate(_.init))
  }

  def isLeftTruncatable (n: Long): Boolean = {
    propertyHolds(n, _.isPrime, truncate(_.substring(1)))
  }

  def truncate (truncateFn: String => String) (n: Long): Option[Long] = {
    val truncated = truncateFn(n.toString)
    truncated match {
      case "" => None
      case _ => Some(truncated.toLong)
    }
  }

  @scala.annotation.tailrec
  def propertyHolds (n: Long, property: Long => Boolean, reduceFn: Long => Option[Long]): Boolean = {
    property(n) && (reduceFn(n) match {
      case Some(reduced) => propertyHolds(reduced, property, reduceFn)
      case None => true
    })
  }
}
