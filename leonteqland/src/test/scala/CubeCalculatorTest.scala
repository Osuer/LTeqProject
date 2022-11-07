import org.scalatest.funsuite.AnyFunSuite

class CubeCalculatorTest extends AnyFunSuite{
  test("CubeCalculator.cubeWith3") {
    assert(CubeCalculator.cube(3) === 27)
  }

  test("CubeCalculator.cubeWith1") {
    assert(CubeCalculator.cube(1) === 1)
  }
}

