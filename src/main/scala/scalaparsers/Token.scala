package scalaparsers

/** Tokens are returned by the layout parser rather than raw characters
  *
  * @author EAK
  */

sealed abstract class Token extends Product with Serializable

final case object VSemi extends Token {
  override def toString = "virtual semicolon"
}

final case object VBrace extends Token {
  override def toString = "virtual right brace"
}

final case object WhiteSpace extends Token {
  override def toString = "white space"
}

final case object Other extends Token {
  override def toString = "other"
}
