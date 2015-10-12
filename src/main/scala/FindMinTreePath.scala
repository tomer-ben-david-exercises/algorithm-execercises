package com.example
/**
 * @author tomerb
 **

// Find the minimal path to least farthest descendant.
object FindMin {
  def main(args: Array[String]): Unit = {

    val rootLeftLeft = Node(None, None, "rootLeftLeft")
    val rootLeftRight = Node(None, None, "rootLeftRight")
    val rootLeft = Node(Some(rootLeftLeft), Some(rootLeftRight), "rootLeft")
    val rootRightLeft = Node(None, None, "rootRightLeft")
    val rootRightRight = Node(None, None, "rootRightRight")
    val rootRight = Node(Some(rootRightLeft), Some(rootRightRight), "rootRight")
    val root = Node(Some(rootLeft), Some(rootRight), "root")

    println(findMin(Some(root), 0))
  }

  def findMin(node: Option[Node], curMin: Int): Int = {
    node match {
      case None => curMin
      case Some(n: Node) =>
        Math.min(
          findMin(n.left, curMin + 1),
          findMin(n.right, curMin + 1))
    }
  }

}

case class Node(left: Option[Node], right: Option[Node], value: String)
