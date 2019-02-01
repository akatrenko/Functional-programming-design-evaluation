package calculator

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
                   c: Signal[Double]): Signal[Double] = {
    Var(b() * b() - 4 * a() * c())
  }

  def computeSolutions(a: Signal[Double], b: Signal[Double],
                       c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    Var{
      //var result = Set[Double]()
      val delta = computeDelta(a, b, c)()
      if (delta > 0) {
        Set((-b() + math.sqrt(delta)) / (2 * a()),
          (-b() - math.sqrt(delta)) / (2 * a()))
      } else if (computeDelta(a, b, c)() == 0) {
        Set((-b()) / (2 * a()))
      } else {
        Set.empty
      }
    }
  }
}
