package utils

import common._

/**
 *  Arbol Binario
 *
 */
object ArbolBinario {

  /**
   * Un árbol binario de búsqueda también llamados BST (acrónimo del inglés Binary Search Tree)
   * es un tipo particular de árbol binario que presenta una estructura de datos en forma de árbol
   * usada en informática.
   *
   * Árbol binario
   *
   * la mayoría de los árboles binarios son de búsqueda
   *
   * Un árbol binario no vacío, de raíz R, es un árbol binario de búsqueda si:
   *
   * En caso de tener subárbol izquierdo, la raíz R debe ser mayor que el valor máximo almacenado en el
   * subárbol izquierdo, y que el subárbol izquierdo sea un árbol binario de búsqueda.
   * En caso de tener subárbol derecho, la raíz R debe ser menor que el valor mínimo almacenado en el
   * subárbol derecho, y que el subárbol derecho sea un árbol binario de búsqueda.
   *
   * En Resumen: Un elemento apunta a otros dos elementos, uno esta a la izquierda y otro a la derecha.
   * El elemento a la izquierda es más pequeño y el segundo es más grande.
   * Cada uno de estos dos elementos puede apuntar a otros dos elementos (o a uno o a ninguno).
   * En efecto, cada elemento tienen sus propios sub-árboles. Lo bueno de los árboles binarios
   * de búsqueda es que sabemos que todos los elementos que están en el sub-árbol de la izquierda
   * de, 5, por ejemplo, son menores que 5. Lo elementos que están en el sub-árbol de la derecha
   * son mayores. Así que si estamos buscando el elemento 8 en nuestro árbol, empezamos comparándolo
   * con 5, como vemos que es menor que 5, nos vamos al sub-árbol de la derecha. Ahora estaríamos en 7,
   * como es menor que 8 continuaríamos hacia la derecha. De esta forma encontraríamos el elemento en
   * tres pasos. Si estuviéramos usando una lista (o un árbol no balanceado), nos hubiera costado unos 7
   * pasos encontrar el 8.
   *
   */

  abstract class Tree
  case class EmptyTree() extends Tree
  case class Node(nro: Int, left: Tree, rigth: Tree) extends Tree

  /**
   * Inserta un elemento
   */



  
def treeInsert(nro:Int, tree: Tree) : Tree = tree match {
    case EmptyTree() => Node (nro, EmptyTree(), EmptyTree())
    case Node (nroTree, left, right) => if (nroTree == nro)  Node (nro, left, right)
                                                           else if (nro < nroTree)  Node (nroTree, treeInsert(nro, left), right)
                                                           else Node (nroTree, left, treeInsert(nro, right))  
  } 

  /**
   * Devuelve verdadero si el elemento esta en el arbol.
   */
 // def elem(nro: Int, tree: Tree): Boolean = 
  
    def elem(nro:Int, tree: Tree) : Boolean = tree match {
    case EmptyTree() => false
    case Node (nroTree, left, right) => if (nroTree == nro)  true
                                                           else if (nro < nroTree)  elem(nro, left)
                                                           else elem(nro, right)
  } 

  /**
   * Devuelve la cantidad de nodos del arbol
   */
  def countNodes(tree: Tree): Int = tree match
  {
    case EmptyTree()=>0
    case Node(nroTree, left, right)=>1+countNodes(left)+countNodes(right)
  }

  /**
   * Devuelve un arbol donde se aplico esta funcion
   */
  def apply(tree: Tree, fx: (Int) => Int): Tree = ???
  /**
   * Devuelve un arbol con cada elementos multiplicado por dos
   */
  def double(tree: Tree): Tree = tree match {
    case EmptyTree() => new EmptyTree()
    case Node (nroTree, left, right) => new Node (nroTree*2,double(left),double(right))  
  } 
  
  /**
   * Devuelve una lista ordenada
   */
  def toList(tree: Tree): List[Int] = ???
  
    /**
   * Devuelve una lista ordenada
   */
  def toString(tree: Tree): String = ???
  
}
