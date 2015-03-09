/**
 * Copyright (C) 2014 Typesafe Inc. <http://www.typesafe.com>
 */
package akka.stream.scaladsl

import akka.stream.javadsl
import akka.stream.scaladsl

/**
 * Implicit converters allowing to convert between Java and Scala DSL elements.
 */
private[akka] object JavaConverters {

  implicit final class AddAsJavaSource[Out, Mat](val source: scaladsl.Source[Out, Mat]) extends AnyVal {
    def asJava: javadsl.Source[Out, Mat] = new javadsl.Source(source)
  }
  implicit final class AddAsJavaFlow[In, Out, Mat](val flow: scaladsl.Flow[In, Out, Mat]) extends AnyVal {
    def asJava: javadsl.Flow[In, Out, Mat] = new javadsl.Flow(flow)
  }
  implicit final class AddAsJavaSink[In, Mat](val sink: scaladsl.Sink[In, Mat]) extends AnyVal {
    def asJava: javadsl.Sink[In, Mat] = new javadsl.Sink(sink)
  }
  implicit final class AsAsJavaFlowGraphBuilder[Out](val builder: scaladsl.FlowGraph.Builder) extends AnyVal {
    def asJava: javadsl.FlowGraph.Builder = new javadsl.FlowGraph.Builder()(builder)
  }
}
