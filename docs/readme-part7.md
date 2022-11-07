# PART 7: Neuheiten in Java 19

## Build Tools und IDE
- noch keine durchgehende Unterstützung
- Intellij / Eclipse / Maven 3.8.6 -> ok
- Gradle 7.5.1 noch nicht

## Record Patterns (preview)
- if (obj instanceof Point(int x, int y)) -> auf x und y kann direkt zugegriffen werden
  - auch rekursiv möglich (Parameter Typen im Konstruktor können genau so aufgelöst werden)

## Virtual Threads (preview)
- leichtgewichtige Threads
- Code sieht nahezu gleich aus wie bei bisheriger Thread-Programmierung
- Unterschied: anderer Executor, sonst alles gleich

## Pattern Matching for switch (third preview)
- case String str when str.startsWith("INFO") -> ... ("when" anstatt &&)

## Structured Concurrency (Incubator)
- bessere Strukturierung von concurrent Abläufen
- verbessertes Fehlerhandling von zusammengehörigen concurrent ausgeführten Operationen