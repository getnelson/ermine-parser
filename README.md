# Ermine Parser

[![image](https://travis-ci.org/oncue/ermine-parser.svg)](https://travis-ci.org/oncue/ermine-parser) [ ![Download](https://api.bintray.com/packages/oncue/releases/ermine-parser/images/download.svg) ](https://bintray.com/oncue/releases/ermine-parser/_latestVersion)

A parser combinator library for Scala, based on the [Trifecta library for Haskell](http://hackage.haskell.org/package/trifecta).

The main features of Trifecta is that it provides good error messages. When a parser fails, it can report the failure location in the source, along with a message indicating what the failure was, including suggestions for how the source could be modified to fix the error.

It is reasonably fast, and stack safe.
