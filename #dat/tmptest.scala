import org.scalatest.FunSuite

object skarasi
{
  def main(args: Array[String]): Unit =
  {
    println("skarasi")
  }


}

class SetSuite extends FunSuite {
  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
  }
}

