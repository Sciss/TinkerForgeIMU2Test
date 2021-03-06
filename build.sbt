lazy val deps = new {
  val main = new {
    val fileUtil  = "1.1.5"
    val jzy3d     = "1.0.3"
    val kollFlitz = "0.2.4"
    val scopt     = "4.0.1"
    val swingPlus = "0.5.0"
    val tinker    = "2.1.30"
    val pi4j      = "1.4"
    val scalaOSC  = "1.3.0"
  }
}

lazy val root = project.in(file("."))
  .settings(
    name                 := "TinkerForgeIMU2Test",
    organization         := "de.sciss",
    version              := "0.1.0-SNAPSHOT",
    scalaVersion         := "2.13.5",
    description          := "Testing the TinkerForge IMU2 brick sensor board from Scala",
    homepage             := Some(url(s"https://github.com/Sciss/${name.value}")),
    licenses             := Seq("LGPL v2.1+" -> url("http://www.gnu.org/licenses/lgpl-2.1.txt")),
    scalacOptions       ++= Seq("-deprecation", "-unchecked", "-feature", "-Xfuture", "-encoding", "utf8"),
    libraryDependencies ++= Seq(
      "com.tinkerforge"   %   "tinkerforge" % deps.main.tinker,
      "com.github.scopt"  %%  "scopt"       % deps.main.scopt,
      "de.sciss"          %%  "fileutil"    % deps.main.fileUtil,
      "de.sciss"          %%  "kollflitz"   % deps.main.kollFlitz,
      "de.sciss"          %%  "swingplus"   % deps.main.swingPlus,
      "de.sciss"          %%  "scalaosc"    % deps.main.scalaOSC,
      "org.jzy3d"         %   "jzy3d-api"   % deps.main.jzy3d,
      "com.pi4j"          %   "pi4j-core"   % deps.main.pi4j
    ),
    resolvers ++= Seq(
      ("jzv3d releases" at "http://maven.jzy3d.org/releases").withAllowInsecureProtocol(true)  // 3D chart
    ),
    // assembly
    target          in assembly := baseDirectory.value,
    // mainClass       in assembly := Some("de.sciss.tinkerforge.RecordAccel"),
    mainClass       in assembly := Some("de.sciss.tinkerforge.View"),
    // assemblyJarName in assembly := "RecordAccel.jar"
    assemblyJarName in assembly := "WekiIMU.jar"
  )
