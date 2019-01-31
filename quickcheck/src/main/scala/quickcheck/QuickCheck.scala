package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  lazy val genHeap: Gen[H] = for {
    arbitrary <- arbitrary[Int]
    oneHeap <- oneOf(const(empty), genHeap)
  } yield insert(arbitrary, oneHeap)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("gen1") = forAll { h: H =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("meld") = forAll { (firstElem: H, secondElem: H) =>
    val minFirstElem = findMin(firstElem)
    val minSecondElem = findMin(secondElem)
    val meldElem = meld(firstElem, secondElem)
    val minMeld = findMin(meldElem)
    minMeld == minFirstElem || minMeld == minSecondElem
  }

  property("meldMinMove") = forAll { (h1: H, h2: H) =>
    def removeMinElem(ts: H, as: List[Int]): List[Int] = {
      if (!isEmpty(ts)) findMin(ts) :: removeMinElem(deleteMin(ts), as)
      else as
    }

    val meld1 = meld(h1, h2)
    val minFirstElem = findMin(h1)
    val meld2 = meld(deleteMin(h1), insert(minFirstElem, h2))
    val removeFirstElem = removeMinElem(meld1, Nil)
    val removeSecondElem = removeMinElem(meld2, Nil)
    removeFirstElem == removeSecondElem
  }
}
