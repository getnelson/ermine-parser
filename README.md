# Ermine Parser

[![Build Status](https://travis-ci.org/Verizon/ermine-parser.svg?branch=master)](https://travis-ci.org/Verizon/ermine-parser) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.verizon.ermine/parser_2.11/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.verizon.ermine/parser_2.11)

A parser combinator library for Scala, based on the [Trifecta library for Haskell](http://hackage.haskell.org/package/trifecta).

The main features of Trifecta is that it provides good error messages. When a parser fails, it can report the failure location in the source, along with a message indicating what the failure was, including suggestions for how the source could be modified to fix the error.

It is reasonably fast, and stack safe.

