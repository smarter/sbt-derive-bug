val foo = taskKey[Unit]("")
val bar = taskKey[Unit]("")

lazy val a = (project in file("a")).
  settings(
    foo in Compile := {
      println("foo in a")
    }
    ,
    Def.derive(bar := {
      val _ = foo.value
    })
  )

lazy val root = (project in file(".")).
  aggregate(a).
  settings(
    foo in Compile := {
      println("foo in root")
    }
  )
