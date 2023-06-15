<p align="center"><img width=12.5% src="https://i.blamejared.com/searchables.png"></p>
<p align="center" style="display: flex; flex-direction: row; align-items: center; justify-content: center;"><img width=60% src="https://i.blamejared.com/searchables_banner.png"><span style="font-size: 40px; ">-api</span></p>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
[![GitHub issues](https://img.shields.io/github/issues/maxicode2/searchables?style=flat-square)](https://github.com/maxicode2/searchables-api/issues)
[![GitHub license](https://img.shields.io/github/license/maxicode2/searchables?color=0690ff&style=flat-square)](https://github.com/maxicode2/searchables-api/blob/1.19.4/LICENSE)

## Table of Contents

- [Introduction](#introduction)
- [Code Examples](#code-examples)
- [Feedback](#feedback)
- [License](#license)
- [Setup](#setup)
- [Build](#build)
- [Maven](#maven)

## Introduction

Searchables is a library mod that adds helper methods that allow for searching and filtering elements based on components (`shape:square color:red`), as well as offering built in auto-complete functionality.

## Code Examples

Assuming you have the following code structure, which defines a `Shape` object and a list of Shapes:
```java
public record Shape(String name, String type, String colour) {}
    
public static final List<Shape> SHAPES = List.of(
        new Shape("one", "square", "red"),
        new Shape("two", "square", "dark blue"),
        new Shape("three", "circle", "red"),
        new Shape("four", "triangle", "yellow")
);
```

You may want to be able to filter that list of Shapes to find specific shapes or shapes that meet certain criteria.
To do this, you can define a `SearchableType<Shape>` object like so:

```java
public static final SearchableType<Shape> SHAPE = new SearchableType.Builder<Shape>() // Starts a builder
            .defaultComponent(SearchableComponent.create("name", shape -> Optional.of(shape.name()))) // Sets the name of the shape as the default component
            .component(SearchableComponent.create("type", shape -> Optional.of(shape.type()))) // Adds a new component for the type of the shape
            .component(SearchableComponent.create("color", shape -> Optional.of(shape.colour()))) // Adds a new component for the color of the shape
            .build();
```

Once you have a `SearchableType`, you are able to perform searches like so:
```java
SHAPE.filterEntries(SHAPES, "one"); // Returns a list with a single entry of Shape("one", "square", "red") - When searching for a default component, you don't need to specify the key
SHAPE.filterEntries(SHAPES, "color:red"); // Returns a list with the entries, Shape("one", "square", "red") and Shape("three", "circle", "red")
SHAPE.filterEntries(SHAPES, "one color:red"); // Returns a list with a single entry of Shape("one", "square", "red")
SHAPE.filterEntries(SHAPES, "color:red one"); // Returns a list with a single entry of Shape("one", "square", "red") - The search itself can be in any order
SHAPE.filterEntries(SHAPES, "color:'dark blue'"); // Returns a list with a single entry of Shape("two", "square", "dark blue") - terms with spaces, or quote characters need to be quoted - valid quote characters are '"`
```

## Feedback

If you're running into a bug or have a feature request, please don't be afraid to make an [issue on the tracker](https://github.com/maxicode2/searchables-api/issues).

## License

Distributed under the MIT License. See the [LICENSE](https://github.com/maxicode2/searchables-api/blob/main/LICENSE) file for more information.

## Setup

To set up the Searchables development environment you must clone the repo.

```bash
git clone https://github.com/maxicode2/searchables-api.git
```

After the project has been cloned and initialized you can directly import it into your IDE of choice.

## Build

Building the project is as easy as running a Gradle command!
Simply run:
```bash
gradlew build
```
and the outputted `.jar` files will be put in the `build/libs/` folder.

## Maven

Every push to this repository is built and published to the [Maven Central](https://central.sonatype.com) maven, to use these builds in your project, first add the BlameJared maven to your `repositories` block in your build.gradle file like so:

```groovy
repositories {
    mavenCentral()
}
```

Then, you can use the following snippets. Just replace `[VERSION]` with the latest version for each artifact.

### Fabric [![Maven](https://img.shields.io/maven-central/v/codes.maxi/guava?color=C71A36&label=Latest%20version&logo=Latest%20version&style=flat-square)](https://repo1.maven.org/maven2/codes/maxi/searchables-api/)

```kotlin
dependencies {
    implementation("codes.maxi.searchables:Searchables-api:[VERSION]")
    // Example:
    // implementation("codes.maxi.searchables:Searchables-api:1.0.0")
}
```
