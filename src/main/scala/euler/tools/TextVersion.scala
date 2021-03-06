package euler.tools

object TextVersion {

  val units = Map(
    0 -> "zero",
    1 -> "one",
    2 -> "two",
    3 -> "three",
    4 -> "four",
    5 -> "five",
    6 -> "six",
    7 -> "seven",
    8 -> "eight",
    9 -> "nine"
  )

  val teens = Map(
    0 -> "ten",
    1 -> "eleven",
    2 -> "twelve",
    3 -> "thirteen",
    4 -> "fourteen",
    5 -> "fifteen",
    6 -> "sixteen",
    7 -> "seventeen",
    8 -> "eighteen",
    9 -> "nineteen"
  )

  val tens = Map(
    2 -> "twenty",
    3 -> "thirty",
    4 -> "forty",
    5 -> "fifty",
    6 -> "sixty",
    7 -> "seventy",
    8 -> "eighty",
    9 -> "ninety"
  )

  def Of (number: Int): String = {
    number.toString.length match {
      case n if n == 1 => units(number)
      case n if n == 2 => {
        if (number < 20) teens(number % 10)
        else {
          number % 10 match {
            case 0 => tens(number / 10)
            case _ => Array(tens(number / 10), units(number % 10)).mkString("-")
          }
        }
      }
      case n if n == 3 => {
        number % 100 match {
          case 0 => Array(units(number / 100), "hundred").mkString(" ")
          case _ => Array(Of(number - (number % 100)), Of(number % 100)).mkString(" and ")
        }
      }
      case n if n < 7 => {
        number % 1000 match {
          case 0 => Array(units(number / 1000), "thousand").mkString(" ")
          case _ => Array(Of(number / 1000), "thousand", Of(number % 1000)).mkString(" ")
        }
      }
      case n if n == 7 => {
        number % 1000000 match {
          case 0 => Array(units(number / 1000000), "million").mkString(" ")
          case _ => Array(Of(number / 1000000), "million", Of(number % 1000000)).mkString(" ")
        }
      }
    }
  }
}
