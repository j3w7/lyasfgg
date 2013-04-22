package utils

import org.squeryl.SessionFactory
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Session
import org.squeryl.adapters.DerbyAdapter

object PersistenceTest extends App {

  Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
  SessionFactory.concreteFactory = Some(() =>
    Session.create(
      java.sql.DriverManager.getConnection("..."),
      new DerbyAdapter))


}