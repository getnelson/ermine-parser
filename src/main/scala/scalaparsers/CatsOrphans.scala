package scalaparsers

import cats.kernel.{Comparison, Monoid}

private[scalaparsers] object CatsOrphans {
  // https://github.com/typelevel/cats/pull/2087
  implicit val catsKernelComparisonMonoid: Monoid[Comparison] = new Monoid[Comparison] {
    def empty: Comparison = Comparison.EqualTo

    def combine(x: Comparison, y: Comparison): Comparison = x match {
      case Comparison.EqualTo => y
      case o                  => o
    }
  }
}
