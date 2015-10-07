If you want to use it for your own projects, you can download it on Curse (http://www.curse.com/mc-mods/minecraft/226991-java-version-checker) or bundled with one of my other mods, Hardcore Ender Expansion (http://hee.chylex.com/)

The mod is in Public Domain, feel free to do whatever you want with it! Hugs and mentions appreciated but not required.

## Shading Java 8 Checker into your mod

*Warning: this is experimental, if you find any issues, please report them immediately.*

You can insert Java Checker into your mod, so that it will alert the user if they are using outdated Java. You will need to get a modified version of the Java Checker mod, and place it in the **libs** folder of your mod setup.

You can download [Java 8+](https://www.dropbox.com/s/gmd4xgr1iygpjxo/Java8Checker%20%20MC-1.7.10%20%20v1.1-shade.jar?dl=1) or [Java 7+](https://www.dropbox.com/s/4qehcjnach7dy6t/Java7Checker%20%20MC-1.7.10%20%20v1.1-shade.jar?dl=1) checkers. Currently they are both for 1.7.10 only, there will be a more proper update later (the currently released versions have a bug that prevents shading).

Then you need to configure your **build.gradle** file to shade the checker into your own mod files. Use this as a guide, make sure to update everything in <> brackets. 

```
configurations{
  shade
  compile.extendsFrom shade
}

<your buildscript info is somewhere here>

dependencies{
  shade files('libs/Java<version>Checker MC-1.7.10 v1.1-shade.jar')
}

<your mod info is somewhere here>

minecraft{
  <your workspace information is somewhere here>
  srgExtra "PK: chylex/javacheck <yourmodname>/shade/javacheck"
}

jar{
  configurations.shade.each{ dep ->
    from(project.zipTree(dep)){
      exclude 'META-INF', 'META-INF/**', 'mcmod.info'
    }
  }
  
  manifest{
    attributes 'FMLCorePlugin': '<yourmodname>.shade.javacheck.Java<version>CheckerCoremod'
    attributes 'FMLCorePluginContainsFMLMod': 'true'
  }
}
```

You can also use [Hardcore Ender Expansion's build.gradle](https://github.com/chylex/Hardcore-Ender-Expansion/blob/master/build.gradle) as a reference.

Now build the mod and run it to make sure nothing messed up. If you need help with something, ask AbrarSyed because I have absolutely no idea what I'm doing :P.
