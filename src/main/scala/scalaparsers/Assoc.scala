package scalaparsers

sealed abstract class Assoc extends Product with Serializable
final case object AssocL extends Assoc
final case object AssocR extends Assoc
final case object AssocN extends Assoc
