You can download latest versions of Java Checker on CurseForge:

http://minecraft.curseforge.com/projects/java-version-checker

The mod is in Public Domain, so do whatever you want with it! Hugs and mentions appreciated but not required. If you want to include Java Checker in your own mod, read the shading guide.

## Shading Java Checker into your mod

*Warning: this is experimental, if you find any issues, please report them immediately.*

You can insert Java Checker into your mod, so that it will alert the user if they are using outdated Java. You will need to download a special version designed for shading, you can find it on [CurseForge](http://minecraft.curseforge.com/projects/java-version-checker/files/2262108).

This file will work fine for all Minecraft versions starting from 1.6.2. It can currently check for Java 7 or 8, based on how you configure it.

In order to shade and configure Java Checker, you need to update your **build.gradle** file. Use this as a guide, make sure to update everything in <> brackets.

```
configurations{
  shade
  compile.extendsFrom shade
}

<your buildscript info is somewhere here>

dependencies{
  shade files('libs/JavaCheckerShade  MC-UNIVERSAL  v1.2.jar')
}

<your mod info is somewhere here>

minecraft{
  srgExtra "PK: chylex/javacheck <yourmodname>/shade/javacheck"
}

jar{
  configurations.shade.each{ dep ->
    from(project.zipTree(dep)){
      exclude 'META-INF', 'META-INF/**', 'mcmod.info'
    }
  }
  
  manifest{
    attributes 'TweakClass': '<yourmodname>.shade.javacheck.Java<version>Checker'
  }
}
```

You can also use [Hardcore Ender Expansion's build.gradle](https://github.com/chylex/Hardcore-Ender-Expansion/blob/master/build.gradle) as a reference.

Now build the mod and run it to make sure nothing messed up. If you need help with something related to build.gradle, ask AbrarSyed because I have absolutely no idea what I'm doing :P.
