import scala.io.StdIn.readLine

@main def main: Unit =
  // val a = (50.63, 3.07)
  // val b = (48.86, 2.35)
  // val c = (44.84, -0.58)
  // val d = (45.76, 4.84)
  // val e = (43.3, 5.37)
  // val f = (43.6, 1.44)
  // val points = List(a, b, c, d, e, f)
  // val routes = List((0,1),(1,2),(1,3),(0,2),(3,4),(4,3),(2,5))
  // val path = Path(points, routes, 0, 5, Nil)
  // println(path.shortestPathWithStops(path.findPaths()))

  println("Enter the origin :")
  val origin = readLine().toInt
  println("Enter the destination :")
  val dest = readLine().toInt
  println("Enter the stops like this : 0 1 2 if the stops are the points 0, 1 and 2")
  val stopsStr = readLine()
  val stops = stopsStr.split(" ").map(_.toInt).toList
  println("Enter the number of points and routes :")
  val nbPointsRoutes = readLine()
  val nbPoints = nbPointsRoutes.split(" ")(0).toInt
  val nbRoutes = nbPointsRoutes.split(" ")(1).toInt

  var points: List[(Double, Double)] = Nil
  var routes: List[(Int, Int)] = Nil
  for (i <- (1 to nbPoints))
  do
    println("Enter the lat of point of ID " + (i-1) + " : ")
    val lat = readLine().toDouble
    println("Enter the long of point of ID " + (i-1) + " : ")
    val long = readLine().toDouble
    points = (lat, long) :: points
  for (i <- (1 to nbRoutes))
  do
    println("Enter the ID of the first point of route : ")
    val first = readLine().toInt
    println("Enter the ID of the second point of route : ")
    val second = readLine().toInt
    routes = (first, second) :: routes

  val path = Path(points.reverse, routes, origin, dest, stops)
  println(path.shortestPathWithStops(path.findPaths()))
