/**
 * This is a module file.
 *
 * Modules were introduced in Java 9, allowing modules to express dependencies on other modules and to publish their
 * public packages.
 *
 * Using modules makes things easier when working with JavaFX, because JavaFX is itself published as a module.
 *
 * Please note: "module" in Java is not quite the same as "dependency" in Gradle. They are similar concepts, but
 * "modules" is part of the Java language (but doesn't express how to find them on the internet) whereas
 * "dependencies" is part of the Gradle build system and expresses how to find them on the internet (but does not
 * specify the module imports to the Java compiler). We need both.
 */
module dotsAndBoxes {
    requires javafx.graphics;
    requires javafx.controls;
    requires org.apache.logging.log4j;
    exports dotsandboxes;
}