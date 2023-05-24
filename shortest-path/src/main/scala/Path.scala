import scala.math._

class Path(var points: List[(Double,Double)], var routes: List[(Int, Int)], var origin: Int, var destination: Int, var stopsList: List[Int]):

    val roadLength = (x1: Double, x2: Double, y1: Double, y2: Double) => sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2))

    def pathLength(path: List[Int]): Double =
        var sum = 0.0
        for (List(left,right) <- path.sliding(2))
        do 
            val (x1, y1): (Double, Double) = points.apply(left)
            val (x2, y2): (Double, Double) = points.apply(right)
            sum = sum + roadLength(x1,x2,y1,y2)
        sum

    def shortestPath(pathList: List[List[Int]]): List[Int] =
        if(pathList.length == 0){
            null
        }
        else if (pathList.length == 1){
            pathList(0)
        }
        else {
            val tail = shortestPath(pathList.tail)
            if(pathLength(pathList(0)) < pathLength(tail)) pathList(0) else tail
        }

    def filterPath(pathList: List[List[Int]], stopsList: List[Int]): List[List[Int]] =
        if(pathList.length == 0){
            null
        }
        else if(stopsList.length == 0){
            pathList
        }
        else{
            filterPath(pathList.filter(_.contains(stopsList.head)), stopsList.tail)
        }

    def shortestPathWithStops(pathList: List[List[Int]]): List[Int] =
        shortestPath(filterPath(pathList, stopsList))


    def findPaths(): List[List[Int]] = {
        def dfs(current: Int, visited: Set[Int], path: List[Int]): List[List[Int]] = {
            if (current == destination) {
            List(path :+ current)
            } else {
            val connectedRoutes = routes.filter(_(0) == current).filterNot(route => visited.contains(route(1)))
            connectedRoutes.flatMap(route => dfs(route(1), visited + route(1), path :+ current))
            }
        }
        dfs(origin, Set(origin), List.empty)
    }

end Path
