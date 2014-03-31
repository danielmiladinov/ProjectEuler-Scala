package euler.tools

class NumberUtilities [T] (implicit repr: Integral[T]) {
  import repr._
  private val One = repr.fromInt(1)

  val fibonacci: Stream[T] = One #:: fibonacci.scanLeft(One)(_ + _)

  def primes (n: Long = 1L): Stream[Long] = {
    import ImplicitConversions._
    n #:: primes(n.nextPrime)
  }
}
