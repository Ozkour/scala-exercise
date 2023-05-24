// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  val a = (0.5, 10.2)
  val b = (10.1, 10.5)
  val c = (10.5, 20.3)
  val points = List(a, b, c)
  val routes = List((0,1),(1,2),(2,0))
  val stops = List(1, 2)
  val path = Path(points, routes, 0, 2, stops)
  
  test("Length of a road") {
    val obtained = (math floor path.roadLength(a(0), b(0), a(1), b(1)) * 100) / 100
    val expected = 9.60
    assertEquals(obtained, expected)
  }
//9.6046 + 9.8081
  test("Length of a path") {
    val aPath = List(0,1,2)
    val obtained = (math floor path.pathLength(aPath) * 100) /100
    val expected = 19.41
    assertEquals(obtained, expected)
  }

  test("The shortest path"){
    val pathList = List(List(0,1), List(1,2), List(0,1,2))
    val obtained = path.shortestPath(pathList)
    val expected = List(0,1)
    assertEquals(obtained, expected)
  }

  test("Filter the paths"){
    val pathList = List(List(0,1), List(1,2), List(0,1,2))
    val obtained = path.filterPath(pathList, stops)
    val expected = List(List(1,2), List(0,1,2))
    assertEquals(obtained, expected)
  }

  test("The shortest path with the stops"){
    val pathList = List(List(0,1), List(1,2), List(0,1,2))
    val obtained = path.shortestPathWithStops(pathList)
    val expected = List(1,2)
    assertEquals(obtained, expected)
  }

  test("Find all paths"){
    val obtained = path.findPaths()
    val expected = List(List(0,1,2))
    assertEquals(obtained, expected)
  }
}
