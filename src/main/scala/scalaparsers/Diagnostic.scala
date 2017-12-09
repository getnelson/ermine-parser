package scalaparsers

import cats.Monad
import cats.implicits._

abstract class Diagnostic[M[+_]] {
  /** Fail with a message at a given location. this may abort backtracking for | */
  def raise(p: Pos, d: Document, aux: List[Document]): M[Nothing] = fail(p.report(d, aux:_*))

  /** Fail with a message (at the current location if parsing) */
  def fail(d: Document): M[Nothing]

  /** Fail without a message */
  def empty: M[Nothing]
}

object Diagnostic {
  // more traditional failure, etc.
  def fail[M[+_]](d: Document)(implicit M: Diagnostic[M]) = M.fail(d)

  def failUnless[M[+_]](b: Boolean, e: => Document)(implicit M: Monad[M], D: Diagnostic[M]): M[Unit] =
    if (b) ().pure[M] else fail[M](e)

  def failWhen[M[+_]](b: Boolean, e: => Document)(implicit M: Monad[M], D: Diagnostic[M]): M[Unit] =
    if (b) fail[M](e) else ().pure[M]

  def raise[M[+_]](p: Pos, d: Document, extra: List[Document] = List())(implicit M: Diagnostic[M]): M[Nothing] =
    M.raise(p,d, extra)

  def raiseUnless[M[+_]](b: Boolean, p: Pos, e: => Document, xs: => List[Document] = List())(implicit M: Monad[M], D: Diagnostic[M]): M[Unit] =
    if (b) ().pure[M] else raise[M](p, e, xs)

  def raiseWhen[M[+_]](b: Boolean, p: Pos, e: => Document, xs: => List[Document] = List())(implicit M: Monad[M], D: Diagnostic[M]): M[Unit] =
    if (b) raise[M](p, e, xs) else ().pure[M]

  def empty[M[+_]](implicit M: Diagnostic[M]): M[Nothing] =
    M.empty

  def guard[M[+_]](b: Boolean)(implicit M: Monad[M], D: Diagnostic[M]): M[Unit] =
    if (b) ().pure[M] else empty[M]
}

// vim: set ts=4 sw=4 et:
