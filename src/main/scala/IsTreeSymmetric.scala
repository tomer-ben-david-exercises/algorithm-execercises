package com.example

/**
 * @author tomerb
 * on 14/10/15
 */
object IsTreeSymmetric {
  case class Node(left: Option[Node], right: Option[Node], value: Int)

  def main(args: Array[String]): Unit = {
    println(isSymetric(root.left, root.right))
  }

  val leftLeft = Node(None, None, 3)
  val leftRight = Node(None, None, 2)
  val rightRight = Node(None, None, 3)
  val rightLeft = Node(None, None, 2)
  val rootLeft = Node(Some(leftLeft), Some(leftRight), 2)
  val rootRight = Node(Some(rightLeft), Some(rightRight), 2)
  val root = Node(Some(rootLeft), Some(rootRight), 1)

  def isSymetric(left: Option[Node], right: Option[Node]): Boolean = {
    (left, right) match {
      case (None, None) => true
      case (None, Some(Node(_, _, _))) => false
      case (Some(Node(_, _,_)), None) => false
      case (Some(l: Node), Some(r: Node)) =>
        l.value == r.value &&
          isSymetric(l.right, r.left) && isSymetric(l.left, r.right)
    }
  }
}
